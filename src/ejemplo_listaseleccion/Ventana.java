/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_listaseleccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Brandon A. Jacobo
 */
 public class Ventana extends JFrame implements ActionListener{
    CampoLista alumno1, alumno2, alumno3;
    JButton btnEvaluar;
    
    public Ventana() {
        super.setTitle("Ventana lista");
        super.setBounds(100, 100, 800, 600);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        //Creando campo de lista.
        alumno1 = new CampoLista("Juan Juanito Junacio Junio", getWidth()/2-200, 100, 400, 50);
        alumno2 = new CampoLista("El otro juanito que no es juanito", getWidth()/2-200, 150, 400, 50);
        alumno3 = new CampoLista("El juanito que es juanito", getWidth()/2-200, 200, 400, 50);
        //Añadiendo al JFrame
        super.add(alumno1);
        super.add(alumno2);
        super.add(alumno3);
        //Boton
        btnEvaluar = new JButton("Evaluar");
        btnEvaluar.setBounds(getWidth()/2-40, getHeight()-200, 80, 30);
        btnEvaluar.addActionListener(this);
        super.add(btnEvaluar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnEvaluar)){
            String asistencia = "Falta";
            if(alumno1.esEstadoSeleccion()){//Estado es marcado, true
                asistencia = "Asistencia";
            }
            System.out.println("Alumon: "+alumno1.getTexto()+" Tiene: "+asistencia);
            asistencia = "Falta";
            if(alumno2.esEstadoSeleccion()){//Estado es marcado, true
                asistencia = "Asistencia";
            }
            System.out.println("Alumon: "+alumno2.getTexto()+" Tiene: "+asistencia);
            asistencia = "Falta";
            if(alumno3.esEstadoSeleccion()){//Estado es marcado, true
                asistencia = "Asistencia";
            }
            System.out.println("Alumon: "+alumno3.getTexto()+" Tiene: "+asistencia);
        }
    }

}
