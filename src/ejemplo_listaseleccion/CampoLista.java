package ejemplo_listaseleccion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Brandon A. Jacobo
 */
public class CampoLista extends JPanel implements ActionListener{
    private BotonSeleccion btnSeleccion;
    private JLabel lblCampo;
    private Color colorCampoSelect, colorCampoNoSelect;
    
    /**
     * Tamaño y posicion del CampoLista, contiene un texto y un boton como "seleccion"
     * Ideal para realizar un pase de asistencia
     * @param texto del campo de la lista
     * @param posX posicion en eje X
     * @param posY posicion en eje Y
     * @param ancho ancho en pixeles
     * @param alto  alto en pixeles
     */
    public CampoLista(String texto, int posX, int posY, int ancho, int alto){
        super.setBounds(posX, posY, ancho, alto);
        super.setLayout(null);
        btnSeleccion = new BotonSeleccion(getWidth()-40, getHeight()/2-10, 20, 20);
        btnSeleccion.addActionListener(this);
        lblCampo = new JLabel(texto);
        lblCampo.setFont(new Font("Arial", 0, 24));
        lblCampo.setBounds(0, 0, getWidth()-40, getHeight());
        colorCampoSelect = new Color(0,255,0);
        colorCampoNoSelect = new Color(255,0,0);
        super.setBackground(colorCampoNoSelect);
        super.add(lblCampo);
        super.add(btnSeleccion);
    }
    
    /**
     * Cambiar el texto actual del CampoLista
     * @param nuevoTexto nuevo texto del CampoLista
     */
    public void setNuevoTexto(String nuevoTexto){
        lblCampo.setText(nuevoTexto);
    }
    /**
     * Obtener el texto actual del CampoLista
     * @return el String texto
     */
    public String getTexto(){
        return lblCampo.getText();
    }
    
    /**
     * 
     * @param nuevoColorCampoSelect nuevo color para cuando se selecciona el campo
     */
    public void setColorCampoSelect(Color nuevoColorCampoSelect){
        colorCampoSelect = nuevoColorCampoSelect;
    }
    
    /**
     * 
     * @param nuevoColorCampoNoSelect nuevo color para cuando no se selecciona el campo
     */
    public void setColorCampoNoSelect(Color nuevoColorCampoNoSelect){
        colorCampoNoSelect = nuevoColorCampoNoSelect;
    }
    
    /**
     * 
     * @return el boton seleccion
     */
    public BotonSeleccion getBtnSeleccion(){
        return btnSeleccion;
    }
    
    /**
     * 
     * @return estado del boton
     * - true: boton seleccionado
     * - false: boton no seleccionado
     */
    public boolean esEstadoSeleccion(){
        return btnSeleccion.getEstado();
    }
    
    /**
     * 
     * @param nuevoEstado nuevo estado del boton
     * - true: boton seleccionado
     * - false: boton no seleccionado
     */
    public void setEstadoSeleccion(boolean nuevoEstado){
        btnSeleccion.setEstado(nuevoEstado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Cambioando estado del boton
        if(btnSeleccion.getEstado()){
            btnSeleccion.setEstado(false);
        }else{
            btnSeleccion.setEstado(true);
        }
        //Cambiando el color del JPanel de acuerdo a el estado
        if(btnSeleccion.getEstado()){
            super.setBackground(colorCampoSelect);
        }else{
            super.setBackground(colorCampoNoSelect);
        }
    }
}
