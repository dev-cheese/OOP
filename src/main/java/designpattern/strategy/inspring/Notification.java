package designpattern.strategy.inspring;

public abstract class Notification {
    protected abstract void send();
}

class NotificationEmail extends Notification {
    private String email;

    public NotificationEmail(String email) {
        this.email = email;
    }

    @Override
    protected void send() {
        System.out.println(email + " 이메일 알림 전송");
    }
}

class NotificationSMS extends Notification {
    private int number;

    public NotificationSMS(int number) {
        this.number = number;
    }

    @Override
    protected void send() {
        System.out.println(number + " SMS 알림 전송");
    }
}

class NotificationSender {
    private Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public void send() {
        notification.send();
    }
}
class Slack {
    private String slackUrl;
    private String accessToken;

    public String getSlackUrl() {
        return slackUrl;
    }

    public void setSlackUrl(String slackUrl) {
        this.slackUrl = slackUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

class NotificationSlack extends Notification {


    private Slack slack;

    public NotificationSlack(Slack slack) {
        this.slack = slack;
    }

    @Override
    protected void send() {
        System.out.println(slack.getAccessToken() + slack.getSlackUrl() + "을 기반으로 슬랙으로 메세지를 보냅니다");
    }
}

final class SlackBuilder {
    private String slackUrl;
    private String accessToken;

    private SlackBuilder() {
    }

    public static SlackBuilder aSlack() {
        return new SlackBuilder();
    }

    public SlackBuilder withSlackUrl(String slackUrl) {
        this.slackUrl = slackUrl;
        return this;
    }

    public SlackBuilder withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Slack build() {
        Slack slack = new Slack();
        slack.setSlackUrl(slackUrl);
        slack.setAccessToken(accessToken);
        return slack;
    }
}


class Main {
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender();

        sender.setNotification(new NotificationSMS(1071333262));
        sender.send();

        sender.setNotification(new NotificationEmail("cheese10yun"));
        sender.send();

    }
}


/**
 * 이메일주소,전화번호,notification객체를 메소드의 파라미터로 받게하고
 * <p>
 * <p>
 * 빈은 프로토타입이  아닌  일반빈(싱글톤)으로 만들면 좋을것 같네요
 * 프로토타입 빈을  남발하면 동접자가  많아지면 메모리가  부족해질겁니다
 * <p>
 * 잘 이해가 가지 않습니다. 멤버 필드를 사용하지 않고 send 메소드에 어떻게 넘겨줄수 있을 까요 ?
 * send() 오버라이딩 되어 NotificationEmail 클래스에서는 이메일이 보내야 하고,  NotificationSMS 클래스에서는 이메일을 보내야합니다.
 * send() 는 동일하게 하위 재정의가 동일하게 되니 해당 클래스마다 달라지면 안된다고 생각합니다 SRP, OCP 위반이라고 생각이 들고요
 * 순수 자바에서는 맴버필드를 이용해서 매끄럽게 send 메소드에 값을 할당 할 수 있습니다. 하지만 스프링에서는 싱글톤 사용시 맴버 필드가 스레드에 안전하지 않으니 저렇게라도 구현을 해야하는가 입니다.
 */








