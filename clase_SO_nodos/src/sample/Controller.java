package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    Cola cola = new Cola();//Variable que nos permitirá acceder a los métodos de la clase Cola
    @FXML ComboBox listaMenu;//Definimos el nombre del ComboBox del FXML
    @FXML ListView <Integer> list;//Definimos el nombre del ListView del FXML

    ObservableList<Integer> items1 =FXCollections.observableArrayList();//Lista que nos permitirá añadir elementos al ListView

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Definimos las opciones que tendrá el ComboBox
        this.listaMenu.getItems().addAll("Insertar Elementos", "Mostrar elementos", "Buscar elemento", "Extraer elemento"
                ,"Obtener tamaño de la cola", "Vaciar la cola");

        //Nos permitirá saber que opción eligió el usuario
        listaMenu.setOnAction(event -> {

            //Variable que compara la decisión del usuario con las opción predefinidas
            String value = (String) listaMenu.getValue();

            switch (value) {
                case "Insertar Elementos"://Si el usuario elige insertar datos en la cola

                    if  (cola.frente == null){//Si la cola esta vacía
                        //Pregunta al usuario la cantidad de elementos que  desea insertar y el valor se lo pasa a la variable Rango
                        int rango = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamaño de elementos de la cola"));
                        for (int i = 0; i < rango; i++){//Repite el método de insertar elementos, dependiendo dl rango establecido por el usuario
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor"));
                            cola.insertar(valor);//Llamamos el método de insertar y le pasamos el valor de la variable "valor"
                        }
                    }else{
                        //Pregunta al usuario la cantidad de elementos que  desea insertar y el valor se lo pasa a la variable Rango
                        int rango = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamaño de elementos de la cola"));
                        for (int i = 0; i < rango; i++){//Repite el método de insertar elementos, dependiendo dl rango establecido por el usuario
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor"));
                            cola.insertar(valor);//Llamamos el método de insertar y le pasamos el valor de la variable "valor"
                        }

                        items1.clear();//Limpia la lista
                        list.setItems(items1);//Le pasa la lista vacía al ListView
                        cola.mostrar(items1, list);//Llamamos al método mostrar de la clase Cola y le pasamos los datos actualizados a la lista y al ListView

                    }
                    listaMenu.getSelectionModel().clearSelection();//Limpia la selección del ComboBox
                    break;

                case "Mostrar elementos"://Si el usuario elige mostrar los elementos
                    cola.mostrar(items1, list);//Llamamos al método mostrar y le pasamos los elementos al ListView
                    listaMenu.getSelectionModel().clearSelection();//Limpia la selección del ComboBox
                    break;
                case "Buscar elemento"://Si el usuario elige buscar un elemento
                    //Le preguntamos al usuario el elemento que desea buscar y le pasamos el valor a la variable buscar
                    int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el valor a buscar"));
                    cola.buscar(buscar);//Llamamos al método buscar de la clase Cola y le pasamos el valor de la variable buscar
                    listaMenu.getSelectionModel().clearSelection();//Limpia la selección del ComboBox
                    break;

                case "Extraer elemento"://Si el usuario elige eliminar un valor de la cola

                    items1.clear();//Limpia la lista
                    list.setItems(items1);//y le pasa esa lista vacía al ListView
                    cola.extraer();//Llamamos al método extraer de la clase Cola
                    cola.mostrar(items1, list);//Llamamos al método mostrar y le pasamos el  nombre de la lista y del ListView
                    listaMenu.getSelectionModel().clearSelection();//Limpia la selección del ComboBox
                    break;

                case "Obtener tamaño de la cola"://Si el usuario quiere saber el tamaño de la cola
                    //Llamamos al método tamaño de la Clase Cola y lo mostramos por un mensaje en pantalla
                    JOptionPane.showMessageDialog(null,"El tamaño de la cola es: " + cola.tamano());
                    listaMenu.getSelectionModel().clearSelection();//Limpia la selección del ComboBox
                    break;

                case "Vaciar la cola"://Si el usuario elige eliminar completamente los elementos de la cola
                    //Llamamos al método borrar elementos y le pasamos el nombre de lista y del ListView
                    cola.borrarElementos(items1, list);
                    listaMenu.getSelectionModel().clearSelection();//Limpia la selección del ComboBox
                    break;

                default: break;
            }
        });

    }
}
