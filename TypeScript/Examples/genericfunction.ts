function identity<T>(arg: T): T {
    return arg;
}

let output1 = identity("Welcome to TS");  // Explicit type
let output2 = identity(100);  // Type inferred as number

console.log(output1);  // Output: Welcome to TS
console.log(output2);  // Output: 100
