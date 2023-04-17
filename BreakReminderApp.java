import java.util.Timer;
import java.util.TimerTask;

class BreakReminderApp {
   //private int breakLength; // in minutes
    private int breakFrequency; // in minutes
    private Timer timer;
    private boolean isBreakTime;

    public BreakReminderApp(int breakLength, int breakFrequency) {
        //this.breakLength = breakLength;
        this.breakFrequency = breakFrequency;
        this.isBreakTime = false;
    }

    public void startSchedule() {
        if (timer == null) {
            timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (isBreakTime) {
                        System.out.println("Your break is over - time to get back to work");
                        isBreakTime = false;
                    } else {
                        System.out.println("It's break time!");
                        isBreakTime = true;
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 0, breakFrequency * 60 * 1000); // convert minutes to milliseconds
        } else {
            System.out.println("Schedule is already running.");
        }
    }

    public void stopSchedule() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println("Schedule stopped.");
        } else {
            System.out.println("Schedule is not running.");
        }
    }

    public boolean isRunning() {
        return timer != null;
    }
}
