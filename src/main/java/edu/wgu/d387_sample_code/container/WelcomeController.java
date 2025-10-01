package edu.wgu.d387_sample_code.container;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class WelcomeController {

    private Executor ex = Executors.newFixedThreadPool(2);

    @GetMapping("welcome")
    public ResponseEntity<List<String>> getWelcomeMessage() {
        List<String> list = new ArrayList<>();


        ex.execute(() -> {
            MessageDisplayer welcomeUS = new MessageDisplayer("en", "US");
            list.add(welcomeUS.getWelcomeMessage());
            System.out.println("English Message Received");


        });
        ex.execute(() -> {
            MessageDisplayer welcomeFR = new MessageDisplayer("fr", "CA");
            list.add(welcomeFR.getWelcomeMessage());
            System.out.println("French Message Received");
        });
        try {Thread.sleep(750); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return ResponseEntity.ok(list);
    }

}