const appendLazy = (arr, data, time) => {
    return new Promise(resolve => {
        setTimeout(() => {
            arr.push(data);
            resolve(arr)
        }, time)
    });
}
arr = [10,20]
let start = appendLazy(arr, 30000, 2000);
//then
console.log("test1");
start.then((res) => {
    console.log("test3");
    console.log(res);
    console.log("test4");
})
console.log("test2");