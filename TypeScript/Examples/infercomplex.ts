let numbers = [1, 2, 3]; // TypeScript infers 'numbers' as 'number[]'
let person = { name: "Shiva", age: 30 }; // TypeScript infers 'person' as '{ name: string; age: number; }'

// numbers: 1,2,3 (type: object)
console.log(`numbers: ${numbers} (type: ${typeof numbers})`); 

// person: {"name":"John","age":30} (type: object)
console.log(`person: ${JSON.stringify(person)} (type: ${typeof person})`); 


// Array element type: number
console.log(`Array element type: ${typeof numbers[0]}`); 

// Person name type: string, age type: number
console.log(`Person name type: ${typeof person.name}, age type: ${typeof person.age}`); 

