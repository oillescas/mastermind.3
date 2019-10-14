package dev.illescas.mastermind.views.console;

import dev.illescas.mastermind.types.Color;
import santaTecla.utils.Console;

class ColorView extends dev.illescas.mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		new Console().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
