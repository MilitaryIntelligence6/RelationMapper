package cn.misection.filter.service.impl;

import org.apache.poi.ss.usermodel.Workbook;

import cn.misection.filter.dao.MoneyDAO;
import cn.misection.filter.service.MoneyService;
import cn.misection.filter.util.PoiUtil;

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

  private Workbook workbook;

  public MoneyServiceImpl(String moneyPath, String outPath) {
    this.moneyPath = moneyPath;
    this.outPath = outPath;
    init();
  }

  private void init() {
    workbook = MoneyDAO.readWorkbook(moneyPath);
  }

  @Override
  public void save() {
    PoiUtil.saveWorkBook(workbook, outPath);
  }

  @Override
  public Workbook getWorkbook() {
    return workbook;
  }
}
