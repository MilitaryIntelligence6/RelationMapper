package cn.misection.relation.addition

import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import java.io.FileOutputStream

/**
 * @ClassName WorkbookAddition
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 14:46:00
 */

fun Workbook.saveAt(path: String) {
  FileOutputStream(path).let {
    write(it)
    it.close()
  }
}

fun Sheet.rowAppend(rowNum: Int, value: String?) {
  val row: Row? = this.getRow(rowNum)
  value?.let { row?.createCell(row.lastCellNum + 1)?.setCellValue(it) }
}
