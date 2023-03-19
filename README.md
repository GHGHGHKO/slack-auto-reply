# slack-auto-reply
slack 환영 봇 입니다.  
[특정 채널](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/build-with-jib.yml#L59) 에서 글이 올라올 때  

[환영 봇](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/build-with-jib.yml#L61) 이 [history](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/src/main/kotlin/com/slackbot/reply/service/SlackReplyService.kt#L39) 를 불러오는 slack API로 [특정 범위](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/src/main/kotlin/com/slackbot/reply/service/SlackReplyService.kt#L39) 를 조회하여  
환영 봇이 댓글을 달지 않는 글을 찾아 [정해진 thread comment](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/build-with-jib.yml#L63) 를 답니다.

아직 스케줄이 걸려있지 않습니다. ([수동 트리거](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/auto-reply-job.yml#L7) 로 되어있습니다.)  
조절 후 반영 할 예정입니다.
