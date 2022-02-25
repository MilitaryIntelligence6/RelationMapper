package cn.misection.relation.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.misection.relation.constant.Path;
import cn.misection.relation.task.MapperTask;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName Application
 * @Description TODO
 * @CreateTime 2022年02月25日 00:04:00
 */
public class Application {

  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    service.execute(new MapperTask(Path.ROOT_PATH, "suchaosheng"));
    service.shutdown();
  }
}
