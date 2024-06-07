package com.handson.basic.util;

import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

import com.sendgrid.*;

@Service
public class EmailServiceSendGrid {

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${sendgrid.key}")
    private String SENDGRID_API_KEY;

    // according to the example at https://app.sendgrid.com/guide/integrate/langs/java
    public Response send(String subject, String toAddress, String emailContent) {

        Email from = new Email("roei.no.reply@gmail.com");
        Email to = new Email(toAddress);
        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            logger.error("Error sending email to " + toAddress, ex);
        }
        
        return response;

    }

}
