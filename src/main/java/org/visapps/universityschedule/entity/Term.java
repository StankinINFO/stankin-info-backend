package org.visapps.universityschedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "terms")
@Getter
@Setter
@AllArgsConstructor
public class Term {

    @Id
    String id;

    String value;

}
