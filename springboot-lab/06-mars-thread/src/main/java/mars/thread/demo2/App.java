package mars.thread.demo2;

public class App {

    public static void main(String[] args) {
        synchronized (App.class){
        }
        test2();
    }

    private static synchronized void test2() {}
}
