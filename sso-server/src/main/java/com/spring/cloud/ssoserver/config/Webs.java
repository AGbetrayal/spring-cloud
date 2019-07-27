package com.spring.cloud.ssoserver.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author AGbetrayal
 * @date 2019/7/27 8:50
 */
public class Webs {

    public static void writeJson(HttpServletResponse response, int status, Object data) {
        String json = JsonUtils.serialize(data);
        if (StringUtils.isNotEmpty(json)) {
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            try (PrintWriter writer = response.getWriter()) {
                response.setStatus(status);
                writer.write(json);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }
}
