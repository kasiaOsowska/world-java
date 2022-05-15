package projekt.swiat.organizm;

import java.awt.Image;
import java.util.Random;

import projekt.swiat.Swiat;

public abstract class Organizm {
	public int sila;
	public int inicjatywa;
	public int x;
	public int y;
	public boolean wykonanoTure;
	public int wiek;
	public static final int wymiarObrazka = 60;
	public Swiat swiat;
	
	protected Organizm(int sila, int inicjatywa, int x, int y, Image img, Swiat swiat)
	{
		this.sila=sila;
		this.inicjatywa=inicjatywa;
		this.x=x;
		this.y=y;
		this.wykonanoTure=true;
		this.wiek = 0;
		this.swiat = swiat;
	}
	public abstract char zwrochar();
	public abstract Image zwrocObrazek();
	public abstract int zwrocReprezentacjeGraficznaX();
	public abstract int zwrocReprezentacjeGraficznaY();
	public abstract int getx();
	public abstract int gety();
	public abstract boolean odbilAtak(Organizm atakujacy);
	public abstract boolean dobryWech();
	public abstract boolean zmienPozycjeOrganizmu(Organizm organizm, int nrPola);
	public abstract boolean dodajSile(Organizm agresor);
	public abstract void akcja();
	public boolean dodajOrganizmNaLosowymPustymSasiednimPolu(Organizm organizm)
	{
		Random generator = new Random();
		int nrPola = generator.nextInt(4);
		for (int i = 0; i < 4; i++)
		{
			if (nrPola == 0)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx() + 1, organizm.gety()))
				{
					swiat.dodajOrganizm(organizm.zwrochar(), organizm.getx() + 1, organizm.gety());
					return true;
				}
			}
			if (nrPola == 1)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx(), organizm.gety()+1))
				{
					swiat.dodajOrganizm(organizm.zwrochar(), organizm.getx(), organizm.gety()+1);
					return true;
				}
			}
			if (nrPola == 2)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx()-1, organizm.gety()))
				{
					swiat.dodajOrganizm(organizm.zwrochar(), organizm.getx()-1, organizm.gety());
					return true;
				}
			}
			if (nrPola == 3)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx(), organizm.gety()-1))
				{
					swiat.dodajOrganizm(organizm.zwrochar(), organizm.getx(), organizm.gety()-1);
					return true;
				}
			}
			nrPola = (nrPola + 1) % 4;
		}

		
		return false;
	}
	
}
