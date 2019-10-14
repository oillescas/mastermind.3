package dev.illescas.mastermind.models;

import java.util.ArrayList;

public class Registry {
	
	private ArrayList<GameMemento> mementoList;
	
	private Game game;
	
	private int previous;
	
	Registry(Game game) {
		this.game = game;
		this.mementoList = new ArrayList<GameMemento>();
		this.mementoList.add(previous, this.game.createMemento());
		this.previous = 0;
	}

	void registry() {
		for (int i = 0; i < this.previous; i++) {
			this.mementoList.remove(0);
		}
		this.previous = 0;
		this.mementoList.add(this.previous, this.game.createMemento());
	}

	void undo(Game game) {
		this.previous++;
		game.set(this.mementoList.get(this.previous));
	}

	void redo(Game game) {
		this.previous--;
		game.set(this.mementoList.get(this.previous));
	}

	boolean undoable() {
		return this.previous < this.mementoList.size() - 1;
	}

	boolean redoable() {
		return this.previous >= 1;
	}

	public void reset() {
		this.mementoList = new ArrayList<GameMemento>();
		this.mementoList.add(previous, this.game.createMemento());
		this.previous = 0;
	}

}
