package projekt.swiat.organizm.zwierzeta;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Zolw extends Zwierze
{
	static Image imgZolw = Toolkit.getDefaultToolkit().getImage("zolw.png");
	public Zolw(int x, int y, Swiat swiat) {
		super(2, 1, x, y, imgZolw, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'z';
	}

	@Override
	public Image zwrocObrazek() {
		return imgZolw;
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
	public int getx() {
		return this.x;
	}

	@Override
	public int gety() {
		return this.y;
	}

	@Override
	public boolean odbilAtak(Organizm atakujacy) {
		if(atakujacy.sila<5)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean dobryWech() {
		return false;
	}
	@Override
	public void akcja() {
		Random generator = new Random();
		if(generator.nextInt(4) == 2)
		{
			zmienPozycjeOrganizmu(this, -1);
		}
		
	}

}
