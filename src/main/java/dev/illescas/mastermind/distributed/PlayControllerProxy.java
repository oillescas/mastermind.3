package dev.illescas.mastermind.distributed;

import java.util.ArrayList;
import java.util.List;

import dev.illescas.mastermind.controllers.PlayController;
import dev.illescas.mastermind.distributed.dispatchers.FrameType;
import dev.illescas.mastermind.distributed.dispatchers.TCPIP;
import dev.illescas.mastermind.models.Session;
import dev.illescas.mastermind.types.Color;
import dev.illescas.mastermind.types.Error;

public class PlayControllerProxy extends PlayController{

	private TCPIP tcpip;

	PlayControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public Error addProposedCombination(List<Color> colors) {
		this.tcpip.send(FrameType.ADD_PROPOSE_COMBINATION.name());
		this.tcpip.send(colors.size());
		for (Color color : colors) {
			this.tcpip.send(color);
		}
		Error error = this.tcpip.receiveError();
		return error;
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

	@Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

	@Override
	public boolean undoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean redoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isWinner() {
		this.tcpip.send(FrameType.IS_WINNER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isLooser() {
		this.tcpip.send(FrameType.IS_LOOSER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public List<Color> getColors(int position) {
		this.tcpip.send(FrameType.GET_COLORS.name());
		this.tcpip.send(position);
		int size = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>(); 
		for (int i = 0; i < size; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		return colors;
	}

	@Override
	public int getAttempts() {
		this.tcpip.send(FrameType.GET_ATTEMPTS.name());
		return this.tcpip.receiveInt();
	}
	
	@Override
	public int getBlacks(int position) {
		this.tcpip.send(FrameType.GET_BLACKS.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public int getWhites(int position) {
		this.tcpip.send(FrameType.GET_WHITES.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public void exit() {
		this.tcpip.send(FrameType.EXIT.name());
	}

}
