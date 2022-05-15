package projekt.swiat.organizm.rosliny;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import projekt.swiat.Swiat;
import projekt.swiat.organizm.Organizm;
import projekt.swiat.organizm.zwierzeta.Zwierze;

public class Barszcz extends Roslina
{
	static Image imgBarszcz = Toolkit.getDefaultToolkit().getImage("barszcz.png");
	public Barszcz(int x, int y, Swiat swiat) {
		super(10, 0, x, y, imgBarszcz, swiat);
	}

	@Override
	public char zwrochar() {
		
		return 'b';
	}

	@Override
	public Image zwrocObrazek() {
		return imgBarszcz;
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
		return false;
	}
	private boolean sprawdzCzySasieniePoleZajmujeZwierze(int x, int y)
	{
		if(swiat.sprawdzCzyWPlanszy(x, y))
		{
			if(swiat.plansza[x][y] instanceof Zwierze)
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	private boolean zabijWSasiedztwie()
	{
		Random generator = new Random();
		int nrPola = generator.nextInt(4);
		for (int i = 0; i < 4; i++)
		{
			if (nrPola == 0)
			{
				if (this.sprawdzCzySasieniePoleZajmujeZwierze(this.getx() + 1, this.gety()))
				{
					System.out.println("barszcz zabil "+ swiat.plansza[this.getx() + 1][this.gety()].zwrochar() + "bo byl w sasiedztwie");
					swiat.plansza[this.getx() + 1][this.gety()] = null;
				}
			}
			if (nrPola == 1)
			{
				if (this.sprawdzCzySasieniePoleZajmujeZwierze(this.getx(), this.gety()+1))
				{
					System.out.println("barszcz zabil "+ swiat.plansza[this.getx()][this.gety()+1].zwrochar() + "bo byl w sasiedztwie");
					swiat.plansza[this.getx()][this.gety()+1] = null;
				}
			}
			if (nrPola == 2)
			{
				if (this.sprawdzCzySasieniePoleZajmujeZwierze(this.getx() - 1, this.gety()))
				{
					System.out.println("barszcz zabil "+ swiat.plansza[this.getx() - 1][this.gety()].zwrochar() + "bo byl w sasiedztwie");
					swiat.plansza[this.getx() - 1][this.gety()] = null;
				}
			}
			if (nrPola == 3)
			{
				if (this.sprawdzCzySasieniePoleZajmujeZwierze(this.getx(), this.gety()-1))
				{
					System.out.println("barszcz zabil "+ swiat.plansza[this.getx()][this.gety()-1].zwrochar() + "bo byl w sasiedztwie");
					swiat.plansza[this.getx()][this.gety()-1] = null;
				}
			}
			nrPola = (nrPola + 1) % 4;
		}
		return false;
	}
	@Override
	public void akcja() {
		dodajOrganizmNaLosowymPustymSasiednimPolu(this);
		this.zabijWSasiedztwie();
		
	} 

}
