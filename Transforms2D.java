import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300,300);  // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex();

			// TODO Apply transforms here, depending on the value of whichTransform!
			if(whichTransform == 0)
			{
				g2.setPaint(Color.green);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 1)
			{
				g2.rotate(Math.PI /2);
				g2.setPaint(Color.green);
				g2.drawPolygon(pol);
				g2.fill(pol);
				
			}
			if(whichTransform == 2)
			{
				g2.rotate(Math.PI /4);
				g2.setPaint(Color.green);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 3)
			{
				g2.rotate(Math.PI /6);
				g2.setPaint(Color.green);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 4)
			{
				g2.setPaint(Color.green);
				g2.scale(1.5, 1.5);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 5)
			{
				g2.setPaint(Color.green);
				g2.scale(0.5, 0.5);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 6)
			{
				g2.setPaint(Color.green);
				g2.scale(2, 0.5);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 7)
			{
				g2.setPaint(Color.green);
				g2.translate(100,50);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 8)
			{
				g2.setPaint(Color.green);
				g2.rotate(Math.PI / 4);
				g2.scale(0.5, 2);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			if(whichTransform == 9)
			{
				g2.setPaint(Color.blue);
				g2.rotate(Math.PI / 2);
				g2.scale(0.5, 0.5);
				g2.translate(10, 200);
				g2.drawPolygon(pol);
				g2.fill(pol);
			}
			 // Draw image with center at (0,0).
		}
	}

	private Display display;
	private BufferedImage pic;
	Polygon pol = new Polygon();
	private JComboBox<String> transformSelect;

	public Transforms2D() throws IOException {
		
		int r = 150;
		int n = 15;				
		for(int i = 0; i < n ; i++)
		
		{	
		pol.addPoint((int)Math.round(r * Math.cos((Math.PI /2 + 2 * Math.PI * i)/n)),(int)Math.round( r * Math.sin((Math.PI /2 + 2 * Math.PI * i)/n)));
		}
		display = new Display();
		display.setBackground(Color.WHITE);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transforms2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}