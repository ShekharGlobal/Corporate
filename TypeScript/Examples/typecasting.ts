class Employee {
    employeeId: number;
    constructor(employeeId: number) {
        this.employeeId = employeeId;
    }
}

class Manager extends Employee {
    constructor(employeeId: number, public department: string) {
        super(employeeId);
    }
}

const emp: Employee = new Manager(1, 'Sales');
console.log((<Manager>emp).department);  // Type casting to Manager to access department
