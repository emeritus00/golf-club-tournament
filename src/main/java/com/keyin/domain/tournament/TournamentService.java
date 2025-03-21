package com.keyin.domain.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> findAllTournaments() {
        return (List<Tournament>) tournamentRepository.findAll();
    }

    public Tournament findTournamentById(long id) {
        Optional<Tournament> TournamentOptional = tournamentRepository.findById(id);
        return TournamentOptional.orElse(null);
    }


    public Tournament findTournamentByLocation(String location) {
        return (Tournament) tournamentRepository.findByLocation(location);
    }

    public Tournament findTournamentByStartDate(LocalDate startDate) {
        return (Tournament) tournamentRepository.findByStartDate(startDate);
    }

    public void deleteTournamentById(long id) {
        tournamentRepository.deleteById(id);
    }

    public Tournament updateTournamentById(long id, Tournament updatedTournament) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);

        if (tournamentOptional.isPresent()) {
            Tournament tournamentToUpdate = tournamentOptional.get();
            tournamentToUpdate.setStartDate(updatedTournament.getStartDate());
            tournamentToUpdate.setEndDate(updatedTournament.getEndDate());
            tournamentToUpdate.setLocation(updatedTournament.getLocation());
            tournamentToUpdate.setCashPrizeAmount(updatedTournament.getCashPrizeAmount());
            tournamentToUpdate.setEntryFee(updatedTournament.getEntryFee());
            tournamentToUpdate.setParticipatingMembers(updatedTournament.getParticipatingMembers());

            return tournamentRepository.save(tournamentToUpdate);
        }

        return null;
    }
}
