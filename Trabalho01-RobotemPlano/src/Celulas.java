import java.util.ArrayList;

public class Celulas {

	private int x;
	private int y;
	private int id;
	public ArrayList<RobosAbstract> robos;
	public boolean temAluno;
	public boolean temBug;
	public boolean roboVisitou;
	
	public Celulas(int id, int x, int y) {
		robos = new ArrayList<RobosAbstract>();
		this.x = x;
		this.y = y;
		this.id = id;
		temAluno = false;
		temBug = false;
		roboVisitou = false;
	}

	public String imprimir() {
		if(roboVisitou) {
			if(temAluno) 
				return "!";
			
			if(temBug) 
				return "#";
		}
		
		return "*";
	}
	
	public RobosAbstract getRobo() {
		//return robos.get(0);
		return robos.get(robos.size()-1); //retorna o ultimo robo que entrou na celula
	}
	
	public void addRobo(RobosAbstract robo) {
		robos.add(robo);
		roboVisitou = true;
	}
	
	public void addAluno() {
		temAluno = true;
		temBug = false;
		// fazendo isso para asegurar que não vai ter aluno e bug na mesma celula
	}
	
	public void addBug() {
		temBug = true;
		temAluno = false;
		// fazendo isso para asegurar que não vai ter aluno e bug na mesma celula
	}
	
	public void removerAluno() {
		temAluno = false;
	}
	
	public void removerBug() {
		temBug = false;
	}
	
	public boolean temRobo() {
		return (!robos.isEmpty());
	}
	
	public void removerRobo(RobosAbstract robo) {
		robos.remove(robo);
	}
	
	
	public boolean temAluno() {
		return temAluno;
	}

	public boolean temBug() {
		return temBug;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
