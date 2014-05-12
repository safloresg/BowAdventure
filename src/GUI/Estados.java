package GUI;

public enum Estados {
	
	Menu(2),Game(1);
	
	Estados(int num){
	   this.num = num;
	}
	private int num;
	public int getNumberOfMenu(){
		return num;
	}

}
