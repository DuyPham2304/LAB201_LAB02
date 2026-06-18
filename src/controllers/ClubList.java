/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dto.Club;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ClubList extends ArrayList<Club> {

    private final String pathFile = "clubs.txt";
    private final String HEADER_TABLE = String.format("|--------------------------------------------------------------|\n"
            + "| %-5s | %-22s | %-15s | %-7s |%n"
            + "|--------------------------------------------------------------|", "Club ID", "Club Name", "Sponsor Brand", "Budget");
    private final String FOOTER_TABLE = "|--------------------------------------------------------------|";

    public Club searchById(String id) {
        for (Club c : this) {
            if (c.getClubId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public List<Club> displayAllClubsWithBudget(int budget) {
        ClubList list = new ClubList();
        for (Club c : this) {
            if (c.getBudget() <= budget) {
                list.add(c);
            }
        }
        return list;
    }

    public boolean addClub(Club c) {
        if(searchById(c.getClubId()) != null){
            return false;
        } else {
            this.add(c);
            return true;
        }
    }

    public void updateClub(Club club, Club newInformation) {
        if (!newInformation.getClubName().equals("") || !newInformation.getClubName().isEmpty()) {
            club.setClubName(newInformation.getClubName());
        }
        if (!newInformation.getSponsorName().equals("") || !newInformation.getSponsorName().isEmpty()) {
            club.setSponsorName(newInformation.getSponsorName());
        }
        if (newInformation.getBudget() != 0) {
            club.setBudget(newInformation.getBudget());
        }
    }

    public void showAll() {
        showAll(this);
    }

    public void showAll(List<Club> l) {
        System.out.println(HEADER_TABLE);
        for (Club c : l) {
            System.out.println(c.toString());
        }
        System.out.println(FOOTER_TABLE);
    }

    public Club dataToObject(String text) {
        String[] data = text.split(",");
        return new Club(data[0].trim(), data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()));
    }

    public void readFromFile() {
        FileReader fr = null;
        try {
            File f = new File(pathFile);

            if (!f.exists()) {
                System.out.println("clubs.txt file not found !");
                return;
            }

            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String temp = "";

            while ((temp = br.readLine()) != null) {
                Club i = dataToObject(temp);
                if (i != null) {
                    this.add(i);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClubList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClubList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClubList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ClubList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
