package com.example.uuzaz.teamcook04_1;

public class Main_Feedback_ListItem {
    private String feedback_nameStr;
    private String feedback_levelStr;
    private String feedback_rollStr;



    public void setFeedback_name(String feedback_name) {
        feedback_nameStr = feedback_name;
    }

    public void setFeedback_level(String feedback_level) {
        feedback_levelStr = feedback_level;
    }

    public void setFeedback_roll(String feedback_roll) {
        feedback_rollStr = feedback_roll;
    }



    public String getFeedback_name() {
        return this.feedback_nameStr;
    }

    public String getFeedback_level() {
        return this.feedback_levelStr;
    }

    public String getFeedback_roll() {
        return this.feedback_rollStr;
    }


}
