package projekt.swiat.organizm.rosliny;

import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Jagody extends Roslina
{
	static Image imgJagody = Toolkit.getDefaultToolkit().getImage("jagody.png");
	public Jagody(int x, int y, Swiat swiat) {
		super(99, 0, x, y, imgJagody, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'j';
	}

	@Override
	public Image zwrocObrazek() {
		return imgJagody;
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
	public boolean zmienPozycjeOrganizmu(Organizm organizm, int nrPola) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dodajSile(Organizm agresor) {
		return false;
	} 
	 

}
