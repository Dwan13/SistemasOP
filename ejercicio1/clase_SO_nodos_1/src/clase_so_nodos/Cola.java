/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_so_nodos;

import java.util.Random;

/**
 *
 * @author HP
 */
public class Cola {
int i,num,t_proceso;
nodo cab,aux,aux_2,cajero;

Cola(){
    cajero = new nodo();
    cajero.nombre = "cajero";
    //cajero.sig=cajero;
}
public void nuevo(String nombre){
    nodo nuevo=new nodo();
    nuevo.nombre = nombre;
    if (cab==null){
        cab=nuevo;
        cab.sig = cajero;
        cajero.sig = cab;
        aux = cab;
    }
    else{
        nuevo.sig=cajero;
        aux.sig = nuevo;
        aux = nuevo;
    }
}

public String extraerElemento(){
    if (cab==null){
        return cajero.nombre+" --> No hay elementos";
    }
    else{
        aux_2 = cab;
        if (cab != cab.sig){
            cab = cab.sig;
            cajero.sig = cab;
            return aux_2.nombre;
        }
        else{
            cab=null;
            return aux_2.nombre;
        }    
    }
}

public String mostrarCola(){
    if (cab==null){
        return cajero.nombre+" --> No hay elementos";
    }
    else{
        nodo recorredor = cajero;
        String nodoCadena="";
        nodoCadena = nodoCadena +" --> "+recorredor.nombre;
        recorredor = recorredor.sig;
        while (recorredor!=cajero) {
            nodoCadena = nodoCadena +" --> "+recorredor.nombre;
            recorredor = recorredor.sig;
        }
        return nodoCadena;
    }
}

public String numElementos(){
    if (cab==null){
        return "No hay elementos";
    }
    else{
        nodo recorredor = cab;
        int contador=0;
        contador=contador+1;
        recorredor = recorredor.sig;
        while (recorredor!=cab) {
            contador=contador+1;
            recorredor = recorredor.sig;
        }
        return ""+contador;
    }
}

}
