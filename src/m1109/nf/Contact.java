/*
 * Module 2105 : Classe Contact
 * Cette classe représente les contacts d'un carnet d'adresse
 */
package m1109.nf;

import java.util.HashSet;

/**
 *
 * @author IUT2
 */

/**
 * 
 * @class Contact
 * Fiche d'un contact du carnet d'adresse
 */
public class Contact implements java.io.Serializable, Comparable {
    // Attributs définissant un contact
    private String nom; // Nom du contact
    private String prenom; // Prénom du contact
    private int dateJour; // Jour de la date de naissance du contact
    private Mois dateMois; // Mois de la date de naissance du contact
    private int dateAnnee; // Année de la date de naissance du contact
    private String numeroTelephone; // Numéro de téléphone du contact
    private String email; // Email du contact
    private Region region; // Région où habite le contact

    private DispoSortie disponibilite; // Disponibilité préférée du contact
    private HashSet<Hobby> hobbies; // Hobbies du contact
        
    /**
     * Constructeur vide
     */
    public Contact() {
        // On affecte des valeurs par défaut aux attributs
        this.nom = "Nouveau contact";
        this.prenom = "Pr\u00E9nom";
        this.dateJour = 1;
        this.dateMois = Mois.JANVIER;
        this.dateAnnee = 1970;        
        this.numeroTelephone = "";
        this.email = "";
        this.region = Region.ALSACE;        
        this.disponibilite = DispoSortie.SOIR;
        this.hobbies = new HashSet<Hobby>();
    }
    
    /**
     * Constructeur avec paramètres
     * @param nom nom à affecter au contact
     * @param prenom prénom à affecter au contact
     * @param jour jour de naissance à affecter au contact
     * @param mois mois de naissance à affecter au contact
     * @param annee année de naissance à affecter au contact
     * @param telephone n° de téléphone à affecter au contact
     * @param email mél à affecter au contact
     * @param region région d'habitation à affecter au contact
     * @param dispo disponibilité pour les sorties à affecter au contact
     * @param hobbies ensemble de hobbies à affecter au contact
     * 
     */
    public Contact(String nom, String prenom, int jour, Mois mois, int annee, String telephone, String email, Region region, DispoSortie dispo, HashSet<Hobby> hobbies) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateJour = jour;
        this.dateMois = mois;
        this.dateAnnee = annee;        
        this.numeroTelephone = telephone;
        this.email = email;
        this.region = region;        
        this.disponibilite = dispo;
        this.hobbies = hobbies;
    }
    
    /**
     * Retourne le nom du contact
     * @return 
     */
    public String getNom() { 
        return this.nom;
    }

    /**
     * Affecte le nom du contact
     * @param nom chaîne contenant le nom du contact
     * @return retourne vrai si l'affectation a pu se faire (nom non null) et false sinon
     */
    public boolean setNom(String nom) {
        if (nom != null) { 
            this.nom = nom;
            return true;
        }
        return false ;
    }

    /**
     * Retourne le prénom du contact
     * @return 
     */
    public String getPrenom() { 
        return this.prenom;
    }

    /**
     * Affecte le prénom du contact
     * @param prenom prénom du contact
     * @return retourne vrai si l'affectation a pu se faire (prenom non null) et false sinon
     */
    public boolean setPrenom(String prenom) {
        if (prenom != null) { 
            this.prenom = prenom;
            return true ;
        }
        return false ;
    }
    
    /**
     * Retourne le jour de la date de naissance du contact
     * @return int
     */
    public int  getDateNaissanceJour()  { 
        return this.dateJour; 
    }
    /**
     * Retourne le mois de la date de naissance du contact
     * @return Mois
     */
    public Mois getDateNaissanceMois()  { 
        return this.dateMois; 
    }
    /**
     * Retourne l'annee de la date de naissance du contact
     * @return int
     */
    public int  getDateNaissanceAnnee() { 
        return this.dateAnnee; 
    }
    /**
     * Retourne la date de naissance du contact (concaténation des éléments
     * @return String
     */
    public String  getDateNaissance() { 
        return this.dateJour + " " + this.dateMois + " " + this.dateAnnee; 
    }
    
    /**
     * Affecte la date de naissance du contact
     * @param jour : jour de la date de naissance
     * @param mois : mois de la date de naissance (non null)
     * @param annee : année de la date de naissance
     * @return true si les affectations ont pu être faites (mois non null) et false sinon
     */
    public boolean setDateNaissance(int jour, Mois mois, int annee) {        
        if (mois == null) {
            return false ;
        }
        this.dateAnnee = annee;
        this.dateMois = mois;
        this.dateJour = jour;
        return true;
    }
    
    /**
     * Retourne le numéro de téléphone du contact
     * @return String
     */
    public String getNumeroTelephone() { 
       return this.numeroTelephone;
    }

    /**
     * Affecte le numéro de téléphone
     * @param numeroTelephone : une chaîne contenant le numéro de téléphone (non null)
     * @return true si l'affectation a pu être faite, false sinon
     */
    public boolean setNumeroTelephone(String numeroTelephone) {       
        if (numeroTelephone != null) { 
            this.numeroTelephone = numeroTelephone;
            return true ;
        }
        
        return false;
    }

    /**
     * Retourne le mél du contact
     * @return String
     */
    public String getEmail() { 
        return this.email; 
    }

    /**
     * Affecte le mél du contact
     * @param email : chaine non nulle contenant le mél du contact
     * @return true si l'affectation a pu se faire (email non null), false sinon
     */
    public boolean setEmail(String email) {       
        if (email != null) { 
            this.email = email;
            return true ;
        }
        return false;
    }

    /**
     * Retourne la région du contact
     * @return Region
     */
    public Region getRegion() { 
        return this.region; 
    }

    /**
     * Affecte la région du contact
     * @param region : un objet contenant une Region (non null)
     * @return true si l'affectation a pu être faite (region non null) et false sinon
     */
    public boolean setRegion(Region region) {       
        if (region != null) { 
            this.region = region;
            return true ;
        }
        return false ;
    }
    
    /**
     * Retourne la disponibilité pour des sorties
     * @return DispoSortie
     */
    public DispoSortie getDisponibilite() { 
       return this.disponibilite; 
    }

    /**
     * Affecte la disponibilité pour des sorties
     * @param disponibilite : une DispoSortie non null
     * @return true si l'affectation a pu être faite (disponibilite non null) et false sinon
     */
    public boolean setDisponibilite(DispoSortie disponibilite) {       
        if (disponibilite != null) { 
            this.disponibilite = disponibilite;
            return true ;
        }
        return false;
    }

    /**
     * Retourne la liste des hobby
     * @return tableau contenant la liste des hobby
     */
    public HashSet<Hobby> getHobbies() { 
        return this.hobbies; 
    }
    
    /**
     * Ajoute un Hobby dans la liste
     * @param hobby un hobby à ajouter à l'ensemble des hobbies du contact (non null, pas encore dans l'ensemble)
     * @return True si le hobby n'est pas encore dans la liste
     */
    public boolean addHobby(Hobby hobby) {
        if (hobby == null) {
            // hobby ne peut pas être null
            return false;
        }
        if (this.hobbies.contains(hobby)) {
            // hobby déjà présent dans l'ensemble
            return false ;
        }
        
        hobbies.add(hobby);
        return true ;
    }
    
    /**
     * Retire tous les hobbies de la liste
     */
    public void removeAllHobbies() {
        this.hobbies = new HashSet<Hobby>();
    }    
        
    /**
     * Représentation textuelle d'un contact
     * @return chaîne de caractère contenant le nom et prénom du contact
     */
    @Override
    public String toString() {
        return nom + " " + prenom;
    }
    
    public void afficherDansConsole(String indentation) {
        System.out.println(indentation + "---------------------------------------------------");
        System.out.println(indentation + "                CONTACT");
        System.out.println(indentation + "---------------------------------------------------");
        System.out.println(indentation + "nom : " + this.getNom());
        System.out.println(indentation + "prenom : " + this.getPrenom());
        System.out.println(indentation + "region : " + this.getRegion());
        System.out.println(indentation + "email : " + this.getEmail());
        System.out.println(indentation + "telephone : " + this.getNumeroTelephone());
        System.out.println(indentation + "date de naissance : " + this.getDateNaissance()) ;
        System.out.println(indentation + "dispo : " + this.getDisponibilite());
            
        /* Liste des hobbys */
        for(Hobby hobby : this.getHobbies()) {
            System.out.println(indentation + "hobbby : " + hobby);
        }
        System.out.println(indentation + "---------------------------------------------------");
    }
    
    /**
     * Compare les nom+prenom de ce contact avec un autre contact
     * pour pouvoir les trier dans l'ordre alphabétique (inverse !)
     * ATTENTION : renvoie l'ordre inverse de l'ordre alpha
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        Contact autreContact = (Contact) o ;
        
        return (autreContact.toString().compareTo(this.toString()));
    }
}
