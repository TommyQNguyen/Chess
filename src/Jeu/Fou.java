package Jeu;

public class Fou extends Piece{
	
	public Fou(String nom, String couleur)
	{
		super(nom, couleur);
	}

	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //Egalement, on considere un deplacement nul ( depart = arrivee ) comme etant VALIDE.
			return true;
		//Si la valeur absolue de la difference entre ligne de depart et ligne d'arrivee est egale a
		// 	 la valeur absolue de la difference entre colonne de depart et colonne d'arrivee
		if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne())) 
			return true;
		
		return false;
	}
}
