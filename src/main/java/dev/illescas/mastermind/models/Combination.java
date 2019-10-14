package dev.illescas.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import dev.illescas.mastermind.types.Color;

public abstract class Combination {
	
	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	private static final int WIDTH = 4;

	protected List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList<Color>();
	}
	
	public static int getWidth() {
		return Combination.WIDTH;
	}
	
	public void clearColors() {
		this.colors.clear();
	}
	
	public void addColor(Color color) {
		this.colors.add(color);
	}
}
