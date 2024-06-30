package com.devin.emailservice;

import com.devin.emailservice.service.EmailServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@SpringBootTest
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailServiceImpl emailService;

    public EmailServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendWelcomeEmail() {
        String toEmail = "test@example.com";

        emailService.sendWelcomeEmail(toEmail);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}