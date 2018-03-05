import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Random rand = new Random();
	private Color skyColor = ColorTools.randomColor();
	private Color groundColor = ColorTools.randomColor();
	private ArrayList<Planet> planets = new ArrayList<>();

	public Game () {
		makeSun();
		makePlanets(2);
	}

	public void update(double delta) {
		for (int i = 0; i < planets.size(); i++) {

			// all time-related values must be multiplied by delta!
			Planet p = planets.get(i);
			System.out.println(p);
			p.y += 1;
			System.out.println("d " + p.y);
		}
	}

	public void paint(int width, int height, Graphics g) {
		System.out.println("PAINT");
		((Graphics2D) g).setPaint(new GradientPaint(0, 0, skyColor, 0, height, skyColor.brighter().brighter().brighter(), true));
		g.fillRect(0, 0, width, height);

		for (Planet planet : planets) {
			planet.draw(g);
		}

		((Graphics2D) g).setPaint(new GradientPaint(0, 0, groundColor, 0, height, groundColor.darker().darker().darker(), true));
		g.fillRect(0, height - (height / 3), width, (height / 3));
	}

	public void makeSun() {
		int x, y;

		x = 400;
		y = 500;

		planets.add(new Sun(x, y, 10, 400));
	}

	public void makePlanets(int count) {
		int x, y;

		for (int i = 0; i < count; i++) {
			x = rand.nextInt(800 + 1);
			y = rand.nextInt(800 + 1);

			planets.add(new Planet(x, y, 10, 400));
		}
	}

}
