package test.hashmap;

import java.util.regex.Pattern;

/**
 * hash值相同会存在同一个桶里
 * hashCode方法故意将所有数字字符串key的hash值返回1，其他字符串key的hash值返回2
 */
public class MapKey {

    private static final String REG = "[0-9]+";

    private String key;

    public MapKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKey mapKey = (MapKey) o;

        return !(key != null ? !key.equals(mapKey.key) : mapKey.key != null);

    }

    @Override
    public int hashCode() {
        if (key == null)
            return 0;
        Pattern pattern = Pattern.compile(REG);
        if (pattern.matcher(key).matches())
            return 1;
        else
            return 2;
    }

    @Override
    public String toString() {
        return key;
    }
}