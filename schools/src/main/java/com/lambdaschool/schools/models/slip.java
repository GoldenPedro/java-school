package com.lambdaschool.schools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This models an advice slip from
 * <br><a href="https://api.adviceslip.com/advice">https://api.adviceslip.com/advice</a>
 * Note that this class is not an entity so will not get saved into the database.
 * To match the class name from the external source, the class must start with a lowercase letter :-(
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
public class slip
{
    /**
     * Id (Int) of this advice slip
     */
    private int id;

    /**
     * Advice (String) of this advice slip
     */
    private String advice;

    /**
     * Getter for slip id
     * @return returns the slip id (int) of this advice slip
     */
    public int getId()
    {
        return id;
    }

    /**
     * Setter for slip id
     * @param id the new slip id (int) for this advice slip
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Getter for advice
     * @return the advice (String) of this advice slip
     */
    public String getAdvice()
    {
        return advice;
    }

    /**
     * Setter for advice
     * @param advice the new advice (String) for this advice slip
     */
    public void setAdvice(String advice)
    {
        this.advice = advice;
    }
}
