package com.keyin.domain.tournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    List<Tournament> findByStartDate(LocalDate startDate);
    List<Tournament> findByLocation(String location);
}
