
Array.prototype.equals = function (arr) {
    if (this.length !== arr.length) return false;

    for (let i in arr) {
        let t = this[i],
            a = arr[i];
        console.log("-----------------------------------");
        console.log(i);
        console.log(t);
        console.log(a);
        if (t instanceof Array && a instanceof Array) {
            console.log("둘다 array래");
            if (!t.equals(a)){
                console.log("둘이 같지않데");
                return false;
            }
        } else if (this[i] !== arr[i]) {
            console.log("둘이 안같데");
            return false;
        }
    }

    return true;
}

console.log([1, 2, [3, 4], 5, [6, [7, 8, [91]]]].equals([1, 2, [3, 4], 5, [6, [7, 8, [91]]]]));
//console.log([1, 2, [3], 5, [6, [7, 8, [91]]]].equals([1, 2, [3, 4], 5, [6, [7, 8, [91]]]]));