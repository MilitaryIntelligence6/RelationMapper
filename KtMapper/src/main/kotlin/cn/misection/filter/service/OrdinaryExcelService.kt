package cn.misection.filter.service

import org.apache.poi.ss.usermodel.Workbook

/**
 * @ClassName MoneyService
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 15:48:00
 */
interface OrdinaryExcelService {

  fun getWorkBook(): Workbook

  fun save()
}
