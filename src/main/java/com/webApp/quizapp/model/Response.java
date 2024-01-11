package com.webApp.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Response {
    private Integer integer;
    private String response;
}
