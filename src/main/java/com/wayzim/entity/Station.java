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
@Table(name = "station")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Station implements Serializable {
    private static final long serialVersionUID = 5710681570344949882L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "DeployTime")
    private Date deployTime;
    @Column(name = "Country")
    private String country;
    @Column(name = "Province")
    private String province;
    @Column(name = "City")
    private String city;
    @Column(name = "District")
    private String district;
    @Column(name = "DistrictCode")
    private String districtCode;

    @OneToMany(mappedBy = "station")
    private Set<SortLine> sortLineSet = new HashSet<>();

    public Station() {
    }

    public Station(String name, String company, String country, String province, String city, String districtCode) {
        this.name = name;
        this.company = company;
        this.country = country;
        this.province = province;
        this.city = city;
        this.districtCode = districtCode;
    }


}
