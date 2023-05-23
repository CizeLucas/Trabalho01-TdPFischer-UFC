
public class RoboPeao extends RobosAbstract{

	public RoboPeao(int id, String nome, Plano plano, int posXInicial, int posYInicial) {
		super(id, nome, plano, posXInicial, posYInicial);
		apelidoNoPlano = 'P';
	}

	
	public void avancar() {
		int coordTemp[] = this.movimentarRobo(coord, 1, 0);
		coord[0] = coordTemp[0];
		coord[1] = coordTemp[1];
		if(!coord.equals(coordTemp)) {
			this.checarAlunoOuBug(coord);
			System.out.println("robo se moveu");
		}
		
	}

	public void retroceder() {
		int coordTemp[] = this.movimentarRobo(coord, -1, 0);
		coord[0] = coordTemp[0];
		coord[1] = coordTemp[1];
		if(!coord.equals(coordTemp)) {
			this.checarAlunoOuBug(coord);
			System.out.println("robo se moveu");
		}
	}

}
