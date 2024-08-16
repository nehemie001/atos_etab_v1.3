package models;

import java.text.SimpleDateFormat;

/**
 * Classe représentant un professeur.
 * Elle hérite de la classe models.Personne et implémente les interfaces IEducation et dao.ICRUDProfesseur.
 */
public class Professeur extends Personne {
    private Boolean vacant;
    private String matiereEnseigne;
    private String prochainCours;
    private String sujetProchaineReunion;

    public Professeur(Boolean vacant, String matiereEnseigne, String prochainCours, String sujetProchaineReunion) {
        this.vacant = vacant;
        this.matiereEnseigne = matiereEnseigne;
        this.prochainCours = prochainCours;
        this.sujetProchaineReunion = sujetProchaineReunion;
    }

    public Boolean getVacant() {
        return vacant;
    }

    public void setVacant(Boolean vacant) {
        this.vacant = vacant;
    }

    public String getMatiereEnseigne() {
        return matiereEnseigne;
    }

    public void setMatiereEnseigne(String matiereEnseigne) {
        this.matiereEnseigne = matiereEnseigne;
    }

    public String getProchainCours() {
        return prochainCours;
    }

    public void setProchainCours(String prochainCours) {
        this.prochainCours = prochainCours;
    }

    public String getSujetProchaineReunion() {
        return sujetProchaineReunion;
    }

    public void setSujetProchaineReunion(String sujetProchaineReunion) {
        this.sujetProchaineReunion = sujetProchaineReunion;
    }

    public void ajouter(Professeur professeur){

    }

    public void mettreAjour(Professeur professeur){

    }

    @Override
    public String toString() {
        return "Professeur{" +
                "vacant=" + vacant +
                ", matiereEnseigne='" + matiereEnseigne + '\'' +
                ", prochainCours='" + prochainCours + '\'' +
                ", sujetProchaineReunion='" + sujetProchaineReunion + '\'' +
                '}';
    }
}
