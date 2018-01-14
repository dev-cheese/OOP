package ocp.before;

import java.util.Calendar;

/**
 * 다음 코드는 오후 10시가 되면 MP3를 동작시켜 음악을 연주한다.
 * 그러나 이 코드가 제대로 작동하는지 테스트하려면 저녁 10시까지 기다려야한다.
 * OCP를 적용해서 이 문제를 해결하는 코드를 작성하라
 */
public class TimeReminder {

    private MP3 mp3;

    public void reminder() {
        Calendar cal = Calendar.getInstance();
        mp3 = new MP3();
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        if (hour >= 22) {
            mp3.playSong();
        }

    }
}

class MP3 {

    public void playSong() {
        System.out.println("start song");
    }
}

