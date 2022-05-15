package projekt.swiat.organizm.rosliny;

import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Guarana extends Roslina
{
	static Image imgGuarana = Toolkit.getDefaultToolkit().getImage("guarana.png");
	Swiat swiat;
	public Guarana(int x, int y, Swiat swiat) {
		super(0, 0, x, y, imgGuarana, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'g';
	}

	@Override
	public Image zwrocObrazek() {
		return imgGuarana;
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
	public boolean dodajSile(Organizm agresor) {
		agresor.sila+=3;
		return true;
	}
	

}
