package GameData.Default.Save;

import GameData.Ressources.Contenu.InitContenu;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveEngine implements Serializable {
    private Path chemin;
    private File fichier;

    private SaveEngine(){
        //directory();
        //file();
    }

    public static void newSave(){
        new SaveEngine();
        Sauvegarde save = new Sauvegarde("SV"+InitContenu.compteurSave.toString());
        String nomFichier = "SV_"+save.getId().substring(2)+".ser";

        // Serialization
        try{
            //Saving of object in a file
            FileOutputStream fichier = new FileOutputStream(nomFichier);
            ObjectOutputStream out = new ObjectOutputStream(fichier);

            // Method for serialization of object
            out.writeObject(save);

            out.close();
            fichier.close();

            System.out.println("Sauvegarde réussie");

        }catch(IOException ex){
            System.out.println("IOException !");
        }
    }

    public static Sauvegarde getSave(String id){
        Sauvegarde save;
        // Deserialization
        try{
            // Reading the object from a file
            FileInputStream fichier = new FileInputStream("SV_"+id.substring(2)+".ser");
            ObjectInputStream in = new ObjectInputStream(fichier);

            // Method for deserialization of object
            save = (Sauvegarde)in.readObject();

            in.close();
            fichier.close();

            System.out.println("Récupération sauvegarde réussie !");
            return save;
        }catch(IOException ex){
            System.out.println("IOException !");
        }catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException !");
        }
        return null;
    }

    public static void loadSave(String id){
        Sauvegarde save = SaveEngine.getSave(id);
        if (save!=null){
            InitContenu.listeTeams = save.getListeTeam();
            InitContenu.listeQuetes = save.getListeQuetes();
        }else{
            System.out.println("Il y a dû avoir une erreur dans le chargement de la sauvegarde");
        }
    }
}
