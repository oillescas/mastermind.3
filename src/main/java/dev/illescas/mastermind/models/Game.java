package dev.illescas.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import dev.illescas.mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;


	private ArrayList<ProposedCombination> proposedCombinations;

	private ArrayList<Result> results;

	private int attempts;

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Game() {
		this.clear();
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}
	
	public boolean isWinner() {
		return this.attempts != 0  && this.results.get(this.attempts-1).isWinner();
	}

	public int getAttempts() {
		return this.attempts;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}
	
	@SuppressWarnings("unchecked")
	GameMemento createMemento() {
		return new GameMemento(this.attempts, 
				(List<ProposedCombination>)this.proposedCombinations.clone(),
				(List<Result>)this.results.clone());
	}
	
	void set(GameMemento memento) {
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = memento.getAttempts();
		for (int i = 0; i < memento.getSize(); i++) {
			this.proposedCombinations.add(memento.getProposedCombination(i).clone());
			this.results.add(memento.getResult(i).clone());
		}
	}

	public SecretCombination getSecretCombination() {
		return secretCombination;
	}

	public void addResult(Result result) {
		this.results.add(result);
	}

	public ProposedCombination getProposedCombination(int i) {
		return this.proposedCombinations.get(i);
	}

	public Result getResult(int i) {
		return this.results.get(i);
	}


}
