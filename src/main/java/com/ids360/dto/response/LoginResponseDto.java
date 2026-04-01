    package com.ids360.dto.response;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

        import java.util.List;
    import com.ids360.entity.UserOrganizationRole;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class LoginResponseDto {

        private String userId;
        private String email;
        private String firstName;
        private String lastName;
        private boolean requiresOrgSelection;
        private List<UserOrganizationRole> organizations;

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
