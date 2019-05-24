package controller;


public class CommandsFactory {
	private LatexEditorController controller;
	

	
	public CommandsFactory() {
		super();
		
	}
	

	public CommandsFactory(LatexEditorController control) {
		controller=control;
	}


	public Command create(String Name) {
		switch(Name) {
			case "CreateCommand": 
				return new CreateCommand(controller);
			case "AddLatexCommand":
				return new AddLatexCommand(controller);
			case "EditCommand":
				return new 	EditCommand(controller);
			case "LoadCommand":
				return new LoadCommand(controller);
			case "SaveCommand":
				return new SaveCommand(controller);
			case "VersionsCommand":
				return new VersionsCommand(controller);
			case "Compile":
				return new CompileCommand(controller);
//			case "RollbackToPreviousVersionCommand":
//				return new RollbackToPreviousVersionCommand(controller);				
//			case "EnableVersions":
//				return new EnableVersionsManagementCommand(controller);
//			case "DisableVersions":
//				return new DisableVersionsManagementCommand(controller);
//			case "ChangeVersionsStrategyCommand":
//				return new ChangeVersionsStrategyCommand(controller);
			//case "UpdateCommand":
			//	return new Updater(controller);
			default: return null;
		}

	}
}
