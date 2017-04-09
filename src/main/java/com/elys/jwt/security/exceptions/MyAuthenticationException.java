package com.elys.jwt.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Elys Javier Rivero
 *
 * @since 09/04/17
 */
public class MyAuthenticationException extends AuthenticationException {
    public MyAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public MyAuthenticationException(String msg) {
        super(msg);
    }
}
