package dev.illescas.mastermind.controllers;

import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;

/**
 * RedoController
 */
public class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public void redo() {
        ((SessionImpl) this.session).redo();
    }

    public boolean redoable() {
        return ((SessionImpl) this.session).redoable();

    }

}