package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.LatexEditorController;

import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class Window {

	private JFrame frame;
	private JButton btnActivateTrack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LatexEditorController latexEditor = new LatexEditorController();
		
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

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}
	
	
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
		
		JButton btnSave = new JButton("Save");
		menuBar.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		menuBar.add(btnExit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{32, 23, 23, 23, 23, 23, 23, 23, 23, 14, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JButton btnBook = new JButton("Book");
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.insets = new Insets(0, 0, 5, 5);
		gbc_btnBook.gridx = 8;
		gbc_btnBook.gridy = 0;
		frame.getContentPane().add(btnBook, gbc_btnBook);
		
		JButton btnArticle = new JButton("Article");
		GridBagConstraints gbc_btnArticle = new GridBagConstraints();
		gbc_btnArticle.insets = new Insets(0, 0, 5, 5);
		gbc_btnArticle.gridx = 9;
		gbc_btnArticle.gridy = 0;
		frame.getContentPane().add(btnArticle, gbc_btnArticle);
		
		JButton btnLetter = new JButton("Letter");
		GridBagConstraints gbc_btnLetter = new GridBagConstraints();
		gbc_btnLetter.insets = new Insets(0, 0, 5, 5);
		gbc_btnLetter.gridx = 10;
		gbc_btnLetter.gridy = 0;
		frame.getContentPane().add(btnLetter, gbc_btnLetter);
		
		JButton btnEmpty = new JButton("Empty");
		GridBagConstraints gbc_btnEmpty = new GridBagConstraints();
		gbc_btnEmpty.anchor = GridBagConstraints.EAST;
		gbc_btnEmpty.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmpty.gridx = 11;
		gbc_btnEmpty.gridy = 0;
		frame.getContentPane().add(btnEmpty, gbc_btnEmpty);
		
		JButton btnChapter = new JButton("Chapter");
		btnChapter.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnChapter = new GridBagConstraints();
		gbc_btnChapter.insets = new Insets(0, 0, 5, 5);
		gbc_btnChapter.gridx = 0;
		gbc_btnChapter.gridy = 1;
		frame.getContentPane().add(btnChapter, gbc_btnChapter);
		
		JButton btnSection = new JButton("Section");
		GridBagConstraints gbc_btnSection = new GridBagConstraints();
		gbc_btnSection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSection.gridx = 0;
		gbc_btnSection.gridy = 2;
		frame.getContentPane().add(btnSection, gbc_btnSection);
		
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
		
		JButton btnSubsubsection = new JButton("Subsubsection");
		GridBagConstraints gbc_btnSubsubsection = new GridBagConstraints();
		gbc_btnSubsubsection.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubsubsection.gridx = 0;
		gbc_btnSubsubsection.gridy = 4;
		frame.getContentPane().add(btnSubsubsection, gbc_btnSubsubsection);
		
		JButton btnItimizeList = new JButton("Itimize list");
		GridBagConstraints gbc_btnItimizeList = new GridBagConstraints();
		gbc_btnItimizeList.insets = new Insets(0, 0, 5, 5);
		gbc_btnItimizeList.gridx = 0;
		gbc_btnItimizeList.gridy = 5;
		frame.getContentPane().add(btnItimizeList, gbc_btnItimizeList);
		
		JButton btnEnumerationList = new JButton("Enumeration list");
		GridBagConstraints gbc_btnEnumerationList = new GridBagConstraints();
		gbc_btnEnumerationList.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnumerationList.gridx = 0;
		gbc_btnEnumerationList.gridy = 6;
		frame.getContentPane().add(btnEnumerationList, gbc_btnEnumerationList);
		
		JButton btnTable = new JButton("Table");
		GridBagConstraints gbc_btnTable = new GridBagConstraints();
		gbc_btnTable.insets = new Insets(0, 0, 5, 5);
		gbc_btnTable.gridx = 0;
		gbc_btnTable.gridy = 7;
		frame.getContentPane().add(btnTable, gbc_btnTable);
		
		JEditorPane editorPane = new JEditorPane();
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.gridwidth = 10;
		gbc_editorPane.gridheight = 9;
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.gridx = 7;
		gbc_editorPane.gridy = 3;
		frame.getContentPane().add(editorPane, gbc_editorPane);
		
		JButton btnFigure = new JButton("Figure");
		GridBagConstraints gbc_btnFigure = new GridBagConstraints();
		gbc_btnFigure.insets = new Insets(0, 0, 5, 5);
		gbc_btnFigure.gridx = 0;
		gbc_btnFigure.gridy = 8;
		frame.getContentPane().add(btnFigure, gbc_btnFigure);
		
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
		
		JButton btnStable = new JButton("Stable");
		popupMenu.add(btnStable);
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
}
