package Partie1;

public class Pion extends Piece{
	
	private boolean premierMouvement = true; //Boolean qui v�rifie si la pi�ce a fait son premier mouvement ou non
	
	public Pion (String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	
	public boolean estValide(Position depart, Position arrivee)
	{
		//Diff�rence entre ligne d'arriv�e et ligne de d�part est �gale a 1 ou 2
		if (premierMouvement) 
			return Math.abs(arrivee.getLigne() - depart.getLigne()) == 1 || Math.abs(arrivee.getLigne() - depart.getLigne()) == 2;
		else
			return Math.abs(arrivee.getLigne() - depart.getLigne()) == 1; // Diff�rence est �gale a 1
	}

}
