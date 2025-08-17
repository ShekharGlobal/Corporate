import React from "react";
import { useSelector, useDispatch } from "react-redux";

function App() {
  // Access state
  const count = useSelector((state) => state.count);

  // Dispatch actions
  const dispatch = useDispatch();

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Redux Counter Example</h1>
      <h2>{count}</h2>
      <button onClick={() => dispatch({ type: "INCREMENT" })}>Increment</button>
      <button onClick={() => dispatch({ type: "DECREMENT" })}>Decrement</button>
    </div>
  );
}

export default App;
