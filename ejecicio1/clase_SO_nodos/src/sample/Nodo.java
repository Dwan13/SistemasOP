package sample;

public class Nodo {

    private int valor;//valor inicial
    private Nodo proximo; //puntero hacia el siguiente nodo
    String nombre;

    //Constructor simple, inicializa sin valor
    public Nodo() {
        this.valor=0;
        this.proximo=null;
    }

    //Constructor
    public Nodo(int valor){
        this.valor=valor;
        this.proximo=null;
    }

    //Envia el valor
    public void setValor(int valor){
        this.valor = valor;
    }

    //Apunta y enviar el valor al siguiente nodo
    public void setProximo(Nodo siguiente){
        this.proximo = siguiente;
    }

    //Recibe el valor del nodo
    public int getValor(){
        return this.valor;
    }

    //Recibe el valor del siguiente nodo
    public Nodo getProximo(){
        return this.proximo;
    }
}
