/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_so_nodos;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Interfaz extends JFrame implements ActionListener{
   
    private Label interfaz;
    private JTextArea salida;
    private Button añadir_elemento;
    private Button eliminar_elemento;
    private Button mostrar_cola;
    private Button numero_elementos;
    private Cola cola;
    
    Interfaz(){
        
        this.setLayout(null);
        cola = new Cola();
        this.interfaz = new Label("Sistema de Colas");
        this.interfaz.setFont(new Font("Serif", Font.CENTER_BASELINE, 24));
        this.interfaz.setBounds(100,25,400,50);
        this.add(this.interfaz);
        
        this.salida = new JTextArea();
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        JScrollPane scrollPane = new JScrollPane(this.salida); 
        this.salida.setEditable(true);
        this.salida.setFont(new Font("Serif", Font.BOLD, 12));
        this.salida.setBounds(100,50,400,150);
        this.add(this.salida);
        this.add(scrollBar);
        this.add(scrollPane);
        
        
        
        this.añadir_elemento = new Button("Añadir elemento");
        this.añadir_elemento.setBounds(100, 200, 150, 50);
        this.añadir_elemento.setActionCommand("agregar");
        this.añadir_elemento.addActionListener(this);
        this.add(this.añadir_elemento);
        
        
        this.eliminar_elemento = new Button("Eliminar elemento");
        this.eliminar_elemento.setBounds(300, 200, 150, 50);
        this.eliminar_elemento.setActionCommand("eliminar");
        this.eliminar_elemento.addActionListener(this);
        this.add(this.eliminar_elemento);
        
        
        this.mostrar_cola = new Button("Mostrar Cola");
        this.mostrar_cola.setBounds(100, 300, 150, 50);
        this.mostrar_cola.setActionCommand("mostrar");
        this.mostrar_cola.addActionListener(this);
        this.add(this.mostrar_cola);
        
        this.numero_elementos = new Button("Número de elementos");
        this.numero_elementos.setBounds(300, 300, 150, 50);
        this.numero_elementos.setActionCommand("numero");
        this.numero_elementos.addActionListener(this);
        this.add(this.numero_elementos);
        
        
        
        this.setResizable(true);
        this.setBounds(300, 200, 600, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "agregar":{
                cola.nuevo(JOptionPane.showInputDialog(null));
                this.salida.setText(cola.mostrarCola());
                String tex = cola.mostrarCola();
                this.salida.append(cola.mostrarCola());
                this.salida.setText(tex);
                this.salida.repaint();
                System.out.println(cola.mostrarCola());
                break;
            }
            case "eliminar":{
                JOptionPane.showConfirmDialog(null, cola.extraerElemento());
                this.salida.setText(cola.mostrarCola());
                System.out.println(cola.mostrarCola());
                break;
            }
            case "mostrar":{
                this.salida.setText(cola.mostrarCola());
                System.out.println(cola.mostrarCola());
                break;
            }
            case "numero":{
                JOptionPane.showMessageDialog(null, cola.numElementos());
                System.out.println(cola.numElementos());
                break;
            }
        }
    }
    

    
}
