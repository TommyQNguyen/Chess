package Jeu;

public class Cavalier extends Piece {
	
	Cavalier(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //Egalement, on considere un deplacement nul ( depart = arrivee ) comme etant VALIDE.
			return true;
		//Si la norme des positions de depart de d'arrivee du cavalier est egale a 5
		System.out.println("estValide() Cavalier, norme est de " + norme(depart, arrivee));
		if (norme(depart, arrivee) == 5) 
			return true;
		else	
			return false;
	}

}
