package com.microservice.employeeservice.model;

public record Employee(Long id, Long depId, String name, int age, String position) {

}
