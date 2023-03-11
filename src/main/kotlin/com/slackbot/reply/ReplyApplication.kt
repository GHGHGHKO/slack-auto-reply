package com.slackbot.reply

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReplyApplication

fun main(args: Array<String>) {
	runApplication<ReplyApplication>(*args)
}
