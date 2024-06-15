package com.luve2code.cruddemo.dao;

import com.luve2code.cruddemo.entity.Instructor;
import com.luve2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    public void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
