package com.wayzim.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/6/7 18:32
 */

@Getter
@Setter
@Entity
@Table(name = "device")
@AllArgsConstructor
@ToString
public class Device implements Serializable {

    private static final long serialVersionUID = 461077349799730053L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "SortlineID")
    private Integer sortLineId;
    @Column(name = "InstallTime")
    private Date installTime;
    @Column(name = "ParentDeviceID")
    private Integer parentDeviceId;
    @Column(name = "Type")
    private Integer type;
    @Column(name = "Index")
    private Integer index;
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Column(name = "LastStateChangedTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Alisa/Shanghai")
    private Date lastStateChangedTime;
    @Column(name = "State")
    private Integer state;
    @Column(name = "StateType")
    private Integer stateType;
    @Column(name = "Remark")
    private String remark;
    private String name;
    private Date alarmTime;

    @ManyToOne
    @JoinColumn(name = "sortLineId",referencedColumnName = "id")
    private SortLine sortLine;
}
