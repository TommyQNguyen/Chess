package Partie1;

public class Fou extends Piece{
	
	public Fou(String nom, String couleur)
	{
		super(nom, couleur);
	}

	public boolean estValide(Position depart, Position arrivee)
	{
		//Si la valeur absolue de la différence entre ligne de départ et ligne d'arrivée est égale à
		// 	 la valeur absolue de la différence entre colonne de départ et colonne d'arrivée
		if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne())) 
			return true;
		else if(depart == arrivee) //Également, on considère un déplacement nul ( depart = arrivee ) comme étant VALIDE.
			return true;
		else
			return false;
	}
	
	
	
}
