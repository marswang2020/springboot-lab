package mars.gupao.singleton.test;

import mars.gupao.singleton.threadlocal.ThreadLocalSingleton;

/**
 * Created by Tom.
 */
public class ExectorThread implements Runnable{

    public void run() {

//        LazySimpleSingletion instance = LazySimpleSingletion.getInstance();
//        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + instance);

    }
}
