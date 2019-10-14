package dev.illescas.mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dev.illescas.mastermind.models.SessionImpl;
import dev.illescas.mastermind.models.StateValue;

public class SessionImplDAO {

	private static final String SAVES_DIRECTORY = "/Users/oris/master/ejercicio3/saves";
	private static final String EXT = ".mm";

	private static File directory;

	static {
		SessionImplDAO.directory = new File(SessionImplDAO.SAVES_DIRECTORY);
	}
	
	private SessionImpl sessionImpl;
	
	private GameDAO gameDAO;

	public void associate(SessionImpl sessionImpl) {
		this.sessionImpl = sessionImpl;
		this.gameDAO = new GameDAO(this.sessionImpl.getGame());
	}

	public void load(String name) {
		this.sessionImpl.setSessionName(name);
		File file = new File(SessionImplDAO.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameDAO.load(bufferedReader);
			this.sessionImpl.resetRegistry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sessionImpl.setStateValue(StateValue.IN_GAME);
		if (this.sessionImpl.isLooser() || this.sessionImpl.isWinner()) {
			this.sessionImpl.setStateValue(StateValue.FINAL);
		}
	}

	public void save() {
		this.save(this.sessionImpl.getSessionName());
	}

	public void save(String name) {
		if (name.endsWith(SessionImplDAO.EXT)) {
			name = name.replace(SessionImplDAO.EXT, "");
		}
		File file = new File(SessionImplDAO.directory, name + SessionImplDAO.EXT);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImplDAO.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplDAO.EXT)) {
				return true;
			}
		}
		return false;
	}

}
