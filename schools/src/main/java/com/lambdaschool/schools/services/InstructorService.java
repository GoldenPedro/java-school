package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.Instructor;

/**
 * The Service that works with the Instructor Model
 */
public interface InstructorService
{
    /**
     * Returns the instructor with random advice, the given primary key.
     *
     * @param id The primary key (long) of the instructor you seek.
     * @return The given course or throws an exception if not found.
     */
    Instructor addAdvice(long id);

    /**
     * Returns the instructor with random advice, the given primary key.
     *
     * @param id The primary key (long) of the instructor you seek.
     * @param searchTerm the search term for the advice sought
     * @return The given course or throws an exception if not found.
     */
    Instructor addAdvice(long id, String searchTerm);
}
