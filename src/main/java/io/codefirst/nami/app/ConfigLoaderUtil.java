package io.codefirst.nami.app;

public interface ConfigLoaderUtil {

    static String getProperty(String key) {
        return SpringContext.getAppContext().getEnvironment().getProperty(key);
    }
}