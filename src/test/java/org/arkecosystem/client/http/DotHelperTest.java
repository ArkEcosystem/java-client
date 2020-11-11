package org.arkecosystem.client.http;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DotHelperTest {

    @Test
    void toDot() {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("q", "query");
            put("number", 4);
            put("address", new HashMap<String, Object>() {{
                put("street", "7 Michigan St");
                put("city", "Jersey");
            }});
            put("level1", new HashMap<String, Object>() {{
                put("level2", new HashMap<String, Object>() {{
                    put("level3", "value");
                }});
            }});
        }};

        Map<String, String> newMap = DotHelper.toDot(map);
        System.out.println(newMap);
        assertEquals("query", newMap.get("q"));
        assertEquals("4", newMap.get("number"));
        assertEquals("7 Michigan St", newMap.get("address.street"));
        assertEquals("Jersey", newMap.get("address.city"));
        assertEquals("value", newMap.get("level1.level2.level3"));
    }
}
