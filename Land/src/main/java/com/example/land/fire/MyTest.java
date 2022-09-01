package com.example.land.fire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.util.calendar.BaseCalendar;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    private static final long DAY_SECONDS = 86400 * 1000;

    @Test
    public void ymlTest() {
        Integer a = 2;
        Date date = new Date();
        Timestamp startTime = new Timestamp(date.getTime() - (a * DAY_SECONDS));
        Timestamp endTime = new Timestamp(date.getTime());
        System.out.println(startTime);
        System.out.println(endTime);
    }

    private long cc(BaseCalendar.Date date) {
        return date.getDayOfMonth();
    }


    @Test
    public void ossTest() {
        ArrayList<String> objects = new ArrayList<>();
        List<String> asd = objects.stream().filter(a -> a.equals("asd")).collect(Collectors.toList());
        System.out.println(asd.size());
    }

    @Test
    public void ssTest() throws Exception{
        AtomicReference<String> a = new AtomicReference<>();
        a.set("asd");
        System.out.println(a.get());
        AtomicReference<String> b = new AtomicReference<>("ok");
        System.out.println(b.get());
    }
}

