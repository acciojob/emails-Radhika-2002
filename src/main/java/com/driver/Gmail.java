package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash;
    private int inboxCapacity;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        if (inbox.size() >= inboxCapacity) {
            trash.add(inbox.remove(0)); // remove oldest mail and move to trash
        }
        inbox.add(new Mail(date, sender, message));
    }

    public void deleteMail(String message){
        inbox.removeIf(mail -> mail.getMessage().equals(message));
    }


    public String findLatestMessage(){
        return inbox.isEmpty() ? null : inbox.get(inbox.size() - 1).getMessage();
    }

    public String findOldestMessage(){
        return inbox.isEmpty() ? null : inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        return inbox.size();
    }

    public int getTrashSize(){
        return trash.size();
    }

    public void emptyTrash(){
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }
}
