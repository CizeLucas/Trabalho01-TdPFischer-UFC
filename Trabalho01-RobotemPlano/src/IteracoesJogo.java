import java.util.ArrayList;
import java.util.Scanner;

public class IteracoesJogo {
		
	private Plano plano;
	private ArrayList<RobosAbstract> arrayRobos = new ArrayList<RobosAbstract>();
	private Scanner scan;
	private int contadorDeRodadas;
	private String nomeJogador;
	
	IteracoesJogo() {
		
		scan = new Scanner(System.in);
		contadorDeRodadas=1;
		
		System.out.print("Insira o nome do jogador: ");
		nomeJogador = scan.nextLine();
		
		System.out.print("\nInsira o tamanho desejado para o plano: "+
				"\n > Observacao: Melhor colocar valores impares.");
		int tamanhoPlano = this.scanDeInteiros();
		
		System.out.print("\nInsira a quantidade desejada de ALUNOS para essa partida: ");
		int qtdAlunos = this.scanDeInteiros();
		
		System.out.print("\nInsira a quantidade desejada de BUGS para essa partida: ");
		int qtdBugs = this.scanDeInteiros();
		
		System.out.println("\nInsira a coordenada onde os robos vao nascer no plano:"+
				"\n > Observacao (1): valores entre 0 e "+(tamanhoPlano-1)+"."+
				"\n > Observacao (2): Melhor colocar no centro do plano em X = Y = "+(int)tamanhoPlano/2+".");
		System.out.print("Coordenada X: ");
		int x = this.scanDeInteiros();
		System.out.print("Coordenada Y: ");
		int y = this.scanDeInteiros();
		int[] coordInicioRobos = {x,y};
		System.out.println("\n\n");
		
		plano = new Plano(tamanhoPlano, qtdBugs, qtdAlunos, coordInicioRobos);
		
		arrayRobos.add(new RoboAndador("Andador", 'A', plano, coordInicioRobos[0], coordInicioRobos[1]));
		arrayRobos.add(new RoboPeao("Peao", 'P', plano, coordInicioRobos[0], coordInicioRobos[1]));
		arrayRobos.add(new RoboTorre("Torre", 'T', plano, coordInicioRobos[0], coordInicioRobos[1]));
		arrayRobos.add(new RoboBispo("Bispo", 'B', plano, coordInicioRobos[0], coordInicioRobos[1]));
		arrayRobos.add(new RoboCavalo("Cavalo", 'C', plano, coordInicioRobos[0], coordInicioRobos[1]));
		arrayRobos.add(new RoboRei("Rei", 'R', plano, coordInicioRobos[0], coordInicioRobos[1]));
		arrayRobos.add(new RoboRainha("Rainha", 'r', plano, coordInicioRobos[0], coordInicioRobos[1]));
		
	}
	
	public void jogar() {
		System.out.println("Bem-vindo "+nomeJogador+" ao jogo Xadrez On Steroids!\n");
		System.out.println("Esses sao os movimentos dos Robos: ");
		this.imprimirDescricaoMovRobos();
		System.out.println("\n\n");
		System.out.println("Agora, Vamos iniciar:");
		System.out.println("\n");
		
		while(plano.checarSeJogoAcabou()) {
			for(int i=0; i<17; i++)
				System.out.print("--");
			System.out.println("\nRodada Num.: "+contadorDeRodadas);
			plano.imprimirTabuleiro();
			for (RobosAbstract robo : arrayRobos) {
				System.out.println("Defina o movimento para o "+robo.toString()+":");
				robo.interfaceUsuario(this.returnTipoDeMovimento(), this.returnQtdDeCasasDoMovimento());
				plano.imprimirTabuleiro();
			}
			this.finalizarMovimentoRobos();
			System.out.println();
			if(!plano.checarSeJogoAcabou())
				this.imprimirPontuacoes();
			System.out.println("\n");
			contadorDeRodadas++;
		}
		System.out.println("FIM DE JOGO, "+nomeJogador+"!");
		this.imprimirRelatorioDosRobos();
		System.out.println(this.roboComMaiorPontuacao());
	}
	
	public int scanDeInteiros() { 
		//metodo para leitura de inteiros protegida com try-catch chamando a funcao recursivamente
		int numInt;
		try {
			numInt = Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			System.out.print("Insira o campo acima corretamente: ");
			numInt = scanDeInteiros();
		}
		return numInt;
	}
	
	public boolean returnTipoDeMovimento() {
		//retorna true para Avancar OU false para retroceder
		char comando;
		do {
			System.out.print("    Digite 'A' para avancar ou 'R' para retroceder: ");
			comando = scan.nextLine().toUpperCase().charAt(0);
			if(comando=='A') 
				return true;
		
			if(comando=='R') 
				return false;
		} while(!(comando=='A' || comando=='R'));
		return true;
	}
	
	public void imprimirDescricaoMovRobos() {
		for (RobosAbstract robo : arrayRobos)
			System.out.println(robo.descreverMovRobo());
	}
	
	public int returnQtdDeCasasDoMovimento() {
		System.out.print("    Digite a quantidade de casas para o robo se movimentar: ");
		return this.scanDeInteiros();
	}
	
	public void imprimirPontuacoes() {
		for (RobosAbstract robo : arrayRobos) {
			System.out.println(robo.stringPontuacao());
		}
	}
	
	public void finalizarMovimentoRobos() {
		for (RobosAbstract robo : arrayRobos) {
			robo.finalizarMovimentos();
		}
	}
	
	public void imprimirRelatorioDosRobos() {
		ArrayList<String> listaDeCoordenadasTemp;
		for (RobosAbstract robo : arrayRobos) {
			listaDeCoordenadasTemp = robo.getListaDeCoordenadas();
			
			System.out.print("O "+robo.toString()+" finalizou a partida com "+robo.getPontuacao()+
					" pontos, "+"\n  pois resgatou "+robo.getQtdAlunosColetados()+" Aluno(s) e encontrou "+
					robo.getQtdBugsColetados()+" Bug(s).\n"+
					"  Alem disso, andou em "+listaDeCoordenadasTemp.size()+" celulas");
			
			if(listaDeCoordenadasTemp.size()>0) {
				System.out.print(", e as coordenadas delas sao:\n");
				for (String coord : listaDeCoordenadasTemp) {
					System.out.print(coord);
				}
			}
			
			System.out.println("\n");
		}
	}
	
	public String roboComMaiorPontuacao() {
		RobosAbstract roboMaiorPontuacao=arrayRobos.get(0);
		String msg="Nessa partida";
		
		for (RobosAbstract robo : arrayRobos) {
			if(robo.getPontuacao() > roboMaiorPontuacao.getPontuacao()) {
				roboMaiorPontuacao = robo;
			}
		}
		
		for (RobosAbstract robo : arrayRobos) {
			if(robo.getPontuacao() == roboMaiorPontuacao.getPontuacao()) {
				msg+=(", o "+robo.toString());
			}
		}
		
		return (msg+" obteve a maior pontuacao! ("+roboMaiorPontuacao.getPontuacao()+" pontos).");
	}
	
}
