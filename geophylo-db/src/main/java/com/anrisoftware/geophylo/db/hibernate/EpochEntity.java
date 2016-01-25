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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NaturalId;

import com.anrisoftware.geophylo.db.model.Epoch;

@Entity
public class EpochEntity implements Epoch {

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @NaturalId(mutable = true)
    private String preferred;

    @ElementCollection
    private Map<Locale, String> names;

    private String rank;

    private double olderBound;

    private double yougherBound;

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

    @Override
    public String getPreferred() {
        return preferred;
    }

    @Override
    public String getName(Locale locale) {
        return names.get(locale);
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public double getOlderBound() {
        return olderBound;
    }

    @Override
    public double getYougherBound() {
        return yougherBound;
    }

    @Override
    public List<Epoch> getBroader() {
        return broaderEpoch;
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
