package dev.illescas.mastermind.views.console.menu;

import java.util.ArrayList;

import santaTecla.utils.WithConsoleView;

public class Menu extends WithConsoleView {

	private final static String OPTION_TEXT = "----- Choose one option -----";
	
	private ArrayList<Command> commandList;

	public Menu() {
		this.commandList = new ArrayList<Command>();
	}

	public void execute() {
        ArrayList<Command> commands = this.filterActiveCommands();
        
		boolean error;
		int option;
		do {
			error = false;
			this.console.writeln();
			this.console.writeln(Menu.OPTION_TEXT);
			for (int i = 0; i < commands.size(); i++) {
				this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			option = this.console.readInt("") - 1;
			if (option >= this.commandList.size() || option < 0) {
				error = true;
			} 				
		} while (error);
		commands.get(option).execute();;
	}

    private ArrayList<Command> filterActiveCommands() {
        ArrayList<Command> commands =  new ArrayList<Command>();

        for (int i = 0; i < this.commandList.size(); i++) {
			if (this.commandList.get(i).isActive()) {
                commands.add(this.commandList.get(i));
			}
        }
        return commands;
    }
    
    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

}
