package com.slackbot.reply.client

import com.slackbot.reply.dto.ChatPostThreadMessageRequestDto
import com.slackbot.reply.dto.ChatPostThreadMessageResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "slackWrite", url = "\${slack.url}")
interface SlackWriteClient {

    @PostMapping("/chat.postMessage")
    fun writeChatPostThreadMessage(
        @RequestHeader(value = HttpHeaders.AUTHORIZATION) authorization: String,
        chatPostThreadMessageRequestDto: ChatPostThreadMessageRequestDto
    ): ChatPostThreadMessageResponseDto
}
