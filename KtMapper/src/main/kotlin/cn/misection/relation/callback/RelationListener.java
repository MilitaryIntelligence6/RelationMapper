package cn.misection.relation.callback;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.misection.relation.entity.PersonRelationPair;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName RelationLisener
 * @Description TODO
 * @CreateTime 2022年02月25日 16:53:00
 */
public class RelationListener implements ReadListener<PersonRelationPair> {

  /**
   * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
   */
  private static final int BATCH_COUNT = 3000;

  /**
   * 缓存的数据
   */
  private List<PersonRelationPair> memoryDataList = new ArrayList<>(BATCH_COUNT);

  private final Consumer<List<PersonRelationPair>> consumer;

  public RelationListener(Consumer<List<PersonRelationPair>> consumer) {
    this.memoryDataList = new ArrayList<>(BATCH_COUNT);
    this.consumer = consumer;
  }


  @Override
  public void invoke(PersonRelationPair personRelationPair, AnalysisContext analysisContext) {
    Log.get().info("解析到一条数据{}", JSONUtil.toJsonStr(personRelationPair));
    memoryDataList.add(personRelationPair);
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    Log.get().info("所有 relation 数据解析完成!");
    consumer.accept(memoryDataList);
  }
}
