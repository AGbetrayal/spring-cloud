package com.spring.cloud.ssoserver.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * JSON Utils
 *
 * @author kevin
 * @date 2018-07-17 14:48
 */
public final class JsonUtils {

    public static final String IGNORE_ENTITY_SERIALIZE_FIELD_FILTER_ID = "fieldFilter";

    public static final String HANDLER = "handler";

    public static final String HIBERNATE_LAZY_INITIALIZER = "hibernateLazyInitializer";

    private static ObjectMapper mapper;

    private static ObjectMapper getMapper() {
        if (Objects.isNull(mapper)) {
            synchronized (JsonUtils.class) {
                if (Objects.isNull(mapper)) {
                    mapper = new ObjectMapper();
                    configure(mapper, true);
                }
            }
        }
        return mapper;
    }

    public static void configure(ObjectMapper om) {
        configure(om, false);
    }

    public static void configure(ObjectMapper om, boolean disableAnnotation) {
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter(IGNORE_ENTITY_SERIALIZE_FIELD_FILTER_ID,
                SimpleBeanPropertyFilter.serializeAllExcept(HANDLER, HIBERNATE_LAZY_INITIALIZER));
        om.setFilterProvider(filterProvider);
    }

    private static ObjectMapper indentMapper;

    private static ObjectMapper getIndentMapper() {
        if (Objects.isNull(indentMapper)) {
            synchronized (JsonUtils.class) {
                if (Objects.isNull(indentMapper)) {
                    indentMapper = new ObjectMapper();
                    indentMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    configure(indentMapper, true);
                }
            }
        }
        return indentMapper;
    }

    /**
     * 将对象序列化为JSON string.
     *
     * @param obj obj
     * @return json str
     */
    public static String serialize(Object obj) {
        return serialize(obj, false);
    }

    /**
     * 将对象序列化为 JSON string
     *
     * @param obj    obj
     * @param indent indent
     * @return json str
     */
    public static String serialize(Object obj, boolean indent) {
        if (Objects.isNull(obj)) {
            return null;
        }
        ObjectMapper mapper = indent ? getIndentMapper() : getMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json 字符串反序列化为对象
     *
     * @param json  json str
     * @param clazz Class
     * @param <T>   T
     * @return T
     */
    public static <T> T deserialize(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper mapper = getMapper();
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json 字符串反序列化为对象集合
     *
     * @param <T>   T
     * @param json  json str
     * @param clazz class
     * @return 序列化的List
     */
    public static <T> List<T> deserializeList(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper mapper = getMapper();
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化json 字符串到对象
     * 二级泛型: 如：JsonResult<List<SysUser>>
     *
     * @return 序列化的对象
     */
    public static <T> T deserialize(String json, Class<T> rawType, Class<?> parametrized, Class<?> parameterClasses) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper mapper = getMapper();
        try {
            JavaType type = mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(rawType, type));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
