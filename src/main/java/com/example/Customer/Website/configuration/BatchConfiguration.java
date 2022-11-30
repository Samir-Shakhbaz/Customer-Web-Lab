package com.example.Customer.Website.configuration;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public BatchProperties.Job job(JobBuilderFactory jobBuilderFactory, Step nameStep, Step designationStep) {
        return jobBuilderFactory.get("employee-loader-job")
                .incrementer(new RunIdIncrementer())
                .start(nameStep)
                .next(designationStep)
                .build();
    }

    //add your Steps, ItemReaders, ItemProcessors, and ItemWriter below
}