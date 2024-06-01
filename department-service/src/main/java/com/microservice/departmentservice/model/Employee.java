package com.microservice.departmentservice.model;

public record Employee(Long id, Long depId, String name, int age, String position) {

}
