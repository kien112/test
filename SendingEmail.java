
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {
    private String userEmail;
    private String myHash;
    
    
    
    public SendingEmail(String userEmail, String myHash) {
        this.userEmail = userEmail;
        this.myHash = myHash;
    }
    
    public void sendMail(){
        String email = "ngkien112@gmail.com";
        String pword = "kien123aa";
        
        Properties p = new Properties();
        
        p.put("mail.smtp.auth", true);
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        
        Session s = Session.getInstance(p, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(email, pword);
            }
        });
        
        try{
            MimeMessage mess = new MimeMessage(s);
            mess.setFrom(new InternetAddress(email));
            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            mess.setSubject("saas");
            mess.setText("Verwdis: ");
            mess.setText("http://localhost:8080/SenEmail/ActiveAcc?key1="+userEmail+"&key2="+myHash);
            Transport.send(mess);
        }catch(Exception e){
            
        }
    }
}
