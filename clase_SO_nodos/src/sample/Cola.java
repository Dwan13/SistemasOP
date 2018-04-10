package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javax.swing.*;

public class Cola {

    public Nodo frente, cajero;//el inicio de la cola

    public Cola() { //Método que nos permite iniciar la cola en 0 o null
        cajero = new Nodo();
        cajero.nombre = "cajero";
        
        this.frente = null; //Indicamos que la variable frente es igual a nulo
    }

    public void insertar(int valor){ //Método para insertar un elemento a la cola, que nos pedirá el valor del elemento

        Nodo nuevo = new Nodo(valor);// Le asignamos el valor agregado a la variable "valor" e indicamos que es un nuevo nodo

        if(frente == null){// Si el inicio de la cola esta vacío lo asigna como el valor principal
            frente = nuevo; //manda el valor ingresado al frente o inicio de la cola
        }else{
            Nodo temp = frente;
            while(temp.getProximo() != null){// Un ciclo while que si el valor no es nulo
                temp = temp.getProximo();//recibe el siguiente valor ingresado
            }
            temp.setProximo(nuevo);//y enviándolo a la siguiente posición que sigue
        }
    }


    public void buscar(int busqueda) { //Método para buscar un elemento en la cola, que nos pedirá el valor del elemento
        try {
            Nodo temp = frente; //Definimos un nuevo nodo
            int posicion = 1; //Declaramos una variable llamada "posición" con el valor de 0

            if (temp.getValor() == busqueda) { //Si el valor ingresado es igual al primero de la cola
                JOptionPane.showMessageDialog(null,"El valor está en la posición 0");//muestra el mensaje anterior
            } else {
                while (temp != null) {//Un ciclo while que buscara el valor en la cola, siempre y cuando el valor no sea nulo
                    if (temp.getProximo().getValor() == busqueda) {//Si el valor es encontrado en los siguientes elementos de la cola

                        JOptionPane.showMessageDialog(null,"valor en la posición:" + posicion);// muestra el mensaje
                        //anterior.

                        break;//Detiene el proceso
                    }
                    posicion++;//Dependiendo de las veces que repita el proceso será el lugar donde se encuentre
                    temp = temp.getProximo();//Pasa al siguiente valor de la cola y lo envía.
                }}
        }
        catch (Exception ex)
        { //Si el valor no se encuentra en la cola muestra el siguiente mensaje
            JOptionPane.showMessageDialog(null,"El elemento no se encuentra");
        }
    }

    public void mostrar(ObservableList<Integer> items1, ListView<Integer> list){ //Método para mostrar los elementos de la cola en un ListView
        if( frente != null){//Si el valor de la cola no es nulo
            Nodo temp = frente;//Definimos un nuevo nodo

            while(temp != null){//Ciclo while que repetirá el proceso si el valor inicial no es nulo
                items1.addAll(temp.getValor());//Añade el valor de la cola a un lista
                temp = temp.getProximo();//pasa el valor de la cola al inicio para repetir el ciclo
            }

            list.setItems(items1);//Manda todos los valores de la lista un ListView para visualizarlos gráficamente

        }else{//Muestra un mensaje indicándonos que la cola esta vacía
            JOptionPane.showMessageDialog(null,"La cola está vacía.");
        }
    }

    public int extraer(){//Método para extraer el primer valor de la cola
        if(frente == frente.getProximo()){//Si la cola esta vacía
            return 0;//retorna el valor de 0
        }else{
            int valorExtraer = frente.getValor(); //variable temporal
            JOptionPane.showMessageDialog(null,"Valor extraído: "+ frente.getValor());
            frente = frente.getProximo(); //cambiar el frente por el siguiente
            return valorExtraer ; //devolver el valor extraído de la cola
        }
    }

    public void borrarElementos(ObservableList<Integer> items1, ListView<Integer> list){//Método para vaciar la cola
        if(vacia() == true){//Si la cola no tiene ningún valor muestra el mensaje siguiente
            JOptionPane.showMessageDialog(null,"La cola ya está vacía");
        }else{
            while(vacia() == false){
                frente.getValor();//Elimina el valor inicial
                frente = frente.getProximo();//pasa el segundo valor y lo convierte en el inicial repitiendo el proceso de eliminación
            }
            items1.clear();//vacia la lista
            list.setItems(items1);//y actualiza los elementos del ListView
            mostrar(items1, list);//Muestra los elementos de la lista en el ListView

            //Muestra un mensaje confirmándonos que los elementos de la cola han sido eliminados
            JOptionPane.showMessageDialog(null,"La elementos de la cola han sido eliminados");
        }
    }

    public int tamano (){//Método para mostrar el tamaño de la cola
        Nodo aux = null;
        int i=0;//Inicia la variable i en 0
        aux = frente;
        while(aux != null){//Ciclo while que cuenta los elementos de la cola
            aux = aux.getProximo();
            i++;
        }
        return i;//y los almacena en la variable
    }

    public boolean vacia (){//Verifica si el frente de la cola
        return ( frente == frente.getProximo());//es nulo
    }
}
