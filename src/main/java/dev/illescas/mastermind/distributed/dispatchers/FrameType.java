package dev.illescas.mastermind.distributed.dispatchers;

public enum FrameType { 
	START, 
	GET_STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE, 
	IS_WINNER, 
	IS_LOOSER, 
	GET_ATTEMPTS, 
	GET_COLORS, 
	ADD_PROPOSE_COMBINATION, 
	GET_WIDTH,
	RESUME,
	GET_BLACKS,
	GET_WHITES,
	CLOSE, 
	EXIT, 
	START_NAME, 
	GET_NAMES, 
	SAVE, 
	SAVE_NAME, 
	HAS_NAME, EXISTS,
	GET_SESSION_NAME, 
	SET_SESSION_NAME;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
