/*
 * Module 1109 : module IHM : Carnet d'adresse
 */
package m1109.ihm;


import m1109.nf.Contact;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.util.HashMap;
import java.util.HashSet;
import m1109.nf.Hobby;
import m1109.nf.DispoSortie;
import m1109.nf.Region;
import m1109.nf.Mois;
/**
 * @author IUT2
 */
public class IhmContact extends JPanel {

    private JTextField       champNom; // Widget de type champ texte pour afficher et saisir le nom du contact
    private JTextField       champPrenom;
    private HashMap<String, JRadioButton> champDisponibilite;
    private JTextField      champRegionDisplay;
    private JComboBox       champRegion;
    private JComboBox       champJour;
    private JComboBox       champMois;
    private JComboBox       champAns;
    private JTextField       champTel;
    private JTextField       champNaissance;
    private JCheckBox       champHobby;
    private JTextField       champEmail;  
    private ButtonGroup     champDispo;
    private HashMap<String, JCheckBox>       champHobbies;

    /*
     * Formulaire pour saisir les informations relatives à un contact
     */
    public IhmContact() {
        super();
        champDisponibilite = new HashMap<String, JRadioButton>();
        champHobbies = new HashMap<String, JCheckBox>();
        initUIComponents();
    }
    
    /**
     * Crée et positionne les composants graphiques constituant l'interface
     */
    private void initUIComponents() {      
        /** Pour l'exemple **/
        
        // Ajoute dans l'IHM un libellé + un champ pour la saisie/Affichage du nom
        this.add(new JLabel("Nom :"));
        champNom = new JTextField(30);
        this.add(champNom);
        this.add(new JLabel("Prenom :"));
        champPrenom = new JTextField(30);
        this.add(champPrenom);

        this.add(new JLabel("Telephone :"));
        champTel = new JTextField(30);
        this.add(champTel);
        this.add(new JLabel("Email :"));
        champEmail = new JTextField(30);
        this.add(champEmail);
        this.add(new JLabel("Date Naissance:"));
        champNaissance = new JTextField(30);
        this.add(champNaissance);

        
          JLabel labelDispo= new JLabel("Disponibilite");
          this.add(labelDispo);
             champDispo=new ButtonGroup();
     
        for(DispoSortie dis : DispoSortie.values())
        {
            Integer i =champDisponibilite.size();
            JRadioButton radbut = new JRadioButton(dis.toString());
            champDispo.add(radbut);
            champDisponibilite.put(dis.toString(),radbut);
            this.add(radbut);
        }
        
        JLabel labelRegion = new JLabel("Region : ");
        this.add(labelRegion);
        
        Region[] region= Region.values();
        champRegion = new JComboBox(region);
        this.add(champRegion);
        
        JLabel labelJour = new JLabel("Jour : ");
        this.add(labelJour);
        
        Integer[] jour= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        champJour = new JComboBox(jour);
        this.add(champJour);
        
        JLabel labelMois = new JLabel("Mois : ");
        this.add(labelMois);
        
        Mois[] mois= Mois.values();
        champMois = new JComboBox(mois);
        this.add(champMois);
        
        
        JLabel labelAnnee = new JLabel("Annee : ");
        this.add(labelAnnee);
        
        Integer[] annee= {0};
        champAns = new JComboBox(annee);
        
        for(Integer i=1900; i<=2016;i++)
        {
            
            champAns.addItem(i); 
        }
        this.add(champAns);
        
        
        
        
        
        for(Hobby h : Hobby.values())
        {
             Integer i =champHobbies.size();  
             JCheckBox check= new JCheckBox(h.toString());
             champHobbies.put(h.toString(),check);
            this.add(check);
            
        }
        
        


        
        /** TP 1 : à compléter **/
    }
    
    /**
     * Affecte des valeurs au formulaire de fiche contact
     * @param contact un contact pour mettre à jour à l'IHM
     * @return vrai si ok
     */
    public boolean displayContact(Contact contact) 
    {
        if (contact == null) { return false; }
                
        // Nom du contact
        champNom.setText(contact.getNom());
        champPrenom.setText(contact.getPrenom()); 
        /*String region = (String)champRegion.getSelectedItem().toString();
        champRegionDisplay = new JTextField();
        champRegionDisplay.setText(region);*/
        champTel.setText(contact.getNumeroTelephone());
        champNaissance.setText(contact.getDateNaissance());
        for(DispoSortie dis : DispoSortie.values())
        {
            if (contact.getDisponibilite()==dis)
            {
                champDisponibilite.get(dis.toString()).setSelected(true);
            
            }
            
        }
        
        champEmail.setText(contact.getEmail());
        
        
        if(!champHobbies.isEmpty())
        {
         for(Hobby h : contact.getHobbies())
        {
            champHobbies.get(h.toString()).setSelected(true);
          
        }
        }
        
        
        /** TP 1 : à compléter **/
        
        return true;
    }
    
    /**
     * Relit les 
     * @param contact un contact à mettre à jour à partir de l'IHM
     * @return vrai si ok
     */
    public Boolean modifyContact(Contact contact) {
        if (contact == null) { return false; }

        // Affecte la valeur du champ nom à l'attribut nom du contact
        contact.setNom(champNom.getText());
        contact.setPrenom(champPrenom.getText()); 
        contact.setNumeroTelephone(champTel.getText()); 
        //contact.setDateNaissance(champNaissance.getText());
        
        //===================================
        //GESTION DISPONIBILITE
        //===================================
        for(DispoSortie dis : DispoSortie.values())
        {
            if (champDispo.toString()==dis.toString())
            {
                contact.setDisponibilite(dis);
            
            }
            
        }
       
        
        
        //===================================
        //GESTION EMAIL
        //===================================
        
        contact.setEmail(champEmail.getText());
        
        
        //===================================
        //GESTION HOBBIES
        //===================================        
        for(Hobby h : Hobby.values())
        {
             if(champHobbies.get(h.toString()).isSelected())
             {contact.addHobby(h);
             }
             
             else
             {
                 contact.removeAllHobbies();
             }
        }
        
        
        //===================================
        //GESTION REGIONS
        //===================================
        
        contact.setRegion((Region) champRegion.getSelectedItem());
        contact.setDateNaissance(champJour.getSelectedIndex()+1, (Mois) champMois.getSelectedItem(),(Integer) champAns.getSelectedItem()); 
        
        // TODO : TP1 - renseigner les autres attributs du contact à partir des champs de l'IHM

        return true;
    }
    
    
    
}