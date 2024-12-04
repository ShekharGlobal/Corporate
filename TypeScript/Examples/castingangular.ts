let someValue: unknown = "This is a string";

// Type assertion using angle-bracket syntax
let strLength: number = (<string>someValue).length;

console.log(`The length of the string is: ${strLength}`); // Outputs: The length of the string is: 16
