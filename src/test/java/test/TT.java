package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/6/27
 */
public class TT {

    public static void main(String[] args)throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("1");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }

    }

}
