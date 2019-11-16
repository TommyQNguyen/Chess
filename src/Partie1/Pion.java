package Partie1;

public class Pion extends Piece{
	
	private boolean premierMouvement = true; //Boolean qui vérifie si la pièce a fait son premier mouvement ou non
	
	public Pion (String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	
	public boolean estValide(Position depart, Position arrivee)
	{
		//Différence entre ligne d'arrivée et ligne de départ est égale a 1 ou 2
		if (premierMouvement) 
			return Math.abs(arrivee.getLigne() - depart.getLigne()) == 1 || Math.abs(arrivee.getLigne() - depart.getLigne()) == 2;
		else
			return Math.abs(arrivee.getLigne() - depart.getLigne()) == 1; // Différence est égale a 1
	}

}
