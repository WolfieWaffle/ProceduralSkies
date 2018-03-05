import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	private Game game = new Game();
	static JFrame frame = new JFrame();
	static ColorDisplay panel = new ColorDisplay();
	boolean gameRunning = true;
	int fps;

	public void init() {
		frame.setContentPane(panel);
		frame.setSize(800, 800);
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		gameLoop();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.paint(getWidth(), getHeight(), g);
	}

	public void gameLoop() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

		// keep looping round til the game ends
		double t = 0.0;
		double dt = 1 / 60.0;

		double currentTime = System.nanoTime();

		while (gameRunning) {
			double newTime = System.nanoTime();
			double frameTime = newTime - currentTime;
			currentTime = newTime;

			while (frameTime > 0.0) {
				float deltaTime = (float) Math.min(frameTime, dt);
				game.update(deltaTime);
				frameTime -= deltaTime;
				t += deltaTime;
			}

			repaint();
		}
	}

}
