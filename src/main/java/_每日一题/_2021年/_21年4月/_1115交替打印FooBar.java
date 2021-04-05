package _每日一题._2021年._21年4月;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: _1115交替打印FooBar
 * @Author: lerry_li
 * @CreateDate: 2021/04/05
 * @Description
 */
public class _1115交替打印FooBar {
    /**
     * 解法1：ReentrantLock+Condition
     */
    class FooBar {
        private int n;

        private ReentrantLock lock = new ReentrantLock();
        private Condition foo = lock.newCondition(), bar = lock.newCondition();

        private int flag = 1;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                while (flag != 1) {
                    foo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 2;
                bar.signal();
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                if (flag != 2) {
                    bar.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 1;
                foo.signal();
                lock.unlock();
            }
        }
    }

    /**
     * 解法2：Semaphore
     */
    class FooBar2 {
        private int n;

        public FooBar2(int n) {
            this.n = n;
        }

        Semaphore foo = new Semaphore(1);
        Semaphore bar = new Semaphore(0);

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }

    /**
     * 解法3：
     */
    class FooBar3 {
        private int n;

        public FooBar3(int n) {
            this.n = n;
        }

        CyclicBarrier cb = new CyclicBarrier(2);
        volatile boolean fin = true;

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!fin) ;
                printFoo.run();
                fin = false;
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                }
                printBar.run();
                fin = true;
            }
        }
    }

}
