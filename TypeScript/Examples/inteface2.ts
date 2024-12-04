interface PersonInterface {
    name: string;
    age: number;
    greet(): string;
  }
  
  class Persons implements PersonInterface {
    name: string;
    age: number;
  
    constructor(name: string, age: number) {
      this.name = name;
      this.age = age;
    }
  
    greet(): string {
      return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
    }
  }
  
  const personObj2 = new Persons('Navinkumar karnati', 21);
  console.log(personObj2.greet());
  