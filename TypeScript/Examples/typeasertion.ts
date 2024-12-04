let s1: unknown = "Hello, TypeScript";

// Type assertion to string
let i: number = (s1 as string).length;
console.log(i);  // Output: 17

