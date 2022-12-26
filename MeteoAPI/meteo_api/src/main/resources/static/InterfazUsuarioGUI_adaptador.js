
function ObtenerCoordenadasYMetereologia() {
    const poblacion = document.getElementById("poblacion").value;
    const codigoPais = document.getElementById("codigoPais").value;

    fetch("http://localhost:8080/meteo", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
        }
    })
        .then((response) => {
            if (!response.ok) {
                alert(
                    "No se ha podido obtener datos metereologicos:\n" +
                        response.status +
                        " " +
                        response.statusText
                );
            }
            return response.json();
        })
        .then((jsonData) => {
            const timestamp = new Date(Date.now());
            console.log(timestamp.toISOString(), "Consulta metereologica para [" + poblacion + " , " + codigoPais + "], con resultado: ", JSON.stringify(jsonData));
            //_TODO_pendiente recuperarlos datos reales.
            const temperaturaActual = jsonData["temperatura_celsius"];
            const humedadActual = jsonData["temperatura_celsius"];
            const vientoVelocidad = jsonData["temperatura_celsius"];
            const vientoDireccion = jsonData["temperatura_celsius"];
            document.getElementById("contenedorRespuestaAPI").innerHTML =
                "<p> Temperatura: " +
                temperaturaActual +
                "°C </p>" +
                "<p> Humedad: " +
                humedadActual +
                "% </p>" +
                "<p> Viento: " +
                vientoVelocidad +
                "m/s , soplando desde " +
                vientoDireccion +
                "°" +
                "</p>" +
                "<p><small>Consulta realizada el " +
                timestamp.toLocaleString() +
                "</small></p>";
        })
        .catch((error) => alert("Se ha producido un error al obtener datos metereologicos:\n" + error.message));}