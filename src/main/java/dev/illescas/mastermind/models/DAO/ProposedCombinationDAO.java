package dev.illescas.mastermind.models.DAO;

import dev.illescas.mastermind.models.ProposedCombination;

class ProposedCombinationDAO extends CombinationDAO {

	ProposedCombinationDAO(ProposedCombination proposedCombination) {
		super(proposedCombination);
	}

	ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}
