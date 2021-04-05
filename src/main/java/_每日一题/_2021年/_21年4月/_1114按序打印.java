package _每日一题._2021年._21年4月;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: _1114按序打印
 * @Author: lerry_li
 * @CreateDate: 2021/04/05
 * @Description
 */
public class _1114按序打印 {

    /**
     * 解法1：lock-free无锁编程 使用volatile修时共享变量
     */
    class Foo {

        private volatile int flag;

        public Foo() {
            flag=1;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag=2;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while(flag!=2);
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag=3;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while(flag!=3);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }
}
