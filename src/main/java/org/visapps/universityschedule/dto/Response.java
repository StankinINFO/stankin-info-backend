package org.visapps.universityschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Response {

    private Boolean success;
    private Integer total;
    private List<?> results;

    public static Response Success(List<?> results) {
        return new Response(true, results.size(), results);
    }

    public static Response Error() {
        return new Response(false, 0, new ArrayList<>());
    }
}
