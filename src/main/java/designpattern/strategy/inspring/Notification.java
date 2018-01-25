package designpattern.strategy.inspring;

// 간단하게 전략 패턴을 구현 했습니다. 소스를 간단하게 설명 하자면 setNotification 메소드에 어떤 인스턴르를 주입 하냐에 따라서 send의 행위가 달라집니다.
public abstract class Notification {
    protected abstract void send();
}
// 1, 2, 3 순서대로 읽어주시면 감사하겠습니다.
//2: 1 번을 하기위해서 빈등록을 프로토타입으로 했습니다.
//3:  프로토 타입으로 한 이유는 멤버 필드가 있어 스레드에 세이프 하지 않다고 판단 해서 입니다.
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
        System.out.println( number+" SMS 알림 전송");
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

class Main {
    public static void main(String[] args) {
        NotificationSender sender = new NotificationSender();

        sender.setNotification(new NotificationSMS(1071333262));
        sender.send();

        sender.setNotification(new NotificationEmail("cheese10yun"));
        sender.send();
    }
}









