package com.ramn.tools;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramn.repository.LiftRepository;
import com.ramn.entity.Lift;
@Component
public class H2DatabaseInitializer {

    @Autowired
    private LiftRepository liftRepository;

    @PostConstruct
    public void init() {
        // Insert sample data into the Lift table
        Lift lift1 = new Lift("1", "TowerA", "A", "1F", true);
        Lift lift2 = new Lift("2", "TowerA", "B", "GF", true);
        Lift lift3 = new Lift("3", "TowerB", "A", "2F", true);
        Lift lift4 = new Lift("4", "TowerC", "B", "1F", false);
        Lift lift5 = new Lift("5", "TowerD", "A", "4F", false);
        Lift lift6 = new Lift("6", "TowerD", "B", "6F", false);
        Lift lift7 = new Lift("7", "TowerD", "C", "6F", true);

        liftRepository.save(lift1);
        liftRepository.save(lift2);
        liftRepository.save(lift3);
        liftRepository.save(lift4);
        liftRepository.save(lift5);
        liftRepository.save(lift6);
        liftRepository.save(lift7);
    }
}

