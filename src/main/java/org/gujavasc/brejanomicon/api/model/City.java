package org.gujavasc.brejanomicon.api.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Long id;
    private String name;
    private Boolean capital;
    private State state;
}
