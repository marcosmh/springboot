package com.markcode.app.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    private static final Logger logger = LoggerFactory.getLogger(BatchConfig.class);
    @Bean
    public FlatFileItemReader<Persona> reader() {
        logger.info("Leyendo el acrchivo.....");
        return new FlatFileItemReaderBuilder<Persona>()
                .name("personaItemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names("nombre","apellido")
                .targetType(Persona.class)
                .build();
    }

    @Bean
    public PersonaItemProcessor processor(){
        return new PersonaItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Persona> writer(DataSource datasource) {
        return new JdbcBatchItemWriterBuilder<Persona>()
                .sql("INSERT INTO persona (nombre, apellido) VALUES (:nombre, :apellido) ")
                .dataSource(datasource)
                .beanMapped()
                .build();
    }

    @Bean
    public Job importarPersonaJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener listener) {
        logger.info("Guardando en la base de datos.....");
        return new JobBuilder("importarPersonaJob", jobRepository)
                .listener(listener)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      DataSourceTransactionManager transactionManager,
                      FlatFileItemReader<Persona> reader,
                      PersonaItemProcessor processor,
                      JdbcBatchItemWriter<Persona> writer) {

        logger.info("Step1 .....");
        TaskletStep s = null;
        try {
            s = getStep1(jobRepository, transactionManager, reader, processor, writer);
        } catch (Exception e) {
            logger.error("Error: "+e.getMessage());
        }


        return s;
    }

    private static TaskletStep getStep1(JobRepository jobRepository, DataSourceTransactionManager transactionManager, FlatFileItemReader<Persona> reader, PersonaItemProcessor processor, JdbcBatchItemWriter<Persona> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Persona, Persona>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }


}
