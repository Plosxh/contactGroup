/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m1109.main;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import m1109.ihm.IhmContact;
import m1109.ihm.IhmGroupe;
import m1109.nf.Contact;
import m1109.nf.DispoSortie;
import m1109.nf.Groupe;
import m1109.nf.Hobby;
import m1109.nf.Mois;
import m1109.nf.Region;
import m1109.nf.Symbole;

/**
 *
 * @author IUT2
 */

public class Main {

    private static Contact contact;             // Un contact que l'on va afficher / modifier
    public static IhmContact ihmContact;        // L'IHM permettant d'afficher un contact
    public static JFrame window1;               // Une fenêtre dans laquelle on va afficher l'IHM du contact
    public static JFrame window2;               // Une fenêtre dans laquelle on va afficher l'IHM du groupe
    private static Groupe groupe;
    public static IhmGroupe ihmGroupe;          // L'IHM permettant d'afficher un groupe de contacts
        
    public static void main(String[] args) {        
        // Instanciation d'un contact
        contact = new Contact();

        // Instanciation d'un contact
        contact = new Contact();
        contact.setNom("Dupont");
        contact.setPrenom("Amélie");
        contact.setDateNaissance(5, Mois.JUILLET, 2001);
        contact.setNumeroTelephone("03.89.76.54.20");
        contact.setRegion(Region.RHONE_ALPES);
        contact.setEmail("amelie.dupont@gmail.com");
        contact.addHobby(Hobby.CINEMA);
        contact.addHobby(Hobby.LECTURE);
        contact.setDisponibilite(DispoSortie.WEEK_END);
        
        // Affiche l'IHM d'un contact
        afficherIhmContact();
        
        // Instanciation d'un groupe
        groupe = new Groupe();
        groupe.setNom("Copains IUT2");
        groupe.addContact(contact);
        groupe.addSymbole(Symbole.FLEUR);
        groupe.addSymbole(Symbole.ARBRE);
        Point[] points = {  new Point(20,20), 
                            new Point(100,20), 
                            new Point(100,100), 
                            new Point(20,100)};
        groupe.setLogo(points);
        
        afficherIhmGroupe();
    }
    
    public static void afficherIhmContact() {
        // Instanciation de la fenêtre 
        window1 = new JFrame("Test IHM Contact");
        // Indique de sortir du programme lorsque la fenêtre est fermée par l'utilisateur
        window1.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window1.setSize(900, 800);
        

        // Instanciation de l'IHM d'un contact
        ihmContact = new IhmContact();
        // Affectation des attributs du contact aux champs de l'IHM
        ihmContact.displayContact(contact);


        // Ajout de l'IHM dans la fenêtre
        window1.getContentPane().setLayout(new BorderLayout());
        window1.add(ihmContact, BorderLayout.CENTER);
        
        // Ajout d'un bouton dans la fenêtre (pour tester la méthode getValues de IhmContact)
        JButton testGet = new JButton("Tester IhmContact.modifyContact()");
        window1.add(testGet, BorderLayout.SOUTH);
        
        // Gestion des événements (ici le clic) du bouton
        testGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                
                ihmContact.modifyContact(contact);
                
                // Affiche le contact sur la console
                contact.afficherDansConsole("");
                
                // Affiche le contact dans un popup
                
                // Nom du contact
                message  = "nom : " + contact.getNom() + "\n";
                // Prénom du contact
                message += "prenom : " + contact.getPrenom() + "\n";
                // Région du contact
                message += "region : " + contact.getRegion() + "\n";
                // Email du contact
                message += "email : " + contact.getEmail() + "\n";
                // Téléphone du contact
                message += "telephone : " + contact.getNumeroTelephone() + "\n";
                // Date de naissance du contact
                message += "date de naissance : " + contact.getDateNaissance() + "\n";
                // Disponibilité préférée du contact
                message += "dispo : " + contact.getDisponibilite() + "\n";

                // Liste des hobbys du contact
                for(Hobby hobby : contact.getHobbies()) {
                    // Remarque :   Java va appeler automatiquement 
                    //              hobby.toString() qui est redéfini dans Hobby 
                    //              pour renvoyer le libellé du hobby
                    message += "hobbby : " + hobby + "\n"; 
                }

                // Affichage de message dans un popup
                JOptionPane.showMessageDialog(
                        window1,
                        message, 
                        "Résultat du test", 
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        window1.setVisible(true);        
    }   
    
    public static void afficherIhmGroupe() {
        // Instanciation de la fenêtre 
        window2 = new JFrame("Test IHM Groupe");
        // Indique de sortir du programme lorsque la fenêtre est fermée par l'utilisateur
        window2.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window2.setSize(900, 800);
        window2.setLocation(100, 100);
        

        // Instanciation de l'IHM d'un groupe
        ihmGroupe = new IhmGroupe();
        // Affectation des attributs du contact aux champs de l'IHM
        ihmGroupe.displayGroupe(groupe);


        // Ajout de l'IHM dans la fenêtre
        window2.getContentPane().setLayout(new BorderLayout());
        window2.add(ihmGroupe, BorderLayout.CENTER);
        
        // Ajout d'un bouton dans la fenêtre (pour tester la méthode majGroupeDepuisIhm de IhmGroupe)
        JButton testGet = new JButton("Tester IhmGroupe.majGroupeDepuisIhm()");
        window2.add(testGet, BorderLayout.SOUTH);
        
        // Gestion des événements (ici le clic) du bouton
        testGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                
                ihmGroupe.majGroupeDepuisIhm(groupe);
                
                // Affiche le contact sur la console
                groupe.afficherDansConsole("");
            }
        });
        
        window2.setVisible(true);        
    }    
}
