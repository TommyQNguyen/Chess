package Jeu;

public class Echiquier implements MethodesEchiquier {
private Case location [][] = new Case[8][8];

  public Echiquier()
  {
	  for (int i = 0; i < location.length; i++) 
		for (int j = 0; j < location.length; j++) 
			location[i][j] = new Case();
  }

//Méthode à compléter 
public void debuter()
{
  for (int k = 0; k < 8; k++) 
  {
	//Insertions des pieces de classe Pion dans le tableau de Case
	location[1][k].ajouterPiece(new Pion("pionBlanc" + String.valueOf(k), "blanc")); 
	location[6][k].ajouterPiece(new Pion("pionNoir" + String.valueOf(k), "noir"));
  }
  
  	//Insertions des Tours
  	location[0][0].ajouterPiece(new Tour("tourBlanche1", "blanc"));
  	location[0][7].ajouterPiece(new Tour("tourBlanche2", "blanc"));
  	location[7][0].ajouterPiece(new Tour("tourNoir1", "noir"));
  	location[7][7].ajouterPiece(new Tour("tourNoir2", "noir"));

  	//Insertion des Cavaliers
  	location[0][1].ajouterPiece(new Cavalier("cavalierBlanc1", "blanc"));
  	location[0][6].ajouterPiece(new Cavalier("cavalierBlanc2", "blanc"));
  	location[7][1].ajouterPiece(new Cavalier("cavalierNoir1", "noir"));
  	location[7][6].ajouterPiece(new Cavalier("cavalierNoir2", "noir"));

  	//Insertion des Fous
  	location[0][2].ajouterPiece(new Fou("fouBlanc1", "blanc"));
  	location[0][5].ajouterPiece(new Fou("fouBlanc2", "blanc"));
  	location[7][2].ajouterPiece(new Fou("fouNoir1", "noir"));
  	location[7][5].ajouterPiece(new Fou("fouNoir2", "noir"));

  	//Insertion des Reines
  	location[0][3].ajouterPiece(new Reine("reineBlanche", "blanc"));
  	location[7][3].ajouterPiece(new Reine("reineNoir", "noir"));

  	//Insertion des Rois
  	location[0][4].ajouterPiece(new Roi("roiBlanc", "blanc"));
  	location[7][4].ajouterPiece(new Roi("roiNoir", "noir"));
}

public Case getCase ( int ligne, int colonne )
{
return location[ligne][colonne];
}

public Case getCase(Position position) 
{
	return getCase(position.getLigne(), position.getColonne());
}

//Méthode à compléter 
public boolean captureParUnPionPossible ( Position depart,Position arrivee )
{
	switch (getCase(depart.getLigne(),depart.getColonne()).getPiece().getCouleur()) {
	case "blanc": //Si la diagonale du pion blanc est Bas-Droite OU Bas-Gauche
		if (getCase(depart.getLigne() + 1, depart.getColonne() + 1).estOccupee() || getCase(depart.getLigne() + 1, depart.getColonne() - 1).estOccupee()) 
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //Si la case est occupee
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee("blanc"); // Retourne VRAI si la piece d'arrivee est noire
		break;

	case "noir": //Si la diagonale du pion noir est Haut-Droite OU Haut-Gauche
		if (getCase(depart.getLigne() - 1, depart.getColonne() + 1).estOccupee() || getCase(depart.getLigne() - 1, depart.getColonne() - 1).estOccupee()) 
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //Si la case est occupee
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee("noir"); // Retourne VRAI si la piece d'arrivee est blanche
		break;
	}
	return false;
}

//Méthode à compléter    
public boolean cheminPossible ( Position  depart , Position arrivee)
{
	int differenceLigne = arrivee.getLigne() - depart.getLigne();
	int differenceColonne = arrivee.getColonne() - depart.getColonne();
	
	if (depart == arrivee)
		return true;
	
	//Mouvement possible du CAVALIER
	if (getCase(depart.getLigne(), depart.getColonne()).getPiece().getNom().charAt(0) == 'c') {
		if(!getCase(depart.getLigne(), depart.getColonne()).getPiece().estValide(depart, arrivee))
			return false;
		
		if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //Si la case est occupee
			return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
		return true; // Retourne VRAI si la case est occupee ET il n'y a aucune piece a la case d'arrivee
	}
	
	
	//Mouvement VERTICAL haut
	if (differenceColonne == 0) {
		if (differenceLigne < 0) 
		{
			for (int i = 1; i < depart.getLigne() - arrivee.getLigne(); i++) 
				if (getCase(depart.getLigne() - i, depart.getColonne()).estOccupee()) 
					return false;
			
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
			return true;
		} 
		//Mouvement vertical bas
		else if (differenceLigne > 0) 
		{
			for (int i = 1; i < arrivee.getLigne() - depart.getLigne(); i++) 
				if (getCase(depart.getLigne() + i, depart.getColonne()).estOccupee()) 
					return false;
			
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
			return true;
		}
	}
	
	//Mouvement HORIZONTAL gauche
		if (differenceLigne == 0) {
			if (differenceColonne < 0) 
			{
				for (int i = 1; i < depart.getColonne() - arrivee.getColonne(); i++) 
					if (getCase(depart.getLigne(), depart.getColonne() - i).estOccupee()) 
						return false;
				
				if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
					return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
				return true;
			} 
			//Mouvement horizontal droite 
			else if (differenceColonne > 0) 
			{
				for (int i = 1; i < arrivee.getColonne() - depart.getColonne(); i++) 
					if (getCase(depart.getLigne(), depart.getColonne() + i).estOccupee()) 
						return false;
				
				if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
					return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
				return true;
			}
		}
	
	//Mouvement DIAGONAL Haut-Gauche
	if (Math.abs(differenceLigne) == Math.abs(differenceColonne)) {
		if (differenceLigne < 0 && differenceColonne < 0) 
		{
			for (int i = 1; i < Math.abs(differenceColonne); i++) 
				if (getCase(depart.getLigne() - i, depart.getColonne() - i).estOccupee()) 
					return false;
			
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
			return true;
		} 	
		//Mouvement diagonal Bas-Gauche
		else if (differenceLigne > 0 && differenceColonne < 0) 
		{
			for (int i = 1; i < Math.abs(differenceColonne); i++) 
				if (getCase(depart.getLigne() + i, depart.getColonne() - i).estOccupee()) 
					return false;
			
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
			return true;
		}
		//Mouvement diagonal Haut-Droite
		else if (differenceLigne < 0 && differenceColonne > 0) 
		{
			for (int i = 1; i < Math.abs(differenceColonne); i++) 
				if (getCase(depart.getLigne() - i, depart.getColonne() + i).estOccupee()) 
					return false;
			
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
			return true;
		}
		//Mouvement diagonal Bas-Droite
		else if (differenceLigne > 0 && differenceColonne > 0) 
		{
			for (int i = 1; i < Math.abs(differenceColonne); i++) 
				if (getCase(depart.getLigne() + i, depart.getColonne() + i).estOccupee()) 
					return false;
			
			if (getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee()) //if same color or not
				return getCase(arrivee.getLigne(), arrivee.getColonne()).estOccupee(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur());
			return true;
		}
	}
		return false;
}

public String afficher() {
	String s = "";
	for(int i=0; i < 8; i++) {
		for(int j = 0; j < 8; j++) {
			s += getCase(i,j).estOccupee() ? getCase(i,j).getPiece().getNom() + "\t|" : "x\t\t|";
		}
		s += '\n';
	}
	return s;
}
/*public boolean roquePossible (Position depart, Position arrivee ) 
{
}

public boolean priseEnPassantPossible( Position depart, Position arrivee )
{
}
*/
public boolean promotionPossible (Position depart, Position arrivee)
{
	if(getCase(depart.getLigne(), depart.getColonne()).getPiece().getNom().charAt(0) != 'p') //Si ce n'est pas un pion
		return false;
	
	if(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur() == "blanc" ) 
		if(depart.getLigne() == 6)
			if(captureParUnPionPossible(depart, arrivee) || !getCase(7, depart.getColonne()).estOccupee())
				return true;
	
	if(getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur() == "noir") // verifie couleur
		if(depart.getLigne() == 1) // verifie proche de la fin de l'echiquier
			if(captureParUnPionPossible(depart, arrivee) || !getCase(0, depart.getColonne()).estOccupee()) // verifie movement possible
				return true;
	
	return false;
}
/*
	public static void main ( String [] args )
	{
		Echiquier e = new Echiquier ();
		e.debuter();
		System.out.println(e.afficher());
	
		
	}*/
}








