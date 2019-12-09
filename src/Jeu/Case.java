package Jeu;

public class Case extends Object {

private Piece piece;

  public Case() {}
  
  public Case( Piece piece )
  {
	  this.piece = piece;
  }

public Piece getPiece ()
  {
	return piece;
  }

public void setPiece ( Piece piece )
{
	this.piece = piece;
}

//Vérifier si la prochaine position contient (oui ou non) une pièce
public boolean estOccupee()
    {
    if ( piece == null )
      return false;
    else
      return true;
    }
	
//Méthode à compléter 	
//Vérifier si la prochaine position contient (oui ou non) une pièce de la même couleur que la pièce à déplacer
  public boolean estOccupee(String couleur)
  {
	  if(piece == null) {
		  return false;
	  }
	  
	  if (piece.getCouleur() == couleur)
		  return false;
	  else
		  return true;
  }

  public void ajouterPiece ( Piece piece )
  {
    this.piece = piece;
  }

  public void enleverPiece ()
  {

  if ( piece != null )
    {
    piece = null; 
    }
  }
}