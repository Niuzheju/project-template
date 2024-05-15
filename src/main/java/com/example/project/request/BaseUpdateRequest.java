package com.example.project.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseUpdateRequest {

    private Long id;
    private Long adminId;
    private String username;


}
