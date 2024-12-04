// Parent class
class Animal {
    name: string;

    constructor(name: string) {
        this.name = name;
    }

    makeSound(): void {
        console.log('Some generic animal sound');
    }
}

// Child class inheriting from Animal
class Dog extends Animal {

    constructor(name: string) {
        super(name);  // Call the parent class constructor
    }

    makeSound(): void {
        console.log('Woof! Woof!');
    }
}

// Creating an instance of Dog
const dog = new Dog('Buddy');
console.log(dog);
dog.makeSound();  // Output: Woof! Woof!
