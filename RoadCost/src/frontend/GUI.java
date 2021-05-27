package frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame {

	private ResultsPanel resultsPanel;
	private DataEntryPanel dataPanel;

	public GUI() {	
		super("Road Cost");	
		
		//Create the data entry panel and menu items
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.dataPanel = new DataEntryPanel();
		JButton confirm = new JButton("Confirm");
		confirm.setPreferredSize(new Dimension(320, 50));
		this.dataPanel.add(confirm);
		add(this.dataPanel);
		createMenu();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar menu = new JMenuBar();
		final JMenuItem reset = new JMenuItem("Reset");
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(reset);
		menu.add(quit);
		setJMenuBar(menu);
		
		// Add listeners to menu items.
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(dataPanel);
				dataPanel = new DataEntryPanel();
				JButton confirm = new JButton("Confirm");
				confirm.setPreferredSize(new Dimension(320, 50));
				dataPanel.add(confirm);
				add(dataPanel);
				createMenu();
				pack();
				setVisible(true);
			}
		});

		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		new GUI();
	}
}
