package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.types.Error;
import santaTecla.utils.Console;

public class ErrorView extends dev.illescas.mastermind.views.ErrorView {

	public ErrorView(Error error) {
		super(error);
	}
	
	public void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
