import React, { Component } from "react";

class LifecycleDemo extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    console.log("Constructor: Component is being created");
  }

  componentDidMount() {
    console.log("componentDidMount: Component mounted on screen");
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("componentDidUpdate: Component updated");
    console.log("Previous state:", prevState, "Current state:", this.state);
  }

  componentWillUnmount() {
    console.log("componentWillUnmount: Component will be removed");
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "20px" }}>
        <h1>Count: {this.state.count}</h1>
        <button onClick={() => this.setState({ count: this.state.count + 1 })}>
          Increment
        </button>
      </div>
    );
  }
}

export default LifecycleDemo;
