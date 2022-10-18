package reentrantlock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/10/18
 * @since 1.0.0
 */
public class VolatileExample extends Thread {
    public volatile static Boolean stop = false;
    /**
     * volatile 保证可见性（主内存-本地内存） 有序性（禁止cpu指令重排）
     * AtomicInteger 使用cas保证原子性
     */
    public volatile static AtomicInteger w = new AtomicInteger(0);

    @Override
    public void run() {
//        int i=0;
//        while(!stop){ //load
//            i++;//。。。。
//        }
        for (int i = 0; i < 10000; i++) {
            w.getAndAdd(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //可见性
//        new Thread(new VolatileExample(),"线程").start();
//        Thread.sleep(1000);
//        stop = true;

        //原子性测试
        for (int i = 0; i < 5; i++) {
            new Thread(new VolatileExample(), "线程" + i).start();
        }
        Thread.sleep(3000);

        System.out.println(w.get());
    }
}
