package Jeu;

public class Reine extends Piece{
	
	public Reine(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee) 
	{
		if(depart == arrivee) //Egalement, on considere un deplacement nul ( depart = arrivee ) comme etant VALIDE.
			return true;
		//Methode estValide() de classe Fou 
		if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne())) 
			return true;
		if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne()) //Methode estValide() de classe Tour
			return true;

		return false;
	}

}
