var timellegada = [0];
var timeRafaga = [];
var timeRetorno = [];
var timeEspera = [];
var timeFinal = [];
var comodin = 3;
var espacio = 10;
var multiplo = 0;
var tiempo = 1000; // un segundo
var y = 0;
var row = Math.floor(Math.random() * (10 - 2)) + 2;

// //Hilo ejecuta cosas cada 1 segundos
// for (var i = 0; i < 5; i++) {
//   setTimeout((function() {
//     console.log('Ejecuto cosas en el futuro (A) en indice: ', this)
//   }).bind(i), multiplo * tiempo);
//   multiplo += 1; // 1 porque es un procedimiento por for
// }

function createTime() {
  timellegada = [0];
  timeRafaga = [];
  timeRetorno = [];
  timeEspera = [];
  timeFinal = [];
  comodin = 3;
  espacio = 10;
  row = Math.floor(Math.random() * (10 - 2)) + 2;
  //create timellegada
  for (var i = 1; i < row - 1; i++) {
    comodin = comodin + Math.floor((Math.random() * 10) + 1) * i
    timellegada.push(comodin)
  }
  // console.log("timellegada ", timellegada);
  //create timeRafaga
  for (var i = 0; i < row - 1; i++) {
    timeRafaga.push(Math.floor((Math.random() * 100) + 1))
  }
  // console.log("timeRafaga ", timeRafaga);

  //create timeFinal
  timeFinal.push(timeRafaga[0])
  for (var i = 1; i < row - 1; i++) {
    timeFinal.push(timeRafaga[i] + timeFinal[i - 1])
  }
  // console.log("timeFinal ", timeFinal);
  //create timeRetorno
  for (var i = 0; i < row - 1; i++) {
    timeRetorno.push(timeFinal[i] - timellegada[i])
  }
  // console.log("timeRetorno ", timeRetorno);
  //create timeEspera
  for (var i = 0; i < row - 1; i++) {
    timeEspera.push(timeRetorno[i] - timeRafaga[i])
  }
  // console.log("timeEspera ", timeEspera);
}

function createTable() {
  var a = document.body.childNodes
  document.body.removeChild(a[3]);
  var html = "";
  var table_start = "<table border=20>";
  var table_end = "</table>";
  var tr_start = "<tr>";
  var tr_end = "</tr>";
  var td_start = "<td>";
  var td_end = "</td>";
  html += table_start;

  for (var r = 0; r < row; r++) {
    html += tr_start;
    for (var c = 0; c < 6; c++) {
      if (r === 0 && c === 0) {
        html += td_start + "Proceso" + td_end;
      }
      if (r === 0 && c === 1) {
        html += td_start + "Tiempo de llegada" + td_end;
      }
      if (r === 0 && c === 2) {
        html += td_start + "Tiempo de Rafaga" + td_end;
      }
      if (r === 0 && c === 3) {
        html += td_start + "Tiempo de retorno" + td_end;
      }
      if (r === 0 && c === 4) {
        html += td_start + "Tiempo de espera" + td_end;
      }
      if (r === 0 && c === 5) {
        html += td_start + "Tiempo Final" + td_end;
      }
      if (r >= 1 && c === 0) {
        html += td_start + "P" + r + td_end;
      }
      if (r >= 1 && c === 1) {
        html += td_start + timellegada[r - 1] + " llegada" + td_end;
      }
      if (r >= 1 && c === 2) {
        html += td_start + timeRafaga[r - 1] + " Rafaga" + td_end;
      }
      if (r >= 1 && c === 3) {
        html += td_start + timeRetorno[r - 1] + " Retorno" + td_end;
      }
      if (r >= 1 && c === 4) {
        html += td_start + timeEspera[r - 1] + " Espera" + td_end;
      }
      if (r >= 1 && c === 5) {
        html += td_start + timeFinal[r - 1] + " Final" + td_end;
      }
    }
    html += tr_end;
  }
  html += table_end;

  document.body.innerHTML += html;
}

function createGraph() {
  //Create diagrama de grantt
  //create table
  createTime();
  createTable();
  var c = document.getElementById("myCanvas");
  var ctx = c.getContext("2d");
  ctx.lineWidth = "10";
  ctx.moveTo(0, 0);
  ctx.lineTo(timeFinal[timeFinal.length - 1] + 4, 0);
  ctx.stroke();
  for (var i = 0; i < row; i++) {
    setTimeout((function() {
      console.log("HOla entre", this);
      ctx.beginPath();
      ctx.lineWidth = "5";
      ctx.strokeStyle = "#000000";
      ctx.rect(timellegada[y] + timeEspera[y], espacio * y + 20, timeRafaga[y], 5);
      ctx.stroke();
      if (i > 0) {
        ctx.beginPath();
        ctx.lineWidth = "5";
        ctx.strokeStyle = "#dfe9eb";
        ctx.rect(timellegada[y], espacio * y + 20, timeEspera[y], 5);
        ctx.stroke();
      }
      ctx.beginPath() //iniciar ruta
      // ctx.strokeStyle="#ffffff"; //color externo
      ctx.fillStyle = "#ffffff"; //color de relleno
      ctx.font = "bold 10px arial"; //estilo de texto
      ctx.fillText("P" + (y + 1), timellegada[y] + timeEspera[y] + 3, espacio * y + 25);
      ctx.stroke();
      y += 1;
    }).bind(i), multiplo * tiempo);
    multiplo += 1; // 1 porque es un procedimiento por for
  }
}
