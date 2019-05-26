package view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import controller.LatexEditorController;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.Toolkit;
import java.awt.Font;

public class Window {

	private JFrame frmLatexeditor;
	private LatexEditorController latexEditor = new LatexEditorController(this);
	private JTextField TexFilePath;
	private JEditorPane editorPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private int caretPosition;
	private JTextField StableTextField;
	private JRadioButton TrackingON;
	//private String stableFilePath;
	/*public class MainWindow {
		
		public static void main(String[] args) {
			
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Window window = new Window();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		*/
		public Window() {
			initialize();
		}

	//}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLatexeditor = new JFrame();
		frmLatexeditor.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmLatexeditor.setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/view/latex.png")));
		frmLatexeditor.setTitle("LatexEditor 2430 2944");
		frmLatexeditor.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmLatexeditor.setBounds(100, 100, 1025, 639);
		frmLatexeditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmLatexeditor.setJMenuBar(menuBar);
		
		JButton btnOpenFile = new JButton("Open file");
		menuBar.add(btnOpenFile);	
		//btnOpenFile.addActionListener(e-> latexEditor.enact(new String[] {"Load",TexFilePath.getText()}));
		btnOpenFile.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent ch) 
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			int rVal = fileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				TexFilePath.setText(fileChooser.getSelectedFile().toString());
				latexEditor.enact(new String[] {"Load",TexFilePath.getText()});
			}
		}
		});
		//btnRollback.addActionListener(e-> latexEditor.enact(new String [] {"Versions",btnRollback.getText()}));
		
		JButton btnSave = new JButton("Save");
		menuBar.add(btnSave);
		//btnSave.addActionListener(e-> latexEditor.enact(new String [] {btnSave.getText(),TexFilePath.getText()}));
		btnSave.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent ch) 
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			int rVal = fileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				TexFilePath.setText(fileChooser.getSelectedFile().toString());
				latexEditor.enact(new String[] {btnSave.getText(),TexFilePath.getText()});
			}
		}
		});
		
		
		JButton btnExit = new JButton("Exit");
		menuBar.add(btnExit);
		
		TexFilePath = new JTextField();
		TexFilePath.setToolTipText("Where the file is stored");
		menuBar.add(TexFilePath);
		TexFilePath.setColumns(10);
		/*
		JButton SetFileLocationBtn = new JButton("Set File Location");
			SetFileLocationBtn.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent ch) 
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					TexFilePath.setText(fileChooser.getSelectedFile().toString());
				}
			}
			});
			
		menuBar.add(SetFileLocationBtn);
		*/
		
		
		
		JButton CompileBtn = new JButton("CompilePDF");
		menuBar.add(CompileBtn);
		CompileBtn.addActionListener(e-> latexEditor.enact(new String [] {"Compile", this.getFileLocation()}));
		
		
		
		btnExit.addActionListener(e-> System.exit(0));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 159, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{32, 23, 23, 23, 23, 23, 23, 23, 23, 14, 23, 23, 0, 0, 0, 0, 120, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmLatexeditor.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCommands = new JLabel("Commands");
		GridBagConstraints gbc_lblCommands = new GridBagConstraints();
		gbc_lblCommands.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommands.gridx = 0;
		gbc_lblCommands.gridy = 0;
		frmLatexeditor.getContentPane().add(lblCommands, gbc_lblCommands);
		
		JLabel CreateLbl = new JLabel("Create New :");
		CreateLbl.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_CreateLbl = new GridBagConstraints();
		gbc_CreateLbl.insets = new Insets(0, 0, 5, 5);
		gbc_CreateLbl.gridx = 5;
		gbc_CreateLbl.gridy = 0;
		frmLatexeditor.getContentPane().add(CreateLbl, gbc_CreateLbl);
		
		JButton btnReport = new JButton("Report");
		GridBagConstraints gbc_btnReport = new GridBagConstraints();
		gbc_btnReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnReport.gridx = 7;
		gbc_btnReport.gridy = 0;
		frmLatexeditor.getContentPane().add(btnReport, gbc_btnReport);
		btnReport.addActionListener(e-> latexEditor.enact(new String [] {"Create", btnReport.getText()}));
		
		JButton btnBook = new JButton("Book");
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.insets = new Insets(0, 0, 5, 5);
		gbc_btnBook.gridx = 8;
		gbc_btnBook.gridy = 0;
		frmLatexeditor.getContentPane().add(btnBook, gbc_btnBook);
		btnBook.addActionListener(e-> latexEditor.enact(new String[] {"Create", btnBook.getText()}));
		
		JButton btnArticle = new JButton("Article");
		GridBagConstraints gbc_btnArticle = new GridBagConstraints();
		gbc_btnArticle.insets = new Insets(0, 0, 5, 5);
		gbc_btnArticle.gridx = 9;
		gbc_btnArticle.gridy = 0;
		frmLatexeditor.getContentPane().add(btnArticle, gbc_btnArticle);
		btnArticle.addActionListener(e-> latexEditor.enact(new String [] {"Create", btnArticle.getText()}));
		
		JButton btnLetter = new JButton("Letter");
		GridBagConstraints gbc_btnLetter = new GridBagConstraints();
		gbc_btnLetter.insets = new Insets(0, 0, 5, 5);
		gbc_btnLetter.gridx = 10;
		gbc_btnLetter.gridy = 0;
		frmLatexeditor.getContentPane().add(btnLetter, gbc_btnLetter);
		btnLetter.addActionListener(e-> latexEditor.enact(new String [] {"Create", btnLetter.getText()}));
		
		JButton btnEmpty = new JButton("Empty");
		GridBagConstraints gbc_btnEmpty = new GridBagConstraints();
		gbc_btnEmpty.anchor = GridBagConstraints.EAST;
		gbc_btnEmpty.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmpty.gridx = 11;
		gbc_btnEmpty.gridy = 0;
		frmLatexeditor.getContentPane().add(btnEmpty, gbc_btnEmpty);
		btnEmpty.addActionListener(e-> latexEditor.enact(new String[] {"Create", btnEmpty.getText()}));
		
		JButton btnChapter = new JButton("Chapter");
		btnChapter.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnChapter = new GridBagConstraints();
		gbc_btnChapter.insets = new Insets(0, 0, 5, 5);
		gbc_btnChapter.gridx = 0;
		gbc_btnChapter.gridy = 1;
		frmLatexeditor.getContentPane().add(btnChapter, gbc_btnChapter);
		btnChapter.addActionListener(e-> latexEditor.enact(new String [] {"AddLatex", btnChapter.getText(),getCaret()}));
		
		JButton btnSection = new JButton("Section");
		GridBagConstraints gbc_btnSection = new GridBagConstraints();
		gbc_btnSection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSection.gridx = 0;
		gbc_btnSection.gridy = 2;
		frmLatexeditor.getContentPane().add(btnSection, gbc_btnSection);
		btnSection.addActionListener(e-> latexEditor.enact(new String [] {"AddLatex", btnSection.getText(),getCaret()}));
		
		JLabel lblTextEditor = DefaultComponentFactory.getInstance().createLabel("Text Editor");
		GridBagConstraints gbc_lblTextEditor = new GridBagConstraints();
		gbc_lblTextEditor.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextEditor.gridx = 4;
		gbc_lblTextEditor.gridy = 2;
		frmLatexeditor.getContentPane().add(lblTextEditor, gbc_lblTextEditor);
		
		JButton btnEditBtn = new JButton("Commit Changes");
		btnEditBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isTrackingOn()) {
					latexEditor.enact(new String[] {"Versions","Commit"});
				}else {
					JOptionPane.showMessageDialog(btnEditBtn, "Tracking is Disabled");
				}
			}
		});
		btnEditBtn.setToolTipText("Click this to update the document");
		GridBagConstraints gbc_btnEditBtn = new GridBagConstraints();
		gbc_btnEditBtn.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditBtn.gridx = 5;
		gbc_btnEditBtn.gridy = 2;
		frmLatexeditor.getContentPane().add(btnEditBtn, gbc_btnEditBtn);
		
		
		
		
		JButton btnRollback = new JButton("Rollback");
		GridBagConstraints gbc_btnRollback = new GridBagConstraints();
		gbc_btnRollback.insets = new Insets(0, 0, 5, 5);
		gbc_btnRollback.gridx = 6;
		gbc_btnRollback.gridy = 2;
		frmLatexeditor.getContentPane().add(btnRollback, gbc_btnRollback);
		btnRollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isTrackingOn()) {
					latexEditor.enact(new String[] {"Versions",btnRollback.getText()});
				}else {
					JOptionPane.showMessageDialog(btnRollback, "Tracking is Disabled");
				}
			}
		});
		//btnEditBtn.addActionListener(e-> latexEditor.enact(new String[] {"Edit",this.GetDocText()}));
		//btnEditBtn.addActionListener(e-> latexEditor.enact(new String[] {"Versions","Commit"}));
		
		
		JButton btnSubsection = new JButton("Subsection");
		GridBagConstraints gbc_btnSubsection = new GridBagConstraints();
		gbc_btnSubsection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubsection.gridx = 0;
		gbc_btnSubsection.gridy = 3;
		frmLatexeditor.getContentPane().add(btnSubsection, gbc_btnSubsection);
		btnSubsection.addActionListener(e-> latexEditor.enact(new String [] {"AddLatex", btnSubsection.getText(),getCaret()}));
		
		JButton btnSubsubsection = new JButton("Subsubsection");
		GridBagConstraints gbc_btnSubsubsection = new GridBagConstraints();
		gbc_btnSubsubsection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubsubsection.gridx = 0;
		gbc_btnSubsubsection.gridy = 4;
		frmLatexeditor.getContentPane().add(btnSubsubsection, gbc_btnSubsubsection);
		btnSubsubsection.addActionListener(e-> latexEditor.enact(new String[] {"AddLatex", btnSubsubsection.getText(),getCaret()}));
		
		JButton btnItemizeList = new JButton("Itemize_list");
		GridBagConstraints gbc_btnItemizeList = new GridBagConstraints();
		gbc_btnItemizeList.insets = new Insets(0, 0, 5, 5);
		gbc_btnItemizeList.gridx = 0;
		gbc_btnItemizeList.gridy = 5;
		frmLatexeditor.getContentPane().add(btnItemizeList, gbc_btnItemizeList);
		btnItemizeList.addActionListener(e-> latexEditor.enact(new String[] {"AddLatex", btnItemizeList.getText(),getCaret()}));
		
		JButton btnEnumerationList = new JButton("Enumeration_list");
		GridBagConstraints gbc_btnEnumerationList = new GridBagConstraints();
		gbc_btnEnumerationList.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnumerationList.gridx = 0;
		gbc_btnEnumerationList.gridy = 6;
		frmLatexeditor.getContentPane().add(btnEnumerationList, gbc_btnEnumerationList);
		btnEnumerationList.addActionListener(e-> latexEditor.enact(new String[] {"AddLatex", btnEnumerationList.getText(),getCaret()}));

		
		JButton btnTable = new JButton("Table");
		GridBagConstraints gbc_btnTable = new GridBagConstraints();
		gbc_btnTable.insets = new Insets(0, 0, 5, 5);
		gbc_btnTable.gridx = 0;
		gbc_btnTable.gridy = 7;
		frmLatexeditor.getContentPane().add(btnTable, gbc_btnTable);
		btnTable.addActionListener(e-> latexEditor.enact(new String[] {"AddLatex", btnTable.getText(),getCaret()}));

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.gridheight = 14;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 3;
		frmLatexeditor.getContentPane().add(scrollPane, gbc_scrollPane);
		
		editorPanel = new JEditorPane();
		editorPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				handleKeypress();
			}
		});
		
		scrollPane.setViewportView(editorPanel);
		
		
		
		JButton btnFigure = new JButton("Figure");
		GridBagConstraints gbc_btnFigure = new GridBagConstraints();
		gbc_btnFigure.insets = new Insets(0, 0, 5, 5);
		gbc_btnFigure.gridx = 0;
		gbc_btnFigure.gridy = 8;
		frmLatexeditor.getContentPane().add(btnFigure, gbc_btnFigure);
		btnFigure.addActionListener(e-> latexEditor.enact(new String[] {"AddLatex", btnFigure.getText(),getCaret()}));

		
		JLabel lblTrackHistory = DefaultComponentFactory.getInstance().createLabel("Track History");
		GridBagConstraints gbc_lblTrackHistory = new GridBagConstraints();
		gbc_lblTrackHistory.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrackHistory.gridx = 0;
		gbc_lblTrackHistory.gridy = 9;
		frmLatexeditor.getContentPane().add(lblTrackHistory, gbc_lblTrackHistory);
		
		TrackingON = new JRadioButton("Tracking ON");
		TrackingON.setSelected(true);
		TrackingON.addActionListener(e-> latexEditor.enact(new String [] {"Versions","Enable"}));
			
		buttonGroup_1.add(TrackingON);
		GridBagConstraints gbc_TrackingON = new GridBagConstraints();
		gbc_TrackingON.insets = new Insets(0, 0, 5, 5);
		gbc_TrackingON.gridx = 0;
		gbc_TrackingON.gridy = 10;
		frmLatexeditor.getContentPane().add(TrackingON, gbc_TrackingON);
		
		JRadioButton TrackingOFF = new JRadioButton("Tracking OFF");
		TrackingOFF.setSelected(true);
		buttonGroup_1.add(TrackingOFF);
		GridBagConstraints gbc_TrackingOFF = new GridBagConstraints();
		gbc_TrackingOFF.insets = new Insets(0, 0, 5, 5);
		gbc_TrackingOFF.gridx = 0;
		gbc_TrackingOFF.gridy = 11;
		frmLatexeditor.getContentPane().add(TrackingOFF, gbc_TrackingOFF);
		TrackingOFF.addActionListener(e-> latexEditor.enact(new String [] {"Versions","Disable"}));
		
		JRadioButton Volatile = new JRadioButton("Volatile");
		buttonGroup.add(Volatile);
		Volatile.setSelected(true);
		GridBagConstraints gbc_Volatile = new GridBagConstraints();
		gbc_Volatile.insets = new Insets(0, 0, 5, 5);
		gbc_Volatile.gridx = 0;
		gbc_Volatile.gridy = 12;
		frmLatexeditor.getContentPane().add(Volatile, gbc_Volatile);
		
		Volatile.addActionListener(e-> latexEditor.enact(new String [] {"Versions","Volatile"}));
		
		JRadioButton NonVolatile = new JRadioButton("Stable");
		buttonGroup.add(NonVolatile);
		GridBagConstraints gbc_NonVolatile = new GridBagConstraints();
		gbc_NonVolatile.insets = new Insets(0, 0, 5, 5);
		gbc_NonVolatile.gridx = 0;
		gbc_NonVolatile.gridy = 13;
		frmLatexeditor.getContentPane().add(NonVolatile, gbc_NonVolatile);
		//Volatile.addActionListener(e-> latexEditor.enact(new String [] {"Versions","Stable"}));
		NonVolatile.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent ch) 
		{
			
				
			
				JFileChooser fileChooser = new JFileChooser("src\\stables");
			
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				//fileChooser.setCurrentDirectory();
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					StableTextField.setText(fileChooser.getSelectedFile().toString());
					latexEditor.enact(new String [] {"Versions","Stable",StableTextField.getText()});
				}
			
				//JOptionPane.showMessageDialog(NonVolatile, "Tracking is Disabled");
			
		}
		});
		
		StableTextField = new JTextField();
		GridBagConstraints gbc_StableTextField = new GridBagConstraints();
		gbc_StableTextField.insets = new Insets(0, 0, 5, 5);
		gbc_StableTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_StableTextField.gridx = 0;
		gbc_StableTextField.gridy = 14;
		frmLatexeditor.getContentPane().add(StableTextField, gbc_StableTextField);
		StableTextField.setColumns(10);
		
		
	}

	

	public JFrame getFrame() {
		return frmLatexeditor;
	}

	public void setFrame(JFrame frame) {
		this.frmLatexeditor = frame;
	}
	
	public String getFileLocation() {
		return TexFilePath.getText();
	}
	public void setFileLocation(String text) {
		TexFilePath.setText(text);
	}
	
	public void ReFreshText(String str) {
		editorPanel.setText(str);
	}
	public String GetDocText() {
		
		return editorPanel.getText();
		
	}
	private void handleKeypress() {
		caretPosition=editorPanel.getCaretPosition();
		latexEditor.enact(new String [] {"Edit", this.GetDocText()});
		//THIS WILL ENABLE THE UNDO FUNCTION 
		
		
		//latexEditor.enact(new String [] {"Versions","Commit"});
		
		
		
		editorPanel.setCaretPosition(caretPosition);
	}
	private String getCaret() {
		//System.out.println(caretPosition);
		//return Integer.toString(editorPanel.getCaretPosition());
		
		return Integer.toString(caretPosition);
	}
	
	private boolean isTrackingOn() {
		return (TrackingON.isSelected());
	}
}
