package controller;

import model.Document;

public interface Command {
	void execute(Document doc, String [] args);

}
