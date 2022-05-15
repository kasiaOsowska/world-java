package projekt.swiat.organizm.rosliny;

import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Trawa extends Roslina
{	static Image imgTrawa = Toolkit.getDefaultToolkit().getImage("trawa.png");
	public Trawa(int x, int y, Swiat swiat) 
	{
		super(0, 0, x, y, imgTrawa, swiat);
		
	}
	public Image zwrocObrazek()
	{
		return imgTrawa;
	}
	@Override
	public char zwrochar() {
		
		return 't';
	}
	@Override
	public int zwrocReprezentacjeGraficznaX() {
		return this.x*wymiarObrazka;
	}
	@Override
	public int zwrocReprezentacjeGraficznaY() {
		return this.y*wymiarObrazka;
	}
	@Override
	public int getx()
	{
		return this.x;
	}
	@Override
	public int gety() {
		
		return this.y;
	}
	@Override
	public boolean dodajSile(Organizm agresor) {
		return false;
	}
}
