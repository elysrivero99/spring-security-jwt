package com.elys.jwt.security;

import com.elys.jwt.security.exceptions.MyAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Elys Javier Rivero
 *
 * @since 09/04/17
 */
@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    //FIXME: Temporal X_APP_IDs
    private List<String> ids = Collections.singletonList("ABCD");

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        CustomAuthenticationBean customAuthenticationBean = (CustomAuthenticationBean) usernamePasswordAuthenticationToken;

        if (!StringUtils.isEmpty(customAuthenticationBean.getxAppId()) && ids.contains(customAuthenticationBean.getxAppId())) {
            AuthenticatedUser authenticatedUser;

            //TODO: GET idUser from JWT
            authenticatedUser = new AuthenticatedUser(100);

            return authenticatedUser;
        } else {
            throw new MyAuthenticationException("X-APP-ID, not valid");
        }

    }
}
