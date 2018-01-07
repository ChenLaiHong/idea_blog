package com.ch.utils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * Created by 赖红 on 2017/12/27.
 */
public class DateJsonValueProcessor implements JsonValueProcessor {
    private String format = "yyyy-MM-dd";
    public DateJsonValueProcessor() {

    }

    public DateJsonValueProcessor(String format) {
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return null;
    }

    @Override
    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return null;
    }
}
