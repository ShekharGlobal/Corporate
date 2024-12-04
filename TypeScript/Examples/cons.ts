class Person {
    name: string;
    age: number;

    // Constructor method
    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    // Method to display person information
    displayInfo(): void {
        console.log(`Name: ${this.name}, Age: ${this.age}`);
    }
}

// Creating an instance of the Person class
const person1 = new Person('Priya', 30);
person1.displayInfo();  // Output: Name: Alice, Age: 30
