package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class DisplayComponent extends JComponent {
	public static final int GRID_SIZE = 50;

	public DisplayComponent() {
		super();
		setPreferredSize(new Dimension(600, 600));

	}

	@Override
	protected void paintComponent(Graphics g) {
		/*
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2));
		for (int i = 0; i <= 50; i++) {
			Line2D hline = new Line2D.Double(0, i * GRID_SIZE, 600, i * GRID_SIZE);
			Line2D vline = new Line2D.Double(i * GRID_SIZE, 0, i * GRID_SIZE, 600);
			g2d.draw(hline);
			g2d.draw(vline);
		}
		*/
	}
}