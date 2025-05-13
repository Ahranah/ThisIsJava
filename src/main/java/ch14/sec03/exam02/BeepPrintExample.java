package ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    toolkit.beep();
                    // static 호출
                    try{ Thread.sleep(500);}
                    catch (InterruptedException e) {}
                }
            }
        });
        thread.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("beep");
            try{ Thread.sleep(500);} catch(InterruptedException e) {}
        }
    }
}
