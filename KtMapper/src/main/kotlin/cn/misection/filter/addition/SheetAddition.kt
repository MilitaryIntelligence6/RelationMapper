package cn.misection.filter.addition

import org.apache.poi.ss.usermodel.Sheet

/**
 * @ClassName SheetAddition
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月28日 21:46:00
 */
object SheetAddition {
  fun Sheet.rowAppend(rowNum: Int, value: String?) {
    getRow(rowNum)?.run {
      value?.let { createCell(lastCellNum + 1)?.setCellValue(value) }
    }
  }
}
