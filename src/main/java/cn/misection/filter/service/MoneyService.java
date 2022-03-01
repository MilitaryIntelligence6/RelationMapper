package cn.misection.filter.service;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MoneyService
 * @Description TODO
 * @CreateTime 2022年02月25日 14:38:00
 */
public interface MoneyService {

  Workbook getWorkbook();

  void save();
}
