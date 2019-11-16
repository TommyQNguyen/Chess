package Partie1;

public class Cavalier extends Piece {
	
	Cavalier(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		//Si la norme des positions de départ de d'arrivée du cavalier est égale à 5
		if (norme(depart, arrivee) == 5) 
			return true;
		else if(depart == arrivee) //Également, on considère un déplacement nul ( depart = arrivee ) comme étant VALIDE.
			return true;
		else	
			return false;
	}

}
