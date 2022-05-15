package projekt.swiat.organizm.rosliny;

import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Mlecz extends Roslina
{
	Swiat swiat;
	static Image imgMlecz = Toolkit.getDefaultToolkit().getImage("mlecz.png");
	public Mlecz(int x, int y, Swiat swiat) {
		super(0, 0, x, y, imgMlecz, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'm';
	}

	@Override
	public Image zwrocObrazek() {
		return imgMlecz;
	}

	@Override
	public int zwrocReprezentacjeGraficznaX() {
		
		return this.x*60;
	}

	@Override
	public int zwrocReprezentacjeGraficznaY() {
		return this.y*60;
	}

	@Override
	public int getx() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int gety() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public boolean dodajSile(Organizm agresor) {
		return false;
	}
	@Override
	public void akcja() {
		dodajOrganizmNaLosowymPustymSasiednimPolu(this);
		dodajOrganizmNaLosowymPustymSasiednimPolu(this);
		dodajOrganizmNaLosowymPustymSasiednimPolu(this);
		
	}

}
