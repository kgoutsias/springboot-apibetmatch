package net.javaguides.springbootapibetmatch.repository;

import net.javaguides.springbootapibetmatch.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchOddsRepository extends JpaRepository<MatchOdds,Long> {
}
