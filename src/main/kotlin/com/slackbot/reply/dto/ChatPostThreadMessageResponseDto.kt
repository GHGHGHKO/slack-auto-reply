package com.slackbot.reply.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ChatPostThreadMessageResponseDto (
    @JsonProperty("ok") val ok: Boolean,
    @JsonProperty("channel") val channel: String,
    @JsonProperty("ts") val ts: String,
    @JsonProperty("message") val message: Message,
    @JsonProperty("warning") val warning: String
)

data class Message(
    @JsonProperty("bot_id") val botId: String?,
    @JsonProperty("type") val type: String?,
    @JsonProperty("text") val text: String?,
    @JsonProperty("user") val user: String?,
    @JsonProperty("ts") val ts: String?,
    @JsonProperty("app_id") val appId: String?,
    @JsonProperty("blocks") val blocks: List<Blocks>?,
    @JsonProperty("team") val team: String?,
    @JsonProperty("thread_ts") val threadTs: String?,
    @JsonProperty("parent_user_id") val parentUserId: String?,
)
