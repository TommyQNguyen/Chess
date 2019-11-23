package Jeu;

/* classe abstraite Piece */

public abstract class Piece {
private String nom;
private String couleur;

/** 
constructeur permettant d'initialiser le nom et la couleur d'un objet Piece
nom  le nom de la piece
couleur la couleur de la pièce
*/
public Piece (String nom, String couleur)
{
setNom(nom);
setCouleur ( couleur );
}

public String getNom ()
  {
  return nom;
  }

public void setNom (String nom)
  {
  this.nom = nom;
  }

public String getCouleur ()
  {
  return couleur;
  }

public void setCouleur ( String couleur )
  {
  if (( couleur == "noir" ) || ( couleur == "blanc" ))
    this.couleur = couleur;
  }
 /* norme mathématique entre cette Position et une autre */
/** 
*méthode permettant de calculer la norme mathématique entre deux Position 
*depart  la position de départ d'une Piece
*arrivee la position d'arrivee d'Une Piece
*la somme des carrés des distances
*
*/
public double norme (Position depart, Position arrivee)
  {
  return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
  }

/* méthode abstraite à implémenter dans chacune des sous - classes */

public abstract boolean estValide (Position depart, Position arrivee);


}
