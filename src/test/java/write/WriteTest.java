package write;

import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;

import cn.misection.demo.constant.Path;
import entity.DemoData;
import entity.IndexData;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName WriteTest
 * @Description TODO
 * @CreateTime 2022年02月25日 19:31:00
 */
public class WriteTest {

  public static void main(String[] args) {
//    String fileName = Path.OUT_DIR_PATH + "indexWrite" + System.currentTimeMillis() + ".xlsx";
    String fileName = Path.OUT_DIR_PATH + "indexWrite" + ".xlsx";
    // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    EasyExcel.write(fileName, IndexData.class).sheet("模板").doWrite(WriteTest::data);
  }

  private static List<DemoData> data() {
    List<DemoData> list = ListUtils.newArrayList();
    for (int i = 0; i < 10; i++) {
      DemoData data = new DemoData();
      data.setString("字符串String" + i);
      data.setDate(new Date());
      data.setDoubleData(0.99);
      list.add(data);
    }
    return list;
  }
}
