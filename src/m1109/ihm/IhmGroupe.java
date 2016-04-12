/*
 * Module 1109 : module IHM : Carnet d'adresse
 */
package m1109.ihm;

import m1109.nf.Groupe;
/**
 *
 * @author IUT2
 */
public class IhmGroupe extends javax.swing.JPanel {
    /*
     * Composants graphiques constituants l'interface
     */
    private IhmLogo ihmLogo;
    
    
    /**
     * Creates new form CarnetUI
     */
    public IhmGroupe() { 
        super();
        
        initUIComponents();    
    }

    /**
     * Crée et positionne les composants graphiques constituant l'interface
     * avec : 
     *  - en haut : les informations du groupe (nom, icone, symbole,...)
     *  - au centre : la liste des membres du groupe
     *  - en bas : les boutons d'action sur le groupe
     */
    private void initUIComponents() {      
        
        this.add(new javax.swing.JLabel("Fiche groupe à compléter"));
                
        ihmLogo = new IhmLogo();
        this.add(ihmLogo);  
        
        // A Compléter en TP2
    }
    
    /**
     * Affecte les valeurs des attributs d'un groupe aux widgets de l'IHM
     * @param groupe groupe de contacts
     */    
    public void displayGroupe(Groupe groupe) {
        if (groupe != null) { 
            // A Compléter en TP2
        }
    }
    
    /**
     * Retourne les valeurs associées au formulaire de fiche groupe de contacts
     * @param groupe
    */    
    public void majGroupeDepuisIhm(Groupe groupe) {
        if (groupe != null) { 
            // A compléter en TP2
        }
    }
       
}
