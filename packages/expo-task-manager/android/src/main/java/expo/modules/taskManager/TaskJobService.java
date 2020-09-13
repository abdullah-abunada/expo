package expo.modules.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;

public class TaskJobService extends JobService {
  @Override
  public boolean onStartJob(JobParameters params) {
    try {
      Context context = getApplicationContext();
      TaskService taskService = new TaskService(context);

      return taskService.handleJob(this, params);
    } catch (Exception e) {
         return false;
    }
  }

  @Override
  public boolean onStopJob(JobParameters params) {
    Context context = getApplicationContext();
    TaskService taskService = new TaskService(context);

    return taskService.cancelJob(this, params);
  }
}
