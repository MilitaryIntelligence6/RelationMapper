package cn.misection.filter.service.impl

import cn.misection.filter.addition.WorkbookAddition.saveAt
import cn.misection.filter.dao.OrdinaryExcelDAO
import cn.misection.filter.service.OrdinaryExcelService
import org.apache.poi.ss.usermodel.Workbook

/**
 * @ClassName MoneyServiceImpl
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 15:55:00
 */
class OrdinaryExcelServiceImpl constructor(
  private val inPath: String,
  private val outPath: String,
) : OrdinaryExcelService {

  private val workbook: Workbook = OrdinaryExcelDAO.readWorkbook(inPath)

  override fun getWorkBook(): Workbook {
    return workbook
  }

  override fun save() {
    workbook.saveAt(outPath)
  }
}
