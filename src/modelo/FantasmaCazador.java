package modelo;

// Blinky:
// 		Forma de Perseguir: Blinky conoce a cada paso la ubicaci�n de PacMan y decide c�mo moverse seg�n qu�
// direcci�n est� m�s cerca para comerlo.
// 		Forma de Huir: Como conoce la ubicaci�n de Pacman se fija en qu� direcci�n lo tiene m�s cerca y se
// aleja de ella.

public class FantasmaCazador extends Fantasma {

	public FantasmaCazador(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
	}

	public void huir(PacMan pacman) {
		try {
			if(Math.abs(this.getX() - this.getLaberinto().getPacMan().getX()) <= 
				Math.abs(this.getY() - this.getLaberinto().getPacMan().getY())){
					if((this.getX() - this.getLaberinto().getPacMan().getX()) < 0){
						this.setIzquierda();
					}else{
						if((this.getX() - this.getLaberinto().getPacMan().getX()) > 0){
							this.setDerecha();
						}
						else {
							if((this.getY() - this.getLaberinto().getPacMan().getY()) < 0){
								this.setArriba();
							}
							else{
								if((this.getY() - this.getLaberinto().getPacMan().getY()) > 0){
									this.setAbajo();
								}
							}
						}
					}
			} else {
				if((this.getY() - this.getLaberinto().getPacMan().getY()) < 0){
					this.setArriba();
				}else{
					if((this.getY() - this.getLaberinto().getPacMan().getY()) > 0){
						this.setAbajo();
					}
					else {
						if((this.getX() - this.getLaberinto().getPacMan().getX()) < 0){
							this.setIzquierda();
						}
						else{
							if((this.getX() - this.getLaberinto().getPacMan().getX()) > 0){
								this.setDerecha();
							}
						}
					}
				}
			}
		}
		catch (PosicionInvalidaException e) {
		}
	}

	public void perseguir(PacMan pacman) {
		try {
			if(Math.abs(this.getX() - this.getLaberinto().getPacMan().getX()) <= 
				Math.abs(this.getY() - this.getLaberinto().getPacMan().getY())){
					if((this.getX() - this.getLaberinto().getPacMan().getX()) < 0){
						this.setDerecha();
					}
					else{
						if((this.getX() - this.getLaberinto().getPacMan().getX()) > 0){
							this.setIzquierda();
						}
						else {
							if((this.getY() - this.getLaberinto().getPacMan().getY()) < 0){
								this.setAbajo();
							}
							else{
								if((this.getY() - this.getLaberinto().getPacMan().getY()) > 0){
									this.setArriba();
								}
							}
						}
					}
			} else {
				if((this.getY() - this.getLaberinto().getPacMan().getY()) < 0){
					this.setAbajo();
				}
				else{
					if((this.getY() - this.getLaberinto().getPacMan().getY()) > 0){
						this.setArriba();
					}
					else {
						if((this.getX() - this.getLaberinto().getPacMan().getX()) < 0){
							this.setDerecha();
						}
						else{
							if((this.getX() - this.getLaberinto().getPacMan().getX()) > 0){
								this.setIzquierda();
							}
						}
					}
				}
			}
		}
		catch (PosicionInvalidaException e) {
		}
	}
	
	@Override
	public void jugarTurno() {
		this.decidirEstrategia();
		for(int i = 1 ; i <= this.getVelocidad()+1 ; i++) {
			this.mover();	
		}
	}
	
}

