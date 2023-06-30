package net.javaguides.springbootapibetmatch.repository;

import net.javaguides.springbootapibetmatch.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {
}
