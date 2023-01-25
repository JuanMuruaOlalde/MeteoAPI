window.addEventListener("load", () => {
  fetch("/meteo/ultimasConsultas", {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        alert(
          "No se ha podido obtener datos históricos de las últimas consultas:\n" +
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
        "Consulta de los últimas consultas metereologicas. ",
        JSON.stringify(jsonData)
      );
      if (jsonData.size === 0) {
        cuerpoDeLaTabla.innerHTML =
          "<tr><td colspan=" + "6" + ">No datos que mostrar</td></tr>";
      } else {
        jsonData.forEach((parte) => {
          cuerpoDeLaTabla = document.getElementById("cuerpoDeLaTabla");
          cuerpoDeLaTabla.innerHTML +=
            "<tr>" +
            "<td>" +
            parte["ubicacion"] +
            "</td>" +
            "<td>" +
            parte["fecha"] +
            "</td>" +
            "<td>" +
            parte["temperatura_celsius"] +
            " °C</td>" +
            "<td>" +
            parte["humedad_porcentual"] +
            " %</td>" +
            "<td>" +
            parte["velocidadDelViento_ms"] +
            " m/s</td>" +
            "<td>" +
            parte["orientacionDelViento_grados"] +
            " °</td>" +
            "</tr>";
        });
      }
    })
    .catch((error) =>
      alert(
        "Se ha producido un error al obtener datos históricos de las últimas consultas:\n" +
          error.message
      )
    );
});
