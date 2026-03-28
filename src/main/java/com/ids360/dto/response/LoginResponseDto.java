package com.ids360.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String requiresOrgSelection;
    private String organizations;

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", requiresOrgSelection='" + requiresOrgSelection + '\'' +
                ", organizations='" + organizations + '\'' +
                '}';
    }
}
