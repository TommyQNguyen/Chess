package Jeu;

public class Fou extends Piece{
	
	public Fou(String nom, String couleur)
	{
		super(nom, couleur);
	}

	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //�galement, on consid�re un d�placement nul ( depart = arrivee ) comme �tant VALIDE.
			return true;
		//Si la valeur absolue de la diff�rence entre ligne de d�part et ligne d'arriv�e est �gale �
		// 	 la valeur absolue de la diff�rence entre colonne de d�part et colonne d'arriv�e
		if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne())) 
			return true;
		
		return false;
	}
}
