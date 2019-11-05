/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_listaseleccion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Brandon A. Jacobo
 */
public class BotonSeleccion extends JButton{

    private boolean estado;

    public BotonSeleccion(int posX, int posY, int ancho, int alto) {
        super.setBounds(posX, posY, ancho, alto);
        super.setContentAreaFilled(false);
        estado = false;
    }

    /**
     *
     * @param nuevoEstado Estado nuevo del boton - true: Boton seleccionado -
     * false: Boton sin seleccion
     */
    public void setEstado(boolean nuevoEstado) {
        estado = nuevoEstado;
    }

    /**
     *
     * @return el estado del boton - true: Boton seleccionado - false: Boton sin
     * seleccion
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Modifica los colores del boton si se Presiona, Pasa sobre el o sin
     * interaccion 0
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        //Para saber cuando presionas el boton o no
        if (this.getModel().isRollover()) { //Pasando por el boton
            g.setColor(Color.GRAY);
        } else {//Sin interaccion
            g.setColor(new Color(220,220,220));
        }
        if (this.getModel().isPressed()) { //Presionando el boton
            g.setColor(Color.BLACK);
        }
        g.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 50, 50);
        if (estado) {
            g.setColor(Color.BLACK);
            g.fillRoundRect(3, 3, this.getWidth() - 7, this.getHeight() - 7, 50, 50);
        }
        super.paintComponent(g);
    }

    /**
     * Modifica borde del boton
     *
     * @param g
     */
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(1, 1, this.getWidth() - 3, this.getHeight() - 3, 50, 50);
        g.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 50, 50);
    }

    /**
     * Modifica el contenedor del boton
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean contains(int x, int y) {
        Shape figura;
        figura = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);
        return (figura.contains(x, y));
    }
    
}
