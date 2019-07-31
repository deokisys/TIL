module.exports.Publisher = class {
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
const tt = new this.Publisher();
tt.publish("feafsadsafdsafdfasd");
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let tmp = 0;
rl.setPrompt("명령하세요 : ");
rl.prompt();
rl.on('line', (input) => {
    if (input === "q") {
        console.log(`(프로그램 종료)`);
        rl.close();
        process.exit();
    } else {
        tt.publish(input);
        rl.prompt();
    }

});


