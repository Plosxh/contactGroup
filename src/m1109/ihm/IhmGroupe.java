/*
 * Module 1109 : module IHM : Carnet d'adresse
 */
package m1109.ihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m1109.nf.Contact;
import m1109.nf.Groupe;
import m1109.nf.Symbole;
/**
 *
 * @author IUT2
 */
public class IhmGroupe extends javax.swing.JPanel {
    /*
     * Composants graphiques constituants l'interface
     */
    private IhmLogo logoGroupe;
    private IhmLogo zoneDessin;
    private JTextField nomGroup;
    private HashSet<Contact> contacts; 
    private DefaultTableModel model;
    private JButton effacer;
    private JButton valider;
    private JButton annuler;
    private JLabel labelGroup;
    private HashMap<String, JCheckBox>  champSymboles;
    
    
    /**
     * Creates new form CarnetUI
     */
    public IhmGroupe() { 
        super();
        champSymboles = new HashMap<String, JCheckBox>();
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
                
        logoGroupe = new IhmLogo();
        this.add(logoGroupe);  
        
        //===========================
        // GESTION NOM GROUPE
        //===========================
        labelGroup = new JLabel("Nom du Groupe : ");
        this.add(labelGroup);

        nomGroup = new JTextField(30);
        this.add(nomGroup);
        
        
        //===========================
        // GESTION TABLE CONTACT
        //===========================
        JLabel labelTable = new JLabel("Contacts du Groupe : ");
        this.add(labelTable);
      
        String[] colonnes ={"Nom", "Prenom", "Numero de telephone", "Email"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colonnes);

        JTable table = new JTable(model);
        this.add(table.getTableHeader());
        this.add(table);
        
        //===========================
        // GESTION CANVAS
        //===========================    
        
        zoneDessin = new IhmLogo();
        this.add(zoneDessin);
        //===========================
        // GESTION BOUTON
        //===========================        
        
        effacer = new JButton("Effacer zone dessin");
        this.add(effacer);
        
        valider = new JButton("Valider");
        this.add(valider);
        
        annuler = new JButton("Annuler");
        this.add(annuler);
        
        
        //===========================
        // GESTION LISTE SYMBOLE
        //=========================== 
        for(Symbole s : Symbole.values())
        {
             //Integer i =champSymboles.size();  
             JCheckBox check= new JCheckBox(s.toString());
             champSymboles.put(s.toString(),check);
            this.add(check);
            
        }
        
        
        
        // A Compléter en TP2
    }
    
    /**
     * Affecte les valeurs des attributs d'un groupe aux widgets de l'IHM
     * @param groupe groupe de contacts
     */    
    public void displayGroupe(Groupe groupe) {
        if (groupe != null) 
        {    
            nomGroup.setText(groupe.getNom());
            logoGroupe.setLogo(groupe.getLogo());
            
            

             for(Contact c : groupe.getContacts())
                {  
                 String[] valeurs={c.getNom(),c.getPrenom(),c.getNumeroTelephone(),c.getEmail()};  
                 //model.addRow(new String[]{c.getNom(),c.getPrenom(),c.getNumeroTelephone(),c.getEmail()});   
                 model.addRow(valeurs);

                }
           if(!champSymboles.isEmpty())
            {
             for(Symbole s : groupe.getSymboles())
                {
                    champSymboles.get(s.toString()).setSelected(true);

                }
            }
             
        }
    }
    
    /**
     * Retourne les valeurs associées au formulaire de fiche groupe de contacts
     * @param groupe
    */    
    public void majGroupeDepuisIhm(Groupe groupe) {
        if (groupe != null) { 
         
            for(Symbole s : Symbole.values())
                {
                   if(champSymboles.get(s.toString()).isSelected())
                     {groupe.addSymbole(s);
                     }

                     else
                     {
                         groupe.removeSymbole(s);
                     }
                }
            
            
            
        }
    }
       
}
