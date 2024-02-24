package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE); // The inboxCapacity is equal to the maximum value an integer can store.
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
    int maxMeetings = 0;
    for (Meeting meeting : calendar) {
        int count = 0;
        for (Meeting other : calendar) {
            if (meeting != other && !meeting.overlaps(other)) {
                count++;
            }
        }
        maxMeetings = Math.max(maxMeetings, count);
    }
    return maxMeetings;
    }

}
