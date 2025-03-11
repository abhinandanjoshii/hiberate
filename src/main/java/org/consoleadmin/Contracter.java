package org.consoleadmin;

import jakarta.persistence.*;

@Entity
public class Contracter {

    @Id
    private int uid;
    private String name;
    private String tech;
    @OneToOne
    private ContracterDetails contracterConfigs;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public ContracterDetails getContracterConfigs() {
        return contracterConfigs;
    }

    public void setContracterConfigs(ContracterDetails contracterConfigs) {
        this.contracterConfigs = contracterConfigs;
    }

    @Override
    public String toString() {
        return "Contracter{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", contracterConfigs=" + contracterConfigs +
                '}';
    }
}
