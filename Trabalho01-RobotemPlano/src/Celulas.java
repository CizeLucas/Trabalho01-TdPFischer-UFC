import java.util.ArrayList;

public class Celulas {

	private int x;
	private int y;
	private int id;
	public ArrayList<RobosAbstract> robos;
	public boolean temAluno;
	public boolean temBug;
	
	public Celulas(int id, int x, int y) {
		robos = new ArrayList<RobosAbstract>();
		this.x = x;
		this.y = y;
		this.id = id;
		temAluno = false;
		temBug = false;
	}

	
	public RobosAbstract getRobo() {
		return robos.get(0);
		//return robos.get(robos.size()-1); //retorna o ultimo robo que entrou na celula
	}
	
	public void addRobo(RobosAbstract robo) {
		robos.add(robo);
		//System.out.println(robos.size());
	}
	
	public boolean temRobo() {
		return (!robos.isEmpty());
		//return (!robos.isEmpty());
	}
	
	public void removerRobo(RobosAbstract robo) {
		robos.remove(robo);
	}
	
	
	public boolean temAluno() {
		return temAluno;
	}

	public void temAluno(boolean temAluno) {
		this.temAluno = temAluno;
	}

	public boolean temBug() {
		return temBug;
	}

	public void temBug(boolean temBug) {
		this.temBug = temBug;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	
	
}
