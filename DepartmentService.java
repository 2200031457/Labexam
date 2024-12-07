package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.entity.Department;
import com.klef.jfsd.exam.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(int departmentId) {
        departmentRepository.deleteByDepartmentId(departmentId);
    }
}
