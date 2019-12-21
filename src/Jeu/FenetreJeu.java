package Jeu;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FenetreJeu extends JFrame
  {
  Echiquier e;        //echiquier
  JLabel [][] tab;    //tableau de JLabels
  
  JPanel jPanel1 = new JPanel();  // panel du haut
  JPanel jPanel2 = new JPanel();  // panel du bas ( grille )
  GridLayout gridLayout1 = new GridLayout();
  
  JButton boutonDebuter = new JButton();
  JTextField champTexte = new JTextField();
  
  String couleurControle = "blanc";

  public FenetreJeu()   // constructeur appelle méthode JBInit
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {

  
    tab = new JLabel[8][8];   // création du tableau de JLabel
    e = new Echiquier();      // création de l'échiquier

    
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(568, 585));
    this.setTitle("Jeu d'Echecs");
    jPanel1.setBounds(new Rectangle(5, 10, 550, 45));
    jPanel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    jPanel1.setLayout(null);
    jPanel2.setBounds(new Rectangle(5, 65, 550, 465));
    jPanel2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    jPanel2.setLayout(gridLayout1);
    gridLayout1.setColumns(8);
    gridLayout1.setRows(8);
    this.getContentPane().add(jPanel2, null);
    jPanel1.add(champTexte, null);
    jPanel1.add(boutonDebuter, null);
    this.getContentPane().add(jPanel1, null);

   
    boutonDebuter.setBounds(new Rectangle(15, 10, 130, 25));
    boutonDebuter.setText("DEBUTER");

   
    champTexte.setBounds(new Rectangle(160, 10, 320, 25));



    // les écouteurs
    GestionnaireEvenement gest = new GestionnaireEvenement ();
    boutonDebuter.addMouseListener(gest);

    
    for ( int i = 0; i <8; i++ )
      {
      for ( int j = 0; j <8 ; j++ )
        {
        tab[i][j] = new JLabel(); // création du JLabel
        jPanel2.add(tab[i][j]);  // ajouter au Panel
        tab[i][j].setOpaque(true);
        tab[i][j].setHorizontalAlignment(SwingConstants.CENTER);  // pour que les pieces apparaissent au centre de la case
        tab[i][j].addMouseListener(gest);  // ajouter l'écouteur aux sources

        
        if ( (i+j) % 2 == 0 )
          tab[i][j].setBackground(Color.lightGray );  //couleur des cases
        else
          tab[i][j].setBackground(Color.darkGray );
        }
      }


  }
  // main pour pouvoir exécuter l'interface graphique
  public static void main ( String [] args )
  {
	  FenetreJeu j = new FenetreJeu ();
	  j.setVisible(true);
	  j.setLocation(100, 130);
	  j.setDefaultCloseOperation(EXIT_ON_CLOSE);  // ferme le processus associé
  }
  
  
  // classe privée (interne) pour la gestion d'Événements
  private class GestionnaireEvenement extends MouseAdapter
  {

  Piece pieceTampon;
  ImageIcon iconeTampon;
  int ligneClic;
  int colonneClic;
  Position depart, arrivee;
//  String couleurControle = "blanc";
  public void mouseClicked(MouseEvent eve)
  {
	if ( eve.getSource() == boutonDebuter )
    {
    e.debuter();
    tab[0][0].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\TB.gif"));
    tab[0][1].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\CB.gif"));
    tab[0][2].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\FB.gif"));
    tab[0][4].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\RB.gif"));
    tab[0][3].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\DB.gif"));
    tab[0][5].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\FB.gif"));
    tab[0][6].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\CB.gif"));
    tab[0][7].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\TB.gif"));
    tab[7][0].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\TN.gif"));
    tab[7][1].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\CN.gif"));
    tab[7][2].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\FN.gif"));
    tab[7][4].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\RN.gif"));
    tab[7][3].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\DN.gif"));
    tab[7][5].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\FN.gif"));
    tab[7][6].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\CN.gif"));
    tab[7][7].setIcon ( new ImageIcon ("C:\\Temp\\Icones\\TN.gif"));

    //Pions
    for ( int i = 0; i <8; i++ )
      {
      tab[1][i].setIcon(new ImageIcon("C:\\Temp\\Icones\\PB.gif"));
      tab[6][i].setIcon(new ImageIcon("C:\\Temp\\Icones\\PN.gif"));
      }
    champTexte.setText(couleurControle);
    }
  else // donc a clique sur un Label
    {
    //trouver lequel
    for ( int i = 0; i < 8 ; i++ )
      {
      for ( int j = 0; j<8; j++ )
        {
        if (eve.getSource() == tab[i][j])
          {
          ligneClic = i;
          colonneClic = j;
          }
        }
      }
    champTexte.setText(couleurControle);
    
    // 1er cas :
    if (e.getCase(ligneClic, colonneClic).estOccupee() && pieceTampon == null)	{		//clique sur une case occupee , tampon vide : case Depart
    	if (pieceTampon == null)
		{ 
    		if(e.getCase(ligneClic, colonneClic).getPiece() != null) //Si la piece existe
    	    {	
    	    	//Si la couleur de la piece est la meme que la couleur du champ de texte (
    	    	if(!e.getCase(ligneClic, colonneClic).getPiece().getCouleur().equals(champTexte.getText())) {
    	    		return;
    	    	}
    	    }
			depart = new Position(ligneClic, colonneClic);					    //initialiser position depart	
			iconeTampon = (ImageIcon)tab[ligneClic][colonneClic].getIcon();	    //prendre l'icone et la mettre dans le tampon,
			pieceTampon = e.getCase(ligneClic, colonneClic).getPiece();		 	//prendre la piece et la mettre dans le tampon
			tab[ligneClic][colonneClic].setIcon(null); 						 	//enlever le tampon de la place d'origine
		}
    	return;
    }
	
	
    // 2ème cas : clique sur une case vide ; tampon plein case d'arrivee, pas de pion en diagonale
    if(!e.getCase(ligneClic, colonneClic).estOccupee() && pieceTampon != null)
    {
    	arrivee = new Position(ligneClic, colonneClic); 									   //initialiser position d'arrivée
		if(e.getCase(depart.getLigne(), depart.getColonne()).getPiece().estValide(depart, arrivee)) //vérifier estValide(), exclue les pions en diagonale
		{	
			if(e.cheminPossible(depart, arrivee)) //vérifier cheminPossible()
			{
				if(e.getCase(ligneClic, colonneClic).getPiece() != null) //Si la piece existe
			    {	
			    	//Si la couleur de la piece est la meme que la couleur du champ de texte (
			    	if(!e.getCase(ligneClic, colonneClic).getPiece().getCouleur().equals(champTexte.getText())) {
			    		return;
			    	}
			    }
				e.getCase(arrivee.getLigne(), arrivee.getColonne()).ajouterPiece(pieceTampon); //enlever la pièce du tampon et la mettre sur l'arrivée
				e.getCase(depart.getLigne(), depart.getColonne()).enleverPiece();			   //enlever définitivement la pièce du départ
			
				tab[arrivee.getLigne()][arrivee.getColonne()].setIcon(iconeTampon);			   //placer l'icone tampon sur la place d'arrivée
				iconeTampon = null;															   //et l'enlever du tampon
				pieceTampon = null;

				alterne();//Change la couleur de la pièce
				champTexte.setText(couleurControle);
				return;
			}
		}
    }
	  
    // 3ème cas : clique sur une case occupee et tampon plein : case d'arrivee + pion en diagonale
	if (e.getCase(ligneClic, colonneClic).estOccupee() && pieceTampon != null)
	{
		arrivee = new Position(ligneClic, colonneClic); //Reassigner arrivee 
		if(e.getCase(depart.getLigne(), depart.getColonne()).getPiece().estValide(depart, arrivee))
		{
			if (e.cheminPossible(depart, arrivee))
			{
				if(e.getCase(depart).getPiece() != null) //Si la piece existe
			    {	
			    	//Si la couleur de la piece est la meme que la couleur du champ de texte (
			    	if(!e.getCase(depart).getPiece().getCouleur().equals(champTexte.getText())) {
			    		return;
			    	}
			    }
				e.getCase(arrivee.getLigne(), arrivee.getColonne()).ajouterPiece(pieceTampon);
				e.getCase(depart.getLigne(), depart.getColonne()).enleverPiece();
				tab[arrivee.getLigne()][arrivee.getColonne()].setIcon(iconeTampon);
				tab[depart.getLigne()][depart.getColonne()].setIcon(null);
				pieceTampon = null;
				alterne();
            }
		}
		else //c'est peut etre un Pion en diagonale
        if(e.captureParUnPionPossible(depart, arrivee))
        {
        	e.getCase(arrivee).ajouterPiece(pieceTampon);
        	e.getCase(depart).enleverPiece();
        	tab[arrivee.getLigne()][arrivee.getColonne()].setIcon(iconeTampon);
        	tab[depart.getLigne()][depart.getColonne()].setIcon(null);
        	pieceTampon = null;
        	alterne();
        }
  }
  }
  }//Fin méthode mouseClicked()
  public void alterne ()
  {
  if (couleurControle == "blanc")
    couleurControle = "noir";
  else
    couleurControle = "blanc";
  
  champTexte.setText(couleurControle);
  }

}//Fin classe interne
}//Fin FenetreJeu









