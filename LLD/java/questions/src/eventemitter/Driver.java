package eventemitter;

import eventemitter.model.emitter.EventDispatcher;
import eventemitter.model.emitter.EventEmitter;
import eventemitter.model.enums.EventType;
import eventemitter.model.event.Event;
import eventemitter.model.listener.Listener;
import eventemitter.model.listener.SimpleListener;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        Listener l1 = new SimpleListener("l1");
        Listener l2 = new SimpleListener("l2");
        Listener l3 = new SimpleListener("l3");
        EventEmitter eventEmitter = new EventDispatcher();
        eventEmitter.subscribe(EventType.TYPE1, l1);
        eventEmitter.subscribe(EventType.TYPE2, l1);
        eventEmitter.subscribe(EventType.TYPE3, l1);
        eventEmitter.subscribe(EventType.TYPE1, l2);
        eventEmitter.subscribe(EventType.TYPE3, l2);
        eventEmitter.subscribe(EventType.TYPE3, l3);
        Thread t1 = new Thread(()->{
            // emit type1
            for(int i=0;i<2;i++) {
                eventEmitter.emit(new Event(EventType.TYPE1, "helloType1- "+i+":"+ Thread.currentThread().getName()));
            }
        },"t1");
        Thread t2 = new Thread(()->{
            // emit type2
            for(int i=0;i<2;i++) {
                eventEmitter.emit(new Event(EventType.TYPE2, "helloType2- "+i+":"+ Thread.currentThread().getName()));
            }
        },"t2");
        Thread t3 = new Thread(()->{
            // emit type3
            for(int i=0;i<2;i++) {
                eventEmitter.emit(new Event(EventType.TYPE3, "helloType3- "+i+":"+ Thread.currentThread().getName()));
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(3000);
        eventEmitter.unsubscribe(EventType.TYPE3, l3);
        eventEmitter.emit(new Event(EventType.TYPE3, "this is something new! "+Thread.currentThread().getName()));
        Thread.sleep(5000);
        eventEmitter.stopEventLoop();
        eventEmitter.emit(new Event(EventType.TYPE1, "event after stoping eventloop! "+Thread.currentThread().getName()));
        eventEmitter.startEventLoop();
    }
}
