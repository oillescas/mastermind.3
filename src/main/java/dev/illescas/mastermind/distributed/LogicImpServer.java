package dev.illescas.mastermind.distributed;

import dev.illescas.mastermind.controllers.impl.LogicImpl;
import dev.illescas.mastermind.distributed.dispatchers.GetColorsDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.GetBlacksDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.DispatcherPrototype;
import dev.illescas.mastermind.distributed.dispatchers.ExistsDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.FrameType;
import dev.illescas.mastermind.distributed.dispatchers.GetNameDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.HasNameDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.IsLooserDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.ExitDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.AddProposeCombinationDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.RedoDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.RedoableDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.ResumeDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.SaveDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.SaveNameDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.SetNameDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.StartDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.StartNameDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.GetValueStateDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.GetNamesDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.GetAttemptsDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.UndoDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.UndoableDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.GetWhitesDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.GetWidthDispatcher;
import dev.illescas.mastermind.distributed.dispatchers.IsWinnerDispatcher;
import dev.illescas.mastermind.models.DAO.SessionImplDAO;

public class LogicImpServer extends LogicImpl {

	public LogicImpServer(SessionImplDAO sessionImplDAO) {
		super(sessionImplDAO);
		// TODO Auto-generated constructor stub
	}

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.START_NAME, new StartNameDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.GET_NAMES, new GetNamesDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.GET_STATE, new GetValueStateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinnerDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.IS_LOOSER, new IsLooserDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.GET_ATTEMPTS, new GetAttemptsDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.GET_COLORS, new GetColorsDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ADD_PROPOSE_COMBINATION,
				new AddProposeCombinationDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.GET_WIDTH, new GetWidthDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.EXIT, new ExitDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.GET_BLACKS, new GetBlacksDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.GET_WHITES, new GetWhitesDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveController));
		dispatcherPrototype.add(FrameType.SAVE_NAME, new SaveNameDispatcher(this.saveController));
		dispatcherPrototype.add(FrameType.HAS_NAME, new HasNameDispatcher(this.saveController));
		dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveController));
		dispatcherPrototype.add(FrameType.GET_SESSION_NAME, new GetNameDispatcher(this.saveController));
		dispatcherPrototype.add(FrameType.SET_SESSION_NAME, new SetNameDispatcher(this.saveController));
		dispatcherPrototype.add(FrameType.RESUME, new ResumeDispatcher(this.resumeController));
	}

}
