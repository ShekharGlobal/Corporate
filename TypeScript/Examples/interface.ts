interface PersonInterface {
    name: string;   // The person's name (must be a string)
    age: number;    // The person's age (must be a number)
    greet(): string; // A function that returns a greeting (must return a string)
  }
  

  const personObj: PersonInterface = {
    name: 'Navin', // Assign the name 'Navin' to the 'name' property
    age: 24,       // Assign the age 24 to the 'age' property
    greet: function() {
      // Define the 'greet' function
      return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
    }
  };

console.log(personObj.greet());  // Output: Hello, my name is Navin and I am 24 years old.
