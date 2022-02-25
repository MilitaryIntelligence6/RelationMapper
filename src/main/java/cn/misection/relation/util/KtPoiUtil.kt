package cn.misection.relation.util

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import java.io.FileOutputStream
import java.io.IOException

/**
 * @ClassName KtPoiUtil
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月25日 21:41:00
 */
object KtPoiUtil {

  public fun columnAppend(workbook: Workbook?, sheet: Sheet, rowNum: Int, value: String?) {
    val row: Row? = sheet.getRow(rowNum)
    val cell: Cell? = row?.createCell(row.lastCellNum + 1)
    cell?.setCellValue(value)
  }

  fun saveWorkBook(workbook: Workbook, path: String?) {
    try {
      val fileOut = FileOutputStream(path)
      workbook.write(fileOut)
      fileOut.close()
    } catch (e: IOException) {
      e.printStackTrace()
    }
  }
}
