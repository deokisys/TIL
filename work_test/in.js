Observer = class{
    constructor() {
        this.data;
        let ss = require("./pub.js");
        const publisher = new ss.Publisher();
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



const sub1 = new Observer(publisher);
sub1.subscribe(publisher);


console.log("test");
sub1.subscribe(publisher);
