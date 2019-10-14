package dev.illescas.mastermind.controllers.impl;

import dev.illescas.mastermind.controllers.Logic;
import dev.illescas.mastermind.models.SessionImpl;
import dev.illescas.mastermind.models.StateValue;
import dev.illescas.mastermind.models.DAO.SessionImplDAO;

public class LogicImpl extends Logic {
	
	protected SessionImplDAO sessionImplDAO;
	protected StartControllerImpl startController;
	protected PlayControllerImpl playController;
	protected SaveControllerImpl saveController;
	protected ResumeControllerImpl resumeController;

    public LogicImpl(SessionImplDAO sessionImplDAO){
        super();
		this.session = new SessionImpl();
		this.sessionImplDAO = sessionImplDAO;
		this.sessionImplDAO.associate((SessionImpl) this.session);
		
    	this.startController = new StartControllerImpl(this.session, this.sessionImplDAO);
    	this.controllers.put(StateValue.INITIAL, this.startController);

    	this.playController = new PlayControllerImpl(this.session);
    	this.controllers.put(StateValue.IN_GAME, this.playController);
    	
    	this.saveController = new SaveControllerImpl(this.session,this.sessionImplDAO);
    	this.controllers.put(StateValue.SAVING, this.saveController);
    	
		this.resumeController = new ResumeControllerImpl(this.session);
		this.controllers.put(StateValue.FINAL, this.resumeController);
		
		this.controllers.put(StateValue.EXIT, null);
    }

}
