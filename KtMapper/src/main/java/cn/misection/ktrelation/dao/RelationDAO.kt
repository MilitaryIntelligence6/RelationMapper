package cn.misection.ktrelation.dao

import cn.hutool.json.JSONUtil
import cn.hutool.log.Log
import cn.misection.ktrelation.callback.RelationListener
import cn.misection.ktrelation.entity.PersonRelationPair
import com.alibaba.excel.EasyExcel
import java.util.function.Consumer

/**
 * @ClassName RelationDAO
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 12:07:00
 */
object RelationDAO {

  fun readExcel(path: String): List<PersonRelationPair> {

    EasyExcel.read(path, PersonRelationPair::class.java, RelationListener(
        Consumer { dataList ->
          run {
            for ((index: Int, data: PersonRelationPair) in dataList) {
              Log.get().info("读取到第 {} 条数据 {}", index, JSONUtil.toJsonStr(data))

            }
          }

        }
    ))
    return
  }
}
