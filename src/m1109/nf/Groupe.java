/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m1109.nf;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author IUT2
 */
/**
 * 
 * @class Groupe
 * Groupe de contacts
 */
public class Groupe implements java.io.Serializable, Comparable {
    
    /**
     * Attributs :
     * nom : nom du groupe
     * icone : liste de coordonnées d'une forme géométrique
     */
    private String nom;
    private ArrayList<Point> logo;
    private HashSet<Contact> contacts;    
    private HashSet<Symbole> symboles;
    
    /**
     * Contructeur
      */
    public Groupe() {
        /*
         * Initialisation des champs
         */
        this.nom = "Nouveau groupe";
        this.logo = new ArrayList<Point>();
        this.contacts = new HashSet<Contact>();
        this.symboles = new HashSet<Symbole>();        
    }
    
    /**
     * Retourne le nom du groupe
     * @return 
     */
    public String getNom() { return this.nom; }

    /**
     * Affecte le nom du groupe
     * @param nom
     * @return 
     */
    public boolean setNom(String nom) {
        if (nom != null) { 
            this.nom = nom;
            return true;
        }
        
        return false;
    }

    /**
     * Retourne les points définissant le dessin associé au groupe
     * @return tableau d'entiers
     */
    public Point[] getLogo() {
        return logo.toArray(new Point[0]);
    }
     
    /**
     * Affecte l'icône associée au groupe
     * @param points le tableau de points constituant l'icone à associer au groupe
     * @return une valeur booléenne indiquant si l'affectation s'est bien déroulée
     */
    public boolean setLogo(Point[] points) {
        if (points != null) { 
            logo.clear();
            for (Point p1 : points) {
                if (p1 != null) {
                    logo.add(p1);
                }    
            }
            return true ;
        }
        return false ;
    }
    
    /**
     * Retourne la liste des contacts
     * @return tableau contenant les ID de chaque contact
     */
    public HashSet<Contact> getContacts() { 
         return contacts; 
    }    
        
    /**
     * Ajoute un contact dans le groupe
     * @param contact classe identifiant un contact
     * @return vrai si le contact est objet non null et pas encore dans la liste
     */
    public boolean addContact(Contact contact) {
        if (contact != null) {
           if (!contacts.contains(contact)) {
               contacts.add(contact);
               return true ;
           }
        }
        
        return false;        
    }
    
    /**
     * Retire un contact du groupe
     * @param contact classe identifiant un contact
     */
    public void removeContact(Contact contact) {
        if (contact != null) {
           if (contacts.contains(contact)) {
               contacts.remove(contact);
           }
        }
    }

     /**
     * Affecte les contacts
     * @param contacts HashSet de contacts à affecter aux groupes
     */
    public void setContacts(HashSet<Contact> contacts) {
        this.contacts = contacts ;
    }

     /**
     * Supprime tous les contacts
     */
    public void removeContacts() {
        this.contacts = new HashSet<Contact>() ;
    }

   /**
     * Retourne la liste des symboles associés au groupe
     * @return tableau contenant la liste des symboles
     */
    public HashSet<Symbole> getSymboles() { 
        return symboles ; 
    }
    
    /**
     * Ajoute un symbole dans la liste
     * @param symbole un symbole
     */
    public void addSymbole(Symbole symbole) {
         if (symbole != null) {
           if (!symboles.contains(symbole)) {
               symboles.add(symbole);
           }
        }
    }
    
    /**
     * Retire un symbole de la liste
     * @param symbole un symbole
     */
    public void removeSymbole(Symbole symbole) {
        if (symbole != null) {
           if (symboles.contains(symbole)) {
               symboles.remove(symbole);
           }
        }
    }    
    
    /**
     * Retourne une forme textuelle d'un groupe de contacts
     * @return chaîne de caractères contenant le nom du groupe
     */
    @Override
    public String toString() {
        return nom;
    }
    
    /**
     * 
     * @param indentation indentation dans l'affichage
     */
    public void afficherDansConsole(String indentation) {
        System.out.println(indentation + "---------------------------------------------------");
        System.out.println(indentation + "                GROUPE");
        System.out.println(indentation + "---------------------------------------------------");
                
        /* Nom du groupe */
        System.out.println(indentation + "nom du groupe : " + this.getNom());
        
        /* Symboles du groupe */
        System.out.println(indentation + "Symboles du groupe :");
        for(Symbole symbole : this.getSymboles()) {
            System.out.println(indentation + "--> " + symbole);
        }        
        
        /* Liste des des contacts */
        System.out.println(indentation + "Contacts du groupe :");
        for(Contact contact : this.getContacts()) {
            contact.afficherDansConsole(indentation + "\t");
        }

        System.out.println(indentation + "---------------------------------------------------");
    }
    
    /**
     * Compare les noms de ce groupe avec un autre groupe
     * pour pouvoir les trier dans l'ordre alphabétique (inverse !)
     * ATTENTION : renvoie l'ordre inverse de l'ordre alpha
     * @param o
     * @return 
     */
   @Override
    public int compareTo(Object o) {
        Groupe autreGroupe = (Groupe) o ;
        
        return (autreGroupe.toString().compareTo(this.toString()));
    }
}