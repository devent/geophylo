package com.anrisoftware.geophylo.db.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.anrisoftware.geophylo.db.model.EarthMap;

@Entity
public class EarthMapEntity implements EarthMap {

    public interface EarthMapEntityFactory {

        EarthMapEntity create();

    }

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @NotNull
    private String name;

    @NotNull
    @Lob
    private byte[] data;

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                .append("version", version).append("name", name).toString();
    }
}
