import java.awt.Graphics;
import java.util.Collections;

import javax.swing.JPanel;

public class ColorDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	Palette palette;// = new Palette(7);

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int height = getHeight();
		int width = getWidth();
		int portion = height;

		palette = new Palette((int) (Math.random() * 2 + 8));
		System.out.println(palette.size);

		for (int y = 0; y < palette.size; y++) {
			g.setColor(palette.getColor(y));
			g.fillRect(0, 0, width, (int) (height / ((y + 1) / 2.0f)));
		}
	}

	/*@Override
	public void paint(Graphics g) {
		super.paint(g);
		int height = 50;
		for (int y = 0; y < 10; y++) {
			palette = new Palette(7);
			
			for (int i = 0; i < palette.size; i++) {
				g.setColor(palette.getColor(i));
				System.out.println(palette.getColor(i));
				g.fillRect(height * i, y * height, height, height);
			}
		}
		
	}*/

}
