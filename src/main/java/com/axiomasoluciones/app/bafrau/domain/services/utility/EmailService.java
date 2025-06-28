package com.axiomasoluciones.app.bafrau.domain.services.utility;

public interface EmailService {
    void sendNotification(String to, String subject, String text);
}