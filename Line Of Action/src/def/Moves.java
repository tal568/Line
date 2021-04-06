package def;

public class Moves {
  private int[][] move= {{0,0},{0,0}};
  private boolean eaten;
  public Moves(int[]start,int[] end ,boolean eaten) 
  {
	  this.eaten=eaten;
	  this.move[0]=start;
	  this.move[1]=end;
  }
public int[][] GetMove() {
	return move;
}
public void SetMove(int[][] move) {
	this.move = move;
}
public boolean GetEaten() {
	return eaten;
}
public void SetEaten(boolean eaten) {
	this.eaten = eaten;
}
}
