package org.infinity.passport.utils;

import java.net.URLEncoder;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import org.infinity.passport.config.ApplicationConstants;

@Component
public class HttpHeaderCreator {

    @Autowired
    private MessageSource messageSource;

    public HttpHeaders createSuccessHeader(String code, Object... args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Success-Message", getMessage(code, args));
        return headers;
    }

    public HttpHeaders createWarnHeader(String code, Object... args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Warn-Code", code);
        headers.add("X-Warn-Message", getMessage(code, args));
        return headers;
    }

    public HttpHeaders createErrorHeader(String code, Object... args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Error-Code", code);
        headers.add("X-Error-Message", getMessage(code, args));
        return headers;
    }

    private String getMessage(String code, Object... args) {
        String message = messageSource.getMessage(code, args, ApplicationConstants.SYSTEM_LOCALE);

        try {
            message = URLEncoder.encode(message, CharEncoding.UTF_8);
        }
        catch (Exception ex) {
            throw new RuntimeException("Cannot find the message code from message source properties.");
        }
        return message;
    }
}
