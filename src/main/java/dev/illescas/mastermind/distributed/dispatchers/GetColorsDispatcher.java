package dev.illescas.mastermind.distributed.dispatchers;

import java.util.List;

import dev.illescas.mastermind.controllers.impl.PlayControllerImpl;
import dev.illescas.mastermind.types.Color;

public class GetColorsDispatcher extends Dispatcher {

	public GetColorsDispatcher(PlayControllerImpl playControllerImpl) {
		super(playControllerImpl);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		List<Color> colors = ((PlayControllerImpl) this.controller).getColors(position);
		this.tcpip.send(colors.size());
		for (Color color: colors) {
			this.tcpip.send(color);
		}
	}

}
