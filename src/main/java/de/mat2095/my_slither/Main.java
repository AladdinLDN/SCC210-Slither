package de.mat2095.my_slither;

import javax.swing.*;
import java.util.concurrent.TimeUnit;


public final class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("sun.java2d.opengl", "true");

        // workaround to fix issue on linux: https://github.com/bulenkov/Darcula/issues/29
        UIManager.getFont("Label.font");
        try {
            UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MySlitherJFrame SlitherFrame = new MySlitherJFrame();
        SlitherFrame.setVisible(true);

        int minutes = 0;
        long startTime = System.currentTimeMillis();
            while (SlitherFrame.isConnected()) {
                TimeUnit.SECONDS.sleep(1);
                long secondsPassed = (System.currentTimeMillis() - startTime) / 1000;
                if (secondsPassed == 60) {
                    secondsPassed = 0;
                    startTime = System.currentTimeMillis();
                }
                if ((secondsPassed % 60) == 0) {
                    minutes++;
                }
                System.out.println("waddup");
                SlitherFrame.updateTime(minutes, secondsPassed);
            }
        }
    }
