package Jeu;

public class Position 
{

private int ligne ; // de 0 a 7 voir schema
private int colonne; // de 0 a 7


  public Position(int ligne, int colonne)
  {
  this.ligne = ligne;
  this.colonne= colonne;
  }

  public int getLigne ()
  {
  return ligne;
  }

  public int getColonne ()
  {
  return colonne;
  }

  public void setLigne (int ligne)
  {
  this.ligne = ligne;
  }

  public void setColonne ( int colonne )
  {
  this.colonne = colonne;
  }
 
}
