package mars.thread.demo1;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {

        MyThread2 myThread1 = new MyThread2();
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread1).start();
        new Thread(myThread2).start();
    }
}