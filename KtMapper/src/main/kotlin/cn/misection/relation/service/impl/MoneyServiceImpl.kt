package cn.misection.relation.service.impl

import cn.misection.ktrelation.dao.MoneyDAO
import cn.misection.relation.addition.saveAt
import cn.misection.relation.service.MoneyService
import org.apache.poi.ss.usermodel.Workbook

/**
 * @ClassName MoneyServiceImpl
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 15:55:00
 */
class MoneyServiceImpl constructor(
    private val moneyPath: String,
    private val outPath: String,
) : MoneyService {

  private val workbook: Workbook = MoneyDAO.readWorkbook(moneyPath)

  override fun getWorkBook(): Workbook {
    return workbook
  }

  override fun save() {
    workbook.saveAt(outPath)
  }
}
