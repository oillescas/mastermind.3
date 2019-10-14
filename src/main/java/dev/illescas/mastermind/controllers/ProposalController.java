package dev.illescas.mastermind.controllers;

import java.util.List;

import dev.illescas.mastermind.models.Combination;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.models.SessionImpl;
import dev.illescas.mastermind.types.Color;
import dev.illescas.mastermind.types.Error;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			((SessionImpl) this.session).addProposedCombination(colors);
			if (((SessionImpl) this.session).getGame().isWinner() || ((SessionImpl) this.session).getGame().isLooser()) {
				((SessionImpl) this.session).getState().next();
			}
		}
		return error;	
	}

	public boolean isWinner() {
		return ((SessionImpl) this.session).getGame().isWinner();
	}

	public boolean isLooser() {
		return ((SessionImpl) this.session).getGame().isLooser();
	}
	
	public int getAttempts() {
		return ((SessionImpl) this.session).getGame().getAttempts();
	}

	public List<Color> getColors(int position) {
		return ((SessionImpl) this.session).getGame().getColors(position);
	}

	public int getBlacks(int position) {
		return ((SessionImpl) this.session).getGame().getBlacks(position);
	}

	public int getWhites(int position) {
		return ((SessionImpl) this.session).getGame().getWhites(position);
	}

}
