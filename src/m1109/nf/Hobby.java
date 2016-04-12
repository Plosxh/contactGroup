/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m1109.nf;

/**
 *
 * @author IUT2
 */
public enum Hobby implements java.io.Serializable {
    // Instancie les valeurs possibles pour l'énumération Hobby
    CINEMA("Cin\u00E9ma"),
    LECTURE("Lecture"),
    MUSIQUE("Musique"),
    SPORT("Sport");
    
    // Attributs d'un hobby : il a un libellé
    private final String label;

    /**
     * Constructure de Hobby
     * @param label : le libellé du hobby à instancier
     */
    private Hobby(String label) { 
        this.label = label; 
    }
    
    /**
     * Récupération du libellé d'un hobby
     * @return String
     */
    @Override
    public String toString() { 
        return this.label; 
    }     
}