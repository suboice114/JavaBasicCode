package JavaDesignPatterns.Factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂类
 */
public class StaticFactory {

    private static Map<String,Car> map = new HashMap<String,Car>();

    static {
        map.put("aodi", new Car("Aodi", 500000));
        map.put("baoma", new Car("Baoma",300000));
    }
    private StaticFactory() {
    }

    public static Car getCar(String name) {
        return map.get(name);
    }
}
