package com.lambdaschool.schools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * This models the list of advice Slips from
 * <br><a href="https://api.adviceslip.com/advice/search/dog">https://api.adviceslip.com/advice/search/dog</a>
 * Note that this class is not an entity so will not get saved into the database.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slips
{
    /**
     * List of advice slips
     */
    private List<SlipsElement> slips;

    /**
     * Getter for the list of advice slips
     *
     * @return the list of advice slips (SlipsElement)
     */
    public List<SlipsElement> getSlips()
    {
        return slips;
    }

    /**
     * Setter for the list of advice slips
     *
     * @param slips the new list of advice slips (SlipsElement)
     */
    public void setSlips(List<SlipsElement> slips)
    {
        this.slips = slips;
    }
}
