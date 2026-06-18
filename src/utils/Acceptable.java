/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

/**
 *
 * @author ADMIN
 */
public interface Acceptable {
    public final String INTEGER_VALID = "^\\d+$";
    public final String CLUB_ID_VALID = "^[Cc][Ll]-\\d{4}$";
    public final String CLUB_NAME_VALID = "^.{2,20}$";
    public final String SPONSOR_BRAND_VALID = "^.{2,20}$";
    public final String BUDGET_VALID = "^[1-9]\\d*$";
    public final String PLAYER_ID_VALID = "^[Pp]\\d{4}$";
    public final String PLAYER_NAME_VALID = "^.{2,20}$";
    public final String SHIRT_NUMBER_VALID = "^[1-9]\\d?$";
    public final String POSITION_VALID = "^.{2,20}$";
    
    
    public static boolean isValid(String data, String pattern){
        return data.matches(pattern);
    }
}
