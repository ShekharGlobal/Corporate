// App.js
import React, { useContext } from "react";
import { CounterProvider, CounterContext } from "./CounterContext";

const CounterDisplay = () => {
  const { count } = useContext(CounterContext);
  return <h1>Count: {count}</h1>;
};

const CounterButtons = () => {
  const { increment, decrement } = useContext(CounterContext);
  return (
    <>
      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>
    </>
  );
};

export default function App() {
  return (
    <CounterProvider>
      <CounterDisplay />
      <CounterButtons />
    </CounterProvider>
  );
}
