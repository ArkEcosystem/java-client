package org.arkecosystem.client.http;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class DotHelper {
    public static Map<String, String> toDot(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return Collections.emptyMap();
        }
        return toDot(params, new LinkedHashMap<>(), "");
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String> toDot(
            Map<String, Object> params, Map<String, String> accum, String prepend) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof Map) {
                accum.putAll(
                        toDot(
                                (Map<String, Object>) entry.getValue(),
                                accum,
                                prepend + entry.getKey() + "."));
            } else if (entry.getValue() instanceof List) {
                Map<String, Object> stringObjectMap =
                        listAsMapWithNumericKeys((List<?>) entry.getValue());
                toDot(stringObjectMap, accum, prepend + entry.getKey() + ".");
            } else if (entry.getValue() != null) {
                accum.put(prepend + entry.getKey(), entry.getValue().toString());
            }
        }
        return accum;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> listAsMapWithNumericKeys(List<?> params) {
        Map<String, Object> result = new LinkedHashMap<>();

        int i = 0;
        for (Object item : (List<?>) params) {
            result.put(String.valueOf(i++), item);
        }

        return result;
    }
}
