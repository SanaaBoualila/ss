package com.example.student;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullStudentsResponse {
    private String firstName;
    private String lastName;
    private String email;
    List<School> schoolList;
}
