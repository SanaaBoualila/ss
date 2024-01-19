package com.example.student.client;

import com.example.student.School;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "school-service", url = "${application.config.schools-url}")

public interface SchoolClient {
    @GetMapping("/student/{student-id}")
    List<School> findAllSchoolByStudent(@PathVariable("student-id") Integer studentId);

}
