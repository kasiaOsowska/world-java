package projekt.swiat.organizm.zwierzeta;
import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Lis extends Zwierze
{
	static Image imgLis = Toolkit.getDefaultToolkit().getImage("lis.png");
	Swiat swiat;
	public Lis(int x, int y, Swiat swiat) {
		super(3, 7, x, y, imgLis, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'l';
	}

	@Override
	public Image zwrocObrazek() {
		return imgLis;
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
		return true;
	}
	@Override
	public void akcja() {
		zmienPozycjeOrganizmu(this, -1);
		
	}

}
