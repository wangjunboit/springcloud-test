package reentrantlock;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈join 让主线程等待子线程执行结束〉
 *
 * @author wjb
 * @create 2022/10/18
 * @since 1.0.0
 */
public class JoinExample extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new JoinExample());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
