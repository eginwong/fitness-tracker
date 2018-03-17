package com.eginwong.physical.fitnesstracker.repository;

import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FitnessLogRepository extends JpaRepository<FitnessLog, Date> {
}

