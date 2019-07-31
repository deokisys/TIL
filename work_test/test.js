a = 123;
reverse = (arg)=>{ arg = 321;}
reverse(a);

b=[1,2,3,4,5]

c = b.reduce((acc,ele,i) => {
    acc.push(b[4-i]);
    return acc;
},[]);

console.log(b);
console.log(c);