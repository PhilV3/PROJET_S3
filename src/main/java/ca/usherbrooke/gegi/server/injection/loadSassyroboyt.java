package ca.usherbrooke.gegi.server.injection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;


public class loadSassyroboyt {

    /**
     * Fonction de motivation lol
     * @param sass Le numéro du fichier duquel ta phrase de motivation va venir
     * @return Retourne une phrase motivationelle
     */
    public String sendSass(int sass){
        BufferedReader bf = null;
        try {
        switch (sass){
            case 1:
                    bf = new BufferedReader(new FileReader("sassyHobo.txt"),'r');
                break;
            case 2:
                bf = new BufferedReader(new FileReader("sassyMendiant.txt"),'r');
                break;
            case 3:
                bf = new BufferedReader(new FileReader("sassyPlebeien.txt"),'r');
                break;
            case 4:
                bf = new BufferedReader(new FileReader("sassyGood.txt"),'r');
                break;
            case 5:
                bf = new BufferedReader(new FileReader("sassyPedant.txt"),'r');
                break;
            default:
                return "bitchAssBoi";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
        try {
            String l = bf.readLine();
            ArrayList<String> tot = new ArrayList<String>();
            tot.add(l);
            while ((l = bf.readLine()) != null){
                tot.add(l);
            }
            Random rng = new Random();
            return tot.get(rng.nextInt(tot.size()));
        }catch (Exception e ){}
        return "bitch ass bitch";
    }
}
