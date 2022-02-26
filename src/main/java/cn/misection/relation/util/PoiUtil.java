package cn.misection.relation.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.hutool.core.util.StrUtil;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName PoiUtil
 * @Description TODO
 * @CreateTime 2022年02月25日 20:58:00
 */
public class PoiUtil {

  public static void safeRowAppend(Sheet sheet, int rowNum, String value) {
    Row row = sheet.getRow(rowNum);
    Cell cell = row == null ? null : row.createCell(row.getLastCellNum() + 1);
    if (cell != null && value != null) {
      cell.setCellValue(value);
    }
  }

  public static void rowAppend(Workbook workbook, Sheet sheet, int rowNum, String value) {
    Row row = sheet.getRow(rowNum);
    Cell cell = row.createCell(row.getLastCellNum() + 1);
    cell.setCellValue(value);
  }

  public static void saveWorkBook(Workbook workbook, String path) {
    try {
      FileOutputStream fileOut = new FileOutputStream(path);
      workbook.write(fileOut);
      fileOut.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
