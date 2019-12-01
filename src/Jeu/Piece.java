package Jeu;

/* classe abstraite Piece */

public abstract class Piece {
private String nom;
private String couleur;

/** 
constructeur permettant d'initialiser le nom et la couleur d'un objet Piece
nom  le nom de la piece
couleur la couleur de la piece
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
 /* norme mathematique entre cette Position et une autre */
/** 
*methode permettant de calculer la norme mathematique entre deux Position 
*depart  la position de depart d'une Piece
*arrivee la position d'arrivee d'Une Piece
*la somme des carres des distances
*
*/
public double norme (Position depart, Position arrivee)
  {
  return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
  }

/* methode abstraite a implementer dans chacune des sous - classes */

public abstract boolean estValide (Position depart, Position arrivee);


}
