package models;

import java.util.Date;

public class Personne {
    private int id;
    private String dateNaissance;
    private String ville;
    private String nom;
    private String prenom;
    private String telephone;

    public Personne(int id, String dateNaissance, String ville, String nom, String prenom) {
    }

    public Personne(int id, String dateNaissance, String ville, String nom, String prenom, String telephone) {
        this.id = id;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void supprimer(int id){

    }

    public void lister(){

    }

    public int obternirAge(Date age){

        return 0;
    }
}
