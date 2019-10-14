package dev.illescas.mastermind.controllers;

import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;

/**
 * UndoController
 */
public class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    public void undo() {
    	((SessionImpl) this.session).undo();
    }

    public boolean undoable() {
    	return ((SessionImpl) this.session).undoable();

    }

}