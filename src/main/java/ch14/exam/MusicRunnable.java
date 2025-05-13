package ch14.exam;

public class MusicRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("playing music");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

