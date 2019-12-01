package Jeu;

public class Roi extends Piece{
	
	public Roi(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //Egalement, on considere un deplacement nul ( depart = arrivee ) comme etant VALIDE.
			return true;
		//Si le calcul de la norme() = 1 (déplacement vertical/horizontal) ou = 2 (déplacement diagonal)
		if (norme(depart, arrivee) == 1 || norme(depart, arrivee) == 2) 
			return true;
		
		return false;
	}

}
