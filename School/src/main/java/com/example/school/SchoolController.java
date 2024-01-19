package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {



        private final SchoolService service;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void save (@RequestBody School std){
            service.saveSchool(std);
        }

        @GetMapping
        public ResponseEntity<List<School>> findAllSchools(){
            return ResponseEntity.ok(service.findAllSchools());
        }
        //ResponseEntity allows you to control the HTTP response, including status codes and headers.
        //ResponseEntity.ok(service.findAllStudents()): This line returns a ResponseEntity with a status
        // code of 200 (OK) and the list of students retrieved from the service as the response body.


        @GetMapping("/with-students/{school-id}") //get school with all students
        public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable("school-id") Integer schoolId){

            return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
    }

}
