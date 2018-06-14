package com.cetccity.queue.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcustlevel")
public class TCustLevel {
	@Column
	@Id
    private Short id;

	@Column
    private String name;

	@Column
    private Integer subccno;

	@Column
    private Integer vdn;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSubccno() {
        return subccno;
    }

    public void setSubccno(Integer subccno) {
        this.subccno = subccno;
    }

    public Integer getVdn() {
        return vdn;
    }

    public void setVdn(Integer vdn) {
        this.vdn = vdn;
    }
}