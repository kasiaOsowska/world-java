package projekt.swiat;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Obrazki extends JPanel
{
	private static final long serialVersionUID = 1L;
	Swiat swiat;
	MyFrame myFrame;
	Obrazki(Swiat swiat, MyFrame myFrame)
	{
		this.swiat = swiat;
		this.myFrame = myFrame;
		
	}
		
	public void paintComponent(Graphics g)
	{
	  for(int x=0; x<swiat.width; x++)
		{
			for(int y=0; y<swiat.height; y++)
			{
				if(swiat.plansza[x][y]!=null)
				{
					int i = swiat.plansza[x][y].zwrocReprezentacjeGraficznaX();
					int j = swiat.plansza[x][y].zwrocReprezentacjeGraficznaY();
					Image img = swiat.plansza[x][y].zwrocObrazek();
					g.drawImage(img, i, j, this);
				}
				else
					g.drawImage(null, x*60, y*60, this);
			}
		}
	}
}