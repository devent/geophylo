package com.anrisoftware.geophylo.db.hibernate;

import java.awt.Color;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NaturalId;

import com.anrisoftware.geophylo.db.model.EarthMap;
import com.anrisoftware.geophylo.db.model.Epoch;
import com.anrisoftware.geophylo.db.model.Rank;

@Entity
@NamedQueries({
        @NamedQuery(name = "countAllEpochs", query = "select count(*) from EpochEntity"),
        @NamedQuery(name = "reportAllEpochs", query = "select e from EpochEntity e"),
        @NamedQuery(name = "countEpochsRank", query = "select count(*) from EpochEntity where rank = :rank"),
        @NamedQuery(name = "reportEpochsRank", query = "select e from EpochEntity e where rank = :rank") })
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

    @NotNull
    private Color color;

    @OneToOne(fetch = FetchType.LAZY)
    private EpochEntity broader;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EpochEntity> narrower;

    @OneToOne(fetch = FetchType.LAZY)
    private EarthMapEntity earthMap;

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

    public Map<Locale, String> getNames() {
        return names;
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

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setBroader(EpochEntity broader) {
        this.broader = broader;
    }

    @Override
    public Epoch getBroader() {
        return broader;
    }

    public void setNarrower(List<EpochEntity> narrower) {
        this.narrower = narrower;
    }

    @Override
    public List<? extends Epoch> getNarrower() {
        return narrower;
    }

    public void setEarthMap(EarthMapEntity earthMap) {
        this.earthMap = earthMap;
    }

    @Override
    public EarthMap getEarthMap() {
        return earthMap;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                .append("version", version).append("preferred", preferred)
                .append("olderBound", olderBound)
                .append("youngerBound", youngerBound).toString();
    }
}
