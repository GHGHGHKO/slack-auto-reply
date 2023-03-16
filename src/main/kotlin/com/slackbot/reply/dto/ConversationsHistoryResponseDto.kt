package com.slackbot.reply.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ConversationsHistoryResponseDto (
    @JsonProperty("ok") val ok: Boolean,
    @JsonProperty("latest") val latest: String,
    @JsonProperty("oldest") val oldest: String,
    @JsonProperty("messages") val messages: List<Messages>?,
    @JsonProperty("has_more") val hasMore: Boolean,
    @JsonProperty("pin_count") val pinCount: Int,
)

data class Messages(
    @JsonProperty("client_msg_id") val clientMsgId: String?,
    @JsonProperty("type") val type: String,
    @JsonProperty("text") val text: String,
    @JsonProperty("user") val user: String,
    @JsonProperty("ts") val ts: String,
    @JsonProperty("blocks") val blocks: List<Blocks>,
    @JsonProperty("team") val team: String,
    @JsonProperty("thread_ts") val threadTs: String?,
    @JsonProperty("reply_count") val replyCount: Int?,
    @JsonProperty("reply_users_count") val replyUsersCount: Int?,
    @JsonProperty("latest_reply") val latestReply: String?,
    @JsonProperty("reply_users") val replyUsers: List<String>?,
    @JsonProperty("is_locked") val isLocked: Boolean?,
    @JsonProperty("subscribed") val subscribed: String?
)

data class Blocks(
    @JsonProperty("type") val type: String,
    @JsonProperty("block_id") val blockId: String
)

