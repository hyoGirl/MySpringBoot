package com.spring.boot.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/31 20:01
 * @Version 1.0
 */
public class ConditionLock {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Condition product = lock.newCondition();
        Condition consumer = lock.newCondition();


        List<String> list = new ArrayList<>(10);


        Pro p1 = new Pro(lock, product, consumer, list);
        Pro p2 = new Pro(lock, product, consumer, list);

        Con001 c1 = new Con001(lock, product, consumer, list);
        Con001 c2 = new Con001(lock, product, consumer, list);
        Con001 c3 = new Con001(lock, product, consumer, list);


        p1.start();
        c1.start();
        c2.start();
        p2.start();
        c3.start();


//        for (int i = 0; i < 5; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        try {
//                            lock.lock();
//                            while (list.size()==10) {
//                                try {
//                                    product.await();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            list.add("SSS");
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("当前仓库保存的数量为： -->" + list.size());
//                            consumer.signalAll();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        } finally {
//                            lock.unlock();
//                        }
//                    }
//                }
//            }).start();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        for (int i = 0; i < 5; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        try {
//                            lock.lock();
//
//                            while (list.size()==0) {
//                                try {
//                                    consumer.await();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            list.remove(0);
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("当前仓库保存的数量为： --------->" + list.size());
//                            product.signalAll();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        } finally {
//                            lock.unlock();
//                        }
//                    }
//                }
//            }).start();
//        }


    }
}

class Con001 extends Thread {

    ReentrantLock lock;
    Condition product;
    Condition consumer;
    List<String> list;

    Con001(ReentrantLock lock, Condition product, Condition consumer, List<String> list) {
        this.consumer = consumer;
        this.product = product;
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                while (list.size() == 0) {
                    try {
                        consumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前仓库保存的数量为： --------->" + list.size());
                product.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Pro extends Thread {

    ReentrantLock lock;

    Condition product;
    Condition consumer;
    List<String> list;

    Pro(ReentrantLock lock, Condition product, Condition consumer, List<String> list) {
        this.consumer = consumer;
        this.product = product;
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (list.size() == 10) {
                    try {
                        product.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("SSS");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前仓库保存的数量为： -->" + list.size());
                consumer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

