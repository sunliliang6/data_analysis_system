package com.wayzim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/3/23
 */
@Entity
@Table(name = "sortline")
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SortLine implements Serializable {

    private static final long serialVersionUID = -6909800361031438755L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SortLineCode")
    private String sortLineCode;
    @Column(name = "StationID")
    private Integer stationId;
    @Column(name = "Type")
    private Integer type;
    @Column(name = "Name")
    private String name;
    @Column(name = "DeployTime")
    private Date deployTime;
    @Column(name = "MaxLength")
    private Double maxLength;
    @Column(name = "MaxWidth")
    private Double maxWidth;
    @Column(name = "MaxHeight")
    private Double maxHeight;
    @Column(name = "MaxWeight")
    private Double maxWeight;
    @ManyToOne
    @JoinColumn(name = "StationID", insertable = false, updatable = false)
    private Station station;
    @OneToMany(mappedBy = "sortLine")
    private Set<AlarmRecord> alarmRecordSet = new HashSet<>();

    @OneToMany(mappedBy = "sortLine")
    private Set<Device> deviceSet=new HashSet<>();

}
