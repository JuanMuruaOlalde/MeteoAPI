function ObtenerCoordenadasYMetereologia() {
  const poblacion = document.getElementById("poblacion").value;
  const codigoPais = document.getElementById("codigoPais").value;
  const datos = {
    "poblacion": poblacion,
    "codigoPais": codigoPais
  };
  const url = new URL("http://localhost:8080/meteo");
  for (let dato in datos) {
    url.searchParams.append(dato, datos[dato]);
  }
  fetch(url, {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
    //body: JSON.stringify({"poblacion": poblacion, "codigoPais": codigoPais})
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
      console.log(
        timestamp.toISOString(),
        "Consulta metereologica para [" +
          poblacion +
          " , " +
          codigoPais +
          "], con resultado: ",
        JSON.stringify(jsonData)
      );
      const temperaturaActual = jsonData["temperatura_celsius"];
      const humedadActual = jsonData["humedad_porcentual"];
      const vientoVelocidad = jsonData["velocidadDelViento_ms"];
      const vientoDireccion = jsonData["orientacionDelViento_grados"];

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
    .catch((error) =>
      alert(
        "Se ha producido un error al obtener datos metereologicos:\n" +
          error.message
      )
    );
}
