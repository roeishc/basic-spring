package com.handson.basic.repo;

import com.handson.basic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public Iterable<Student> all() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }


    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Student student) {
        repository.delete(student);
    }

    public List<Student> getStudentWithSatHigherThan(Integer sat) {
        return repository.findAllBySatScoreGreaterThan(sat);
    }

    public List<Student> getStudentWithGraduationScoreGreaterThan(Double graduationScore){
        return repository.findAllByGraduationScoreGreaterThan(graduationScore);
    }

    public List<Student> getOutstandingStudents(){
        return getStudentWithGraduationScoreGreaterThan(89D).stream()
                .filter(getStudentWithSatHigherThan(699)::contains)
                .distinct()
                .collect(Collectors.toList());
    }

}
