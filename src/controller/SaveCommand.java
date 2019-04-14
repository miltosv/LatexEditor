package controller;

public class SaveCommand implements Command {

	@Override
	public void execute() {
		doc.Save(filelocation);

	}

}
