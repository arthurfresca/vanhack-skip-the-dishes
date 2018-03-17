package com.skipthedishes.datatransferobject.v1;

import javax.validation.constraints.NotNull;

public class AuthDTO {
    @NotNull(message = "Email can not be null!")
    private String email;

    @NotNull(message = "Password can not be null!")
    private String password;

    private AuthDTO() {
    }

    public AuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
