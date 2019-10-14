package dev.illescas.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import dev.illescas.mastermind.types.Color;

public class ProposedCombination extends Combination implements Cloneable{

	ProposedCombination(List<Color> colors) {
		this.colors = colors;
	}

	public ProposedCombination() {
		// TODO Auto-generated constructor stub
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}
	
	public ProposedCombination clone() {
		List<Color> cloneColors = new ArrayList<Color>();
		for(Color color: this.colors) {
			cloneColors.add(color);
		}
		return new ProposedCombination(cloneColors);
	}

}
