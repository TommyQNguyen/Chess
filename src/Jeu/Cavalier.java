package Jeu;

public class Cavalier extends Piece {
	
	Cavalier(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) //�galement, on consid�re un d�placement nul ( depart = arrivee ) comme �tant VALIDE.
			return true;
		//Si la norme des positions de d�part de d'arriv�e du cavalier est �gale � 5
		if (norme(depart, arrivee) == 5) 
			return true;
		else	
			return false;
	}

}
