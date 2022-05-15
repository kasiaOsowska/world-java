package projekt.swiat.organizm.zwierzeta;
import java.awt.Image;
import java.awt.Toolkit;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;

public class Czlowiek extends Zwierze
{
	static Image imgCzlowiek = Toolkit.getDefaultToolkit().getImage("czlowiek.png");
	int doOdczekania;
	Swiat swiat;
	public Czlowiek(int x, int y, Swiat swiat) {
		super(5, 4, x, y, imgCzlowiek, swiat);
		this.doOdczekania = 0;
		this.swiat = swiat;
	}

	@Override
	public char zwrochar() {
		return 'c';
	}

	@Override
	public Image zwrocObrazek() {
		return imgCzlowiek;
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
		// TODO Auto-generated method stub
		return false;
	}
	public void umiejetnosc()
	{
		if(this.sila>5)
			this.sila--;
		this.doOdczekania--;
		if(swiat.eliksir == true)
		{
			if(this.doOdczekania<1)
			{
				this.sila+=5;
				this.doOdczekania = 5;
			}
			swiat.eliksir = false;
		}
		System.out.println("sila czlowieka wynosi "+ this.sila);
	}
	@Override
	public void akcja() {
		this.umiejetnosc();
		if(swiat.prawo == true)
		{
			swiat.plansza[x][y].zmienPozycjeOrganizmu(this, 0);
			swiat.prawo = false;
		}
		if(swiat.lewo == true)
		{
			swiat.plansza[x][y].zmienPozycjeOrganizmu(this, 2);
			swiat.lewo = false;
		}
		if(swiat.gora == true)
		{
			swiat.plansza[x][y].zmienPozycjeOrganizmu(this, 3);
			swiat.gora = false;
		}
		if(swiat.dol == true)
		{
			swiat.plansza[x][y].zmienPozycjeOrganizmu(this, 1);
			swiat.dol = false;
		}
		
	}

}
