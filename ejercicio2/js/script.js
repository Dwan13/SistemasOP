var btn = document.createElement('button');
btn.innerHTML = "Iniciar";
document.body.appendChild(btn);
btn.addEventListener("click", createTable, true);
function createTable(){
var div = document.createElement('div');
div.setAttribute("id", "tbl");
document.body.appendChild(div)
	document.getElementById("tbl").innerHTML = "<table border = '1'>" +
  '<tr>' +
    '<th>Proceso</th>' +
    '<th>Tiempo de Llegada</th> ' +
    '<th>Tiempo de Rafaga</th>' +
  '</tr>' +
  '<tr>' +
    '<td>cell</td>' +
    '<td>cell</td>' +
    '<td>cell</td>' +
  '</tr>' +
  '<tr>' +
    '<td>cell</td>' +
    '<td>cell</td>' +
    '<td>cell</td>' +
  '</tr>' +
  '<tr>' +
    '<td>cell</td>' +
    '<td>cell</td>' +
    '<td>cell</td>' +
  '</tr>'
};
