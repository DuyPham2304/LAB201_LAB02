/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.Club;
import dto.Player;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Inputter {

    private Scanner sc;

    public Inputter() {
        this.sc = new Scanner(System.in);
    }

    public String getString(String mess) {
        System.out.print(mess);
        return sc.nextLine().trim();
    }

    public int getInt(String mess) {
        int result = 0;
        String temp = getString(mess);
        if (Acceptable.isValid(temp, Acceptable.INTEGER_VALID)) {
            result = Integer.parseInt(temp);
        }
        return result;
    }

    public String inputAndLoop(String mess, String pattern) {
        String result = "";
        boolean more = true;
        do {
            result = getString(mess);
            more = !Acceptable.isValid(result, pattern);
            if (more) {
                System.out.println("Data is invalid!. Re-enter ...");
            }
        } while (more);
        return result;
    }

    public String inputOptionalAndLoop(String mess, String pattern) {
        String result = "";
        boolean more = true;
        do {
            result = getString(mess);
            if (result.isEmpty()) {
                return "";
            }

            more = !Acceptable.isValid(result, pattern);
            if (more) {
                System.out.println("Data is invalid!. Re-enter ...");
            }
        } while (more);
        return result;
    }

    public Club enterClubInfo(boolean isUpdate) {
        if (isUpdate) {
            String clubName = inputOptionalAndLoop("Enter new Club Name: ", Acceptable.CLUB_NAME_VALID);
            String sponsorName = inputOptionalAndLoop("Enter new Sponsor Name: ", Acceptable.SPONSOR_BRAND_VALID);
            int budget;
            String stringBudget = inputOptionalAndLoop("Enter new Budget: ", Acceptable.BUDGET_VALID);
            if (stringBudget.isEmpty() || stringBudget.equals("")) {
                budget = 0;
            } else {
                budget = Integer.parseInt(stringBudget);
            }
            return new Club(null, clubName, sponsorName, budget);
        } else {
            String clubId = inputAndLoop("Enter Club ID: ", Acceptable.CLUB_ID_VALID).toUpperCase();
            String clubName = inputAndLoop("Enter Club Name: ", Acceptable.CLUB_NAME_VALID);
            String sponsorName = inputAndLoop("Enter Sponsor Name: ", Acceptable.SPONSOR_BRAND_VALID);
            int budget = Integer.parseInt(inputAndLoop("Enter Budget: ", Acceptable.BUDGET_VALID));
            return new Club(clubId, clubName, sponsorName, budget);
        }
    }

    public Player enterPlayerInfo(boolean isUpdate) {
        if (isUpdate) {
            String playerName = inputOptionalAndLoop("Enter new player name: ", Acceptable.PLAYER_NAME_VALID);
            String position = inputOptionalAndLoop("Enter new position name: ", Acceptable.POSITION_VALID);
            int shirtNumber;
            String stringShirtNumber = inputOptionalAndLoop("Enter new shirt number: ", Acceptable.SHIRT_NUMBER_VALID);
            if(stringShirtNumber.isEmpty() || stringShirtNumber.equals("")){
                shirtNumber = -1;
            } else {
                shirtNumber = Integer.parseInt(stringShirtNumber);
            }
            return new Player(null, null, playerName, position, shirtNumber);
        } else {
            String playerId = inputAndLoop("Enter Player ID: ", Acceptable.PLAYER_ID_VALID);
            String clubId = inputAndLoop("Enter Club ID: ", Acceptable.CLUB_ID_VALID);
            String playerName = inputAndLoop("Enter Player Name: ", Acceptable.PLAYER_NAME_VALID);
            String position = inputAndLoop("Enter Position: ", Acceptable.POSITION_VALID);
            int shirtNumber = Integer.parseInt(inputAndLoop("Enter shirt number: ", Acceptable.SHIRT_NUMBER_VALID));
            return new Player(playerId, clubId, playerName, position, shirtNumber);
        }
    }
}
