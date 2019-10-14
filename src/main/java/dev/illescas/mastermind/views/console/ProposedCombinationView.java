package dev.illescas.mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.types.Color;
import dev.illescas.mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {
	
	private PlayController proposalController;
	
	public ProposedCombinationView(PlayController acceptorController) {
		this.proposalController = acceptorController;
	}
	
	void write(int position) {
		for (Color color : this.proposalController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
