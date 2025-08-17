import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

import { Provider } from "react-redux";
import store from './redux/Store';   // ✅ matches Store.js

import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Provider store={store}>   {/* ✅ prop must be lowercase 'store' */}
      <App />
    </Provider>
  </React.StrictMode>
);

reportWebVitals();
