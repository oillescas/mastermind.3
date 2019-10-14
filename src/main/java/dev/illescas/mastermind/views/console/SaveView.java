package dev.illescas.mastermind.views.console;


import dev.illescas.mastermind.controllers.SaveController;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;
import santaTecla.utils.YesNoDialog;

class SaveView extends WithConsoleView {

	void interact(SaveController saveController) {
		boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
		String name = null;
		if (save) {
			if (saveController.hasName()) {
				saveController.save();
			} else {
				boolean exists = false;
				do {
					name = this.console.readString(MessageView.NAME.getMessage());
					exists = saveController.exists(name);
					if (exists) {
						this.console.writeln("The proposed name already exists");
					}
				} while (exists);
				saveController.save(name);
			}
		}
		saveController.next();
	}

}
