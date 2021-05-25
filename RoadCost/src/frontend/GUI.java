package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class GUI extends JFrame {
	
	private DisplayComponent displayComp = new DisplayComponent();

	public GUI() { 
		super("Road Costs");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(displayComp, BorderLayout.CENTER);
		createMenu();
		pack();
		setLocationRelativeTo(null);
		setVisible(true); 
	}

	private void createMenu() {
		JMenuBar menu = new JMenuBar();
		final JMenu loadMenu = new JMenu("Add Vehicle");
		final JMenuItem sedan = new JMenuItem("Sedan");
		final JMenuItem other = new JMenuItem("Other");
		final JMenuItem reset = new JMenuItem("Reset");
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(loadMenu);
		loadMenu.add(sedan);
		loadMenu.add(other);
		menu.add(reset);
		menu.add(quit);
		setJMenuBar(menu);

		// Add listeners to menu items.

		sedan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		other.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
	
	public static void main(String[] args) {
		new GUI();
	}
}
