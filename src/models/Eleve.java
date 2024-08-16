package models;

/**
 * Classe représentant un élève.
 * Elle hérite de la classe models.Personne et implémente l'interface dao.ICRUDEleve.
 */
public class Eleve extends Personne {
    private String classe;
    private String matricule;

    public Eleve() {
    }

    public Eleve(String classe, String matricule) {
        this.classe = classe;
        this.matricule = matricule;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "classe='" + classe + '\'' +
                ", matricule='" + matricule + '\'' +
                '}';
    }
}
