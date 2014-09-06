package com.goeuro.test.converter;


import com.goeuro.test.model.GeoObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

public final class JsonToObjectConverter {
    private JsonToObjectConverter(){}

    public static List<GeoObject> convert(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, GeoObject.class));
    }
}
