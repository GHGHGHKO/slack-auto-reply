package com.slackbot.reply.client

import com.slackbot.reply.dto.ConversationsHistoryResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "slackRead", url = "\${slack.url}")
interface SlackReadClient {

    @GetMapping("/conversations.history")
    fun findByConversationsHistory(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) authentication: String,
        @RequestParam("channel") channelCode: String,
        @RequestParam("inclusive") inclusive: Boolean = true,
        @RequestParam("latest") latestChat: String,
        @RequestParam("oldest") oldestChat: String
    ): ConversationsHistoryResponseDto
}
