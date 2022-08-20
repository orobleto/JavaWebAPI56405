import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import HolaMundo from './HolaMundo';


/*
const contenedor = document.getElementById("rootDIV");
const h1 = document.createElement("h1");
const saludo = "Hola Mundo desde JS";
h1.innerText = saludo;
contenedor.appendChild(h1);
*/

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<React.StrictMode>
  <HolaMundo/>
  <App/>
</React.StrictMode>
);



