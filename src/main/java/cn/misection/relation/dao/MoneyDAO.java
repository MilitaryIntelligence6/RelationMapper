package cn.misection.relation.dao;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MoneyDAO
 * @Description TODO
 * @CreateTime 2022年02月25日 13:40:00
 */
public class MoneyDAO {

  public static XSSFWorkbook readMoneyWorkbook(String moneyPath) {
    try {
      return new XSSFWorkbook(new FileInputStream(moneyPath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


//  public static Map<String, List<List<String>>> readMoneyMap(String moneyDirPath) {
//    File dir = new File(moneyDirPath);
//    if (dir.exists() && dir.isDirectory()) {
//      String[] listPathArray = dir.list();
//      if (listPathArray == null) {
//        return new HashMap<>(0);
//      }
//      Map<String, List<List<String>>> moneyXlsxMap = new HashMap<>(listPathArray.length);
//      for (String path : listPathArray) {
//        try {
//          moneyXlsxMap.put(path, ExcelUtils.getInstance().readExcel2List(
//              String.format("%s/%s", moneyDirPath, path)));
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//      return moneyXlsxMap;
//    }
//    return new HashMap<>(0);
//  }

//  public static void output(Map<String, List<List<String>>> data, String outDirPath) {
//    for (Map.Entry<String, List<List<String>>> entry : data.entrySet()) {
//      String name = entry.getKey();
//      List<List<String>> xlsx = entry.getValue();
//      try {
//        ExcelUtils.getInstance().exportObjects2Excel(
//            xlsx, String.format("%s/%s", outDirPath, name));
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }
}
