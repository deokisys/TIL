function makeArray(n, init) {
    if (init === undefined) {
        return [...Array(n).keys()];//[0,1,2,3,4,...]
    } else {
        return [...Array(n).fill().map((ele) => init)];//[init,init,init,...]
    }
}