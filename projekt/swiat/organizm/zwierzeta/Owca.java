package projekt.swiat.organizm.zwierzeta;
import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Owca extends Zwierze
{
	static Image imgOwca = Toolkit.getDefaultToolkit().getImage("owca.png");
	public Owca(int x, int y, Swiat swiat) {
		super(4, 4, x, y, imgOwca, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'o';
	}

	@Override
	public Image zwrocObrazek() {
		return imgOwca;
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
