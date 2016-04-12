/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m1109.nf;

/**
 *
 * @author IUT2
 */
public enum Symbole {
    FLEUR("Fleur"),
    ANIMAL("Animal"),
    MONTAGNE("Montagne"),
    ARBRE("Arbre"),
    TABLEAU("Tableau"),
    TEMPLE("Temple"),
    VOITURE("Voiture"),
    ETOILE("Etoile");
    
    private final String label;
    
    private Symbole(String label) { 
        this.label = label; 
    }
    
    @Override
    public String toString() { return this.label; }    
}
