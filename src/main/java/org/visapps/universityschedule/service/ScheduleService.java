package org.visapps.universityschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.visapps.universityschedule.entity.Timetable;
import org.visapps.universityschedule.repository.*;

import javax.transaction.Transactional;

@Service
public class ScheduleService {

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    ChairRepository chairRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    LoadRepository loadRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SchedRepository schedRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TermRepository termRepository;

    @Autowired
    TimeRepository timeRepository;

    @Autowired
    WeightsRepository weightsRepository;


    @Transactional
    public void saveSchedule(Timetable timetable) {
        areaRepository.deleteAll();
        chairRepository.deleteAll();
        classRepository.deleteAll();
        holidayRepository.deleteAll();
        loadRepository.deleteAll();
        planRepository.deleteAll();
        roomRepository.deleteAll();
        schedRepository.deleteAll();
        specialityRepository.deleteAll();
        subjectRepository.deleteAll();
        teacherRepository.deleteAll();
        termRepository.deleteAll();
        timeRepository.deleteAll();
        weightsRepository.deleteAll();
        areaRepository.saveAll(timetable.getAreas());
        chairRepository.saveAll(timetable.getChairs());
        classRepository.saveAll(timetable.getClasses());
        holidayRepository.saveAll(timetable.getHolidays());
        loadRepository.saveAll(timetable.getLoads().getLoads());
        planRepository.saveAll(timetable.getPlans());
        roomRepository.saveAll(timetable.getRooms());
        schedRepository.saveAll(timetable.getScheds().getScheds());
        specialityRepository.saveAll(timetable.getSpecialities());
        subjectRepository.saveAll(timetable.getSubjects());
        teacherRepository.saveAll(timetable.getTeachers());
        termRepository.save(timetable.getTerm());
        timeRepository.saveAll(timetable.getTimes());
        weightsRepository.save(timetable.getWeights());
    }

    @Transactional
    public void saveTimes(Timetable timetable) {
        timeRepository.deleteAll();
        timeRepository.saveAll(timetable.getTimes());
    }



}
