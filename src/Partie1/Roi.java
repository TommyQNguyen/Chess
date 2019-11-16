package Partie1;

public class Roi extends Piece{
	
	public Roi(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		//Si le calcul de la norme() = 1 (déplacement vertical/horizontal) ou = 2 (déplacement diagonal)
		if (norme(depart, arrivee) == 1 || norme(depart, arrivee) == 2) 
			return true;
		else if(depart == arrivee) //Également, on considère un déplacement nul ( depart = arrivee ) comme étant VALIDE.
			return true;
		else 
			return false;
	}

}
