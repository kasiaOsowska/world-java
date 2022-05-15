package projekt.swiat.organizm.rosliny;

import java.awt.Image;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public abstract class Roslina extends Organizm{

	Roslina(int sila, int inicjatywa, int x, int y, Image img, Swiat swiat) {
		super(sila, inicjatywa, x, y, img, swiat);
	}

	public abstract char zwrochar();
	public abstract Image zwrocObrazek();
	public abstract int zwrocReprezentacjeGraficznaX();
	public abstract int zwrocReprezentacjeGraficznaY();
	public abstract int getx();
	public abstract int gety();
	public boolean odbilAtak(Organizm atakujacy)
	{
		return false;
	}
	public boolean dobryWech()
	{
		return false;
	}
	public boolean zmienPozycjeOrganizmu(Organizm organizm, int nrPola) {
		return false;
	}
	public abstract boolean dodajSile(Organizm agresor);
	public void akcja() 
	{
		dodajOrganizmNaLosowymPustymSasiednimPolu(this);
	}
}
