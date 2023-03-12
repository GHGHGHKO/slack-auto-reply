package com.slackbot.reply.tasklet

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class SlackReplyTasklet: Tasklet {
    override fun execute(
        contribution: StepContribution,
        chunkContext: ChunkContext
    ): RepeatStatus {
        println("execute SlackReplyTasklet")
        return RepeatStatus.FINISHED
    }
}
