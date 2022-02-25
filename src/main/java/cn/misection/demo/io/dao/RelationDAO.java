package cn.misection.demo.io.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.PageReadListener;
import com.github.crab2died.ExcelUtils;
import com.sun.istack.internal.NotNull;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.misection.demo.callback.RelationListener;
import cn.misection.demo.entity.PersonRelationPair;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName RelationReader
 * @Description TODO
 * @CreateTime 2022年02月24日 23:50:00
 */
public class RelationDAO {

  @NotNull
  public static List<PersonRelationPair> readXlsx(String path) {
    final List<PersonRelationPair>[] result = new List[1];
    EasyExcel.read(path, PersonRelationPair.class, new RelationListener(
        (List<PersonRelationPair> dataList) -> {
          for (int i = 0; i < dataList.size(); i++) {
            Log.get().info("读取到第 {} 条数据 {}", i, JSONUtil.toJsonStr(dataList.get(i)));
          }
          result[0] = dataList;
        })).doReadAll();
    return result[0];
  }
}
