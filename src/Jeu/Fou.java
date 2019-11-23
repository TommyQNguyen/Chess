package Jeu;

public class Fou extends Piece{
	
	public Fou(String nom, String couleur)
	{
		super(nom, couleur);
	}

	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //Également, on considère un déplacement nul ( depart = arrivee ) comme étant VALIDE.
			return true;
		//Si la valeur absolue de la différence entre ligne de départ et ligne d'arrivée est égale à
		// 	 la valeur absolue de la différence entre colonne de départ et colonne d'arrivée
		if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne())) 
			return true;
		
		return false;
	}
}
