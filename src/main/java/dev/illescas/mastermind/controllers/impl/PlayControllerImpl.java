package dev.illescas.mastermind.controllers.impl;


import java.util.List;

import dev.illescas.mastermind.controllers.ExitController;
import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.controllers.ProposalController;
import dev.illescas.mastermind.controllers.RedoController;
import dev.illescas.mastermind.controllers.UndoController;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.types.Color;
import dev.illescas.mastermind.types.Error;

/**
 * PlayController
 */
public class PlayControllerImpl extends PlayController {
	
	private ProposalController proposalController;
	private RedoController redoController;
	private UndoController undoController;
	private ExitController exitController;


    public PlayControllerImpl(Session session) {
        super(session);
        this.proposalController = new ProposalController(session);
        this.redoController = new  RedoController(session);
		this.undoController = new UndoController(session);
		this.exitController = new ExitController(session);
    }  

	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}
	
	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	public int getBlacks(int position) {
		return this.proposalController.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.proposalController.getWhites(position);
	}
	public void redo() {
        this.redoController.redo();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }
    
    public void undo() {
    	this.undoController.undo();
    }

    public boolean undoable() {
    	return this.undoController.undoable();
    }

    @Override
	public void exit() {
		this.exitController.exit();
	}
    
}
