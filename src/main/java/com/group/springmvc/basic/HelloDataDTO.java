package com.group.springmvc.basic;

import lombok.Data;

@Data //getter, setter, toString, equalsAndHash, requiredArgsConstructor 를 포함.
public class HelloDataDTO {
    private String username;
    private int age;

    public HelloDataDTO() {
    }

    public HelloDataDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
