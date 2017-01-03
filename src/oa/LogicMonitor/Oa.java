package oa.LogicMonitor;


/**
 * Created by Shengwei_Wang on 9/26/16.
 */
class MyThread extends Thread {
    MyThread() {
        System.out.println(" Thread");
    }

    public void run() {
        System.out.println("run");
    }
    public void run(String s) {
        System.out.println("s run");
    }
}

public class Oa {
    public static void main(String[] s) {
        Thread t = new MyThread(){
            public void run(){
                System.out.println("~~run~~");
            }
        };
        t.start();

    }
}