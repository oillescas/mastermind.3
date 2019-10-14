package dev.illescas.mastermind.models;

import java.util.List;

import dev.illescas.mastermind.types.Color;

public class SessionImpl implements Session {

	private Game game;
	
	private State state;
	
	private Registry registry;
	
	private String sessionName;

	
	public SessionImpl() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);

	}
	
	public void registry() {
		this.registry = new Registry(this.game);
	}
	
	public Game getGame() {
        return this.game;
    }
	
	public State getState() {
		return this.state;
	}
	
	@Override
	public int getWidthConbination() {
		return this.game.getWidth();
	}

	@Override
	public StateValue getValueState() {
		return this.state.getValueState();
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}


	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}


	public void clear() {
		this.state.reset();	
		this.game.clear(); //TODO clear?
		this.registry.reset();
	}


	public String getSessionName() {
		return sessionName;
	}


	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}


	public void resetRegistry() {
		this.registry.reset();
	}


	public void setStateValue(StateValue inGame) {
		this.state.setValueState(inGame);
	}


	public boolean isLooser() {
		return this.game.isLooser();
	}


	public boolean isWinner() {
		return this.game.isWinner();
	}


	public void nextState() {
		this.state.next();
	}

	public boolean hasName() {
		return this.sessionName != null;
	}


}
