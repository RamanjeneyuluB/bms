package com.ramn.tools;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ramn.repository.LiftMvmntRepository;
import com.ramn.entity.LiftMvmnt;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class LiftMvmntInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private LiftMvmntRepository liftMvmntRepository;

    @PostConstruct
    public void init() {
        System.out.println("Initializing LiftMvmnt table...");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Create and insert LiftMvmnt entities
        LiftMvmnt entity1 = new LiftMvmnt(1L, 1, "1F", "3F", LocalTime.of(10, 0), LocalTime.of(11, 0));
        LiftMvmnt entity2 = new LiftMvmnt(2L, 1, "GF", "6F", LocalTime.of(10, 0), LocalTime.of(11, 0));
        LiftMvmnt entity3 = new LiftMvmnt(1L, 2, "3F", "GF", LocalTime.of(11, 0), LocalTime.of(12, 0));
        LiftMvmnt entity4 = new LiftMvmnt(5L, 1, "GF", "5F", LocalTime.of(10, 0), LocalTime.of(11, 0));

        List<LiftMvmnt> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity3);
        entities.add(entity4);

        liftMvmntRepository.saveAll(entities);

        System.out.println("LiftMvmnt table initialized with data.");
    }

    // Other methods and properties
    // ...
}
