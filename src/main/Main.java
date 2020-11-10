package main;

import javax.swing.*;

import modules.*;
import labels.*;

public class Main {

    public static boolean isRunning = true;

    private final String APP_NAME = "CPUZ CLONE";
    private Text cpuSystemUsageText;
    private Text cpuAppUsageText;
    private static JFrame frame;
    private double latencyTime = 0.5;
    private SystemInfo sys;
    private final Vector2 WINDOW_SIZE = new Vector2(500, 500);

    public Main() {
        sys = new SystemInfo();
        frame = new JFrame(APP_NAME);
        frame.setSize((int) WINDOW_SIZE.x, (int) WINDOW_SIZE.y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CallMethods();
    }

    public void GUIInstance() {
        JPanel panel = new JPanel();
        new Text(panel, "CPU USAGE: ");
        cpuSystemUsageText = new Text(panel, "...");
        new Text(panel, "APP TOTAL USAGE: ");
        cpuAppUsageText = new Text(panel, "...");
        frame.add(panel);
    }

    public static void CallMethods() {
        Main main = new Main();
        main.Run();
    }

    public void Run() {
        GUIInstance();
        long currentTime = System.nanoTime();
        long lastTime = currentTime;
        while (isRunning) {
            try {
                Thread.sleep(50);
                double timer = (currentTime - lastTime) / 1000000000;
                currentTime = System.nanoTime();
                if (timer >= latencyTime) {
                    Tick();
                    lastTime = currentTime;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Tick() {
        String cpuSystemUsage = sys.CpuSystemUsage() * 100 + "%";
        cpuSystemUsageText.setText(cpuSystemUsage);
        String appSystemUsage = sys.CpuAppUsage() * 100 + "%";
        cpuAppUsageText.setText(appSystemUsage);
    }
    
}
