package william.fission.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

    public static String writeAsString(Object value) {
        Objects.requireNonNull(value);
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            logger.error("write value error:" + value.getClass(), e);
            throw new RuntimeException("JacksonUtils:convert type:" + value.getClass().getName() + " to string error");
        }
    }

    public static <T> T readValue(String value, Class<T> clazz) {
        Objects.requireNonNull(value);
        try {
            return objectMapper.readValue(value, clazz);
        } catch (IOException e) {
            logger.error("read value error:" + clazz.getName(), e);
            throw new RuntimeException("JacksonUtils:read value:" + value + " error");
        }
    }

    public static <T> T readValue(URL url, Class<T> clazz) {
        Objects.requireNonNull(url);
        try {
            return objectMapper.readValue(url, clazz);
        } catch (IOException e) {
            logger.error("read value error:" + clazz.getName(), e);
            throw new RuntimeException("JacksonUtils:read url:" + url + " error");
        }
    }

    public static <T> T readValue(URL value, TypeReference valueTypeRef) {
        Objects.requireNonNull(value);
        try {
            return objectMapper.readValue(value, valueTypeRef);
        } catch (IOException e) {
            logger.error("read value error:" + valueTypeRef.getType().getTypeName(), e);
            throw new RuntimeException("JacksonUtils:read value:" + value + " error");
        }
    }
    public static <T> T readValue(String value, TypeReference valueTypeRef) {
        Objects.requireNonNull(value);
        try {
            return objectMapper.readValue(value, valueTypeRef);
        } catch (IOException e) {
            logger.error("read value error:" + valueTypeRef.getType().getTypeName(), e);
            throw new RuntimeException("JacksonUtils:read value:" + value + " error");
        }
    }
}
