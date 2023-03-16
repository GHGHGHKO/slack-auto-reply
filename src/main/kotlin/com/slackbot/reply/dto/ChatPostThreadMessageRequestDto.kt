package com.slackbot.reply.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ChatPostThreadMessageRequestDto (
    @JsonProperty("channel") val channel: String,
    @get:JsonProperty("thread_ts") val threadTs: String,
    @JsonProperty("text") val text: String
)
