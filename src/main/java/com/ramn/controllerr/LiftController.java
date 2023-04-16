package com.ramn.controllerr;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramn.entity.Lift;
import com.ramn.entity.LiftMvmnt;
import com.ramn.service.LiftService;

//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LiftController {

    @Autowired
    private LiftService liftsService;

    @GetMapping("/allLifts")
    public List<Lift> getAllLifts() {
        return liftsService.getAllLifts();
    }
    
    @GetMapping("/allLiftsHistory")
    public List<LiftMvmnt> getHistoryOfAllLifts(){
    	return liftsService.getLiftHistory();
    }
    
    @GetMapping("/lifthistory/{liftId}")
    public List<LiftMvmnt> getLiftHistoryByLiftNumber(@PathVariable Long liftId) {
        List<LiftMvmnt> liftMvmntList = liftsService.getLiftHistory(liftId);// liftMvmntRepository.findByLiftNumber(liftNumber);

        return liftMvmntList;
    }
    
    @GetMapping("/lifthistory/{liftId}/{fromTime}/{toTime}")
    public List<LiftMvmnt> getLiftsByTimeRange(@PathVariable int liftId,
                                          @PathVariable LocalTime fromTime,
                                          @PathVariable LocalTime toTime) {
        return liftsService.getLiftHistory(liftId, fromTime, toTime);
    }

    
    @PostMapping("/liftMvmnt")
    public ResponseEntity<LiftMvmnt> createLiftMvmnt(@RequestBody LiftMvmnt liftMvmntEntity) {
    	
        try {
            LiftMvmnt savedLiftMvmnt = liftsService.insertLiftMvmnt(liftMvmntEntity);
            return ResponseEntity.ok(savedLiftMvmnt);
        } catch (Exception e) {
            // Handle any exceptions or validation errors here
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}