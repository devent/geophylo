package com.anrisoftware.geophylo.db.hibernate;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NaturalId;

import com.anrisoftware.geophylo.db.model.Epoch;
import com.anrisoftware.geophylo.db.model.Rank;

@Entity
public class EpochEntity implements Epoch {

    public interface EpochEntityFactory {

        EpochEntity create();

    }

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @NaturalId(mutable = true)
    @NotNull
    private String preferred;

    @ElementCollection
    private Map<Locale, String> names;

    @NotNull
    private Rank rank;

    @Min(0)
    private double olderBound;

    @Min(0)
    private double youngerBound;

    @OneToMany(targetEntity = EpochEntity.class, fetch = FetchType.LAZY)
    private List<Epoch> broaderEpoch;

    @OneToMany(targetEntity = EpochEntity.class, fetch = FetchType.LAZY)
    private List<Epoch> narrowerEpoch;

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setPreferred(String preferred) {
        this.preferred = preferred;
    }

    @Override
    public String getPreferred() {
        return preferred;
    }

    public void setNames(Map<Locale, String> names) {
        this.names = names;
    }

    @Override
    public String getName(Locale locale) {
        return names.get(locale);
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    public void setOlderBound(double olderBound) {
        this.olderBound = olderBound;
    }

    @Override
    public double getOlderBound() {
        return olderBound;
    }

    public void setYoungerBound(double youngerBound) {
        this.youngerBound = youngerBound;
    }

    @Override
    public double getYoungerBound() {
        return youngerBound;
    }

    public void setBroaderEpoch(List<Epoch> broaderEpoch) {
        this.broaderEpoch = broaderEpoch;
    }

    @Override
    public List<Epoch> getBroader() {
        return broaderEpoch;
    }

    public void setNarrowerEpoch(List<Epoch> narrowerEpoch) {
        this.narrowerEpoch = narrowerEpoch;
    }

    @Override
    public List<Epoch> getNarrower() {
        return narrowerEpoch;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
