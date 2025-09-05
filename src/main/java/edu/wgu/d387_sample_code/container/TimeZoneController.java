package edu.wgu.d387_sample_code.container;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/time")
@CrossOrigin

public class TimeZoneController {

    final private String timeStarter = "04:30PM EST";
    final private String dateFixer = "hh:mma z";

    final private String[] timeZones = new String[]{"EST","MST","UTC"};
    
    private SimpleDateFormat formatter = new SimpleDateFormat(dateFixer);


    @GetMapping("/presentation")

    public ResponseEntity<List<String>> getLivePresentationTimes() {
        List<String> timeList = new ArrayList<String>();

        try {
            Date date = formatter.parse(timeStarter);

            for (String i : timeZones) {

                TimeZone xtime = TimeZone.getTimeZone(i);
                formatter.setTimeZone(xtime);
                // Format startDate to the respective timezone
                String dateOut = formatter.format(date);
                timeList.add(dateOut);
            }

            TimeZone xtMST = TimeZone.getTimeZone("MST");
            TimeZone xtUTC = TimeZone.getTimeZone("UTC");
            TimeZone xtEST = TimeZone.getTimeZone("EST");
            formatter.setTimeZone(xtEST);

        } catch (Exception e) {
            System.out.println(e.toString());
            timeList.add(e.toString());
        }

        return ResponseEntity.ok(timeList);
    }

}
