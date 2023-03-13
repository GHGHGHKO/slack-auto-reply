package com.slackbot.reply.service

import com.slackbot.reply.client.SlackReadClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SlackReplyService(
    private val slackReadClient: SlackReadClient
) {

    @Value("\${slack.key}")
    lateinit var slackKey: String

    @Value("\${slack.channel}")
    lateinit var slackChannelCode: String

    fun getSlackConversationsHistory() {
        val latestChat = System.currentTimeMillis()
        val oldestChat = latestChat - (1000L * 60 * 10)
        println("latestChat : $latestChat\n oldestChat : $oldestChat")
        val getConversationsHistory = slackReadClient
            .findByConversationsHistory(
                authentication = "Bearer $slackKey",
                channelCode = slackChannelCode,
                latestChat = String.format("%.6f", latestChat / 1000.0),
                oldestChat = String.format("%.6f", oldestChat / 1000.0)
            )

        println(getConversationsHistory.toString())
    }
}
