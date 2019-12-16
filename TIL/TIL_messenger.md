### 1대1 메신저 만들기

## 시작하기

### 프로젝트 생성하기

- firebase 사이트로 가서 회원가입 후, 웹 프로젝트 생성한다.
  ![프로젝트 생성](https://user-images.githubusercontent.com/24247768/70297151-354da800-1830-11ea-8cd1-ad0fb0cfad4c.png)
- 프로젝트로 들어가서 'project overview'의 proejct settings로 이동한다.
- ![설정위치](https://user-images.githubusercontent.com/24247768/70296273-5365d900-182d-11ea-84ae-0a1b58c0af0a.png)
- 앱이 없는경우 앱 추가하기를 한다.
- 일반의 내앱의 firebase SDK snippet탭의 CDN을 선택하여 스크립트를 복사한다
- ![키](https://user-images.githubusercontent.com/24247768/70296393-dbe47980-182d-11ea-8527-c9a8fcfad6c4.png)

---

### 프로젝트에 적용하기

- 위에서 가져온 키를 아래와 같이 하나의 파일에서 관리하도록 한다.

```js
//firebase.js
import * as firebase from "firebase"
import "firebase/database"//자신이 쓰려는 firebase기능을 추가한다.
let firebaseConfig ={
    apiKey:
    authDomain: ,
    databaseURL: ,
    projectId: ,
    storageBucket: ,
    messagingSenderId: ,
    appId: ,
    measurementId:
}

function Firebase() {
  if (!firebase.apps.length) {//로딩 여부
    firebase.initializeApp(firebaseConfig) //설정 초기화
  }
  firebase.analytics()
  this.database = firebase.database()

  //필요한 로직을 넣는다.
}

export default new Firebase()


```

---

### firebase 데이터베이스 설정하기

- 이제 firebase를 적용할 프로젝트의 루트폴더에서 콘솔로 입력하여 firebase설정을 구성한다.

1. 로그인

- `firebase login`으로 로그인을 한다.

1. firebase 기능을 선택하여 설치

- `firebase init`
- ![firebase init](https://user-images.githubusercontent.com/24247768/70296744-c91e7480-182e-11ea-97d6-e54edc5c25ed.png)
- database를 스페이스바로 선택하고 enter로 다음으로 넘어간다.
- 'Please select an option'
  - `Use an existing project`을 선택
- `Select a default Firebase project for this directory:`
  - 사이트에서 생성한 프로젝트를 선택
- `What file should be used for Database Rules?`
  - 자동으로 (database.rules.json)입력된것을 enter하여 넘겨준다.
- ![선택 예](https://user-images.githubusercontent.com/24247768/70296989-afc9f800-182f-11ea-92f9-ef58af7a7e21.png)
- database.rules.json설정
  `{ "rules": { ".read": true, ".write": true } }`
- 읽기, 쓰기를 true로 하여 읽고 쓰기가 가능하도록 한다.

### 사용하는법

```js
import firebase from "./firebase"

...

firebase.database.ref(...)...//이런식으로 사용한다.
```

- 설정파일을 import하여 사용한다.

---

## 메신저 데이터베이스 예

![메신저 데이터베이스 예](https://user-images.githubusercontent.com/24247768/70298637-ab084280-1835-11ea-8f9a-42f18421b6bd.png)

- messages/방번호/{text:내용,time:시간,userid:작성한사람}
- rooms/방번호/{사용자아이디:true,사용자아이디:true,recent:{text:내용}}

---

## 함수 설명

### 데이터베이스 경로 선택

```js
this.database.ref("경로");
```

### 읽기

- 한번 읽기

```js
this.database
  .ref("경로")
  .once("value")
  .then(result => {
    result.val();
  });
```

- 리스너같이 변화를 감지하며 읽기

```js
this.database.ref("경로").on("value", function(snapshot) {
  snapshot.val();
});
```

### 쓰기

- set함수로 해당 내용으로 덮어서 쓴다.

```js
this.database.ref("경로").set({});
```

- push함수로 경로에 해당 내용을 추가한다.

```js
this.database.ref("경로").push({});
```

### 탐색

- `orderByChild("키")`으로 키를 정렬하고, equalTo("값")으로 해당 키가 해당 키를 가진 부모 키를 찾아낸다.

```js
this.database
  .ref("/rooms/")
  .orderByChild("1")
  .equalTo(true);
//query: room에서 1:true인것을 찾아라
```

---

### useEffect unsubscribe하기

- useEffect에서 리스너를 추가할경우 unsubscribe하도록 하여 리스너가 중첩되지 않게 한다.

```
UseEffect(()=>{
    firebase.get().on("value", listener)
    return () => firebase.get().off("value", listener)//unsubscribe
},[])
```

---

### 무료 조건

![무료](https://user-images.githubusercontent.com/24247768/70306187-8322da00-1849-11ea-82f3-4ad10cc770f8.png)

- 참고

* https://steemit.com/react-native/@rkzhap123/react-native-1
* https://www.youtube.com/watch?v=K_wZCW6wXIo
* https://firebase.google.com/docs/web/setup?authuser=0
* https://firebase.google.com/docs/database/web/start?authuser=0
* https://firebase.google.com/docs/database/web/read-and-write?authuser=0
* https://firebase.google.com/pricing/?hl=ko
