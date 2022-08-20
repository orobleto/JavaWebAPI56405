import React from "react";



const saludo = "Te saludo desde aca...";

function Boton() {
    return (
        <button>Enviar</button>
    );
}

const Link = () => <a href="https://www.educacionit.com/">ir a educacion it</a>

export default function App(params) {
    return(
      <div>
        {saludo}
        <br/>
        <Boton/>
        <br/>
        <Link/>
      </div>
    );
}