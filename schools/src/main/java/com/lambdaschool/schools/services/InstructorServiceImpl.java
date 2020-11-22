package com.lambdaschool.schools.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.models.Slips;
import com.lambdaschool.schools.models.SlipsElement;
import com.lambdaschool.schools.models.slip;
import com.lambdaschool.schools.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service("instructorService")
/**
 * Implements the InstructorService
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstructorServiceImpl implements InstructorService
{
    /**
     * Connects this service to the Instructor table.
     */
    @Autowired
    private InstructorRepository instructorrepos;

    @Override
    public Instructor addAdvice(long id)
    {
        Instructor updatedInstructor = instructorrepos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor id " + id + " not found!"));

        /**
         * Creates the object that is needed to do a client side Rest API call.
         * We are the client getting data from a remote API.
         */
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        // create the url to access the country data
        String requestURL = "https://api.adviceslip.com/advice";
        // create the responseType expected. Notice the slip is the data type we are expecting back from the API!
        ParameterizedTypeReference<slip> responseType = new ParameterizedTypeReference<>()
        {
        };
        // create the response entity. do the get and get back information
        ResponseEntity<slip> responseEntity = restTemplate.exchange(requestURL,
            HttpMethod.GET,
            null,
            responseType);
        // now that we have our data, put it into our object!
        slip slipobj = responseEntity.getBody();

        updatedInstructor.setAdvice(slipobj.getAdvice());

        return updatedInstructor;
    }
    @Override
    public Instructor addAdvice(
        long id,
        String searchTerm)
    {
        Instructor updatedInstructor = instructorrepos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor id " + id + " not found!"));

        /**
         * Creates the object that is needed to do a client side Rest API call.
         * We are the client getting data from a remote API.
         */
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        // create the url to access the country data
        String requestURL = "https://api.adviceslip.com/advice/search/" + searchTerm;
        // create the responseType expected. Notice the slip is the data type we are expecting back from the API!
        ParameterizedTypeReference<Slips> responseType = new ParameterizedTypeReference<>()
        {
        };
        // create the response entity. do the get and get back information
        ResponseEntity<Slips> responseEntity = restTemplate.exchange(requestURL,
            HttpMethod.GET,
            null,
            responseType);
        // now that we have our data, put it into our object!
        SlipsElement slipsElement = responseEntity.getBody().getSlips().get(0);

        updatedInstructor.setAdvice(slipsElement.getAdvice());

        return updatedInstructor;
    }
}