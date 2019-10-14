package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.controllers.ResumeController;
import dev.illescas.mastermind.controllers.SaveController;
import dev.illescas.mastermind.controllers.StartController;
import dev.illescas.mastermind.views.View;
import dev.illescas.mastermind.views.console.menu.PlayMenu;
import dev.illescas.mastermind.views.console.menu.StartMenu;

public class ConsoleView extends View {
	
	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;
	private SaveView saveView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
		this.saveView = new SaveView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);		
		new StartMenu(startController).execute();
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

	@Override
	public void visit(PlayController playController) {
		this.proposalView.interact(playController);
		new PlayMenu(playController).execute();
	}

	@Override
	public void visit(SaveController saveController) {
		this.saveView.interact(saveController);
	}



}
