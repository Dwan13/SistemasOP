var timellegada = [0];
var timeRafaga = [];
var timeRetorno = [];
var timeEspera = [];
var timeFinal = [];
var comodin = 3;
var row = Math.floor(Math.random() * (10 - 2)) + 2;

function createTime() {
  //create timellegada
  for (var i = 1; i < row - 1; i++) {
    comodin = comodin + Math.floor((Math.random() * 10) + 1) * i
    timellegada.push(comodin)
  }
  console.log("timellegada ", timellegada);
  //create timeRafaga
  for (var i = 0; i < row - 1; i++) {
    timeRafaga.push(Math.floor((Math.random() * 100) + 1))
  }
  console.log("timeRafaga ", timeRafaga);

  //create timeFinal
  timeFinal.push(timeRafaga[0])
  for (var i = 1; i < row - 1; i++) {
    timeFinal.push(timeRafaga[i] + timeFinal[i - 1])
  }
  console.log("timeFinal ", timeFinal);
  //create timeRetorno
  for (var i = 0; i < row - 1; i++) {
    timeRetorno.push(timeFinal[i] - timellegada[i])
  }
  console.log("timeRetorno ", timeRetorno);
  //create timeEspera
  for (var i = 0; i < row - 1; i++) {
    timeEspera.push(timeRetorno[i] - timeRafaga[i])
  }
  console.log("timeEspera ", timeEspera);
}

function create() {
  createTime()
  var table_start = "<table id=myTable border=1>";
  var table_end = "</table>";
  var tr_start = "<tr>";
  var tr_end = "</tr>";
  var td_start = "<td>";
  var td_end = "</td>";
  document.write(table_start);

  for (var r = 0; r < row; r++) {
    document.write(tr_start);
    for (var c = 0; c < 6; c++) {
      if (r === 0 && c === 0) {
        document.write(td_start + "Proceso" + td_end);
      }
      if (r === 0 && c === 1) {
        document.write(td_start + "Tiempo de llegada" + td_end);
      }
      if (r === 0 && c === 2) {
        document.write(td_start + "Tiempo de Rafaga" + td_end);
      }
      if (r === 0 && c === 3) {
        document.write(td_start + "Tiempo de retorno" + td_end);
      }
      if (r === 0 && c === 4) {
        document.write(td_start + "Tiempo de espera" + td_end);
      }
      if (r === 0 && c === 5) {
        document.write(td_start + "Tiempo Final" + td_end);
      }
      if (r >= 1 && c === 0) {
        document.write(td_start + "P" + r + td_end);
      }
      if (r >= 1 && c === 1) {
        document.write(td_start + timellegada[r - 1] + " llegada" + td_end);
      }
      if (r >= 1 && c === 2) {
        document.write(td_start + timeRafaga[r - 1] + " Rafaga" + td_end);
      }
      if (r >= 1 && c === 3) {
        document.write(td_start + timeRetorno[r - 1] + " Retorno" + td_end);
      }
      if (r >= 1 && c === 4) {
        document.write(td_start + timeEspera[r - 1] + " Espera" + td_end);
      }
      if (r >= 1 && c === 5) {
        document.write(td_start + timeFinal[r - 1] + " Final" + td_end);
      }
    }
    document.write(tr_end);
  }
  document.write(table_end);
}
