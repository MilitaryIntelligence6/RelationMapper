package cn.misection.ktrelation.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MoneyService
 * @Description TODO
 * @CreateTime 2022年02月25日 14:38:00
 */
public interface MoneyService {

  XSSFWorkbook  getMoneyWorkbook();

  void save();
}
