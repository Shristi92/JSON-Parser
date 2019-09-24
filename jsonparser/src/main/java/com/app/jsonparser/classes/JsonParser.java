package com.app.jsonparser.classes;

import com.app.jsonparser.interfaces.JSONField;
import com.app.jsonparser.interfaces.JSONItem;
import com.app.jsonparser.utils.Mapper;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Date;

public class JsonParser {

    public static <T> T parseJSONObject (JSONObject jObj, Class className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(className.isAnnotationPresent(JSONItem.class)) {

            T item = (T) Class.forName(className.getName()).newInstance();

            for (Field f : className.getDeclaredFields()) {

                f.setAccessible(true);

                JSONField jf = f.getAnnotation(JSONField.class);
                String name = jf.value();
                Class<?> fType = f.getType();

                if (String.class.equals(fType)) {
                    f.set(item, Mapper.setStringValueToData(jObj, name));
                } else if (Integer.class.equals(fType)) {
                    f.set(item, Mapper.setIntValueToData(jObj, name));
                } else if (Date.class.equals(fType)) {
                    f.set(item, Mapper.setDateValueToData(jObj, name));
                }
            }

            return item;

        }

        return null;
    }


}
