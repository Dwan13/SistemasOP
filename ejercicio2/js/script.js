var timellegada = [0];
var timeRafaga = [];
var timeRetorno = [];
var timeEspera = [];
var timeFinal = [];
var comodin = 0;
var row = Math.floor((Math.random() * 100) + 1);

function createTime() {
  //create timellegada
  for (var i = 1; i < row; i++) {
    comodin = comodin + (i * Math.floor((Math.random() * 10) + 1))
    timellegada.push(comodin)
  }
  //create timeRafaga
  for (var i = 0; i < row; i++) {
    timeRafaga.push(i * Math.floor((Math.random() * 10) + 1))
  }
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
      if (r >= 1) {
        if (c === 0) {
          document.write(td_start + "P" + r + td_end);
        } else {
          if (r === 1 && c === 1) {
            document.write(td_start + timellegada[0] + " segundos" + td_end);
          } else if (r > 1 && c === 1) {
            document.write(td_start + timellegada[r] + " segundos" + td_end);
          } else if (c === 2) {
            document.write(td_start + timeRafaga[r] + " segundos" + td_end);
          } else {
            document.write(td_start + r + " " + c + td_end);
          }
        }
      }
    }
    document.write(tr_end);
  }
  document.write(table_end);
}
