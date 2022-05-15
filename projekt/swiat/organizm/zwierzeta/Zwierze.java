package projekt.swiat.organizm.zwierzeta;

import java.awt.Image;
import java.util.Random;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public abstract class Zwierze extends Organizm{

	Zwierze(int sila, int inicjatywa, int x, int y, Image img, Swiat swiat) {
		super(sila, inicjatywa, x, y, img, swiat);
	}

	public abstract char zwrochar();
	public abstract Image zwrocObrazek();
	public abstract int zwrocReprezentacjeGraficznaX();
	public abstract int zwrocReprezentacjeGraficznaY();
	public abstract int getx();
	public abstract int gety();
	public abstract boolean odbilAtak(Organizm atakujacy);
	public abstract void akcja();
	public boolean dodajSile(Organizm agresor) {
		return false;
	}
	
	public boolean zmienPozycjeOrganizmu(Organizm organizm, int nrPola)
	{
		int ilosc = 1;
		Random generator = new Random();
		if(nrPola == -1)
		{
			nrPola = generator.nextInt(4);
			if(organizm instanceof Antylopa)
			{
				if(nrPola%2==0)
				{
					ilosc = 2;
				}
			}
		}
		for (int i = 0; i < 4; i++)
		{
			if (nrPola == 0)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx() + ilosc, organizm.gety()))
				{
					organizm.x = organizm.x+ilosc;
					swiat.plansza[organizm.x-ilosc][organizm.y]=null;
					swiat.plansza[organizm.x][organizm.y]=organizm;
					return true;
				}
				else
				{
					if(swiat.sprawdzCzyWPlanszy(organizm.getx() + ilosc, organizm.gety()))
					{
						swiat.kolizja(swiat.plansza[organizm.x][organizm.y], swiat.plansza[organizm.x+ilosc][organizm.y]);
						return true;
					}
				}
			}
			if (nrPola == 1)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx(), organizm.gety()+ilosc))
				{
					organizm.y = organizm.y+ilosc;
					swiat.plansza[organizm.x][organizm.y-ilosc]=null;
					swiat.plansza[organizm.x][organizm.y]=organizm;
					return true;
				}
				else
				{
					if(swiat.sprawdzCzyWPlanszy(organizm.getx(), organizm.gety()+ilosc))
					{
						swiat.kolizja(swiat.plansza[organizm.x][organizm.y], swiat.plansza[organizm.x][organizm.y+ilosc]);
						return true;
					}
				}
			}
			if (nrPola == 2)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx()-ilosc, organizm.gety()))
				{
					organizm.x = organizm.x-ilosc;
					swiat.plansza[organizm.x+ilosc][organizm.y]=null;
					swiat.plansza[organizm.x][organizm.y]=organizm;
					return true;
				}
				else
				{
					if(swiat.sprawdzCzyWPlanszy(organizm.getx()-ilosc, organizm.gety()))
					{
						swiat.kolizja(swiat.plansza[organizm.x][organizm.y], swiat.plansza[organizm.x-ilosc][organizm.y]);
						return true;
					}
				}
			}
			if (nrPola == 3)
			{
				if (swiat.sprawdzCzyPuste(organizm.getx(), organizm.gety()-ilosc))
				{
					organizm.y = organizm.y-ilosc;
					swiat.plansza[organizm.x][organizm.y+ilosc]=null;
					swiat.plansza[organizm.x][organizm.y]=organizm;
					return true;
				}
				else
				{
					if(swiat.sprawdzCzyWPlanszy(organizm.getx(), organizm.gety()-ilosc))
					{
						swiat.kolizja(swiat.plansza[organizm.x][organizm.y], swiat.plansza[organizm.x][organizm.y-ilosc]);
						return true;
					}
				}
			}
			if(organizm instanceof Czlowiek)
			{
				return false;
			}
			nrPola = (nrPola + 1) % 4;
		}

		return false;
	}
}
