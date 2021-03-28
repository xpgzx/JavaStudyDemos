package javaBase.thread.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * @className: ProducerConsumerModel
 * @description:        该类使用wait/notify 来实现生产者消费者模式
 * @author: gezx
 * @date: 2021/3/24
 **/
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Produce produce = new Produce(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(produce).start();
        new Thread(consumer).start();
    }
}

class Produce implements Runnable{

    private EventStorage storage;

    public Produce(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable{

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            storage.take();
        }
    }
}



class EventStorage{
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        this.maxSize = 100;
        this.storage = new LinkedList<>();
    }

    public synchronized void put(){
        while(storage.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品。");
        notify();
    }

    public synchronized void take(){
        while(storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + "现在仓库还剩下" + storage.size() +"个产品。");
        notify();
    }

}
