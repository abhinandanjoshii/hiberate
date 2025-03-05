package org.consoleadmin;

import jakarta.persistence.*;

@Entity
@Table(name="contracter_table")
public class Contracter {

    @Id
    private int uid;
    @Column(name="contracter_name")
    private String name;
    // skip this detail to be upserted to db, only used for operation

    @Transient
    private String tech;

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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
