package titiritero.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import titiritero.ControladorJuego;
import titiritero.SuperficieDeDibujo;


public class Panel extends java.awt.Panel implements SuperficieDeDibujo {


	private static final long serialVersionUID = -5159188497592488407L;
	private Image imagen;

	// es llamado internamente por el metodo repaint() de la clase Frame
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(this.imagen, 0, 0, null);
	}
	
	@Override
	public void actualizar() {
		this.repaint();
	}

	@Override
	public void limpiar() {
		if(this.imagen == null)
			this.imagen = this.createImage(getSize().width, getSize().height);
		Graphics superficieParaDibujar =  this.imagen.getGraphics();
		superficieParaDibujar.setColor(Color.black);// 
		superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);
		this.setBackground(Color.black);
	}

	public Object getBuffer(){
		return this.imagen.getGraphics();
	}
	
	public Panel(int ancho,int alto, ControladorJuego unControlador){
		this.addMouseListener(new MouseClickController(unControlador));
		this.setSize(ancho, alto);
		this.setVisible(true);
	}
	
	public Panel(int ancho,int alto){
		this.setSize(ancho, alto);
		this.setVisible(true);
	}

}
