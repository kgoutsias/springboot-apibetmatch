package net.javaguides.springbootapibetmatch.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;
    @Column(name = "matchDate")
    private LocalDate matchDate;
    @Column(name = "matchTime")
    private LocalTime matchTime;
    @Column(name = "teamA")
    private String teamA;
    @Column(name = "teamB")
    private String teamB;
    @Column(name = "sport")
    @Enumerated(EnumType.ORDINAL )
    private Sport sport;

    @OneToMany(targetEntity = MatchOdds.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    List<MatchOdds> matchOdds = new ArrayList<>();

    private Match(){

    }

    public Match(String description, LocalDate matchDate, LocalTime matchTime, String teamA, String teamB, Sport sport) {
        this.description = description;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public List<MatchOdds> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOdds> matchOdds) {
        this.matchOdds = matchOdds;
    }
}

