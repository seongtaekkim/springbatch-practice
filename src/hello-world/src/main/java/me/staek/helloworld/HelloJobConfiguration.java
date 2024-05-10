package me.staek.helloworld;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * springbatch 5.0 이후 JobBuilderFactory, StepBuilderFactory는 Deprecated 되어
 * JobBuilder, StepBuilder를 사용함
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class HelloJobConfiguration {

    @Bean
    public Job job1(JobRepository jobRepository, Step step1) {
        return new JobBuilder("job1", jobRepository)
                .start(step1)
                .build();
    }
    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("step1", jobRepository)
                .tasklet(new Tasklet() {
                        @Override
                        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                            log.info("test step1 logging");
                            return RepeatStatus.FINISHED;
                        }
                    }, platformTransactionManager).build();
    }
}
