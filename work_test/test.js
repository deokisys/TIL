//병합 완료
var a =1;
var b ="1";
var b =3;//중복 선언 가능

let count = 0;
let count_al = [];
const sequence_plus = (exename) => count_al[count++]=exename;

let c = 1; //
//let c = 3;// 중복 선언 불가능
console.log(a==b);//형태만
console.log(a===b);//형식도 

//함수 선언
function a(){
    return 1;
}

var a = function(){ //이벤트에서 자주 쓰인다고 한다.
    return 1;
}

//배열
var a = [];
var a =[1,2];
console.log(a);

//객체? 해쉬같음
//객체 안에 객체 생성 가능 
var kk = {3:1,1:2,2:3};//key:value
var kk={};
var kk = new Object();
kk[3] = 1;
kk[1]=2;
kk[2]=3;
console.log(kk[3]);

//출력 like print
//document.write();


function test(){
    test2(arguments);
}
function test2(){
    console.log(arguments);
    console.log(arguments[0]);
    console.log(arguments[0][0]);
    console.log(arguments[0][1]);
}

function fi(...hi){
    fi2(hi);
}
function fi2(...hl){
    const sss = hl[0];
    console.log(sss);
    console.log(sss[0]);
    sequence_plus("gggggggg1");
}
fi2(test);
sequence_plus("gggggggg");

console.log(count_al[0]);
console.log(count_al[1]);