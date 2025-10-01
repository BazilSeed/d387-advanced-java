package edu.wgu.d387_sample_code.container;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;



@Component
public class MessageDisplayer {
    private ResourceBundle resourceBundle;
    private Locale locale;

    public String getWelcomeMessage() {
        return resourceBundle.getString("welcomeMessage");
    }

    public MessageDisplayer() {

    }

    public MessageDisplayer(String language, String country) {
        locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("Translation", locale);
        System.out.printf("%s, %s%n", language, country);
    }
}