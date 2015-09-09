package minesweeperZuzka;

public class Mine extends Tile {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(getState()==State.OPEN){
		return "x";
		}
		else {
		return super.toString();
		}
	} 
}

