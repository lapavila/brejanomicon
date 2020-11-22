package org.gujavasc.brejanomicon.api.model;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class State {
    private Long id;
    private String abbreviation;
    private String name;
}
