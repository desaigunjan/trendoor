package com.trendoor.util;
import java.util.*;

import com.trendoor.vo.ContactUs;

public class EmailUtil
{
   public static void sendEmail(ContactUs contact)
   {    
      String to = "gunju1410@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = contact.getEmail();

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      //properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      /*Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Trendoor Feedback");

         // Now set the actual message
         String text = "From: "+contact.getName()+" \\n";
         text = text + "Phone: "+contact.getPhone()+" \\n";
         text = text + "Message: "+contact.getMessage()+" \\n";
         message.setText(text);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }*/
   }
}