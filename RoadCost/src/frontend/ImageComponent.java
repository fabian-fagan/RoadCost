package frontend;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ImageComponent extends JPanel {
	private BufferedImage image;

	public ImageComponent(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 40, 0, this);
	}

}
