package com.beatricefarias.rugbyscorecounter;

/**
 * Created by beatrice.farias on 25/02/2018.
 */

public class Points {
    private int buttonId;
    private int points;
    private String team;

    /**
     * Public constructor taking paramaters for the object
     * @param buttonId Id of the current button
     * @param points points associated with the button
     * @param team team to add points to
     */
    public Points(int buttonId, int points, String team){
        this.buttonId = buttonId;
        this.points = points;
        this.team = team;
    }

    /**
     * Method which returns button Id parameter
     * @return
     */
    public int getButtonId(){
        return buttonId;
    }

    /**
     * Method which returns points parameter
     * @return points of the button
     */
    public int getPoints(){
        return points;
    }

    /**
     * Method which returns string of the team
     * @return team name to add a score to
     */
    public String getTeam(){
        return team;
    }
}
