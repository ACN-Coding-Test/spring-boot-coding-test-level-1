package com.codejam.demo.dto;

import com.codejam.demo.model.PersonalInformationEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Getter
@Setter
public class PersonalInformationDto {

    private Integer id;

    @Min(value = 1, message = "todo id should not be less than 1")
    @JsonProperty("todo_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer todoId;

    @Pattern(regexp = "^[^<>%$@#]*$", message = "Real Name should not be contains special characters")
    @NotEmpty(message = "Real Name should not be empty")
    @NotNull(message = "Real Name should not be null")
    @JsonProperty("real_name")
    private String realName;

    @Pattern(regexp = "^[^<>%$@#]*$", message = "Idol Name should not be contains special characters")
    @NotEmpty(message = "Idol Name should not be empty")
    @NotNull(message = "Idol Name should not be null")
    @JsonProperty("idol_name")
    private String idolName;

    @JsonProperty(value = "address")
    private String dateTime;

    @JsonProperty(value = "idol_status")
    private String idolStatus;

    public PersonalInformationEntity toEntity() {
        PersonalInformationEntity entity = new PersonalInformationEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }

}
