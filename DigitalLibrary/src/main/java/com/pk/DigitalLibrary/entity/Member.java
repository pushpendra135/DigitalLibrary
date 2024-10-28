package com.pk.DigitalLibrary.entity;

import com.pk.DigitalLibrary.enums.SubscriptionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class Member {

    @Id
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobileNumber;
    private SubscriptionStatus subscriptionStatus;

}
