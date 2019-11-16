package Partie1;

public class Tour extends Piece{
	
	public Tour(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		//Si la position de la ligne de départ est égale à celle d'arrivée,
		//OU la position de la colonne de départ est égale à celle d'arrivée.
		if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne())
			return true;
		else if(depart == arrivee) //Également, on considère un déplacement nul ( depart = arrivee ) comme étant VALIDE.
			return true;
		else
			return false;
	}

}
