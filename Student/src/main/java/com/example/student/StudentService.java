package com.example.student;

import com.example.student.client.SchoolClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolClient schoolClient;

    public void saveStudent(Student std) {
        studentRepository.save(std);
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public FullStudentsResponse findStudentsWithSchools(Integer studentId){
        var student = studentRepository.findById(studentId)
                .orElse(
                        Student.builder()
                                .firstName("NOT_FOUND")
                                .lastName("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        //find all the students from the student microService
        var schools = schoolClient.findAllSchoolByStudent(studentId);
        return FullStudentsResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .schoolList(schools)
                .build();
    }













    public void deleteStudents(Integer id){
        studentRepository.deleteById(id);
    }
}
