package GameData.Ressources.Cheats;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;

import java.util.ArrayList;

public class Engine {
    private InitContenu contenuJeu;

    public Engine(InitContenu contenuJeu){
        this.contenuJeu=contenuJeu;
    }

    public void cheats(String saisie){//Le paramètre saisie correspond au message entré dans les cheats
        String mot = new String();
        ArrayList<Character> listeCaracteres = new ArrayList<>();
        ArrayList<String> listeMots = new ArrayList<>();
        for (Integer a = 0; a<saisie.length(); a++){
            listeCaracteres.add(saisie.charAt(a));
        }//Transformation de la chaîne de caractère en liste

        for (Character element:listeCaracteres) {
            if (element.toString()!=" "){
                mot = mot+element;
            }/*Si il n'y a pas d'espace on ajoute au mot le caractère*/else{
                listeMots.add(mot);
                mot = new String();
            }//S'il y a un espace on ajoute le mot à la liste des mots et on le réinitialise
        }
        useMots(listeMots);

    }//méthode d'analyse des cheats

    private void useMots(ArrayList<String> listeMots){
        switch (listeMots.get(0)){
            case "Afficher":
                break;
            case "Ajouter":
                switch (listeMots.get(1)){
                    case "PNJ":
                        if (listeMots.get(2)!=null){
                            try{
                                String idPnj = listeMots.get(2);
                                for (Pnj pnj:contenuJeu.getListePnjs()){
                                    if (pnj.getId()==idPnj){
                                        if (listeMots.get(3)!=null){
                                            try{
                                                String idTeam = listeMots.get(3);
                                                for (Team team:contenuJeu.getListeTeams()) {
                                                    if (team.getId()==idTeam){
                                                        new Ajouter(contenuJeu, pnj, team);
                                                    }
                                                }
                                            }catch (Exception erreurTeamId){
                                                //Erreur dans la saisie. Le quatrième mot de "Ajouter PNJ" doit être un Id
                                            }

                                        }/*S'il y a un id de team donné*/else{
                                            new Ajouter(contenuJeu, pnj);
                                        }//S'il y a pas d'id de team donné
                                    }
                                }
                            }catch (Exception erreurPnjId){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter PNJ" doit être un Id
                            }
                        }/*S'il y a un id de pnj donné*/else {
                            //new Exception();
                        }//S'il n'y a pas d'id de pnj donné
                        break;
                    case "Objet":
                        if (listeMots.get(2)!=null){
                            try{
                                String idObjet = listeMots.get(2);
                                for (Item objet:contenuJeu.getListeItems()) {
                                    if (objet.getId()==idObjet){
                                        if (listeMots.get(3)!=null){
                                            try{
                                                String idTeam = listeMots.get(3);
                                                for (Team team:contenuJeu.getListeTeams()) {
                                                    if (team.getId()==idTeam){
                                                        new Ajouter(contenuJeu, objet, team);
                                                    }
                                                }
                                            }catch (Exception erreurTeamId){
                                                //Erreur dans la saisie. Le quatrième mot de "Ajouter Objet" doit être un Id de Team
                                            }
                                        }/*S'il y a un id de team donné*/else{
                                            new Ajouter(contenuJeu, objet);
                                        }//S'il n'y a pas d'id de team donné
                                    }
                                }
                            }catch (Exception erreurObjetId){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter objet" doit être un Id d'objet
                            }
                        }/*S'il y a un id d'objet donné*/else{

                        }//S'il n'y a pas d'id d'objet donné
                        break;
                    case "Argent":
                        if (listeMots.get(2)!=null){
                            try{
                                Integer argentAjoutee = Integer.parseInt(listeMots.get(2));
                                if (listeMots.get(3)!=null){
                                    try{
                                        String idTeam = listeMots.get(3);
                                        for (Team team:contenuJeu.getListeTeams()) {
                                            if (team.getId()==idTeam){
                                                new Ajouter(contenuJeu, argentAjoutee, team);
                                            }
                                        }
                                    }catch (Exception erreurArgentTeamId){
                                        //Erreur dans la saisie. Le quatrième mot de "Ajouter Argent [Quantité]" doit être un Id de Team
                                    }

                                }/*Il y a un id de team fourni*/else{
                                    new Ajouter(contenuJeu, argentAjoutee);
                                }//Il n'y a pas d'id de team fourni
                            }catch(Exception erreurArgentInt){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter Argent doit être un entier"
                            }
                        }
                        break;
                }
                break;
            case "Enlever":
                switch (listeMots.get(1)){
                    case "PNJ":
                        if (listeMots.get(2)!=null){
                            try{
                                String idPnj = listeMots.get(2);
                                for (Pnj pnj:contenuJeu.getListePnjs()){
                                    if (pnj.getId()==idPnj){
                                        if (listeMots.get(3)!=null){
                                            try{
                                                String idTeam = listeMots.get(3);
                                                for (Team team:contenuJeu.getListeTeams()) {
                                                    if (team.getId()==idTeam){
                                                        new Enlever(contenuJeu, pnj, team);
                                                    }
                                                }
                                            }catch (Exception erreurTeamId){
                                                //Erreur dans la saisie. Le quatrième mot de "Ajouter PNJ" doit être un Id
                                            }

                                        }/*S'il y a un id de team donné*/else{
                                            new Enlever(contenuJeu, pnj);
                                        }//S'il y a pas d'id de team donné
                                    }
                                }
                            }catch (Exception erreurPnjId){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter PNJ" doit être un Id
                            }
                        }/*S'il y a un id de pnj donné*/else {
                            //new Exception();
                        }//S'il n'y a pas d'id de pnj donné
                        break;
                    case "Objet":
                        if (listeMots.get(2)!=null){
                            try{
                                String idObjet = listeMots.get(2);
                                for (Item objet:contenuJeu.getListeItems()) {
                                    if (objet.getId()==idObjet){
                                        if (listeMots.get(3)!=null){
                                            try{
                                                String idTeam = listeMots.get(3);
                                                for (Team team:contenuJeu.getListeTeams()) {
                                                    if (team.getId()==idTeam){
                                                        new Enlever(contenuJeu, objet, team);
                                                    }
                                                }
                                            }catch (Exception erreurTeamId){
                                                //Erreur dans la saisie. Le quatrième mot de "Ajouter Objet"doit être un Id
                                            }
                                        }/*S'il y a un id de team donné*/else{
                                            new Enlever(contenuJeu, objet);
                                        }//S'il n'y a pas d'id de team donné
                                    }
                                }
                            }catch (Exception erreurObjetId){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter objet" doit être un Id
                            }
                        }/*S'il y a un id d'objet donné*/else{

                        }//S'il n'y a pas d'id d'objet donné
                        break;
                    case "Argent":
                        if (listeMots.get(2)!=null){
                            try{
                                Integer argentRetiree = Integer.parseInt(listeMots.get(2));
                                if (listeMots.get(3)!=null){
                                    try{
                                        String idTeam = listeMots.get(3);
                                        for (Team team:contenuJeu.getListeTeams()) {
                                            if (team.getId()==idTeam){
                                                new Enlever(contenuJeu, argentRetiree, team);
                                            }
                                        }
                                    }catch (Exception erreurArgentTeamId){
                                        //Erreur dans la saisie. Le quatrième mot de "Enlever Argent [Quantité]" doit être un Id de Team
                                    }

                                }/*Il y a un id de team fourni*/else{
                                    new Enlever(contenuJeu, argentRetiree);
                                }//Il n'y a pas d'id de team fourni
                            }catch(Exception erreurArgentInt){
                                //Erreur dans la saisie. Le troisième mot de "Enlever Argent doit être un entier"
                            }
                        }
                        break;
                }
                break;
            case "Teleporter":
                break;
        }//Analyse du premier mot
    }//méthode d'utilisation des cheats
}
