package com.linksharing.dto;


/**
 * Created by karan on 13/7/17.
 */
public class ResourceRatingDTO {

   private ResourceDTO resourceDTO;
    private UserDTO userDTO;
    private Integer score;

    public ResourceDTO getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(ResourceDTO resourceDTO) {
        this.resourceDTO = resourceDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
