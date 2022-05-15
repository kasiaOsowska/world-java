package projekt.swiat;


public class Main{
	public static final int wymiarObrazka = 60;
  public static void main(String[] args)
  {
	  int width = 15, height = 10;
	  Swiat swiat = new Swiat(width, height);
	  swiat.dodajOrganizmNaLosowymPolu('t');
	  swiat.dodajOrganizmNaLosowymPolu('j');
	  swiat.dodajOrganizmNaLosowymPolu('m');
	  swiat.dodajOrganizmNaLosowymPolu('g');
	  swiat.dodajOrganizmNaLosowymPolu('b');
	  swiat.dodajOrganizmNaLosowymPolu('w');
	  swiat.dodajOrganizmNaLosowymPolu('w');
	  swiat.dodajOrganizmNaLosowymPolu('o');
	  swiat.dodajOrganizmNaLosowymPolu('o');
	  swiat.dodajOrganizmNaLosowymPolu('l');
	  swiat.dodajOrganizmNaLosowymPolu('l');
	  swiat.dodajOrganizmNaLosowymPolu('z');
	  swiat.dodajOrganizmNaLosowymPolu('z');
	  swiat.dodajOrganizmNaLosowymPolu('a');
	  swiat.dodajOrganizmNaLosowymPolu('a');
	  swiat.dodajOrganizmNaLosowymPolu('c');
	  new MyFrame(width*wymiarObrazka+30, height*wymiarObrazka+30+100, swiat);
  }
}