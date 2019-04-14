package controller;

<<<<<<< Updated upstream
import java.util.HashMap;

import model.Document;
=======
import model.Document;

>>>>>>> Stashed changes
public class AddLatexCommand implements Command {

	HashMap<String,String>latCommands=new HashMap<String,String>();
	
	public AddLatexCommand() {
		latCommands.put("chapter","\\chapter{...} ");
		latCommands.put("section","\\section{} ");
		latCommands.put("subsection","\\subsection{} ");
		latCommands.put("subsubsection","\\subsubsection{} ");
		latCommands.put("itemize","\\begin{itemize}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{itemize}");
		
		latCommands.put("enumeration","\\begin{enumerate}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{enumerate}");
		
		latCommands.put("table","\\begin{table}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\begin{tabular}{|c|c|c|}\r\n" + 
				"\\hline\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"\\hline\r\n" + 
				"\\end{tabular}\r\n" + 
				"\\end{table}");
		
		latCommands.put("figure","\\begin{figure}\r\n" + 
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
				

		// TODO Auto-generated method stub
>>>>>>> Stashed changes

	}

}
