package cn.misection.relation.dao;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MoneyDAO
 * @Description TODO
 * @CreateTime 2022年02月25日 13:40:00
 */
public class MoneyDAO {

  public static Workbook readMoneyWorkbook(@NotNull String moneyPath) {
    try {
      if (moneyPath.endsWith(".xlsx")) {
        return new XSSFWorkbook(new FileInputStream(moneyPath));
      } else if (moneyPath.endsWith(".xls")) {
        return new HSSFWorkbook((new FileInputStream(moneyPath)));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
