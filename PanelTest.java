
import java.awt.Color;

import java.awt.Graphics;

import java.awt.Image;

public class PanelTest{

	public static void main(String[] args) {
		
		DrawingPanel panel = new DrawingPanel(400, 400);

		panel.setBackground(Color.RED);

		Graphics g = panel.getGraphics();

		// g.setColor(Color.YELLOW);

		// g.drawLine(0, 0, 400, 400);

		// for(int i = 0; i<4; i++){
		// 	g.setColor(Color.YELLOW);
		// 	g.fillRect(100*i, 100*i, 100, 100);
		// 	g.setColor(Color.MAGENTA);
		// 	g.fillOval(100*i, 100*i, 100, 100);
		// }

		Image img = panel.loadImage("head.png");

		g.drawImage(img, 0, 0, panel);
	}
}