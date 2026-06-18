/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author ADMIN
 */
public class Player {

    private String playerId;
    private String clubId;
    private String playerName;
    private String position;
    private int shirtNumber;

    public Player() {
    }

    public Player(String playerId, String clubId, String playerName, String position, int shirtNumber) {
        this.playerId = playerId;
        this.clubId = clubId;
        this.playerName = playerName;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    /**
     * @return the playerId
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId the playerId to set
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the shirtNumber
     */
    public int getShirtNumber() {
        return shirtNumber;
    }

    /**
     * @param shirtNumber the shirtNumber to set
     */
    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Override
    public String toString() {
        return String.format("| %-9s | %-6s | %-15s | %-12s | %-12s |", playerId, clubId, playerName, position, shirtNumber);
    }    

}
