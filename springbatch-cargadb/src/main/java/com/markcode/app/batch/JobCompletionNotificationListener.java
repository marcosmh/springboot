package com.markcode.app.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        if( jobExecution.getStatus() == BatchStatus.COMPLETED ) {
            logger.info("JOB TERMINADO! - Es hora de verificar los resultados");

            jdbcTemplate.query("SELECT nombre, apellido FROM persona",new DataClassRowMapper<>(Persona.class))
                    .forEach(p -> logger.info("Encontrado  <{{}}> en la base de datos", p ));


        }


    }

}
