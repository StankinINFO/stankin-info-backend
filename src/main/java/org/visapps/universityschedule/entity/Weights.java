package org.visapps.universityschedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "Weights", schema="Schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Weights {

    @Id
    @GeneratedValue
    private Integer id;

    @XmlElement(name = "UnAssignedLesson")
    private Integer unAssignedLesson;
    @XmlElement(name = "KlassWindow")
    private Integer klassWindow;
    @XmlElement(name = "KlassMaxPeriod")
    private Integer klassMaxPeriod;
    @XmlElement(name = "KlassMinPeriod")
    private Integer klassMinPeriod;
    @XmlElement(name = "KlassPeriodExtreme")
    private Integer klassPeriodExtreme;
    @XmlElement(name = "TeacherWindow")
    private Integer teacherWindow;
    @XmlElement(name = "TeacherWindowsInRow")
    private Integer teacherWindowsInRow;
    @XmlElement(name = "TeacherParallels")
    private Integer teacherParallels;
    @XmlElement(name = "TeacherSingleLesson")
    private Integer teacherSingleLesson;
    @XmlElement(name = "TeacherBuildingMove")
    private Integer teacherBuildingMove;
    @XmlElement(name = "TeacherMethodDay")
    private Integer teacherMethodDay;
    @XmlElement(name = "SanPiNJuniorSchool")
    private Integer sanPiNJuniorSchool;
    @XmlElement(name = "SanPiNSeniorSchool")
    private Integer sanPiNSeniorSchool;
    @XmlElement(name = "SanPiNHeavyLesson")
    private Integer sanPiNHeavyLesson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnAssignedLesson() {
        return unAssignedLesson;
    }

    public void setUnAssignedLesson(Integer unAssignedLesson) {
        this.unAssignedLesson = unAssignedLesson;
    }

    public Integer getKlassWindow() {
        return klassWindow;
    }

    public void setKlassWindow(Integer klassWindow) {
        this.klassWindow = klassWindow;
    }

    public Integer getKlassMaxPeriod() {
        return klassMaxPeriod;
    }

    public void setKlassMaxPeriod(Integer klassMaxPeriod) {
        this.klassMaxPeriod = klassMaxPeriod;
    }

    public Integer getKlassMinPeriod() {
        return klassMinPeriod;
    }

    public void setKlassMinPeriod(Integer klassMinPeriod) {
        this.klassMinPeriod = klassMinPeriod;
    }

    public Integer getKlassPeriodExtreme() {
        return klassPeriodExtreme;
    }

    public void setKlassPeriodExtreme(Integer klassPeriodExtreme) {
        this.klassPeriodExtreme = klassPeriodExtreme;
    }

    public Integer getTeacherWindow() {
        return teacherWindow;
    }

    public void setTeacherWindow(Integer teacherWindow) {
        this.teacherWindow = teacherWindow;
    }

    public Integer getTeacherWindowsInRow() {
        return teacherWindowsInRow;
    }

    public void setTeacherWindowsInRow(Integer teacherWindowsInRow) {
        this.teacherWindowsInRow = teacherWindowsInRow;
    }

    public Integer getTeacherParallels() {
        return teacherParallels;
    }

    public void setTeacherParallels(Integer teacherParallels) {
        this.teacherParallels = teacherParallels;
    }

    public Integer getTeacherSingleLesson() {
        return teacherSingleLesson;
    }

    public void setTeacherSingleLesson(Integer teacherSingleLesson) {
        this.teacherSingleLesson = teacherSingleLesson;
    }

    public Integer getTeacherBuildingMove() {
        return teacherBuildingMove;
    }

    public void setTeacherBuildingMove(Integer teacherBuildingMove) {
        this.teacherBuildingMove = teacherBuildingMove;
    }

    public Integer getTeacherMethodDay() {
        return teacherMethodDay;
    }

    public void setTeacherMethodDay(Integer teacherMethodDay) {
        this.teacherMethodDay = teacherMethodDay;
    }

    public Integer getSanPiNJuniorSchool() {
        return sanPiNJuniorSchool;
    }

    public void setSanPiNJuniorSchool(Integer sanPiNJuniorSchool) {
        this.sanPiNJuniorSchool = sanPiNJuniorSchool;
    }

    public Integer getSanPiNSeniorSchool() {
        return sanPiNSeniorSchool;
    }

    public void setSanPiNSeniorSchool(Integer sanPiNSeniorSchool) {
        this.sanPiNSeniorSchool = sanPiNSeniorSchool;
    }

    public Integer getSanPiNHeavyLesson() {
        return sanPiNHeavyLesson;
    }

    public void setSanPiNHeavyLesson(Integer sanPiNHeavyLesson) {
        this.sanPiNHeavyLesson = sanPiNHeavyLesson;
    }
}
