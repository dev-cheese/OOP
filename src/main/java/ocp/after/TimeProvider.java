package ocp.after;

import java.util.Calendar;

public interface TimeProvider {
    void setHours(int hours);

    int getTime();
}

class FakeTimeProvider implements TimeProvider {
    private Calendar calendar;

    public FakeTimeProvider() {
        calendar = Calendar.getInstance();
    }

    public FakeTimeProvider(int hours) {
        calendar = Calendar.getInstance();
        setHours(hours);
    }

    public void setHours(int hours) {
        calendar.set(Calendar.HOUR_OF_DAY, hours);
    }

    public int getTime() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

}

class TimeRemider {
    private TimeProvider timeProvider;
    private MP3 mp3 = new MP3();


    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void remider() {
        int hours = timeProvider.getTime();
        if (hours >= 22) {
            mp3.playSong();
        }
    }

}

class MP3 {
    public void playSong() {
        System.out.println("start song");
    }
}
