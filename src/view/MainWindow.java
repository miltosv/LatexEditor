package view;

import java.awt.EventQueue;

public class MainWindow {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.getFrame().setVisible(true);
					//window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public static void Window() throws Exception {
		/*Window window = new Window();
		window.getFrame().setVisible(true);
		window.initialize();
		initialize();
	}
*/
}
