package dev.illescas.mastermind.models;

public class Result implements Cloneable {

	private int blacks = 0;

	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public void setBlacks(int blacks) {
		this.blacks = blacks;
	}

	public void setWhites(int whites) {
		this.whites = whites;
	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	public int getBlacks() {
		return this.blacks;
	}

	public int getWhites() {
		return this.whites;
	}
	
	public Result clone() {
		return new Result(this.blacks, this.whites);
	}

}
