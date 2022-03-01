package cn.misection.filter.addition

import org.apache.poi.ss.usermodel.Workbook
import java.io.FileOutputStream

/**
 * @ClassName WorkbookAddition
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月26日 14:46:00
 */

object WorkbookAddition {
  fun Workbook.saveAt(path: String) {
    FileOutputStream(path).run {
      write(this)
      close()
    }
  }
}


