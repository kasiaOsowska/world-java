package projekt.swiat;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

public class MyFrame extends JFrame implements MouseListener{

	private static final int wymiarObrazka = 60;
	JButton button;
	JButton Blewo;
	JButton Bgora;
	JButton Bdol;
	JButton Bprawo;
	JButton BEliksir;
	JButton BSave;
	JButton BRead;
	
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	Swiat swiat;
	Obrazki obrazki;
	MyFrame(int width, int height, Swiat swiat)
	{
		addMouseListener(this);
		this.width = width;
		this.height = height;
		this.swiat = swiat;
		this.setBounds(0, 0, width, height);
		this.setVisible(true);
	    this.setSize(width,height);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setBackground(new Color(103, 145, 55));
	    this.getContentPane().add(new Obrazki(swiat, this));
	    
	    /*PRZYCISKI*/
	    button = new JButton("wykonaj ture");
	    button.setLayout(null);
		button.setBounds(400, 610, 130, 70);
		button.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
					    turaFrame();
					  } 
					});
		button.setFocusable(false);
		this.add(button);
		 
	   Blewo = new JButton("<-");
	   Blewo.setLayout(null);
	   Blewo.setBounds(0, 610, 90, 70);
	   Blewo.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) {
						  swiat.lewo = true;
					    System.out.println("lewo");
					  } 
					});
	   Blewo.setFocusable(false);
	   this.add(Blewo);
	   
	   Bprawo = new JButton("->");
	   Bprawo.setLayout(null);
	   Bprawo.setBounds(300, 610, 90, 70);
	   Bprawo.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
						  swiat.prawo = true;
					    System.out.println("prawo");
					  } 
					});
	   Bprawo.setFocusable(false);
	   this.add(Bprawo);
	   
	   Bgora = new JButton("^");
	   Bgora.setLayout(null);
	   Bgora.setBounds(100, 610, 90, 70);
	   Bgora.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
					    System.out.println("gora");
					    swiat.gora = true;
					  } 
					});
	   Bgora.setFocusable(false);
	   this.add(Bgora);
	   
	   Bdol = new JButton("dol");
	   Bdol.setLayout(null);
	   Bdol.setBounds(200, 610, 90, 70);
	   Bdol.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
						  swiat.dol = true;
					    System.out.println("dol");
					  } 
					});
	   Bdol.setFocusable(false);
	   this.add(Bdol);
		
	   BEliksir = new JButton("eliskir");
	   BEliksir.setLayout(null);
	   BEliksir.setBounds(540, 610, 90, 70);
	   BEliksir.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
					   swiat.eliksir = true;
					  } 
					});
	   Bdol.setFocusable(false);
	   this.add(BEliksir);
	   
	   BSave = new JButton("zapis");
	   BSave.setLayout(null);
	   BSave.setBounds(640, 610, 90, 70);
	   BSave.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
						  swiat.zapis();
					  } 
					});
	   BSave.setFocusable(false);
	   this.add(BSave);
	   
	   BRead = new JButton("odczyt");
	   BRead.setLayout(null);
	   BRead.setBounds(740, 610, 90, 70);
	   BRead.addActionListener(
				new ActionListener() { 
					  public void actionPerformed(ActionEvent e) { 
						 try {
							swiat.odczyt();
							repaint();
						} 
						 catch (FileNotFoundException e1) 
						 {
							e1.printStackTrace();
						 }
					  } 
					});
	   BRead.setFocusable(false);
	   this.add(BRead);
	   /*PRZYCISKI - koniec */
	   
	    obrazki = new Obrazki(swiat, this);
	    obrazki.repaint();
	}
	
	private void turaFrame()
	{
		swiat.tura();
		this.getContentPane().add(obrazki);
		repaint();
		revalidate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x, y;
		x = e.getX();
 		y = e.getY();
 		x=Math.round(x/wymiarObrazka);
 		y=Math.round(y/wymiarObrazka);
 		 String id = JOptionPane.showInputDialog("podaj pierwsza litere organizmu: ");
 		if(id.equals("t"))
 		 {
 			 swiat.dodajOrganizm('t', x, y);
 		 }
 		if(id.equals("o"))
		 {
			 swiat.dodajOrganizm('o', x, y);
		 }
 		if(id.equals("w"))
		 {
			 swiat.dodajOrganizm('w', x, y);
		 }
 		if(id.equals("c"))
		 {
			 swiat.dodajOrganizm('c', x, y);
		 }
 		if(id.equals("l"))
		 {
			 swiat.dodajOrganizm('l', x, y);
		 }
 		if(id.equals("a"))
		 {
			 swiat.dodajOrganizm('a', x, y);
		 }
 		if(id.equals("z"))
		 {
			 swiat.dodajOrganizm('z', x, y);
		 }
 		if(id.equals("b"))
		 {
			 swiat.dodajOrganizm('b', x, y);
		 }
 		if(id.equals("j"))
		 {
			 swiat.dodajOrganizm('j', x, y);
		 }
 		if(id.equals("m"))
		 {
			 swiat.dodajOrganizm('m', x, y);
		 }
 		if(id.equals("g"))
		 {
			 swiat.dodajOrganizm('g', x, y);
		 }
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}
