import java.awt.*;

public class DrawingPanelDemo{

	public static void main(String[] args) {
		

		// Color[][] pixels = panel.getPixels();

		

		//

		//getNegative(panel);
	}

	public static void getNegative(){

		DrawingPanel panel = new DrawingPanel(500, 500);

		Image img = panel.loadImage("myPhoto.jpeg");

		Graphics gr = panel.getGraphics();

		gr.drawImage(img, 30, 40, panel);

		Color[][] pixels = panel.getPixels();

		for(int i = 0; i<pixels.length; i++){

			for(int j = 0; j<pixels[i].length; j++){

				int r = 255 - pixels[i][j].getRed();
				int g = 255 - pixels[i][j].getGreen();
				int b = 255 - pixels[i][j].getBlue();

				pixels[i][j] = new Color(r, g, b);
					
			}
		}

		panel.setPixels(pixels);

	}
}