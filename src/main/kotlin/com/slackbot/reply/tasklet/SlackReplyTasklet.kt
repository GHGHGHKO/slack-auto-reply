package com.slackbot.reply.tasklet

import com.slackbot.reply.service.SlackReplyService
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class SlackReplyTasklet(
    private val slackReplyService: SlackReplyService
): Tasklet {
    override fun execute(
        contribution: StepContribution,
        chunkContext: ChunkContext
    ): RepeatStatus {
        slackReplyService.postThreadMessage()
        return RepeatStatus.FINISHED
    }
}
