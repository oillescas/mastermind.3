package dev.illescas.mastermind;

import dev.illescas.mastermind.controllers.Logic;
import dev.illescas.mastermind.distributed.LogicProxy;
import dev.illescas.mastermind.views.View;
import dev.illescas.mastermind.views.console.ConsoleView;

public class MastermindClient extends Mastermind{
	
	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}
	
	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new MastermindClient().play();
	}

	@Override
	protected View createView() {
		return new ConsoleView();
	}

}
