package org.gaurav.insurance.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    private String description;

    private Double premiumAmount;

    private Integer duration;

    private String type;

    @ManyToMany(mappedBy = "policies")
    private List<User> users;


}
