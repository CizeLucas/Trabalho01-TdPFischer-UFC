import java.util.ArrayList;
import java.util.Random;

public class Plano {
	
	//private RobosAbstract roboAndador;
	private int tamanho;
	private ArrayList<Celulas> celulas;
	
	public Plano(int tamanho, int qtdBugs, int qtdAlunos, int[] coordInicialRobos) {
		this.tamanho = tamanho;
		int temp=0;
		celulas = new ArrayList<Celulas>();
		int cont=0;
		for(int y=0; y<tamanho; y++) {
			for(int x=0; x<tamanho; x++) {
				celulas.add(new Celulas(cont, x, y));
				cont++;
				if(coordInicialRobos[0]==x && coordInicialRobos[1]==y)
					temp=cont;
			}
		}
		
		//gera um ArrayList entre 0 e ((tamanho^2)-1) que se refere as posicoes do arraylist de celulas
		Random numAleatorio = new Random();
		ArrayList<Integer> listaNumAleatorios = new ArrayList<>();
		int num;
		for(; listaNumAleatorios.size()<(qtdBugs+qtdAlunos); ) {
			do {
				num = numAleatorio.nextInt(tamanho*tamanho);
			} while(listaNumAleatorios.contains(num) || num==temp);
			listaNumAleatorios.add(num);
		}
		
		//for para ler o ArrayList de numeros aleatorios e atribuir bugs ou alunos as celulas
//		for(int i=0; i<listaNumAleatorios.size(); i++) {
//			if(i<qtdBugs) {
//				celulas.get(listaNumAleatorios.get(i)).addBug();
//			} else {
//				celulas.get(listaNumAleatorios.get(i)).addAluno();
//			}
//		}
		celulas.get(2).addAluno();
		celulas.get(6).addAluno();
		celulas.get(8).addBug();
		celulas.get(11).addBug();
		celulas.get(16).addAluno();
		celulas.get(22).addBug();
		celulas.get(24).addAluno();
		/*
		------------			Andador: R 2
		| * * ! * * |			Peao: R
		| * ! * & * |			Torre: A 2
		| * & r * * |			Bispo: A 1	
		| * ! * * * |			Cavalo: R 1
		| * * & * ! |			Rei: A 1
		------------			Rainha: R 4
		*/
		
	} // fim construtor
	
	private Celulas encontrarCelula(int[] coord) {
			for (Celulas celula : this.celulas)
				if(celula.getCoords()[0] == coord[0] && celula.getCoords()[1] == coord[1]) 
					return celula;
		return null;
	}
	
	protected void inicializarRobo(int coord[], RobosAbstract robo) {
		if(this.coordExiste(coord))
			this.encontrarCelula(coord).addRobo(robo);
			this.encontrarCelula(coord).setTrueRoboVisitou();
	}
	
	private boolean coordExiste(int coord[]) {
		if(coord[0]<tamanho && coord[0]>=0 && coord[1]<tamanho && coord[1]>=0)
			return true;
		return false;
	}
	
	protected int[] retornarCoordValida(int coord[]) {
		for(int i=0; i<2; i++) {
			if(coord[i]>=0) {
				while(!(coord[i]<tamanho)) {
					coord[i]--;
				}
			} else {
				while(!(coord[i]>=0)) {
					coord[i]++;
				}	
			}
		} //fim loop for
		return coord;
	}
	
	protected void moverRobo(int coordInicial[], int coordFinal[], RobosAbstract robo) {
		this.encontrarCelula(coordInicial).removerRobo(robo);
		this.encontrarCelula(coordFinal).addRobo(robo);
		//metodo remove o robo da coordInicial e adiciona-o em coordFinal do movimento
	}

//	public boolean celulaTemAluno(int coord[]) {
//		for (Celulas celula : celulas)
//			if(celula.getCoords()[0] == coord[0] && celula.getCoords()[1] == coord[1]) 
//				if(celula.temAluno() && !celula.roboVisitou()) 
//					return true;
//		return false;
//	}
	
	protected boolean celulaTemAluno(int coord[]) {
		Celulas celulaTemp = encontrarCelula(coord);
			if(celulaTemp.temAluno() && !celulaTemp.roboVisitou()) 
				return true;
		return false;
	}
	
	protected boolean celulaTemBug(int coord[]) {
		Celulas celulaTemp = encontrarCelula(coord);
			if(celulaTemp.temBug() && !celulaTemp.roboVisitou())
				return true;
		return false;
	}
	
	protected boolean checarSeJogoAcabou() {
		boolean jogoAcabou = true;
		for (Celulas celula : this.celulas)
			if(celula.roboVisitou() &&  (celula.temAluno() || celula.temBug())) 
				jogoAcabou = false;
		
		return jogoAcabou;
	}
	
	protected void roboVisitouCelula(int coord[]) {
		this.encontrarCelula(coord).setTrueRoboVisitou();
	}
	
	protected void imprimirTabuleiro() {
		Celulas celulaTemp;		
		for(int i=1; i<=(int)tamanho*2.4; i++) 
			System.out.print("-");
		System.out.println();
		for(int i=1; i<=tamanho*tamanho; i++) {
			celulaTemp = celulas.get(i-1);
			
			if((i-1)%tamanho==0)
				System.out.print("| ");
			
			if(celulaTemp.temRobo()) {
				System.out.print(celulaTemp.getRobo().getApelidoNoPlano()+" ");
			} else {
				System.out.print(celulaTemp.imprimir()+" ");
			}
			
			if(i%tamanho==0) {
				System.out.println("|");
				
			}
				
		}
		for(int i=1; i<=(int)tamanho*2.4; i++) 
			System.out.print("-");
		System.out.println();
	}
	
}
