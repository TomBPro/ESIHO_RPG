package GameData.Ressources.Cheats;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;

import java.util.ArrayList;

public class Engine {

    private Engine(){

    }

    public static void cheats(String saisie){//Le paramètre saisie correspond au message entré dans les cheats
        String mot = new String();
        ArrayList<Character> listeCaracteres = new ArrayList<>();
        String[] listeMots = saisie.trim().split(" ");

//        for (Integer a = 0; a<saisie.length(); a++){
//            listeCaracteres.add(saisie.charAt(a));
//        }//Transformation de la chaîne de caractère en liste
//
//        for (Character element:listeCaracteres) {
//            if (element.toString()!=" "){
//                mot = mot+element;
//            }/*Si il n'y a pas d'espace on ajoute au mot le caractère*/else{
//                listeMots.add(mot);
//                mot = new String();
//            }//S'il y a un espace on ajoute le mot à la liste des mots et on le réinitialise
//        }
        useMots(listeMots);

    }//méthode d'analyse des cheats

    protected static void useMots(String[] listeMots){
        switch (listeMots[0]){
            case "Afficher":
                break;
            case "Ajouter":
                switch (listeMots[1]){
                    case "PNJ":
                        if (listeMots[2]!=null){
                            try{
                                String idPnj = listeMots[2];
                                if (Pnj.isPNJInArray(Integer.parseInt(idPnj.substring(1)))){
                                    if (listeMots[3]!=null){
                                        try{
                                            String idTeam = listeMots[3];
                                            if (Team.isTeamInArray(Integer.parseInt(idTeam.substring(1)))){
                                                if (listeMots.length==4){
                                                    new Ajouter(idPnj, idTeam);
                                                }else{
                                                    try{
                                                        new Ajouter(idPnj, idTeam, Integer.parseInt(listeMots[4]));
                                                    }catch (Exception erreurQuantite){
                                                        System.out.println("La quantité ne doit être constituée que de chiffres décimaux");
                                                    }
                                                }
                                            }
                                        }catch (Exception erreurTeamId){
                                            System.out.println("Erreur dans la saisie. Le quatrième mot de \"Ajouter PNJ\" doit être un Id");
                                        }

                                    }/*S'il y a un id de team donné*/else{
                                        new Ajouter(idPnj);
                                    }//S'il y a pas d'id de team donné
                                }else{
                                    System.out.println("Erreur. Il n'y a pas de PNJ correspondant à cet id");
                                }
                            }catch (Exception erreurPnjId){
                                System.out.println("Erreur dans la saisie. Le troisième mot de \"Ajouter PNJ\" doit être un Id");
                            }
                        }/*S'il y a un id de pnj donné*/else {
                            //new Exception();
                        }//S'il n'y a pas d'id de pnj donné
                        break;
                    case "Objet":
                        if (listeMots[2]!=null){
                            try{
                                String idObjet = listeMots[2];
                                if (Item.isItemInArray(Integer.parseInt(idObjet.substring(1)))){
                                    if (listeMots[3]!=null){
                                        try{
                                            String idTeam = listeMots[3];
                                            if (Team.isTeamInArray(Integer.parseInt(idTeam.substring(1)))){
                                                if (listeMots.length==4){
                                                    new Ajouter(idObjet, idTeam);
                                                }else{
                                                    try{
                                                        new Ajouter(idObjet, idTeam, Integer.parseInt(listeMots[4]));
                                                    }catch (Exception erreurQuantite){
                                                        System.out.println("La quantité ne doit être constituée que de chiffres décimaux");
                                                    }
                                                }
                                            }
                                        }catch (Exception erreurTeamId){
                                            //Erreur dans la saisie. Le quatrième mot de "Ajouter Objet" doit être un Id de Team
                                        }
                                    }/*S'il y a un id de team donné*/else{
                                        new Ajouter(idObjet);
                                    }//S'il n'y a pas d'id de team donné
                                }
                            }catch (Exception erreurObjetId){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter objet" doit être un Id d'objet
                            }
                        }/*S'il y a un id d'objet donné*/else{

                        }//S'il n'y a pas d'id d'objet donné
                        break;
                    case "Argent":
                        if (listeMots[2]!=null){
                            try{
                                Integer argentAjoutee = Integer.parseInt(listeMots[2]);
                                if (listeMots[3]!=null){
                                    try{
                                        String idTeam = listeMots[3];
                                        if (Team.isTeamInArray(Integer.parseInt(idTeam.substring(1)))){
                                            new Ajouter(argentAjoutee, idTeam);
                                        }
                                    }catch (Exception erreurArgentTeamId){
                                        //Erreur dans la saisie. Le quatrième mot de "Ajouter Argent [Quantité]" doit être un Id de Team
                                    }

                                }/*Il y a un id de team fourni*/else{
                                    new Ajouter(argentAjoutee);
                                }//Il n'y a pas d'id de team fourni
                            }catch(Exception erreurArgentInt){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter Argent doit être un entier"
                            }
                        }
                        break;
                }
                break;
            case "Enlever":
                switch (listeMots[1]){
                    case "PNJ":
                        if (listeMots[2]!=null){
                            try{
                                String idPnj = listeMots[2];
                                if (Pnj.isPNJInArray(Integer.parseInt(idPnj.substring(1)))){
                                    if (listeMots[3]!=null){
                                        try{
                                            String idTeam = listeMots[3];
                                            if (Team.isTeamInArray(Integer.parseInt(idTeam.substring(1)))){
                                                if (listeMots.length==4){
                                                    new Enlever(idPnj, idTeam);
                                                }else{
                                                    try{
                                                        new Enlever(idPnj, idTeam, Integer.parseInt(listeMots[4]));
                                                    }catch (Exception erreurQuantite){
                                                        System.out.println("La quantité ne doit être constituée que de chiffres décimaux");
                                                    }
                                                }
                                            }
                                        }catch (Exception erreurTeamId){
                                            System.out.println("Erreur dans la saisie. Le quatrième mot de \"Ajouter PNJ\" doit être un Id");
                                        }

                                    }/*S'il y a un id de team donné*/else{
                                        new Enlever(idPnj);
                                    }//S'il y a pas d'id de team donné
                                }else{
                                    System.out.println("Erreur. Il n'y a pas de PNJ correspondant à cet id");
                                }
                            }catch (Exception erreurPnjId){
                                System.out.println("Erreur dans la saisie. Le troisième mot de \"Ajouter PNJ\" doit être un Id");
                            }
                        }/*S'il y a un id de pnj donné*/else {
                            //new Exception();
                        }//S'il n'y a pas d'id de pnj donné
                        break;
                    case "Objet":
                        if (listeMots[2]!=null){
                            try{
                                String idObjet = listeMots[2];
                                if (Item.isItemInArray(Integer.parseInt(idObjet.substring(1)))){
                                    if (listeMots[3]!=null){
                                        try{
                                            String idTeam = listeMots[3];
                                            if (Team.isTeamInArray(Integer.parseInt(idTeam.substring(1)))){
                                                if (listeMots.length==4){
                                                    new Enlever(idObjet, idTeam);
                                                }else{
                                                    try{
                                                        new Enlever(idObjet, idTeam, Integer.parseInt(listeMots[4]));
                                                    }catch (Exception erreurQuantite){
                                                        System.out.println("La quantité ne doit être constituée que de chiffres décimaux");
                                                    }
                                                }
                                            }
                                        }catch (Exception erreurTeamId){
                                            //Erreur dans la saisie. Le quatrième mot de "Ajouter Objet" doit être un Id de Team
                                        }
                                    }/*S'il y a un id de team donné*/else{
                                        new Enlever(idObjet);
                                    }//S'il n'y a pas d'id de team donné
                                }
                            }catch (Exception erreurObjetId){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter objet" doit être un Id d'objet
                            }
                        }/*S'il y a un id d'objet donné*/else{

                        }//S'il n'y a pas d'id d'objet donné
                        break;
                    case "Argent":
                        if (listeMots[2]!=null){
                            try{
                                Integer argentAjoutee = Integer.parseInt(listeMots[2]);
                                if (listeMots[3]!=null){
                                    try{
                                        String idTeam = listeMots[3];
                                        if (Team.isTeamInArray(Integer.parseInt(idTeam.substring(1)))){
                                            new Enlever(argentAjoutee, idTeam);
                                        }
                                    }catch (Exception erreurArgentTeamId){
                                        //Erreur dans la saisie. Le quatrième mot de "Ajouter Argent [Quantité]" doit être un Id de Team
                                    }

                                }/*Il y a un id de team fourni*/else{
                                    new Enlever(argentAjoutee);
                                }//Il n'y a pas d'id de team fourni
                            }catch(Exception erreurArgentInt){
                                //Erreur dans la saisie. Le troisième mot de "Ajouter Argent doit être un entier"
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
