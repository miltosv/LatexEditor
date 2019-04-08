package controller;


public class CommandsFactory {
	public CommandsFactory() {
		;
	}

	
	public Command create(String Name) {
		switch(Name) {
			case "CreateCommand": 
				return new CreateCommand();
			case "AddLatexCommand":
				return new AddLatexCommand();
			case "RollbackToPreviousVersionCommand":
				return new RollbackToPreviousVersionCommand();
			case "EditCommand":
				return new 	EditCommand();
			case "LoadCommand":
				return new LoadCommand();
			case "SaveCommand":
				return new SaveCommand();
			case "EnableVersionsManagementCommand":
				return new EnableVersionsManagementCommand();
			case "DisableVersionsManagementCommand":
				return new DisableVersionsManagementCommand();
			case "ChangeVersionsStrategyCommand":
				return new ChangeVersionsStrategyCommand();
			default: return null;
		}

	}
}
