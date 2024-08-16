package models;

//import java.time.LocalDate;
import java.util.Date;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
//    private LocalDate dateNaissance;
    private String ville;
    private String telephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

//    public LocalDate getDateNaissance() {
//        return dateNaissance;
//    }
//
//    public void setDateNaissance(LocalDate dateNaissance) {
//        this.dateNaissance = dateNaissance;
//    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
