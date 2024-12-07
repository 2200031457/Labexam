package com.klef.jfsd.exam.repository;

import com.klef.jfsd.exam.entity.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.departmentId = ?1")
    void deleteByDepartmentId(int departmentId);
}
