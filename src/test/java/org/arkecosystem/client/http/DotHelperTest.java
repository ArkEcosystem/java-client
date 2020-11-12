package org.arkecosystem.client.http;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DotHelperTest {

    @Test
    void hierarchiesToDot() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("address", new HashMap<String, Object>() {{
                put("street", "7 Michigan St");
                put("city", "Jersey");
            }});
            put("level1", new HashMap<String, Object>() {{
                put("level2", new HashMap<String, Object>() {{
                    put("level3", "value");
                }});
            }});
            put("nulls", null);
        }};

        Map<String, String> newMap = DotHelper.toDot(map);

        assertEquals("7 Michigan St", newMap.get("address.street"));
        assertEquals("Jersey", newMap.get("address.city"));
        assertEquals("value", newMap.get("level1.level2.level3"));
    }

    @Test
    void nullValueToDot() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("nulls", null);
        }};

        Map<String, String> newMap = DotHelper.toDot(map);

        assertNull(newMap.get("nulls"));
    }

    @Test
    void stringValueToDot() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("q", "query");
        }};

        Map<String, String> newMap = DotHelper.toDot(map);

        assertEquals("query", newMap.get("q"));
    }

    @Test
    void integerValueToDot() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("number", 4);
        }};

        Map<String, String> newMap = DotHelper.toDot(map);

        assertEquals("4", newMap.get("number"));
    }

    @Test
    void listToDot() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("addresses", new ArrayList<Object>() {{
                add(new HashMap<String, Object>() {{
                    put("street", "7 Michigan St");
                    put("city", "Jersey");
                }});
                add(new HashMap<String, Object>() {{
                    put("street", "29A Harold Ln");
                    put("city", "Manhattan");
                }});
            }});
        }};

        Map<String, String> newMap = DotHelper.toDot(map);

        assertEquals("7 Michigan St", newMap.get("addresses.0.street"));
        assertEquals("Jersey", newMap.get("addresses.0.city"));

        assertEquals("29A Harold Ln", newMap.get("addresses.1.street"));
        assertEquals("Manhattan", newMap.get("addresses.1.city"));
    }
}
