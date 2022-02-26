package cn.misection.relation.callback

import cn.hutool.json.JSONUtil
import cn.hutool.log.Log
import cn.misection.relation.entity.PersonRelationPair
import com.alibaba.excel.context.AnalysisContext
import com.alibaba.excel.read.listener.ReadListener
import java.util.function.Consumer

/**
 * @ClassName RelationListener
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 14:19:00
 */
class RelationListener constructor(
    private val consumer: Consumer<List<PersonRelationPair>>,
) : ReadListener<PersonRelationPair> {

  private val memoryDataList: MutableList<PersonRelationPair> = mutableListOf()

  override fun invoke(pair: PersonRelationPair?, context: AnalysisContext?) {
    Log.get().info("解析到一条数据 {}", JSONUtil.toJsonStr(pair))
    pair?.let { memoryDataList.add(it) }
  }

  override fun doAfterAllAnalysed(context: AnalysisContext?) {
    consumer.accept(memoryDataList)
  }
}
