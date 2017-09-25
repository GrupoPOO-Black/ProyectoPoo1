package mailing;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase utilizada para enviar correos.
 * @author Kenneth, Caleb, Lery
 *
 */
public class Mail
{
    /**
     * Envia un correo con una Mensaje, Asunto y Destinatario indicado.
     * @param msg - Cuerpo del correo.
     * @param subject - Asunto.
     * @param to - Destinatario.
     * @return true si se pudo enviar.
     */
    public static boolean sendMail(String msg,String subject,String to){
    	try {
            // Propiedades de la conexion
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "salastec1@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("salastec1@gmail.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(msg);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("salastec1@gmail.com", "tecnologicodecostarica"); 
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
