package com.slackbot.reply.config

import com.slackbot.reply.tasklet.SlackReplyTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SlackReplyConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val slackReplyTasklet: SlackReplyTasklet
) {

    @Bean
    fun autoReplyJob(): Job {
        return jobBuilderFactory.get("autoReplyJob")
            .start(autoReplyStep())
            .build()
    }

    private fun autoReplyStep(): Step {
        return stepBuilderFactory.get("autoReplyStep1")
            .tasklet(slackReplyTasklet)
            .build()
    }
}
