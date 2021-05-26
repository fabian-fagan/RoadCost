package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI extends JFrame {

	private ResultsPanel resultsPanel = new ResultsPanel();
	private DataEntryPanel dataPanel = new DataEntryPanel();

	public GUI() {
		super("Road Cost");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(dataPanel);
		createMenu();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar menu = new JMenuBar();
		final JMenu loadMenu = new JMenu("Add Vehicle");
		final JMenuItem reset = new JMenuItem("Reset");
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(loadMenu);
		menu.add(reset);
		menu.add(quit);
		setJMenuBar(menu);

		// Add listeners to menu items.

		loadMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateDataEntryFrame();
			}

		});

		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	private void CreateDataEntryFrame() {
		JFrame secondFrame = new JFrame("My 2nd Window!");
		secondFrame.setLayout(new FlowLayout());
		secondFrame.setTitle("Event Costs");
		secondFrame.setSize(280, 150);
		secondFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}
}
