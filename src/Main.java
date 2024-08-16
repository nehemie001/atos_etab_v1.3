import models.Eleve;
import models.Professeur;
import models.Utilisateur;
import services.IEleveService;
import services.IUtilisateurService;
import services.impl.EleveServiceImpl;
import services.impl.UtilisateurServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws SQLException {

        IEleveService eleveService = new EleveServiceImpl();
        // Affichage de bienvenue
        System.out.println("                             ******************************************************");
        System.out.println("                                     BIENVENU DANS L’APPLICATION ETAB v1.2");
        System.out.println("                             ******************************************************");
        System.out.println("                                                   CONNEXION");

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.ajouterUtilisateurDefaut();

        // Initialisation des variables
        Scanner scanner = new Scanner(System.in);
        boolean authenticated = false;
        LocalDateTime startTime = LocalDateTime.now();

        // Boucle d'authentification
        while (!authenticated) {
            System.out.print("Entrez votre identifiant: ");
            String inputIdentifiant = scanner.nextLine();

            System.out.print("Entrez votre mot de passe: ");
            String inputMotDePasse = scanner.nextLine();

            IUtilisateurService utilisateurService = new UtilisateurServiceImpl();
            authenticated = utilisateurService.authentification(inputIdentifiant, inputMotDePasse);

            if (authenticated) {
                System.out.println("                                 ******************************************************");
                System.out.println("                                 ******************************************************");
                System.out.println("                                          BIENVENU DANS L’APPLICATION ETAB v1.2");
                System.out.println("                                 ******************************************************");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                System.out.println("Date et heure actuelles : " + startTime.format(formatter));
                System.out.println("******************************************************");

                boolean running = true;
                ArrayList<Eleve> listeEleves = new ArrayList<>();
                ArrayList<Professeur> listeProfesseurs = new ArrayList<>();

                while (running) {
                    // Affichage du menu principal
                    System.out.println("MENU:");
                    System.out.println("1: Gestion des élèves");
                    System.out.println("2: Gestion des professeurs");
                    System.out.println("3: Gestion des utilisateurs");
                    System.out.println("0: Quitter");
                    System.out.println("******************************************************");

                    System.out.print("Choisissez une option: ");
                    int choixMenu = scanner.nextInt();
                    scanner.nextLine(); // Pour consommer la ligne restante après nextInt()

                    switch (choixMenu) {
                        case 1:
                            boolean gestionEleves = true;
                            while (gestionEleves) {
                                // Menu de gestion des élèves
                                System.out.println("******************************************************");
                                System.out.println("GESTION DES ELEVES");
                                System.out.println("******************************************************");
                                System.out.println("Menu :");
                                System.out.println("1: Ajouter un élève");
                                System.out.println("2: Supprimer un élève");
                                System.out.println("3: Modifier les informations de l'élève");
                                System.out.println("4: Lister les élèves");
                                System.out.println("5: Obtenir le dernier élève ajouté");
                                System.out.println("6: Retour");
                                System.out.println("0: Accueil");
                                System.out.println("******************************************************");

                                System.out.print("Choisissez une option : ");
                                int choixEleve = scanner.nextInt();
                                scanner.nextLine();

                                switch (choixEleve) {
                                    case 1:
                                        Eleve eleve = new Eleve();

                                        System.out.print("Entrez le nom de l'élève : ");
                                        eleve.setNom(scanner.nextLine());

                                        System.out.print("Entrez le prénom de l'élève : ");
                                        eleve.setPrenom(scanner.nextLine());

                                        System.out.print("Entrez la ville de l'élève : ");
                                        eleve.setVille(scanner.nextLine());

                                        System.out.print("Entrez la classe de l'élève : ");
                                        eleve.setClasse(scanner.nextLine());

                                        System.out.print("Entrez le matricule de l'élève : ");
                                        eleve.setMatricule(scanner.nextLine());

//                                        System.out.print("Entrez la date de naissance de l'élève (dd/MM/yyyy) : ");
//                                        eleve.setDateNaissance(LocalDate.parse(scanner.nextLine()));
//                                        String dateNaissance = null;
//                                        try {
//                                            dateNaissance = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissanceStr));
//                                        } catch (ParseException e) {
//                                            System.out.println("Format de date invalide. Élève non ajouté.");
//                                            break;
//                                        }
                                        System.out.print("Entrez le telephone de l'élève : ");
                                        eleve.setTelephone(scanner.nextLine());

                                        eleveService.save(eleve);

//                                        listeEleves.add(eleve);

                                        System.out.println("Élève ajouté avec succès !");
                                        break;
                                    case 2:
                                        // Supprimer un élève
                                        System.out.print("Entrez l'ID de l'élève à supprimer : ");
                                        int idASupprimer = scanner.nextInt();
                                        scanner.nextLine();

                                        Eleve eleveASupprimer = null;
                                        for (Eleve e : listeEleves) {
                                            if (e.getId() == idASupprimer) {
                                                eleveASupprimer = e;
                                                break;
                                            }
                                        }

                                        if (eleveASupprimer != null) {
                                            listeEleves.remove(eleveASupprimer);
                                            System.out.println("Élève supprimé avec succès !");
                                        } else {
                                            System.out.println("Élève introuvable.");
                                        }
                                        break;
                                    case 3:
                                        // Modifier les informations d'un élève
                                        System.out.print("Entrez l'ID de l'élève à modifier : ");
                                        int idAModifier = scanner.nextInt();
                                        scanner.nextLine();

                                        Eleve eleveAModifier = null;
                                        for (Eleve e : listeEleves) {
                                            if (e.getId() == idAModifier) {
                                                eleveAModifier = e;
                                                break;
                                            }
                                        }

                                        if (eleveAModifier != null) {
                                            System.out.print("Entrez le nouveau nom : ");
                                            eleveAModifier.setNom(scanner.nextLine());

                                            System.out.print("Entrez le nouveau prénom : ");
                                            eleveAModifier.setPrenom(scanner.nextLine());

                                            System.out.print("Entrez la nouvelle ville : ");
                                            eleveAModifier.setVille(scanner.nextLine());

                                            System.out.print("Entrez la nouvelle classe : ");
                                            eleveAModifier.setClasse(scanner.nextLine());

                                            System.out.print("Entrez le nouveau matricule : ");
                                            eleveAModifier.setMatricule(scanner.nextLine());

                                            //eleveAModifier.modifier(eleveAModifier);
                                            System.out.println("Informations de l'élève mises à jour avec succès !");
                                        } else {
                                            System.out.println("Élève introuvable.");
                                        }
                                        break;
                                    case 4:
                                        // List the students
                                        System.out.println("Liste des élèves :");
                                        for (Eleve e : listeEleves) {
                                            System.out.println(e);
                                        }
                                        break;
                                    case 5:
                                        // Get the last student added
                                        if (!listeEleves.isEmpty()) {
                                            System.out.println("Dernier élève ajouté : " + listeEleves.get(listeEleves.size() - 1));
                                        } else {
                                            System.out.println("Aucun élève n'a été ajouté.");
                                        }
                                        break;
                                    case 6:
                                        // Retour au menu principal
                                        gestionEleves = false;
                                        break;
                                    case 0:
                                        // Retour à l'accueil
                                        running = false;
                                        gestionEleves = false;
                                        break;
                                    default:
                                        System.out.println("Option invalide, veuillez réessayer.");
                                }
                            }
                            break;
                        case 2:
                            // Gestion des professeurs
                            System.out.println("PROFESSEUR");

                            break;
                        case 3:
                            // Gestion des utilisateurs (à implémenter)
                            System.out.println("Gestion des utilisateurs - Fonctionnalité à implémenter");
                            break;
                        case 0:
                            // Quitter l'application
                            running = false;
                            System.out.println("Déconnexion réussie. Merci d'avoir utilisé l'application ETAB v1.2.");
                            break;
                        default:
                            System.out.println("Option invalide, veuillez réessayer.");
                    }
                }
            } else {
                System.out.println("Identifiant ou mot de passe incorrect. Veuillez réessayer.");
            }
        }
    }
}
