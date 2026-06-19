/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controllers.ClubList;
import controllers.Menu;
import controllers.PlayerList;
import dto.Club;
import java.util.ArrayList;
import dto.Player;
import utils.Acceptable;
import utils.Inputter;


/**
 *
 * @author ADMIN
 */
public class FootballManagement {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Inputter ndl = new Inputter();
        ClubList clubs = new ClubList();
        PlayerList players = new PlayerList();
        clubs.readFromFile();
        players.readFromFile();
        
        
        menu.addItem("1. List of all clubs");
        menu.addItem("2. Add a new club");
        menu.addItem("3. Search for a club by ID");
        menu.addItem("4. Update a club by ID");
        menu.addItem("5. List of all clubs with budget ≤ input value");
        menu.addItem("6. List all players in ascending order of club names, if same club, sort by shirt number ascending.");
        menu.addItem("7. Search players by partial player name");
        menu.addItem("8. Add a new player");
        menu.addItem("9. Remove a player with ID");
        menu.addItem("10. Update a player with an ID");
        menu.addItem("11. List all players by a specific position");
        menu.addItem("12. Save data to files");
        menu.addItem("13. Load data from files");
        menu.addItem("14. Quit program");
        int choice;
        
        do{
            menu.showMenu();
            choice = Integer.parseInt(ndl.inputAndLoop("Choice: ", Acceptable.CHOICE_VALID));
            switch (choice) {
                case 1:
                    if(clubs.isEmpty()){
                        System.out.println("There are no club in the system!");
                    }else {
                        clubs.showAll();
                    }                   
                    break;
                case 2:
                    Club newCLub = ndl.enterClubInfo(false);
                    if(clubs.addClub(newCLub)){                       
                        System.out.println("Added new club succesfully!");
                    } else {
                        System.out.println("This club ID already exists!");
                    }
                    break;
                case 3:
                    displayClub(clubs.searchById(ndl.inputAndLoop("Enter club ID to search: ", Acceptable.CLUB_ID_VALID)));
                    break;
                case 4:
                    Club club = clubs.searchById(ndl.inputAndLoop("Enter club ID to update: ", Acceptable.CLUB_ID_VALID));
                    if(club != null){
                        Club newInformation = ndl.enterClubInfo(true);
                        clubs.updateClub(club, newInformation);
                        System.out.println("Updated succesfully");
                    } else {
                        System.out.println("This club does not exist!");
                    }                   
                    break;
                case 5:
                    clubs.showAll(clubs.displayAllClubsWithBudget(Integer.parseInt(ndl.inputAndLoop("Enter budget: ", Acceptable.BUDGET_VALID))));
                    break;
                case 6:
                    ArrayList<Player> sortedPlayers = players.sortPlayerByClubAndNumber(clubs);
                    if(sortedPlayers.isEmpty()){
                        System.out.println("There are no player in the system!");
                    } else {
                        players.showAll(sortedPlayers);
                    }
                    break;
                case 7:
                    ArrayList<Player> searchedPlayers = players.searchByName(ndl.inputAndLoop("Enter Name: ", Acceptable.PLAYER_NAME_VALID));
                    if(searchedPlayers.isEmpty()){
                        System.out.println("There are no player with that partial name!");
                    } else {
                        players.showAll(searchedPlayers);
                    }
                    break;
                case 8:
                    Player newPlayer = ndl.enterPlayerInfo(false);
                    if(clubs.searchById(newPlayer.getClubId()) == null){
                        System.out.println("This club does not exist!");
                    } else {
                        switch (players.addPlayer(newPlayer)) {
                            case 1:
                                System.out.println("This player ID already exists!");
                                break;
                            case 2:
                                System.out.println("This shirt number already exists in this club!");
                                break;
                            case 3:
                                System.out.println("added new player successfully!");
                                break;
                        }
                    }
                    break;
                case 9:                 
                    String playerId = ndl.inputAndLoop("Enter player ID: ", Acceptable.PLAYER_ID_VALID);
                    if(players.removePlayer(playerId)){
                        System.out.println("Remove player successfully!");
                    } else {
                        System.out.println("This player does not exist!");
                    }
                    break;
                case 10:
                    Player player = players.searchById(ndl.inputAndLoop("Enter player ID: ", Acceptable.PLAYER_ID_VALID));
                    if(player != null){
                        Player newInformation = ndl.enterPlayerInfo(true);
                        if(players.updatePlayer(player, newInformation)){
                            System.out.println("Updated player successfully!");
                        } else {
                            System.out.println("This shirt number already exists in this club!");
                        }
                    } else {
                        System.out.println("This player does not exist!");
                    }
                    break;
                case 11:
                    ArrayList<Player> listPlayersByPosition = players.listAllPlayersByPostition(ndl.enterPosition("Enter position (Goalkeeper, Defender, Midfielder, Forward, Winger): ", false));
                    if(listPlayersByPosition == null){
                        System.out.println("There is no player with this position in the system!");
                    } else {
                        players.showAll(listPlayersByPosition);
                    }
                    break;
                case 12:
                    players.saveToFile();
                    clubs.saveToFile();
                    System.out.println("Save data sucessfully!");
                    break;
                case 13:
                    players.readFromFile();
                    clubs.readFromFile();
                    System.out.println("Load data successfully!");
                    break;
                case 14:
                    if(!clubs.isSave() || !players.isSave()){
                        clubs.saveToFile();
                        players.saveToFile();
                        return;
                    }
                    return;
            }
        }while(choice >= 1 && choice <= 14);
    }
    
    public static void displayClub(Club c){
        if (c != null) {
            System.out.println("-----------------------------------------");
            System.out.println("Club ID     : " + c.getClubId());
            System.out.println("Club Name   : " + c.getClubName());
            System.out.println("Sponsor Name: " + c.getSponsorName());
            System.out.println("Budget      : " + c.getBudget());
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("This club does not exist!");
        }
    }
}
