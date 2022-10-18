package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/10/18
 * @since 1.0.0
 */
public class ReentrantLockExample extends Thread {
    volatile static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ReentrantLockExample(), "线程" + i).start();
        }
    }
}
