package controller;


public class CommandsFactory {
	private LatexEditorController controller;
	public CommandsFactory(LatexEditorController control) {
		controller=control;
	}

	
	public Command create(String Name) {
		switch(Name) {
			case "CreateCommand": 
				return new CreateCommand(controller);
			case "AddLatexCommand":
				return new AddLatexCommand(controller);
			case "RollbackToPreviousVersionCommand":
				return new RollbackToPreviousVersionCommand(controller);
			case "EditCommand":
				return new 	EditCommand(controller);
			case "LoadCommand":
				return new LoadCommand(controller);
			case "SaveCommand":
				return new SaveCommand(controller);
			case "EnableVersionsManagementCommand":
				return new EnableVersionsManagementCommand(controller);
			case "DisableVersionsManagementCommand":
				return new DisableVersionsManagementCommand(controller);
			case "ChangeVersionsStrategyCommand":
				return new ChangeVersionsStrategyCommand(controller);
			//case "UpdateCommand":
			//	return new Updater(controller);
			default: return null;
		}

	}
}
