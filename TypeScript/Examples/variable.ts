
// 1. Boolean
let isDone: boolean = true;
console.log(`Is done: ${isDone}`); // Output: Is done: true










// 2. Number
let decimal: number = 10;
let hex: number = 0xff;
let binary: number = 0b1010;
let octal: number = 0o12;
console.log(`Decimal: ${decimal}, Hex: ${hex}, Binary: ${binary},
  Octal: ${octal}`);

// 3. String
let firstName: string = "Vikas";
let lastName: string = "S";
let fullName: string = `${firstName} ${lastName}`;
console.log(`Full Name: ${fullName}`); // Output: Full Name: Vikas S

// 4. Array
let list: number[] = [1, 2, 3, 4, 5];
let stringList: Array<string> = ["one", "two", "three"];

console.log(`Number List: ${list}`);
console.log(`String List: ${stringList}`);

// 5. Tuple
let tuple: [string, number];
tuple = ["hello", 42]; // OK
console.log(`Tuple: ${tuple}`); // Output: Tuple: hello,42

// 6. Enum
enum Color {
  Red = 1,
  Green,
  Blue,
}
let colorName: string = Color[2];
console.log(`Color at position 2: ${colorName}`); // Output: Color at position 2: Green

// 7. Unknown
let notSure: unknown = 4;
console.log(`Unknown value (number): ${notSure}`); // Output: Unknown value (number): 4

notSure = "maybe a string";
console.log(`Unknown value (string): ${notSure}`); // Output: Unknown value (string): maybe a string

// 8. Any
let anything: any = "Hello";
anything = 42;
anything = true;
console.log(`Any type value: ${anything}`); // Output: Any type value: true

// 9. Void
function warnUser(): void {
  console.log("This is a warning message");
}
warnUser(); // Output: This is a warning message

// 10. Null and Undefined
let u: undefined = undefined;
let n: null = null;
console.log(`Undefined: ${u}, Null: ${n}`); // Output: Undefined: undefined, Null: null

// 11. Never
function error(message: string): never {
  throw new Error(message);
}

// Uncommenting this will terminate the program due to the thrown error
// error("Something went wrong!");

// 12. Object
let someObject: object = { name: "Ajay", age: 25 };
console.log(`Object: ${JSON.stringify(someObject)}`); // Output: Object: {"name":"Ajay","age":25}

