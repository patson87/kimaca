package com.application.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by macbookpatric on 12/22/16.
 */


@Entity
@Table(name="MGTRULES")
public class MgtRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startDate", insertable=false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endDate", insertable=false)
    private Date endDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", insertable=false)
    private Date creationDate;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
