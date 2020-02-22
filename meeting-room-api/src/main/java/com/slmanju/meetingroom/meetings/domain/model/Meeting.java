package com.slmanju.meetingroom.meetings.domain.model;

import com.slmanju.meetingroom.rooms.domain.model.Room;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data @NoArgsConstructor
@Entity
@Table(name = "meetings")
public class Meeting implements Serializable {

	private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "notes")
    private String notes;

    @Column(name = "meeting_date")
    private String meetingDate;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

}
