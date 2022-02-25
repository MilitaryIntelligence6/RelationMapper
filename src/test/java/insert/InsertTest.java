package insert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.misection.demo.constant.Path;
import cn.misection.demo.constant.Test;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName InsertTest
 * @Description TODO
 * @CreateTime 2022年02月25日 19:59:00
 */
public class InsertTest {

  /**
   * //  Parameters:
   * //   startRow - the row to start shifting
   * //   endRow - the row to end shifting
   * //   n - the number of rows to shift
   * //   copyRowHeight - whether to copy the row height during the shift
   * //   resetOriginalRowHeight - whether to set the original row's height to the default
   * @param wb
   * @param sheet
   * @param startRow
   * @param rows
   */
  public static void insertRow(HSSFWorkbook wb, HSSFSheet sheet, int startRow, int rows) {
    sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), rows, true, false);
    startRow = startRow - 1;
    for (int i = 0; i < rows; i++) {
      HSSFRow sourceRow;
      HSSFRow targetRow = null;
      HSSFCell sourceCell = null;
      HSSFCell targetCell = null;

      startRow = startRow + 1;
      sourceRow = sheet.getRow(startRow);
      targetRow = sheet.createRow(startRow + 1);
      targetRow.setHeight(sourceRow.getHeight());

      for (int j = sourceRow.getFirstCellNum(); j < sourceRow.getLastCellNum(); j++) {
        sourceCell = sourceRow.getCell(j);
        targetCell = targetRow.createCell(j);
//        targetCell.setEncoding(sourceCell.getEncoding());
        targetCell.setCellStyle(sourceCell.getCellStyle());
        targetCell.setCellType(sourceCell.getCellType());
      }
    }
  }

  public static void insertRow(XSSFWorkbook wb, XSSFSheet sheet, int startRow, int rows) {
    sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), rows, true, false);
    startRow = startRow - 1;
    for (int i = 0; i < rows; i++) {
      XSSFRow sourceRow;
      XSSFRow targetRow;
      XSSFCell sourceCell;
      XSSFCell targetCell;

      startRow++;
      sourceRow = sheet.getRow(startRow);
      targetRow = sheet.createRow(startRow + 1);
      targetRow.setHeight(sourceRow.getHeight());

      for (int j = sourceRow.getFirstCellNum(); j < sourceRow.getLastCellNum(); j++) {
        sourceCell = sourceRow.getCell(j);
        targetCell = targetRow.createCell(j);
//        targetCell.setEncoding(sourceCell.getEncoding());
        targetCell.setCellStyle(sourceCell.getCellStyle());
        targetCell.setCellType(sourceCell.getCellType());
      }
    }
  }

  public static void columnAppend(XSSFWorkbook workbook, XSSFSheet sheet, int rowNum, String value) {
    XSSFRow row = sheet.getRow(rowNum);
    XSSFCell cell = row.createCell(row.getLastCellNum() + 1);
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

  @Test
  public static void main(String[] args) {
    String fileName = Path.OUT_DIR_PATH + "indexWrite" + ".xlsx";
    String saveFileName = Path.OUT_DIR_PATH + "indexWriteSave" + ".xlsx";
    try {
      XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
      XSSFSheet sheet = workbook.getSheetAt(0);
      columnAppend(workbook, sheet, 2, "shit");
      saveWorkBook(workbook, saveFileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
