package com.elys.jwt.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by Elys Javier Rivero
 *
 * @since 09/04/17
 */
public class CustomAuthenticationBean extends UsernamePasswordAuthenticationToken {

    private String xAppId;
    private String token;

    public CustomAuthenticationBean(String xAppId, String token) {
        super(null, null);
        this.xAppId = xAppId;
        this.token = token;
    }

    public CustomAuthenticationBean(String xAppId) {
        super(null, null, null);
        this.xAppId = xAppId;
    }

    public String getxAppId() {
        return xAppId;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomAuthenticationBean{");
        sb.append("xAppId='").append(xAppId).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
