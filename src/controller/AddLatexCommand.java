package controller;


import java.util.HashMap;

import model.Document;




public class AddLatexCommand implements Command {
	private LatexEditorController controller;

	HashMap<String,String>latCommands=new HashMap<String,String>();
	
	public AddLatexCommand(LatexEditorController control) {
		controller=control;
		
		latCommands.put("Chapter","\\chapter{...} ");
		latCommands.put("Section","\\section{} ");
		latCommands.put("Subsection","\\subsection{} ");
		latCommands.put("Subsubsection","\\subsubsection{} ");
		latCommands.put("Itemize_list","\\begin{itemize}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{itemize}");
		
		latCommands.put("Enumeration_list","\\begin{enumerate}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{enumerate}");
		
		latCommands.put("Table","\\begin{table}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\begin{tabular}{|c|c|c|}\r\n" + 
				"\\hline\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"\\hline\r\n" + 
				"\\end{tabular}\r\n" + 
				"\\end{table}");
		
		latCommands.put("Figure","\\begin{figure}\r\n" + 
				"\\includegraphics[width=...,height=...]{...}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\end{figure}");
		
		
		
		
	}
	@Override
	public void execute(Document doc, String info) {

		String doctype=doc.getType();
		String docContents=doc.getContents();
		String commandToAdd=latCommands.get(info);
		if(info.equals("chapter") && (doctype.equals("letter") || doctype.equals("article") )) {
			System.out.println("operation not allowed for this type of document");
			return;
		}
		if (doctype.equals("letter")) {
			System.out.println("operation not allowed for LETTER");
			return;
		}
		
		doc.setContents(docContents.concat(commandToAdd));
				



	}

}
