//https://j911.me/2018/10/observer-pattern.html

class Observer{
    constructor() {
        this.data;
    }

    subscribe(publisher) {
        this.publisher = publisher;
        this.publisher.add(this);
    }

    update() {
        this.data = this.publisher.state;
        console.log('update: ' + this.data);
    }

}
class Publisher {
    constructor() {
        this.observers = [];
        this.state = null;
    }
    add(observer) {
        this.observers.push(observer);
    }

    delete(observer) {
        const index = this.observers.indexOf(observer);
        this.observers.splice(index, 1);
    }
    notifyObservers() {
        this.observers.forEach(observer => {
            observer.update();
        });
    }

    publish(test) {
        this.state = test;
        this.notifyObservers()
    }
}



const publisher = new Publisher();
const sub1 = new Observer(publisher);


sub1.subscribe(publisher);

publisher.publish("hello");

module.exports = {
    a,
    b
}

const { b } = require(asdf);