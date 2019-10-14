package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.controllers.ResumeController;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
