package com.driver.test;

import com.driver.Email;
import com.driver.Gmail;
import com.driver.Workspace;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCases {

    @Test
    public void testEmail1() {
        Email email = new Email("accio@gmail.com");
        email.changePassword("Accio@123", "V12@v123");
        assertEquals("V12@v123", email.getPassword());
    }

    @Test
    public void testGmail1() throws ParseException {
        Gmail gmail = new Gmail("accio@gmail.com", 3);
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("21/12/2022"), "Tushar", "Assignment Completed?");
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2022"), "Tushar", "We are running out of time.");
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2022"), "Abhishek", "Assignment to be uploaded on database.");
        assertEquals(3, gmail.getInboxSize());
        assertEquals("Assignment Completed?", gmail.findOldestMessage());
    }

    @Test
    public void testGmail3() throws ParseException {
        Gmail gmail = new Gmail("accio@gmail.com", 3);
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("21/12/2022"), "Tushar", "Assignment Completed?");
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2022"), "Tushar", "We are running out of time.");
        gmail.deleteMail("Assignment Completed?");
        assertEquals(1, gmail.getTrashSize());
    }

    @Test
    public void testWorkspace1() {
        Workspace workspace = new Workspace("accio@gmail.com");
        workspace.addMeeting(new Meeting(LocalTime.of(9, 0), LocalTime.of(10, 0)));
        workspace.addMeeting(new Meeting(LocalTime.of(10, 30), LocalTime.of(11, 30)));
        workspace.addMeeting(new Meeting(LocalTime.of(11, 0), LocalTime.of(12, 0)));
        assertEquals(2, workspace.findMaxMeetings());
    }
}
