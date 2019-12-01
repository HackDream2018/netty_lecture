package test.designpattern.action.interpret;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/1
 */
public class Client {
    
    public static void main(String[] args) {
        String expStr = "a+b-c";
        HashMap<String, Integer> map = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println(String.format("运算 '%s' 结果为: %s", expStr, calculator.run(map)));
    }

    /**
     * 为表达式映射属性值
     */
    public static HashMap<String, Integer> getValue(String expStr) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> values = Arrays.asList(new Integer[]{10, 2, 4});
        int valuesNumFlag = 0;
        for(char ch : expStr.toCharArray()) {
            if(('+' != ch && '-' != ch) && values.size() >= valuesNumFlag) {
                map.put(String.valueOf(ch), values.get(valuesNumFlag));
                valuesNumFlag++;
            }else {
                map.put(String.valueOf(ch), 0);
            }
        }
        return map;
    }
    
}
