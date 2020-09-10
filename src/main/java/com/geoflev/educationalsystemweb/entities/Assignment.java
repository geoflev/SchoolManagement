package com.geoflev.educationalsystemweb.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;
    @NotBlank(message = "Assignment code is required")
    private String assignmentCode;
    @Lob
    private byte[] fileData;
    @NotBlank(message = "Course code is required")
    private LocalDateTime dateTimePosted;
    private String description;
    private String courseCode;

    public Assignment() {
    }

    public Assignment(Long assignmentId, String assignmentCode, byte[] fileData, LocalDateTime dateTimePosted, String description, String courseCode) {
        this.assignmentId = assignmentId;
        this.assignmentCode = assignmentCode;
        this.fileData = fileData;
        this.dateTimePosted = dateTimePosted;
        this.description = description;
        this.courseCode = courseCode;
    }


    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public LocalDateTime getDateTime() {
        return dateTimePosted;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTimePosted = dateTimePosted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
