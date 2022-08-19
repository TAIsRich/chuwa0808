package Hw5_Multithreading_updated.q22_codePratice;

public class Daemon {
    public static void main(String[] args) {

        Thread tPpl = new Thread(new People());
        Thread tGod = new Thread(new God());
        Thread tGod2 = new Thread(new God());

        tGod.setDaemon(true);
        tGod.start();
        tPpl.start();
        tGod2.setDaemon(true);
        tGod2.start(); // 当只剩下守护进程时候，哪怕是有多个，jvm也会退出
        System.out.println("Main end");
    }
}
