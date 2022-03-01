package cn.misection.filter.task

import cn.hutool.log.Log
import cn.misection.filter.service.OrdinaryExcelService
import cn.misection.filter.service.impl.OrdinaryExcelServiceImpl
import cn.misection.filter.util.Calcer
import org.apache.poi.ss.usermodel.Row

/**
 * @ClassName Filter
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月28日 21:52:00
 */
class FilterTask constructor(
  private val rootPath: String,
) {

  companion object {
    private val logger: Log = Log.get()
  }

  private val service: OrdinaryExcelService = OrdinaryExcelServiceImpl(
    "${rootPath}/data/data.xlsx",
    "${rootPath}/out/output.xlsx"
  )

  fun run() {
    val workBook = service.getWorkBook()
    workBook.getSheetAt(0)?.let {
      // 0 开始
      val removeList = arrayListOf<Row>()
      for ((index: Int, row: Row) in it.withIndex()) {
        if (Calcer.shouldRetain(index)) {
          logger.info("row ${index} should retain")
        } else {
          removeList.add(row)
          logger.info("row ${index} should remove")
        }
      }
      for (row in removeList) {
        it.removeRow(row)
      }
    }
    service.save()
  }
}
