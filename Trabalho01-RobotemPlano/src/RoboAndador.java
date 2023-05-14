
public class RoboAndador extends RobosAbstract implements RobosInterface {

	public RoboAndador(int id, String nome, Plano plano, int posXInicial, int posYInicial) {
		super(id, nome, plano, posXInicial, posYInicial);
		apelidoNoPlano = 'A';
	}
	
	public void avancar(int qtd) {
		int coordTemp[] = this.movimentarRobo(coord, 0, qtd);
		coord[0] = coordTemp[0];
		coord[1] = coordTemp[1];
		if(!coord.equals(coordTemp)) {
			this.checarAlunoOuBug(coord);
			System.out.println("robo se moveu");
		}
		
	}
	
	public void voltar(int qtd) {
		int coordTemp[] = this.movimentarRobo(coord, 0, (-1)*qtd);
		coord[0] = coordTemp[0];
		coord[1] = coordTemp[1];
		if(!coord.equals(coordTemp)) {
			this.checarAlunoOuBug(coord);
			System.out.println("robo se moveu");
		}
	}

	public int[] getCoord() {
		return coord;
	}
	
}
