import java.util.ArrayList;
import java.util.Random;

public class Plano {
	
	public RobosAbstract roboAndador;
	public int tamanho;
	public ArrayList<Celulas> celulas;
	
	public Plano(int tamanho) {
		this.tamanho = tamanho;
		celulas = new ArrayList<Celulas>();
		int cont=0;
		for(int y=0; y<tamanho; y++) {
			for(int x=0; x<tamanho; x++) {
				celulas.add(new Celulas(cont, x, y));
				cont++;
			}
		}
		
		Random numAleatorio = new Random();
		ArrayList<Integer> listaNumAleatorios = new ArrayList<>();
		int qtdBugs=8;
		int qtdAlunos=8;
		int num;
		for(; listaNumAleatorios.size()<(qtdBugs+qtdAlunos); ) {
			do {
				num = numAleatorio.nextInt(tamanho*tamanho);
			} while(listaNumAleatorios.contains(num) || num==0);
			listaNumAleatorios.add(num);
		}
		
//		for (Integer integer : listaNumAleatorios) {
//			System.out.print(integer+", ");
//		}
		
		int countBug=0;
		int countAluno = 0;
		for(int i=0; i<listaNumAleatorios.size(); i++) {
			if(i<qtdBugs) {
				countBug++;
				//System.out.println("bug: "+listaNumAleatorios.get(i));
				celulas.get(listaNumAleatorios.get(i)).addBug();
			} else {
				countAluno++;
				celulas.get(listaNumAleatorios.get(i)).addAluno();
			}
		}
		
		
		//System.out.println("\nqtd Bugs: "+ countBug +"   qtd Alunos: "+countAluno);
		
	} // fim construtor
	
	public void inicializarRobo(int x, int y, RobosAbstract robo) {
		int coord[] = new int[2];
		coord[0]=x;
		coord[1]=y;
		if(this.coordExiste(coord)) {
			for (Celulas celula : this.celulas) 
				if(celula.getX() == coord[0] && celula.getY() == coord[1]) {
					celula.addRobo(robo);
				}	
		}
	}
	
	public boolean coordExiste(int coord[]) {
		if(coord[0]<tamanho && coord[0]>=0 && coord[1]<tamanho && coord[1]>=0)
			return true;
		return false;
	}
	
	public void moverRobo(int coordInicial[], int coordFinal[], RobosAbstract robo) {
		for (Celulas celula : celulas) {
			if(celula.getX() == coordInicial[0] && celula.getY() == coordInicial[1]) 
				celula.removerRobo(robo);
			
			if(celula.getX() == coordFinal[0] && celula.getY() == coordFinal[1]) 
				celula.addRobo(robo);
		}
		
		
		
	}

	public boolean celulaTemAluno(int coord[]) {
		for (Celulas celula : celulas)
			if(celula.getX() == coord[0] && celula.getY() == coord[1]) 
				if(celula.temAluno() && !celula.roboVisitou()) 
					return true;
		return false;
	}
	
	public boolean celulaTemBug(int coord[]) {
		for (Celulas celula : celulas) 
			if(celula.getX() == coord[0] && celula.getY() == coord[1])
				if(celula.temBug() && !celula.roboVisitou())
					return true;
		return false;
	}
	
	public void imprimirTabuleiro() {
		Celulas celulaTemp;
		for(int i=1; i<=tamanho*tamanho; i++) {
			celulaTemp = celulas.get(i-1);
			if(celulaTemp.temRobo()) {
				System.out.print(celulaTemp.getRobo().apelidoNoPlano+" ");
			} else {
				System.out.print(celulaTemp.imprimir()+" ");
			}
				
			if(i%tamanho==0)
				System.out.println();
		}
	}
	
	public void roboVisitouCelula(int coord[]) {
		for (Celulas celula : celulas)
			if(celula.getX() == coord[0] && celula.getY() == coord[1]) {
				celula.setTrueRoboVisitou();
			}
	}
	
}
