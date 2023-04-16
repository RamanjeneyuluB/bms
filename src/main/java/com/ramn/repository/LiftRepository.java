package com.ramn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ramn.entity.Lift;

public interface LiftRepository extends PagingAndSortingRepository<Lift, Long>,JpaRepository<Lift, Long> {

}