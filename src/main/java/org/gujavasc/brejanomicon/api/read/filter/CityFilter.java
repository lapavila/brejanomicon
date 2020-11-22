package org.gujavasc.brejanomicon.api.read.filter;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityFilter {
    private String name;
    private Boolean capital;
    private String stateAbbreviation;
}
