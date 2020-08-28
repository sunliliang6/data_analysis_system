package com.wayzim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author SunLiLiang
 * @version 1.0
 * @date 2020/3/23
 */
@Entity
@Table(name = "alarm_record")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class AlarmRecord implements Serializable {
    private static final long serialVersionUID = -5771271845194789709L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AlarmTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alarmTime;
    @Column(name = "SortlineId")
    private String sortLineId;
    @Column(name = "DeviceID")
    private Integer deviceId;
    @Column(name = "ErrorCode")
    private String errorCode;
    @Column(name = "Type")
    private int type;
    @Column(name = "Remark")
    private Long alarmCount;
    private String name;
    private Long stationCount;
    private Long sortLineCount;


    @ManyToOne
    @JoinColumn(name = "SortlineId", referencedColumnName = "SortLineCode", insertable = false, updatable = false)
    private SortLine sortLine;

    public AlarmRecord() {
    }


    public AlarmRecord( Date alarmTime, String sortLineId, Integer deviceId, String errorCode, Integer type) {
        this.alarmTime = alarmTime;
        this.sortLineId = sortLineId;
        this.deviceId = deviceId;
        this.errorCode = errorCode;
        this.type = type;
    }

}
