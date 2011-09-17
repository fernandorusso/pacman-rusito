package titiritero;

/**
 * Esta abstracci�n es s�lo a fin de poder abstraerse de la API gr�fica de Java
 * y poder testear la soluci�n facilmente.
 **/
public interface SuperficieDeDibujo {
	public void limpiar();
	public void actualizar();
	public Object getBuffer();
}
