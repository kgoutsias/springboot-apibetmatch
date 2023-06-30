package net.javaguides.springbootapibetmatch.controller;

import net.javaguides.springbootapibetmatch.exception.ResourceNotFoundException;
import net.javaguides.springbootapibetmatch.model.Match;
import net.javaguides.springbootapibetmatch.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for CRUD functionalities API
 */
@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        return matchRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Match not exist with id" +id));
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match createdMatch = matchRepository.save(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        matchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Match not exist with id for update" +id));
        match.setId(id);
        Match updatedMatch = matchRepository.save(match);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Match not exist with id for delete" +id));
        matchRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
