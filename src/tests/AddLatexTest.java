package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.AddLatexCommand;
import controller.Command;
import controller.LatexEditorController;
import model.Document;

public class AddLatexTest {
	
	private Document doc;
	private String[] command=null;
	private Command com;
	private LatexEditorController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	@Before
	public void setUp() throws Exception {
		controller=new LatexEditorController();
		com = new AddLatexCommand(controller);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_chapterCommand() {	
		command[0]= "";
		command[1]="\\chapter{...}";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex chapter fail, contents aren't equals!" , doc.getContents(),"\\chapter{...}");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_sectionCommand() {	
		command[0]= "";
		command[1]="\\section{...} ";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex section fail, contents aren't equals!" , doc.getContents(),"\\section{...} ");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_subsectionCommand() {	
		command[0]= "";
		command[1]="\\subsection{...} ";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex subsection fail, contents aren't equals!" , doc.getContents(),"\\subsection{...} ");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_subsubsectionCommand() {	
		command[0]= "";
		command[1]="\\subsubsection{...} ";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex subsubsection fail, contents aren't equals!" , doc.getContents(),"\\subsubsection{...} ");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_itemizeCommand() {	
		command[0]= "";
		command[1]="\\begin{itemize}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{itemize}";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex itemize fail, contents aren't equals!" , doc.getContents(),"\\begin{itemize}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{itemize}");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_enumeraterCommand() {	
		command[0]= "";
		command[1]="\\begin{enumerate}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{enumerate}";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex enumerate fail, contents aren't equals!" , doc.getContents(),"\\begin{enumerate}\r\n" + 
				"\\item ...\r\n" + 
				"\\item ...\r\n" + 
				"\\end{enumerate}");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_tableCommand() {	
		command[0]= "";
		command[1]="\\begin{table}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\begin{tabular}{|c|c|c|}\r\n" + 
				"\\hline\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"\\hline\r\n" + 
				"\\end{tabular}\r\n" + 
				"\\end{table}";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex table fail, contents aren't equals!" , doc.getContents(),"\\begin{table}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\begin{tabular}{|c|c|c|}\r\n" + 
				"\\hline\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"... &...&...\\\\\r\n" + 
				"\\hline\r\n" + 
				"\\end{tabular}\r\n" + 
				"\\end{table}");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_figureCommand() {	
		command[0]= "";
		command[1]="\\begin{figure}\r\n" + 
				"\\includegraphics[width=...,height=...]{...}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\end{figure}";
		doc = new Document("","Empty");
		com.execute(doc,command);
		assertEquals("AddLatex figure fail, contents aren't equals!" , doc.getContents(),"\\begin{figure}\r\n" + 
				"\\includegraphics[width=...,height=...]{...}\r\n" + 
				"\\caption{....}\\label{...}\r\n" + 
				"\\end{figure}");
	}
	
	
}
