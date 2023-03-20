# slack-auto-reply
slack 환영 봇 입니다.  
[특정 채널](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/build-with-jib.yml#L59) 에서 글이 올라올 때  

[환영 봇](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/build-with-jib.yml#L61) 이 [history](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/src/main/kotlin/com/slackbot/reply/service/SlackReplyService.kt#L39) 를 불러오는 slack API로 [특정 범위](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/src/main/kotlin/com/slackbot/reply/service/SlackReplyService.kt#L39) 를 조회하여  
환영 봇이 댓글을 달지 않는 글을 찾아 [정해진 thread comment](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/build-with-jib.yml#L63) 를 답니다.

아직 스케줄이 걸려있지 않습니다. ([수동 트리거](https://github.com/GHGHGHKO/slack-auto-reply/blob/797fd4d58c91fd696c80ead0294e0d581b897173/.github/workflows/auto-reply-job.yml#L7) 로 되어있습니다.)  
조절 후 반영 할 예정입니다.

# 사용방법
slack-auth-reply [사용방법](https://github.com/GHGHGHKO/slack-auto-reply/wiki/slack-auto-reply-%EC%82%AC%EC%9A%A9%EB%B0%A9%EB%B2%95)

# 환경변수 (Github secrets 목록)

|Key|Value|설명|
|------|---|---|
|SLACK_CHANNEL|Slack 채널 코드|영어와 숫자로 이루어져 있습니다.|
|SLACK_KEY|Slack key|xoxb로 시작하는 키 입니다.|
|SLACK_WRITE_CHANNELNAME|채널 이름|채널의 이름입니다.(예, 봇-테스트)|
|SLACK_BOTCODE|Slack 봇 코드|영어와 숫자로 이루어져 있습니다.|
|SLACK_WRITE_TEXT|봇의 문구|환영하는 글을 적어주세요!|

# 참고 이미지
![image](https://user-images.githubusercontent.com/26823834/226167760-8c686cc5-675d-4fff-9dda-73d3c91d7a39.png)

![image](https://user-images.githubusercontent.com/26823834/226167768-7fe83093-30f7-496e-90d6-727d8a496b48.png)

# 구현 로직
![flow](https://user-images.githubusercontent.com/26823834/226167797-1614c731-47bf-47c0-ba78-68c7dab3195e.png)

1. spring batch로 job을 생성합니다.
2. Jib을 활용하여 application을 container화 한 뒤 dockerhub에 업로드 합니다.
3. Github Actions에서 dockerhub에 접근하여 container에서 job을 실행합니다.
4. 다음 스케줄에서 다시 dockerhub에 접근하여 container를 실행합니다.
