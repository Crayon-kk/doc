package com.java.doc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("--------A--- come in");
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }

        }, "A").start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("--------B--- come in");
//                TimeUnit.MINUTES.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
            } finally {
                lock.unlock();

            }
        }, "B").start();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("--------C--- come in");
//                TimeUnit.MINUTES.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
            } finally {
                lock.unlock();

            }
        }, "C").start();


    }
}
