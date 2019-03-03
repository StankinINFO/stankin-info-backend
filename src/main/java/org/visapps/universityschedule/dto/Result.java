package org.visapps.universityschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Result {

    private Boolean success;
    private String message;

    public static Result Success() {
        return new Result(true, "");
    }

    public static Result Error(String message) {
        return new Result(false, message);
    }

}
