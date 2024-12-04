abstract class Vehicle {

    constructor(public brand: string) {}

    abstract startEngine(): void;  // Abstract method

    displayBrand(): void {
        console.log(`Brand: ${this.brand}`);
    }
}

class Car extends Vehicle {
    
    constructor(brand: string) {
        super(brand);
    }

    startEngine(): void {
        console.log(`${this.brand} engine started.`);
    }
}

// const vehicle = new Vehicle('Toyota'); // Error: Cannot create an instance of an abstract class
const car = new Car('Toyota');
car.startEngine();  // Output: Toyota engine started.
car.displayBrand();  // Output: Brand: Toyota
