package org.gujavasc.brejanomicon.api.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brewery {
    private Long id;
    private String name;
    private String description;
    private String story;
    private String email;
    private String phone;
    private String website;
    private String address;
    private String postalCode;
    private City city;
}
