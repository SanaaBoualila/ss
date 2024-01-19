package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {



        private final StudentService service;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void save (@RequestBody Student std){
            service.saveStudent(std);
        }

        @GetMapping
        public ResponseEntity<List<Student>> findAllStudents(){

            return ResponseEntity.ok(service.findAllStudents());
        }
        //ResponseEntity allows you to control the HTTP response, including status codes and headers.
        //ResponseEntity.ok(service.findAllStudents()): This line returns a ResponseEntity with a status
        // code of 200 (OK) and the list of students retrieved from the service as the response body.

        @DeleteMapping("{id}")
        public void deleteStudents(@PathVariable int id){
            service.deleteStudents(id);
        }


    @GetMapping("/with-schools/{student-id}")
    public ResponseEntity<FullStudentsResponse> findAllStudents(@PathVariable("student-id") Integer studentId){

        return ResponseEntity.ok(service.findStudentsWithSchools(studentId));
    }











}
