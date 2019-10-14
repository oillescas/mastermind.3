package dev.illescas.mastermind.models;

public interface Session {

	StateValue getValueState();
	
	int getWidthConbination();
	
	String getSessionName();

	void setSessionName(String name);

}