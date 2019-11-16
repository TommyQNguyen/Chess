package Partie1;

public class Tour extends Piece{
	
	public Tour(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		//Si la position de la ligne de d�part est �gale � celle d'arriv�e,
		//OU la position de la colonne de d�part est �gale � celle d'arriv�e.
		if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne())
			return true;
		else if(depart == arrivee) //�galement, on consid�re un d�placement nul ( depart = arrivee ) comme �tant VALIDE.
			return true;
		else
			return false;
	}

}
