package view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JMenuBar;
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

public class Window {

	private JFrame frame;
	private JButton btnActivateTrack;
	private LatexEditorController latexEditor = new LatexEditorController();
	private JTextField TexFilePath;
	
	
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
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 704, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnOpenFile = new JButton("Open file");
		menuBar.add(btnOpenFile);
		
		JButton btnRollback = new JButton("Rollback");
		menuBar.add(btnRollback);
		btnRollback.addActionListener(e-> latexEditor.enact(btnRollback.getText(),TexFilePath.getText()));
		
		JButton btnSave = new JButton("Save");
		menuBar.add(btnSave);
		btnSave.addActionListener(e-> latexEditor.enact(btnSave.getText(),TexFilePath.getText()));
		
		JButton btnExit = new JButton("Exit");
		menuBar.add(btnExit);
		
		TexFilePath = new JTextField();
		TexFilePath.setText("FilePath");
		TexFilePath.setToolTipText("Where the file is stored");
		menuBar.add(TexFilePath);
		TexFilePath.setColumns(10);
		
		btnExit.addActionListener(e-> System.exit(0));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{32, 23, 23, 23, 23, 23, 23, 23, 23, 14, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCommands = new JLabel("Commands");
		GridBagConstraints gbc_lblCommands = new GridBagConstraints();
		gbc_lblCommands.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommands.gridx = 0;
		gbc_lblCommands.gridy = 0;
		frame.getContentPane().add(lblCommands, gbc_lblCommands);
		
		JButton btnReport = new JButton("Report");
		GridBagConstraints gbc_btnReport = new GridBagConstraints();
		gbc_btnReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnReport.gridx = 7;
		gbc_btnReport.gridy = 0;
		frame.getContentPane().add(btnReport, gbc_btnReport);
		btnReport.addActionListener(e-> latexEditor.enact("Create", btnReport.getText()));
		
		JButton btnBook = new JButton("Book");
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.insets = new Insets(0, 0, 5, 5);
		gbc_btnBook.gridx = 8;
		gbc_btnBook.gridy = 0;
		frame.getContentPane().add(btnBook, gbc_btnBook);
		btnBook.addActionListener(e-> latexEditor.enact("Create", btnBook.getText()));
		
		JButton btnArticle = new JButton("Article");
		GridBagConstraints gbc_btnArticle = new GridBagConstraints();
		gbc_btnArticle.insets = new Insets(0, 0, 5, 5);
		gbc_btnArticle.gridx = 9;
		gbc_btnArticle.gridy = 0;
		frame.getContentPane().add(btnArticle, gbc_btnArticle);
		btnArticle.addActionListener(e-> latexEditor.enact("Create", btnArticle.getText()));
		
		JButton btnLetter = new JButton("Letter");
		GridBagConstraints gbc_btnLetter = new GridBagConstraints();
		gbc_btnLetter.insets = new Insets(0, 0, 5, 5);
		gbc_btnLetter.gridx = 10;
		gbc_btnLetter.gridy = 0;
		frame.getContentPane().add(btnLetter, gbc_btnLetter);
		btnLetter.addActionListener(e-> latexEditor.enact("Create", btnLetter.getText()));
		
		JButton btnEmpty = new JButton("Empty");
		GridBagConstraints gbc_btnEmpty = new GridBagConstraints();
		gbc_btnEmpty.anchor = GridBagConstraints.EAST;
		gbc_btnEmpty.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmpty.gridx = 11;
		gbc_btnEmpty.gridy = 0;
		frame.getContentPane().add(btnEmpty, gbc_btnEmpty);
		btnEmpty.addActionListener(e-> latexEditor.enact("Create", btnEmpty.getText()));
		
		JButton btnChapter = new JButton("Chapter");
		btnChapter.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnChapter = new GridBagConstraints();
		gbc_btnChapter.insets = new Insets(0, 0, 5, 5);
		gbc_btnChapter.gridx = 0;
		gbc_btnChapter.gridy = 1;
		frame.getContentPane().add(btnChapter, gbc_btnChapter);
		btnChapter.addActionListener(e-> latexEditor.enact("AddLatex", btnChapter.getText()));
		
		JButton btnSection = new JButton("Section");
		GridBagConstraints gbc_btnSection = new GridBagConstraints();
		gbc_btnSection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSection.gridx = 0;
		gbc_btnSection.gridy = 2;
		frame.getContentPane().add(btnSection, gbc_btnSection);
		btnSection.addActionListener(e-> latexEditor.enact("AddLatex", btnSection.getText()));
		
		JLabel lblTextEditor = DefaultComponentFactory.getInstance().createLabel("Text Editor");
		GridBagConstraints gbc_lblTextEditor = new GridBagConstraints();
		gbc_lblTextEditor.insets = new Insets(0, 0, 5, 5);
		gbc_lblTextEditor.gridx = 7;
		gbc_lblTextEditor.gridy = 2;
		frame.getContentPane().add(lblTextEditor, gbc_lblTextEditor);
		
		JButton btnSubsection = new JButton("Subsection");
		GridBagConstraints gbc_btnSubsection = new GridBagConstraints();
		gbc_btnSubsection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubsection.gridx = 0;
		gbc_btnSubsection.gridy = 3;
		frame.getContentPane().add(btnSubsection, gbc_btnSubsection);
		btnSubsection.addActionListener(e-> latexEditor.enact("AddLatex", btnSubsection.getText()));
		
		JButton btnSubsubsection = new JButton("Subsubsection");
		GridBagConstraints gbc_btnSubsubsection = new GridBagConstraints();
		gbc_btnSubsubsection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubsubsection.gridx = 0;
		gbc_btnSubsubsection.gridy = 4;
		frame.getContentPane().add(btnSubsubsection, gbc_btnSubsubsection);
		btnSubsubsection.addActionListener(e-> latexEditor.enact("AddLatex", btnSubsubsection.getText()));
		
		JButton btnItemizeList = new JButton("Itemize_list");
		GridBagConstraints gbc_btnItemizeList = new GridBagConstraints();
		gbc_btnItemizeList.insets = new Insets(0, 0, 5, 5);
		gbc_btnItemizeList.gridx = 0;
		gbc_btnItemizeList.gridy = 5;
		frame.getContentPane().add(btnItemizeList, gbc_btnItemizeList);
		btnItemizeList.addActionListener(e-> latexEditor.enact("AddLatex", btnItemizeList.getText()));
		
		JButton btnEnumerationList = new JButton("Enumeration_list");
		GridBagConstraints gbc_btnEnumerationList = new GridBagConstraints();
		gbc_btnEnumerationList.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnumerationList.gridx = 0;
		gbc_btnEnumerationList.gridy = 6;
		frame.getContentPane().add(btnEnumerationList, gbc_btnEnumerationList);
		btnEnumerationList.addActionListener(e-> latexEditor.enact("AddLatex", btnEnumerationList.getText()));

		
		JButton btnTable = new JButton("Table");
		GridBagConstraints gbc_btnTable = new GridBagConstraints();
		gbc_btnTable.insets = new Insets(0, 0, 5, 5);
		gbc_btnTable.gridx = 0;
		gbc_btnTable.gridy = 7;
		frame.getContentPane().add(btnTable, gbc_btnTable);
		btnTable.addActionListener(e-> latexEditor.enact("AddLatex", btnTable.getText()));

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 7;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JButton btnFigure = new JButton("Figure");
		GridBagConstraints gbc_btnFigure = new GridBagConstraints();
		gbc_btnFigure.insets = new Insets(0, 0, 5, 5);
		gbc_btnFigure.gridx = 0;
		gbc_btnFigure.gridy = 8;
		frame.getContentPane().add(btnFigure, gbc_btnFigure);
		btnFigure.addActionListener(e-> latexEditor.enact("AddLatex", btnFigure.getText()));

		
		JLabel lblTrackHistory = DefaultComponentFactory.getInstance().createLabel("Track History");
		GridBagConstraints gbc_lblTrackHistory = new GridBagConstraints();
		gbc_lblTrackHistory.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrackHistory.gridx = 0;
		gbc_lblTrackHistory.gridy = 9;
		frame.getContentPane().add(lblTrackHistory, gbc_lblTrackHistory);
		
		btnActivateTrack = new JButton("Activate Track");
		btnActivateTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnActivateTrack, popupMenu);
		
		JButton btnVolatile = new JButton("Volatile");
		popupMenu.add(btnVolatile);
		btnVolatile.addActionListener(e-> latexEditor.enact(btnActivateTrack.getText(), btnVolatile.getText()));

		
		JButton btnStable = new JButton("Stable");
		popupMenu.add(btnStable);
		btnStable.addActionListener(e-> latexEditor.enact(btnActivateTrack.getText(), btnStable.getText()));

		
		GridBagConstraints gbc_btnActivateTrack = new GridBagConstraints();
		gbc_btnActivateTrack.insets = new Insets(0, 0, 5, 5);
		gbc_btnActivateTrack.gridx = 0;
		gbc_btnActivateTrack.gridy = 10;
		frame.getContentPane().add(btnActivateTrack, gbc_btnActivateTrack);
		
		JButton btnDisableTrack = new JButton("Disable Track");
		GridBagConstraints gbc_btnDisableTrack = new GridBagConstraints();
		gbc_btnDisableTrack.insets = new Insets(0, 0, 0, 5);
		gbc_btnDisableTrack.gridx = 0;
		gbc_btnDisableTrack.gridy = 11;
		frame.getContentPane().add(btnDisableTrack, gbc_btnDisableTrack);
		btnDisableTrack.addActionListener(e-> latexEditor.enact(btnDisableTrack.getText(),""));

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public String getFileLocation() {
		return TexFilePath.getText();
	}
	public void setFileLocation(String text) {
		TexFilePath.setText(text);
	}
}
