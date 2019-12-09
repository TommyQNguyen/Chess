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

//V�rifier si la prochaine position contient (oui ou non) une pi�ce
public boolean estOccupee()
    {
    if ( piece == null )
      return false;
    else
      return true;
    }
	
//M�thode � compl�ter 	
//V�rifier si la prochaine position contient (oui ou non) une pi�ce de la m�me couleur que la pi�ce � d�placer
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