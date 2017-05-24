package mail;

import javax.mail.MessagingException;

/**
 * Created by nicol on 24.05.2017.
 */
public class Main {
    public static void main(String args[]) throws MessagingException {

        GmailSender sender = new GmailSender();
        sender.setSender("nicolae_botnaru@mail.md", "12341234");
        sender.addRecipient("nicolae.botnaru@gmail.com");
        sender.setSubject("The subject");
        sender.setBody("The body");
//        sender.addAttachment("TestFile.txt");
        sender.send();
    }
}
