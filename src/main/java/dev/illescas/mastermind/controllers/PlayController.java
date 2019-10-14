package dev.illescas.mastermind.controllers;

import java.util.List;

import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.types.Color;
import dev.illescas.mastermind.types.Error;

public abstract class PlayController extends Controller implements VisitableController{

	public PlayController(Session session) {
		super(session);
	}

	public abstract Error addProposedCombination(List<Color> colors);

	public abstract void undo();

	public abstract void redo();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract List<Color> getColors(int position);

	public abstract int getAttempts();

	public abstract int getBlacks(int position);

	public abstract int getWhites(int position);
	
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	public abstract void exit();

}