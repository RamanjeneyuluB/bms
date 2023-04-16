package com.ramn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramn.entity.LiftMvmnt;

@Repository
public interface LiftMvmntRepository extends JpaRepository<LiftMvmnt, Long> {
	

    List<LiftMvmnt> findByLiftNumber(Long liftNumber);


}