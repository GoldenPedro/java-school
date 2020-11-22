package com.lambdaschool.schools.controllers;

import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The entry point for clients to work primary with instructors
 */
@RestController
@RequestMapping(value = "/instructors")
public class InstructorController
{
    /**
     * Connects this controller to the InstructorService
     */
    @Autowired
    private InstructorService instructorService;

    /**
     * Returns a single instructor with advice based off an instructor id number
     * <br>Example: <a href="http://localhost:2019/instructors/instructor/3/advice">http://localhost:2019/instructors/instructor/3/advice</a>
     *
     * @param instructorId The primary key of the instructor you seek
     * @return JSON object of the instructor you seek plus random advice
     * @see InstructorService#addAdvice(long) InstructorService.addAdvice(long)
     */
    @GetMapping(value = "/instructor/{instructorId}/advice",
        produces = {"application/json"})
    public ResponseEntity<?> getInstructorAdviceById(
        @PathVariable
            Long instructorId)
    {
        Instructor i = instructorService.addAdvice(instructorId);
        return new ResponseEntity<>(i,
            HttpStatus.OK);
    }

    /**
     * Returns a single instructor with advice based off an instructor id number and a search term
     * <br>Example: <a href="http://localhost:2019/instructors/instructor/3/advice/spider">http://localhost:2019/instructors/instructor/3/advice/spider</a>
     *
     * @param instructorId The primary key of the instructor you seek
     * @param searchTerm the search term for the advice sought
     * @return JSON object of the instructor you seek plus random advice
     * @see InstructorService#addAdvice(long, String) InstructorService.addAdvice(long, String)
     */
    @GetMapping(value = "/instructor/{instructorId}/advice/{searchTerm}",
        produces = {"application/json"})
    public ResponseEntity<?> getInstructorAdviceByIdandSearch(
        @PathVariable
            Long instructorId,
        @PathVariable
        String searchTerm)
    {
        Instructor i = instructorService.addAdvice(instructorId, searchTerm);
        return new ResponseEntity<>(i,
            HttpStatus.OK);
    }
}
