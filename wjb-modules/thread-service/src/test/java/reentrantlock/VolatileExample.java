package reentrantlock;

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
    public volatile static int w = 0;

    @Override
    public void run() {
//        int i=0;
//        while(!stop){ //load
//            i++;//。。。。
//        }
        for (int i = 0; i < 10000; i++) {
            w = w + 1;
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
        int h = w;
    }
}
