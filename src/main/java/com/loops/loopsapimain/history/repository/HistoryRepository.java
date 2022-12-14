package com.loops.loopsapimain.history.repository;

import com.loops.loopsapimain.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByHistoryReference(String historyReference);

}
