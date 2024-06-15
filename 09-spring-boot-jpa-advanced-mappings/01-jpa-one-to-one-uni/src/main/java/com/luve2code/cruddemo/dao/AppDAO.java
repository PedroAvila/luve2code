package com.luve2code.cruddemo.dao;

import com.luve2code.cruddemo.entity.Instructor;

public interface AppDAO {

    public void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
