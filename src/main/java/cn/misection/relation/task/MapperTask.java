package cn.misection.relation.task;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.hutool.core.util.StrUtil;
import cn.misection.relation.service.MoneyService;
import cn.misection.relation.service.RelationService;
import cn.misection.relation.service.impl.MoneyServiceImpl;
import cn.misection.relation.service.impl.RelationServiceImpl;
import cn.misection.relation.util.PoiUtil;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MapperTask
 * @Description TODO
 * @CreateTime 2022年02月25日 13:30:00
 */
public class MapperTask implements Runnable {

  private static final int START_ROW = 9;

  private static final int KEY_INDEX = 7;

  private String rootPath;

  private String name;

  private RelationService relationService;

  private MoneyService moneyService;

  public MapperTask(String rootPath, String name) {
    this.rootPath = rootPath;
    this.name = name;
    init();
  }

  private void init() {
    relationService = new RelationServiceImpl(
        String.format("%s/data/%s/relation/relation.xlsx", rootPath, name));
    moneyService = new MoneyServiceImpl(
        String.format("%s/data/%s/money/money.xlsx", rootPath, name),
        String.format("%s/out/%s/%s.xlsx", rootPath, name, name));
  }

  @Override
  public void run() {
    Map<String, String> relationMap = relationService.getRelationMap();
    Workbook workbook = moneyService.getWorkbook();
    for (Sheet sheet : workbook) {
      for (int i = START_ROW; i < sheet.getLastRowNum(); i++) {
        Row row = sheet.getRow(i);
        Cell judgeCell = row == null ? null : row.getCell(KEY_INDEX);
        String key = StrUtil.trim(judgeCell == null ? "null" : judgeCell.getStringCellValue());
        String relation = relationMap.get(key);
        PoiUtil.safeRowAppend(sheet, i, relation);
      }
    }
    moneyService.save();
  }
}
