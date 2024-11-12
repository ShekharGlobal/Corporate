package com.coforge.annotation;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
/**
 * @Temporal is used to specify the type of date or time information 
 * to persist
 * @Temporal(TemporalType.DATE) maps eventDate to only store the
 *  date part (e.g., "2024-11-12").
   @Temporal(TemporalType.TIMESTAMP) maps eventTimestamp to store
    both the date and time parts (e.g., "2024-11-12 14:30:00").
 */
    @Temporal(TemporalType.DATE)
    private Date eventDate; // Only the date part will be persisted

    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimestamp; // Full date and time will be persisted

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }
}
