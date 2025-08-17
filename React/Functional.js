import React, { useState, useEffect } from "react";

function FunctionalDemo() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log("useEffect: Component mounted");
    return () => {
      console.log("Cleanup: Component will unmount");
    };
  }, []); // [] means run only once (like componentDidMount + componentWillUnmount)

  useEffect(() => {
    console.log("useEffect: Count changed:", count);
  }, [count]); // runs when `count` updates (like componentDidUpdate)

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h1>Count: {count}</h1>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

export default FunctionalDemo;
