/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dto.Club;
import dto.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class PlayerList extends ArrayList<Player>{
    private final String pathFile = "players.txt";
    private final String HEADER_TABLE = String.format("|---------------------------------------------------------------------|\n"
                                                    + "| %-9s | %-6s | %-15s | %-12s | %-12s |%n"
                                                    + "|---------------------------------------------------------------------|", "Player ID", "Club ID", "Player Name", "Position", "Shirt Number");
    private final String FOOTER_TABLE = "|---------------------------------------------------------------------|";
    
    public boolean removePlayer(String id){
        Player deletedPlayer = searchById(id);
        if(deletedPlayer == null){
            return false;
        }
        this.remove(deletedPlayer);
        return true;
    }
    
    public int addPlayer(Player p){
        if(searchById(p.getPlayerId()) != null){
            return 1;
        }
        if(isExistedShirtNumber(p.getShirtNumber(), p.getClubId())){
            return 2;
        }
        this.add(p);
        return 3;
    }
    
    public ArrayList<Player> searchByName(String name){
        ArrayList<Player> players = new ArrayList<>();
        for(Player p : this){
            if(p.getPlayerName().toLowerCase().contains(name.toLowerCase())){
                players.add(p);
            }
        }
        return players;
    }
    
    public Player searchById(String id){
        for(Player p : this){
            if(p.getPlayerId().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }
    
    public boolean isExistedShirtNumber(int shirtNumber, String clubId){
        for(Player p : this){
            if(p.getClubId().equalsIgnoreCase(clubId)){
                if(p.getShirtNumber() == shirtNumber){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public String getClubName(Player p, ClubList clublist){
        for(Club c : clublist){
            if(c.getClubId().equalsIgnoreCase(p.getClubId())){
                return c.getClubName();
            }
        }
        return "";
    }
    
    public ArrayList<Player> sortPlayerByClubAndNumber(ClubList clubs){
        ArrayList<Player> players = new ArrayList<>(this);
        
        Collections.sort(players, Comparator.comparing((Player p) -> getClubName(p, clubs)).thenComparingInt(Player::getShirtNumber));
        
        return players;
    }
    
    public void showAll(List<Player> p){
        System.out.println(HEADER_TABLE);
        for(Player i : p){
            System.out.println(i.toString());
        }
        System.out.println(FOOTER_TABLE);
    }
    
    public Player dataToObject(String text){
        String[] data = text.split(",");
        return new Player(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), Integer.parseInt(data[4].trim()));
    }
    
    public void readFromFile(){
        FileReader fr = null;
        try{
            File f = new File(pathFile);
            
            if(!f.exists()){
                System.out.println("players.txt file not found!");
                return;
            }
            
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String temp = "";
            
            while ((temp = br.readLine()) != null){
                Player i = dataToObject(temp);
                if(i != null){
                    this.add(i);
                }
            }
            br.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(PlayerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(PlayerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(PlayerList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex){
                Logger.getLogger(PlayerList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
