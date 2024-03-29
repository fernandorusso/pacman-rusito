package titiritero.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import titiritero.ControladorJuego;




public class MouseClickController extends MouseAdapter {

	private ControladorJuego controlador; 
	
	public MouseClickController(ControladorJuego unControlador) {
		this.controlador = unControlador;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		this.controlador.despacharMouseClick(e.getX(), e.getY());
	}
	
}
