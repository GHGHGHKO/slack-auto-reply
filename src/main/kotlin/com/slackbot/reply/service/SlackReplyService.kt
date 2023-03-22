package com.slackbot.reply.service

import com.slackbot.reply.client.SlackReadClient
import com.slackbot.reply.client.SlackWriteClient
import com.slackbot.reply.dto.ChatPostThreadMessageRequestDto
import com.slackbot.reply.dto.ChatPostThreadMessageResponseDto
import com.slackbot.reply.dto.ConversationsHistoryResponseDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SlackReplyService(
    private val slackReadClient: SlackReadClient,
    private val slackWriteClient: SlackWriteClient
) {

    @Value("\${slack.key}")
    lateinit var slackKey: String

    @Value("\${slack.channel}")
    lateinit var slackChannelCode: String

    @Value("\${slack.botCode}")
    lateinit var slackBotCode: String

    @Value("\${slack.historyRange}")
    lateinit var historyRange: String

    fun postThreadMessage() {
        val getConversationsHistory = getSlackConversationsHistory()
        if (getConversationsHistory.ok) {
            getConversationsHistory.messages?.forEach {
                if ((it.replyUsers == null) || !it.replyUsers.contains(slackBotCode)) {
                    writeSlackChatPostThreadMessage(it.ts)
                }
            }
        }
    }

    fun getSlackConversationsHistory(): ConversationsHistoryResponseDto {
        val latestChat = System.currentTimeMillis()
        val oldestChat = latestChat - (1000L * 60 * Integer.parseInt(historyRange))
        val getConversationsHistory = slackReadClient
            .findByConversationsHistory(
                authentication = "Bearer $slackKey",
                channelCode = slackChannelCode,
                latestChat = String.format("%.6f", latestChat / 1000.0),
                oldestChat = String.format("%.6f", oldestChat / 1000.0)
            )
        if (getConversationsHistory.ok) {
            return getConversationsHistory
        } else {
            throw IllegalArgumentException("/conversations.history is " +
                    "${getConversationsHistory.ok}")
        }
    }

    @Value("\${slack.write.channelName}")
    lateinit var channelName: String

    @Value("\${slack.write.text}")
    lateinit var text: String

    fun writeSlackChatPostThreadMessage(
        threadTs: String): ChatPostThreadMessageResponseDto {
        val chatPostThreadMessageRequestDto =
            ChatPostThreadMessageRequestDto(
                channel = channelName,
                threadTs = threadTs,
                text = text
            )

        val writeChatPostThreadMessage = slackWriteClient
            .writeChatPostThreadMessage(
                authorization = "Bearer $slackKey",
                chatPostThreadMessageRequestDto = chatPostThreadMessageRequestDto
            )

        if (writeChatPostThreadMessage.ok) {
            return writeChatPostThreadMessage
        } else {
            throw IllegalArgumentException("/chat.postMessage is " +
                    "${writeChatPostThreadMessage.ok}")
        }
    }
}
