package Jeu;

public class Pion extends Piece{
	
	//private boolean premierMouvement = true; //Boolean qui v�rifie si la pi�ce a fait son premier mouvement ou non
	
	public Pion (String nom, String couleur)
	{
		super(nom, couleur);
	}
	
	
	public boolean estValide(Position depart, Position arrivee)
	{
		if(depart == arrivee) return true;//�galement, on consid�re un d�placement nul ( depart = arrivee ) comme �tant VALIDE.
	
		switch (getCouleur()) {
			case "blanc":
				if (depart.getLigne() == 1) {
					if (depart.getColonne() == arrivee.getColonne()) 
						return arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() + 2;
				}
				else if (depart.getLigne() != 1) {
					return arrivee.getLigne() == depart.getLigne() + 1;
				}
				break;
	
			case "noir":
				if (depart.getLigne() == 6) {
					if (depart.getColonne() == arrivee.getColonne())
						return arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getLigne() == depart.getLigne() - 2;
				}
				else if (depart.getLigne() != 6) {
						return arrivee.getLigne() == depart.getLigne() - 1;
				}
				
			default: 
				break;
		}
		return false;
	}

}
