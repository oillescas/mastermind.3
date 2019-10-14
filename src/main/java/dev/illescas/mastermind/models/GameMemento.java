package dev.illescas.mastermind.models;

import java.util.List;

public class GameMemento {

	
	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	GameMemento(int attempts, List<ProposedCombination> proposedCombinations, List<Result> results) {
		this.attempts = attempts;
		this.proposedCombinations =proposedCombinations;
		this.results = results;
	}

	void set(ProposedCombination proposedCombination, Result result) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(result);
	}
	
	ProposedCombination getProposedCombination(int position){
		return this.proposedCombinations.get(position);
	}
	
	Result getResult(int position){
		return this.results.get(position);
	}
	
	int getSize() {
		return proposedCombinations.size();
	}
	
	int getAttempts(){
		return this.attempts;
	}

}

