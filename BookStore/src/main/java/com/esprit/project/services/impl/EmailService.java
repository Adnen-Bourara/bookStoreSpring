package com.esprit.project.services.impl;

import com.esprit.project.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendMail(Client client)
    { StringBuilder sb = new StringBuilder();
        sb.append("Message envoyé par : puzzles ").append(client).append(System.lineSeparator());
        sb.append("\n ce message est envoyé pour le client ").append(client.getNom()).append(System.lineSeparator());
        sb.append("\n votre reclamation a éte prise en charge. ");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(client.getMail());
        message.setSubject("reclamation");
        message.setText(sb.toString());
        mailSender.send(message);
    }
}
