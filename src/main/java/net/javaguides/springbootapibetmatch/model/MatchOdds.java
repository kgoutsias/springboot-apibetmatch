package net.javaguides.springbootapibetmatch.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
@Entity
@Table(name = "match_odds")
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="specifier")
    @Pattern(regexp = "[X12]", message = "The Acceptance values for this field is X,1,2")
    private String specifier;

    @Column(name="odd")
    @PositiveOrZero(message = "The field odd must >= 0")
    private Double odd;

    public MatchOdds(){

    }

    public MatchOdds(String specifier, Double odd) {
        this.specifier = specifier;
        this.odd = odd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}
