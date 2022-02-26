package cn.misection.ktrelation.dao

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileInputStream

/**
 * @ClassName MoneyDAO
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月25日 23:47:00
 */
object MoneyDAO {

  @JvmStatic
  fun readWorkbook(moneyPath: String): Workbook =
      when {
        moneyPath.endsWith(".xlsx") -> {
          XSSFWorkbook(FileInputStream(moneyPath))
        }
        moneyPath.endsWith(".xls") -> {
          HSSFWorkbook(FileInputStream(moneyPath))
        }
        else -> throw IllegalArgumentException("the excel path $moneyPath should endWith .xlsx or .xls")
      }
}
