/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1109.nf;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

/**
 *
 * @author Eric
 */
public class Carnet {
    HashSet<Groupe> groupes ;
    HashSet<Contact> contacts ;
    private static final String DB_FILE = "carnet.db";
    private String path = "";
    
    public Carnet() {
        loadDB() ;
    }
    
    /**
     * Chargement des groupes et contact du carnet 
     * à partir du fichier sérialisé
     * Si le fichier n'existe pas ou s'il est illisible
     * les HashSet de groupes et de contacts sont juste
     * initialisés
     */
    private void loadDB() {
        groupes = new HashSet<Groupe>();
        contacts = new HashSet<Contact>();
        
        // creerContactsEtGroupesPourTest();
                
        File file = new File(path + DB_FILE);
        
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;            

            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                
                contacts = (HashSet<Contact>) objectInputStream.readObject();
                groupes = (HashSet<Groupe>) objectInputStream.readObject();
            } catch(IOException e) {
                System.err.println("Erreur dans Carnet.LoadDB() : " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("Erreur dans Carnet.LoadDB() : " + e);
            } finally {
                if (objectInputStream != null) { 
                    try { 
                        objectInputStream.close(); 
                    } catch(IOException e) {
                    }
                }
                
                if (fileInputStream != null) { 
                    try { 
                        fileInputStream.close(); 
                    } catch(IOException e) {
                    }
                }
            }
        }
    }
    
   /**
    * Sauvegarde des groupes et contacts du carnet
    * dans un fichier sérialisé
    */
    public void saveDB() {
        File file;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;            
        
        file = new File(path + DB_FILE);
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            objectOutputStream.writeObject(contacts);
            objectOutputStream.writeObject(groupes);
        } catch (Exception e) {
            System.err.println("Erreur dans Carnet.saveDB : " + e);
        } finally {
                if (objectOutputStream != null) { 
                    try { 
                        objectOutputStream.close(); 
                    } catch(IOException e) {
                    }
                }
                
                if (fileOutputStream != null) { 
                    try { 
                        fileOutputStream.close();
                    } catch(IOException e) {
                    }
                }
            
        }
    }
    
    /**
     * Retourne la liste des contacts
     * @return 
     */
    public HashSet<Contact> getContacts() {
        return contacts;
    }
    
    /**
     * Ajoute un contact
     * @param contact un contact
     */            
    public void addContact(Contact contact) {
        if ((contact != null) && !contacts.contains(contact)) {
            contacts.add(contact);
        }
    }
    
    /**
     * Retire un contact
     * @param contact un contact
     */    
    public void removeContact(Contact contact) {
        if ((contact != null) && contacts.contains(contact)) {
            for(Groupe g : groupes) {
                g.removeContact(contact);
            }
            contacts.remove(contact);
        }
    }

    /**
     * Retourne la liste des groupes
     * @return 
     */
    public HashSet<Groupe> getGroupes() {
        return groupes;
    }
        
    /**
     * Ajoute un groupe
     * @param groupe un groupe de contacts
     */
    public void addGroupe(Groupe groupe) {
        if (groupe != null && !groupes.contains(groupe)) {
            groupes.add(groupe);
        }
    }
    
    /**
     * Retire un groupe
     * @param groupe un groupe de contacts
     */
    public void removeGroupe(Groupe groupe) {
        if (groupe != null && groupes.contains(groupe)) {
            groupes.remove(groupe);
        }
    }

    public HashSet<Contact> getContactsHorsDeGroupe(Groupe groupe) {
        HashSet<Contact> contactsHorsDeGroupe = new HashSet<Contact>();
        
        for (Contact contact : contacts) {
            if (!groupe.getContacts().contains(contact)) {
                contactsHorsDeGroupe.add(contact);
            }
        }
        
        return contactsHorsDeGroupe ;
    }

    private void creerContactsEtGroupesPourTest() {
        // Instanciation d'un contact
        Contact contact1 = new Contact();
        contact1.setNom("Dupont");
        contact1.setPrenom("Amélie");
        contact1.setDateNaissance(5, Mois.JUILLET, 2001);
        contact1.setNumeroTelephone("03.89.76.54.20");
        contact1.setRegion(Region.RHONE_ALPES);
        contact1.setEmail("amelie.dupont@gmail.com");
        contact1.addHobby(Hobby.CINEMA);
        contact1.addHobby(Hobby.LECTURE);
        contact1.setDisponibilite(DispoSortie.WEEK_END);
        contacts.add(contact1);
        
        // Instanciation d'un contact
        Contact contact2 = new Contact();
        contact2.setNom("Bertillon");
        contact2.setPrenom("Pierre");
        contact2.setDateNaissance(8, Mois.AOUT, 1974);
        contact2.setNumeroTelephone("03.87.76.54.20");
        contact2.setRegion(Region.ALSACE);
        contact2.setEmail("pierreb@gmail.com");
        contact2.addHobby(Hobby.SPORT);
        contact2.setDisponibilite(DispoSortie.SOIR);
        contacts.add(contact2);
        
        // Instanciation d'un contact
        Contact contact3 = new Contact();
        contact3.setNom("Bertillon");
        contact3.setPrenom("Sylvie");
        contact3.setDateNaissance(12, Mois.JANVIER, 1955);
        contact3.setNumeroTelephone("03.87.76.54.22");
        contact3.setRegion(Region.PACA);
        contact3.setEmail("bertillons@gmail.com");
        contact3.addHobby(Hobby.LECTURE);
        contact3.setDisponibilite(DispoSortie.WEEK_END);
        contacts.add(contact3);
        
        // Instanciation d'un contact
        Contact contact4 = new Contact();
        contact4.setNom("Rabino");
        contact4.setPrenom("Charles");
        contact4.setDateNaissance(6, Mois.DECEMBRE, 1979);
        contact4.setNumeroTelephone("03.87.74.54.20");
        contact4.setRegion(Region.RHONE_ALPES);
        contact4.setEmail("p.rubino@hotmail.com");
        contact4.addHobby(Hobby.CINEMA);
        contacts.add(contact4);
        
        // Instanciation d'un groupe
        Groupe groupe1 = new Groupe();
        groupe1.setNom("Copains IUT2");
        groupe1.addContact(contact1);
        groupe1.addSymbole(Symbole.FLEUR);
        groupe1.addSymbole(Symbole.ARBRE);
        Point[] points = {  new Point(20,20), 
                            new Point(100,20), 
                            new Point(100,100), 
                            new Point(20,100)};
        groupe1.setLogo(points);
        groupes.add(groupe1);
        
        // Instanciation d'un groupe
        Groupe groupe2 = new Groupe();
        groupe2.setNom("Famille");
        groupe2.addContact(contact1);
        groupe2.addSymbole(Symbole.FLEUR);
        groupe2.addSymbole(Symbole.ARBRE);
        Point[] points2 = { new Point(20,20), 
                            new Point(60,100), 
                            new Point(100,20)};
        groupe2.setLogo(points2);
        groupes.add(groupe2);
    }
}
