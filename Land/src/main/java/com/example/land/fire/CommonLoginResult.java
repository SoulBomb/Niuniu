package com.example.land.fire;

import lombok.Data;

import java.util.List;

/**
 * @author wanji
 */
@Data
public class CommonLoginResult {

    private String code;

    private List<AuthAppRoles> authAppRoles;

    private User user;

    private String msg;

    @Data
    public class AuthAppRoles {
        private String code;
        private String name;
    }

    @Data
    public class User {
        private Integer id;
        private String name;
        private String orgId;
        private String orgName;
        private String tel;
    }
}
