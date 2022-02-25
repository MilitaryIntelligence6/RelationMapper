package cn.misection.demo.io.service.impl;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.misection.demo.io.dao.MoneyDAO;
import cn.misection.demo.io.service.MoneyService;
import cn.misection.demo.util.PoiUtil;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MoneyServiceImpl
 * @Description TODO
 * @CreateTime 2022年02月25日 14:38:00
 */
public class MoneyServiceImpl implements MoneyService {

  private final String moneyPath;

  private final String outPath;

  private XSSFWorkbook moneyWorkbook;

  public MoneyServiceImpl(String moneyPath, String outPath) {
    this.moneyPath = moneyPath;
    this.outPath = outPath;
    init();
  }

  private void init() {
    moneyWorkbook = MoneyDAO.readMoneyWorkbook(moneyPath);
  }

  @Override
  public void save() {
    PoiUtil.saveWorkBook(moneyWorkbook, outPath);
  }

  @Override
  public XSSFWorkbook getMoneyWorkbook() {
    return moneyWorkbook;
  }
}
