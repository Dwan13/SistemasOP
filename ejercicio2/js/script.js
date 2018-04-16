
function create() {
  mostrar=document.getElementById("Mostrar");
  var table_start = "<table id=myTable border=1>";
  var table_end = "</table>";
  var tr_start = "<tr>";
  var tr_end = "</tr>";
  var td_start = "<td>";
  var td_end = "</td>";
  var row = Math.floor((Math.random() * 100) + 1);
  document.write(table_start);

  for (var r = 0; r < 10; r++) {
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
      if (r>=1) {
        document.write(td_start + "Datos" + td_end);
      }
    }
    document.write(tr_end);
  }
  document.write(table_end);
}
