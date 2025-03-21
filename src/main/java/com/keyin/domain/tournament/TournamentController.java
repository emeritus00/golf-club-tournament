package com.keyin.domain.tournament;

import com.keyin.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments() {
        return tournamentService.findAllTournaments();
    }

    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentByID(@PathVariable long id) {
        return tournamentService.findTournamentById(id);
    }

    @GetMapping("/tournaments/search/{location}")
    public Tournament getTournamentByLocation(@PathVariable String location) {
        return tournamentService.findTournamentByLocation(location);
    }

    @GetMapping("/tournaments/search/{startDate}")
    public Tournament getTournamentByStartDate(@PathVariable String startDate) {
        return tournamentService.findTournamentByStartDate(LocalDate.parse(startDate));
    }

    @PostMapping("/tournament")
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @PutMapping("/tournaments/{id}")
    public Tournament updateTournament(@PathVariable long id, @RequestBody Tournament updatedTournament) {
        return tournamentService.updateTournamentById(id, updatedTournament);
    }

    @DeleteMapping("/tournaments/{id}")
    public void deleteTournament(@PathVariable long id) {
        tournamentService.deleteTournamentById(id);
    }
}
