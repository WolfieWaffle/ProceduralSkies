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
		
		palette = PalletteMaker.makePallet(10);

		//g.fillRect(0, 0, width, height);
		int portion = height;

		g.setColor(palette.getBasicColor(0));
		//g.fillRect(0, 0, width, (int) (height / ((y + 1) / 2.0f)));
		for (int y = palette.size; y > 0; y--) {
			int h = (int) Math.round(height / palette.size);
			g.setColor(palette.getBasicColor(y));
			g.fillRect(0, height - ((y + 1) * h), width, h);
			//g.fillRect(0, 0, width, height);
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
