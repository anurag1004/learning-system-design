# EVENT-EMITTER
Design an event emitter that can be used to emit events to multiple listeners. The event emitter should be able to emit events of different types, and the listeners should be able to subscribe to specific event types. The event emitter should also be able to queue events and emit them later.
Here are some of the requirements for the event emitter:
- The event emitter should be able to emit events of different types.
- The listeners should be able to subscribe to specific event types.
- The event emitter should be able to queue events and emit them later.
- The event emitter should be thread-safe.
- The event emitter should be scalable.

Here is a possible design for the event emitter:
- The event emitter will be a class with the following methods:
- on(type, listener): This method subscribes a listener to an event type.
- once(type, listener): This method subscribes a listener to an event type, but the listener will only be called once.
- emit(type, args): This method emits an event of a specific type.
- off(type, listener): This method unsubscribes a listener from an event type.
- The event emitter will also have a queue of events. When an event is emitted, it will be added to the queue. The event emitter will then have a thread that processes the queue and emits the events to the listeners.
- The event emitter will be thread-safe by using a lock to protect the queue. The event emitter will be scalable by using a thread pool to process the queue.