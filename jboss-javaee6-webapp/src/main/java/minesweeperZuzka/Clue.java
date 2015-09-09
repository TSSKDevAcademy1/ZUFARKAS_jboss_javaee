package minesweeperZuzka;

public class Clue  extends Tile {
    /** Value of the clue. */
    private final int value;
    
    /**
     * Constructor.
     * @param value  value of the clue
     */
    public Clue(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}
    //nove
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	if(getState()==State.OPEN){
    	return value+"";
    	}
    	else {
    		return super.toString();
    		}
    }
}