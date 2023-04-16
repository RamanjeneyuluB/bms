package com.ramn.service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ramn.entity.Lift;
import com.ramn.entity.LiftMvmnt;
import com.ramn.repository.LiftMvmntRepository;
//import com.ramn.entity.LiftMvmnt;
import com.ramn.repository.LiftRepository;

import jakarta.annotation.PostConstruct;

@Service
public class LiftService {

	@Autowired
	private LiftRepository liftRepository;

	@Autowired
	private LiftMvmntRepository liftMvmntRepository;

	@Autowired
	private JavaMailSender javaMailSender; // Assuming you have configured JavaMailSender in your application

	@PostConstruct
	public void initDatabase() {
		Lift lift1 = new Lift("1", "TowerA", "A", "1F", true);
		Lift lift2 = new Lift("2", "TowerA", "B", "GF", true);
		Lift lift3 = new Lift("3", "TowerB", "A", "2F", true);
		Lift lift4 = new Lift("4", "TowerC", "B", "1F", false);
		Lift lift5 = new Lift("5", "TowerD", "A", "4F", false);
		Lift lift6 = new Lift("6", "TowerD", "B", "6F", false);
		Lift lift7 = new Lift("7", "TowerD", "C", "6F", true);

//        LiftMvmnt mvmnt1= new LiftMvmtnt()

		liftRepository.saveAll(Arrays.asList(lift1, lift2, lift3, lift4, lift5, lift6, lift7));
	}
	
	public void sendEmailAlertForBadLifts() {
		List<Lift> badLifts = liftRepository.findAll().stream().filter(l -> !l.isGood()).toList(); // Fetch Lift
																									// entities with
																									// isgood = false
		if (!badLifts.isEmpty()) {
			// Compose and send email alert
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("ramanaram022020@gmail.com"); // Set the recipient's email address
			message.setSubject("Alert: Bad Lifts Detected");
			message.setText("The following lifts are marked as not good: " + badLifts.toString());
			javaMailSender.send(message); // Send the email
		}
	}

	

	public List<Lift> getAllLifts() {
		return liftRepository.findAll();
	}

	public List<LiftMvmnt> getLiftHistory(Long liftId) {
		// TODO Auto-generated method stub
		return liftMvmntRepository.findByLiftNumber(liftId);
	}

	public LiftMvmnt insertLiftMvmnt(LiftMvmnt liftMvmnt) {
//			LonocalTime fromTime, LocalTime toTime) {
		try {

			Lift lift = liftRepository.findById(liftMvmnt.getLiftNumber().longValue()).get(); // orElseThrow(IllegalArgumentException::new))

			if (lift != null) {
				lift.setLiftNowAt(liftMvmnt.getToFloor().toString()); // Update liftnowat with to_floor reference
				liftRepository.save(lift); // Save updated Lift entity
			}

			return liftMvmntRepository.save(liftMvmnt);
		} catch (Exception e) {
			// Handle any exceptions or validation errors here
			throw new ServiceException("Failed to create LiftMvmnt", e);
		}
	}

	public List<LiftMvmnt> getLiftHistory(int liftId, LocalTime fromTime, LocalTime toTime) {
		 List<LiftMvmnt> filteredLiftMvmnts = liftMvmntRepository.findAll().stream()
			        .filter(liftMvmnt -> liftMvmnt.getLiftNumber()== liftId && liftMvmnt.getFromTime().isAfter(fromTime) && liftMvmnt.getToTime().isBefore(toTime))
			        .collect(Collectors.toList());

			    return filteredLiftMvmnts;
	}
	
	public List<LiftMvmnt> getLiftHistory() {
		 return  liftMvmntRepository.findAll();
	}
}
