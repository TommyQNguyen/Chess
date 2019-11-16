package Partie1;

public class Reine extends Piece{
	
	public Reine(String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	public boolean estValide(Position depart, Position arrivee) 
	{
		//Méthode estValide() de classe Fou 
		if (Math.abs(depart.getLigne() - arrivee.getLigne()) == Math.abs(depart.getColonne() - arrivee.getColonne())) 
			return true;
		else if (depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne()) //Méthode estValide() de classe Tour
			return true;
		else if(depart == arrivee) //Également, on considère un déplacement nul ( depart = arrivee ) comme étant VALIDE.
			return true;
		else
			return false;
	}

}
