class GenericBox<T> {
    private _contents: T;

    constructor(contents: T) {
        this._contents = contents;
    }

    getContents(): T {
        return this._contents;
    }
}

const stringBox = new GenericBox<string>("Hello, world");
console.log(stringBox.getContents());  // Output: Hello, world

const numberBox = new GenericBox<number>(42);
console.log(numberBox.getContents());  // Output: 42
