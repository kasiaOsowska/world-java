package projekt.swiat.organizm.zwierzeta;
import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Wilk extends Zwierze
{
	static Image imgWilk = Toolkit.getDefaultToolkit().getImage("pies.png");
	public Wilk(int x, int y, Swiat swiat) {
		super(9, 5, x, y, imgWilk, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'w';
	}

	@Override
	public Image zwrocObrazek() {
		return imgWilk;
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
		return false;
	}

	@Override
	public boolean dobryWech() {
		return false;
	}
	@Override
	public void akcja() {
		zmienPozycjeOrganizmu(this, -1);
		
	}

}
