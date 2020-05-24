package mars.thread.demo1.zk;

public class Main {

    PrintProcessor printProcessor;
    protected Main(){
        SaveProcessor saveProcessor=new SaveProcessor();
        saveProcessor.start();

        printProcessor=new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request){
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Request request = new Request();
            request.setName("Mic"+i);
            new Main().doTest(request);
        }
    }
}
