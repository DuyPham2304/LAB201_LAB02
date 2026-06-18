/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author ADMIN
 */
public class Club {
    private String clubId;
    private String clubName;
    private String sponsorName;
    private int budget;

    public Club() {
    }

    public Club(String clubId, String clubName, String sponsorName, int budget) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.sponsorName = sponsorName;
        this.budget = budget;
    }

    /**
     * @return the clubId
     */
    public String getClubId() {
        return clubId;
    }

    /**
     * @param clubId the clubId to set
     */
    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    /**
     * @return the clubName
     */
    public String getClubName() {
        return clubName;
    }

    /**
     * @param clubName the clubName to set
     */
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    /**
     * @return the sponsorName
     */
    public String getSponsorName() {
        return sponsorName;
    }

    /**
     * @param sponsorName the sponsorName to set
     */
    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    /**
     * @return the budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("| %-5s | %-22s | %-15s | %-7s |", clubId, clubName, sponsorName, budget);
    }   
    
}
