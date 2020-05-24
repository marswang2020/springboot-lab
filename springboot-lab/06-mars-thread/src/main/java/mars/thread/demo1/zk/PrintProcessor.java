package mars.thread.demo1.zk;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class PrintProcessor extends Thread implements
        RequestProcessor {
    LinkedBlockingQueue<Request> requests = new
            LinkedBlockingQueue<Request>();
    private final RequestProcessor nextProcessor;
    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Request request=requests.take();
                System.out.println("print data:"+request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
