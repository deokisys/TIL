const increment = (input) => { return input + 1; };
const decrement = (input) => { return input - 1; };
const double = (input) => { return input * 2; };
const halve = (input) => { return input / 2 };
// 1. 일반적일 수 있는 로직
const initial_value = 1;
const incremented_value = increment(initial_value);
const doubled_value = double(incremented_value);
const final_value = decrement(doubled_value);
console.log(final_value); // 3

// 2. reduce 를 활용한 함수형 프로그래밍
const pipeline = [
  increment,
  double,
  decrement,
  decrement,
  decrement,
  halve,
  double,
];
const kk = (accumulator, func) => {console.log(accumulator);return func(accumulator);};
const final_value2 = pipeline.reduce(kk, initial_value);
console.log(final_value2); // 1
