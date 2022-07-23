const URL_DESA = "http://localhost:8080/ServicioRest/apis/usuarios/";



fetch(URL_DESA + "listar").
    then(response => response.json()).
    then(usuariosJSON => {

        usuariosJSON.map(e => {
            document.write('<div id ="' + e.correo + '">')
            document.write("Correo: " + e.correo + "<br>");
            document.write("Clave: " + atob(e.clave) + "<br>");
            document.write("<br><div>")
        }
        )
        return usuariosJSON;
    }
    ).
    catch(error => console.log(error));

usuario = {
    correo: "user12@educacionit.com",
    clave: "12345555"
}


const OBJETO_POST = {
    method: "PUT",
    body: JSON.stringify(usuario),
    headers: {
        "content-type": "application/json"
    }
}


fetch(URL_DESA + "guardarJSON", OBJETO_POST).
    then(response => response.json()).
    then(usuario => console.log(usuario)).
    catch(error => console.log(error));


fetch(URL_DESA+"eliminar", {
    method: "DELETE",
    body: JSON.stringify({
        correo: "user2@gmail.com",
        clave: "65432132"
    }),
    headers: {
        "content-type": "application/json"
    }
}).
then(response=>response.json()).
then(usuarioEliminado=>console.log(usuarioEliminado)).catch(error=>console.log(error));

fetch(URL_DESA+"buscarQ?correo=user9@educacionit.com",{
    method: "GET",
    headers: {
        "content-type": "application/json"
    }
}).
then(response=>response.json()).
then(usuario => console.log(usuario)).
catch(error => console.log(error));



