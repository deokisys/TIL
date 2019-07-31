//TodoHtmlView.js는 html/log.html 파일과 내용을 생성하는 view생성 클래스이다.
///html/log.html 파일내용은 아래와 같으며, 현재todlist 상태값이 출력될때마다 업데이트 된다.
//TodoHtmlView.js는 template literal을 활용해서 HTML문자열을 생성할 수 있고, 'fs' 와 같은 모듈을 사용할 수 있다.
//TodoHtmlView.js 는 ES Classes로 구현한다.
///html/log.html 내용

//https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Inheritance_and_the_prototype_chain
//상속
module.exports = class {
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
