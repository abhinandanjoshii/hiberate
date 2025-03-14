package org.consoleadmin;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Contracter {

    @Id
    private int uid;
    private String name;
    private String tech;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ContracterDetails> contractersConfigs;

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

    public List<ContracterDetails> getContractersConfigs() {
        return contractersConfigs;
    }

    public void setContractersConfigs(List<ContracterDetails> contractersConfigs) {
        this.contractersConfigs = contractersConfigs;
    }

    @Override
    public String toString() {
        return "Contracter{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", contractersConfigs=" + contractersConfigs +
                '}';
    }
}
