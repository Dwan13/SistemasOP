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
public class Colas {
int i,num,t_proceso;
nodo nuevo,cab,p,aux;
public void nuevo(){
    p=new nodo();
    p.sig=p;
    cab=p;
}
public void procesos(){
        Random rnd= new Random();
        num= rnd.nextInt(35);
        for(i=1;i<=num;i++){
            t_proceso=rnd.nextInt(800);
            nuevo=new nodo();
            nuevo.proceso=i;
            nuevo.tiempo=t_proceso;
            cab.sig=nuevo;
            nuevo.sig=p;
            cab=nuevo;
        }
    }
public void imprimir(){
    nuevo=p.sig;
    while(nuevo != p){
        System.out.println(nuevo.proceso + "........."+ nuevo.tiempo);
        System.out.print("\n");
        nuevo= nuevo.sig;
    }
    System.out.println("\n");
    System.out.println("Total de processo en cola .........."+num);
    
}
public void terminar(){
    aux=p;
    if(aux==aux.sig){
        System.out.println("No hay procesos en cola.....");
        
    }else{
        aux=p.sig;
        while(nuevo != p){
            System.err.println("Proceso en ejecución "+nuevo.proceso);
            for(i=1;i<=100000000;i++){
                
            }
            p.sig=aux.sig;
            aux=p.sig;
        }
                
    }
}

}
