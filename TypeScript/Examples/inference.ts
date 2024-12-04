let num = 10; // TypeScript infers 'num' as 'number'
let message = "Hello, TypeScript!"; // TypeScript infers 'message' as 'string'
let isDone2 = false; // TypeScript infers 'isDone' as 'boolean'

// Using console.log to print the values and their inferred types
console.log(`num: ${num} (type: ${typeof num})`); // num: 10 (type: number)

console.log(`message: ${message} (type: ${typeof message})`); // message: Hello, TypeScript! (type: string)

console.log(`isDone: ${isDone2} (type: ${typeof isDone2})`); // isDone: false (type: boolean)

