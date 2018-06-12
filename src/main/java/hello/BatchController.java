package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BatchController {

@Autowired
JobLauncher jobLauncher;

@Autowired
Job job;

  @RequestMapping("/runit")
  public void handle() throws Exception{
         JobParameters jobParameters =
                         new JobParametersBuilder()
                         .addLong("time",System.currentTimeMillis()).toJobParameters();
          jobLauncher.run(job, jobParameters);
  }

}
