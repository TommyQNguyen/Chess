package Jeu;

public class Tour extends Piece{
	
	public Tour(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //Egalement, on considere un deplacement nul ( depart = arrivee ) comme etant VALIDE.
			return true;
		//Si la position de la ligne de depart est egale a celle d'arrivee,
		//OU la position de la colonne de depart est egale a celle d'arrivee.
		if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne())
			return true;

		return false;
	}

}
