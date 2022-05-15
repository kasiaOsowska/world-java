package projekt.swiat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import projekt.swiat.organizm.*;
import projekt.swiat.organizm.rosliny.Barszcz;
import projekt.swiat.organizm.rosliny.Guarana;
import projekt.swiat.organizm.rosliny.Jagody;
import projekt.swiat.organizm.rosliny.Mlecz;
import projekt.swiat.organizm.rosliny.Trawa;
import projekt.swiat.organizm.zwierzeta.Antylopa;
import projekt.swiat.organizm.zwierzeta.Lis;
import projekt.swiat.organizm.zwierzeta.Owca;
import projekt.swiat.organizm.zwierzeta.Wilk;
import projekt.swiat.organizm.zwierzeta.Zolw;
import projekt.swiat.organizm.zwierzeta.Czlowiek;
public class Swiat{
	int width, height;
	public boolean gora;
	public boolean dol;
	public boolean prawo;
	public boolean lewo;
	public boolean eliksir;
	int liczbaTur;
	public Organizm plansza[][];
	Swiat(int width, int height) 
	{
		this.width=width;
		this.height=height;
		plansza = new Organizm[width][height];
		for(int x=0; x<width; x++)
		{
			for(int y=0; y<height; y++)
			{
				this.plansza[x][y]= null;
			}
		}
		this.gora = false;
		this.dol = false;
		this.lewo = false;
		this.prawo = false;
		this.eliksir = false;
		this.liczbaTur=0;
	}
	private int zwrocRandY()
	{
		Random generator = new Random();
		return generator.nextInt(10);
	}
	private int zwrocRandX()
	{
		Random generator = new Random();
		return generator.nextInt(15);
	}
	public boolean dodajOrganizmNaLosowymPolu(char znak)
	{
		int x = zwrocRandX();
		int y = zwrocRandY();
		for(int i=0;i<5; i++)
		{
			if(plansza[x][y]==null)
			{
				if(dodajOrganizm(znak, x, y))
				{
					return true;
				}
			}
			else
			{
				x = zwrocRandX();
			    y = zwrocRandY();
			}
		}
		return false;
		
	}
	public boolean dodajOrganizm(char znak, int x, int y)
	{
		
		if(znak=='t') 
		{
			this.plansza[x][y] = new Trawa(x, y, this);
			return true;
		}
		if(znak=='j')
		{
			this.plansza[x][y] = new Jagody(x, y, this);
			return true;
		}
		if(znak=='m')
		{
			this.plansza[x][y] = new Mlecz(x, y, this);
			return true;
		}
		if(znak=='g')
		{
			this.plansza[x][y] = new Guarana(x, y, this);
			return true;
		}
		if(znak=='b')
		{
			this.plansza[x][y] = new Barszcz(x, y, this);
			return true;
		}
		if(znak=='w')
		{
			this.plansza[x][y] = new Wilk(x, y, this);
			return true;
		}
		if(znak=='o')
		{
			this.plansza[x][y] = new Owca(x, y, this);
			return true;
		}
		if(znak=='l')
		{
			this.plansza[x][y] = new Lis(x, y, this);
			return true;
		}
		if(znak=='z')
		{
			this.plansza[x][y] = new Zolw(x, y, this);
			return true;
		}
		if(znak=='a')
		{
			this.plansza[x][y] = new Antylopa(x, y, this);
			return true;
		}
		if(znak=='c')
		{
			this.plansza[x][y] = new Czlowiek(x, y, this);
			return true;
		}
		return false;
	}
	private Organizm zwrocOrganizmNaPolu(int x, int y)
	{
		if (x >= 0 && x < width)
		{
			if (y >= 0 && y < height)
			{
				return this.plansza[x][y];
			}
		}
		return null;
	}
	public boolean sprawdzCzyPuste(int x, int y)
	{
		if (x >= 0 && x < width)
		{
			if (y >= 0 && y < height)
			{
				if (this.zwrocOrganizmNaPolu(x, y) == null)
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}
	public boolean sprawdzCzyWPlanszy(int x, int y)
	{
		if (x >= 0 && x < width)
		{
			if (y >= 0 && y < height)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
	private boolean sprawdzCzyTaSamaKlasa(Organizm agresor, Organizm obronca)
	{
		if(agresor.zwrochar() == obronca.zwrochar())
		{
			return true;
		}
		return false;
	}
	public boolean kolizja(Organizm agresor, Organizm obronca)
	{
		if(sprawdzCzyTaSamaKlasa(agresor, obronca))
		{
			agresor.dodajOrganizmNaLosowymPustymSasiednimPolu(obronca);
			System.out.println(agresor.zwrochar()+" rozmnozyl sie ");
			return true;
		}
		if(obronca.dodajSile(agresor))
		{
			System.out.println("sila " + agresor.zwrochar()+" wzrosla o 3 i wynosi "+ agresor.sila);
		}
		if(agresor.sila>obronca.sila)
		{
			if(obronca.odbilAtak(agresor))
			{
				System.out.println(obronca.zwrochar()+" odparl atak "+ agresor.zwrochar());
				return true;
			}
			System.out.println(agresor.zwrochar()+" zjadl "+ obronca.zwrochar());
			/* swap pozycji  i usuniecie obroncy */
			plansza[agresor.x][agresor.y] = null;
			agresor.x = obronca.x;
			agresor.y = obronca.y;
			plansza[agresor.x][agresor.y] = agresor;
			obronca = null;
			/* swap pozycji i usuniecie obroncy - koniec */
			return true;
		}
		if(agresor.sila<obronca.sila)
		{
			if(agresor.dobryWech())
			{
				System.out.println(agresor.zwrochar()+" nie ruszyl sie na pole "+ obronca.zwrochar());
				return true;
			}
			System.out.println(agresor.zwrochar()+" zginal przez "+ obronca.zwrochar());
			/* usuniecie agresora */
			plansza[agresor.x][agresor.y] = null;
			agresor = null;
			/* usuniecie agresora - koniec*/
			return true;
		}
		
		return false;
	}
	
	public void tura()
	{
		for (int x = 0; x < width; x++)
		{

			for (int y = 0; y < height; y++)
			{
				if (plansza[x][y] != null)
				{
					plansza[x][y].wykonanoTure = false;
					plansza[x][y].wiek++;
					this.liczbaTur++;
				}
			}
		}
		for(int in = 7; in>=0; in--)
		{
			for(int x=0; x<this.width; x++)
			{
				for(int y=0; y<this.height; y++)
				{
					if(this.plansza[x][y]!=null)
					{
						if(plansza[x][y].inicjatywa == in)
						{
							for(int wiek=this.liczbaTur; wiek>=0; wiek--)
							{
								if(this.plansza[x][y]!=null)
								{
									if(plansza[x][y].wiek == wiek && plansza[x][y].wykonanoTure== false)
									{
										plansza[x][y].wykonanoTure=true;
										plansza[x][y].akcja();
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void zapis()
	{
		PrintWriter zapis;
		
		try {
			zapis = new PrintWriter("C:\\Users\\kasia\\eclipse-workspace\\lab1\\zapis.txt");
			for(int i=0; i<width; i++)
			{
				for(int j=0; j<height; j++)
				{
					if(plansza[i][j]!=null)
					{
						zapis.println(plansza[i][j].zwrochar());
						zapis.println(plansza[i][j].x);
						zapis.println(plansza[i][j].y);
						zapis.println(plansza[i][j].sila);
					}
				}
			}
		    zapis.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("nie udalo sie zapisac");
			e.printStackTrace();
		}
      
	}
	public void odczyt() throws FileNotFoundException 
	{
		for(int i=0; i<width; i++)
		{
			for(int j=0; j<height; j++)
			{
				if(plansza[i][j]!=null)
				{
					plansza[i][j]=null;
				}
			}
		}
		File file = new File("C:\\Users\\kasia\\eclipse-workspace\\lab1\\zapis.txt");
        @SuppressWarnings("resource")
		Scanner in = new Scanner(file);
		String znak;
		while(in.hasNext())
		{
			znak = in.nextLine();
			int x_wczytane = Integer.parseInt(in.nextLine());
			int y_wczytane = Integer.parseInt(in.nextLine());
			int sila = Integer.parseInt(in.nextLine());
			if(znak.equals("c"))
			{
				 this.plansza[x_wczytane][y_wczytane] = new Czlowiek(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("t"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Trawa(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("j"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Jagody(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("m"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Mlecz(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("g"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Guarana(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("b"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Barszcz(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("w"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Wilk(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("o"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Owca(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("l"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Lis(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("z"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Zolw(x_wczytane, y_wczytane, this);
			}
			if(znak.equals("a"))
			{
				this.plansza[x_wczytane][y_wczytane] = new Antylopa(x_wczytane, y_wczytane, this);
			}
			if(this.plansza[x_wczytane][y_wczytane]!=null)
			{
				this.plansza[x_wczytane][y_wczytane].sila = sila;
				this.plansza[x_wczytane][y_wczytane].x=x_wczytane;
				this.plansza[x_wczytane][y_wczytane].y=y_wczytane;
			}
			
		}
		
	}
		
}
