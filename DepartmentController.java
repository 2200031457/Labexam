package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.entity.Department;
import com.klef.jfsd.exam.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Insert a department
    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    // Delete a department by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") int id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok("Department with ID " + id + " deleted successfully.");
    }
}
