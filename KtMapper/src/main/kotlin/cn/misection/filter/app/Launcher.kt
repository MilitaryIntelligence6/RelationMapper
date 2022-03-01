package cn.misection.filter.app

import cn.misection.filter.constant.PathDefine
import cn.misection.filter.task.FilterTask

/**
 * @ClassName Applicaion
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @Description TODO
 * @CreateTime 2022年02月25日 23:35:00
 */
fun main(args: Array<String>) {
//  val threadPool = Executors.newSingleThreadExecutor()
//  threadPool.execute()
//  threadPool.shutdown()
  val task = FilterTask(PathDefine.ROOT_PATH)
  task.run()
}
