package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Command;
import controller.CreateCommand;
import controller.LatexEditorController;
import model.Document;


public class CreateTest {
	
	private String[] info;
	private Command com;
	private Document doc;
	private LatexEditorController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	@Before
	public void setUp() throws Exception {
		controller=new LatexEditorController();
		com = new CreateCommand(controller);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAcceptance_Empty() {
		info="Empty".split("");
		doc=new Document("","Empty");
		com.execute(doc,info);
		assertEquals("Create empty fail, contents aren't equals!", doc.getContents(),"");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAcceptance_Article() {
		info="Article".split("");
		doc=new Document("","Article");
		com.execute(doc,info);
		assertEquals("Create article fail, contents aren't equals!", doc.getContents(),"\\documentclass[11pt,twocolumn,a4paper]{article}\r\n" + 
				"\r\n" + 
				"\\begin{document}\r\n" + 
				"\\title{Article: How to Structure a LaTeX Document}\r\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\r\n" + 
				"\\date{\\today}\r\n" + 
				"\r\n" + 
				"\\maketitle\r\n" + 
				"\r\n" + 
				"\\section{Section Title 1}\r\n" + 
				"\r\n" + 
				"\\section{Section Title 2}\r\n" + 
				"\r\n" + 
				"\\section{Section Title.....}\r\n" + 
				"\r\n" + 
				"\\section{Conclusion}\r\n" + 
				"\r\n" + 
				"\\section*{References}\r\n" + 
				"\r\n" + 
				"\\end{document}");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAcceptance_Book() {
		info="Book".split("");
		doc=new Document("","Book");
		com.execute(doc,info);
		assertEquals("Create book fail, contents aren't equals!", doc.getContents(),"\\documentclass[11pt,a4paper]{book}\r\n" + 
				"\r\n" + 
				"\\begin{document}\r\n" + 
				"\\title{Book: How to Structure a LaTeX Document}\r\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\r\n" + 
				"\\date{\\today}\r\n" + 
				"\r\n" + 
				"\\maketitle\r\n" + 
				"\r\n" + 
				"\\frontmatter\r\n" + 
				"\r\n" + 
				"\\chapter{Preface}\r\n" + 
				"% ...\r\n" + 
				"\r\n" + 
				"\\mainmatter\r\n" + 
				"\\chapter{First chapter}\r\n" + 
				"\\section{Section Title 1}\r\n" + 
				"\\section{Section Title 2}\r\n" + 
				"\\section{Section Title.....}\r\n" + 
				"\r\n" + 
				"\\chapter{....}\r\n" + 
				"\r\n" + 
				"\\chapter{Conclusion}\r\n" + 
				"\r\n" + 
				"\\chapter*{References}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\\backmatter\r\n" + 
				"\\chapter{Last note}\r\n" + 
				"\r\n" + 
				"\\end{document}");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAcceptance_Letter() {
		info="Letter".split("");
		doc=new Document("","Letter");
		com.execute(doc,info);
		assertEquals("Create letter fail, contents aren't equals!", doc.getContents(),"\\documentclass{letter}\r\n" + 
				"\\usepackage{hyperref}\r\n" + 
				"\\signature{Sender's Name}\r\n" + 
				"\\address{Sender's address...}\r\n" + 
				"\\begin{document}\r\n" + 
				"\r\n" + 
				"\\begin{letter}{Destination address....}\r\n" + 
				"\\opening{Dear Sir or Madam:}\r\n" + 
				"\r\n" + 
				"I am writing to you .......\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\\closing{Yours Faithfully,}\r\n" + 
				"\r\n" + 
				"\\ps\r\n" + 
				"\r\n" + 
				"P.S. text .....\r\n" + 
				"\r\n" + 
				"\\encl{Copyright permission form}\r\n" + 
				"\r\n" + 
				"\\end{letter}\r\n" + 
				"\\end{document");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAcceptance_Report() {
		info="Report".split("");
		doc=new Document("","Report");
		com.execute(doc,info);
		assertEquals("Create report fail, contents aren't equals!", doc.getContents(),"\\documentclass[11pt,a4paper]{report}\r\n" + 
				"\r\n" + 
				"\\begin{document}\r\n" + 
				"\\title{Report Template: How to Structure a LaTeX Document}\r\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\r\n" + 
				"\\date{\\today}\r\n" + 
				"\\maketitle\r\n" + 
				"\r\n" + 
				"\\begin{abstract}\r\n" + 
				"Your abstract goes here...\r\n" + 
				"...\r\n" + 
				"\\end{abstract}\r\n" + 
				"\r\n" + 
				"\\chapter{Introduction}\r\n" + 
				"\\section{Section Title 1}\r\n" + 
				"\\section{Section Title 2}\r\n" + 
				"\\section{Section Title.....}\r\n" + 
				"\r\n" + 
				"\\chapter{....}\r\n" + 
				"\r\n" + 
				"\\chapter{Conclusion}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\\chapter*{References}\r\n" + 
				"\r\n" + 
				"\\end{document}");
	}

}
