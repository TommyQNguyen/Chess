package Jeu;

public class Pion extends Piece{
	
	//private boolean premierMouvement = true; //Boolean qui verifie si la piece a fait son premier mouvement ou non
	
	public Pion (String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	
	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) return true;//Egalement, on considere un deplacement nul ( depart = arrivee ) comme etant VALIDE.
	
		switch (getCouleur()) {
			case "blanc":
				if (depart.getLigne() == 1) {
					if (depart.getColonne() == arrivee.getColonne()) 
						return arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() + 2;
				}
				else if (depart.getLigne() != 1) {
					if (depart.getColonne() == arrivee.getColonne())
						return arrivee.getLigne() == depart.getLigne() + 1;
				}
				break;
	
			case "noir":
				if (depart.getLigne() == 6) {
					if (depart.getColonne() == arrivee.getColonne())
						return arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getLigne() == depart.getLigne() - 2;
				}
				else if (depart.getLigne() != 6) {
					if (depart.getColonne() == arrivee.getColonne())
						return arrivee.getLigne() == depart.getLigne() - 1;
				}
				
			default: 
				break;
		}
		return false;
	}

}
