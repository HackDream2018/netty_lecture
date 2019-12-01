package test.designpattern.action.interpret;

import java.util.HashMap;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 变量表达式解析器
 * @date: 2019/12/1
 */
public class VarExpression extends Expression{

    /**
     * key = a, = b
     */
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * 解析表达式参数返回对应的参数内容
     * 解析某个参数后的结果为具体值比如 参数a=1就返回1
     */
    @Override
    public int interpret(HashMap<String, Integer> map) {
        return map.get(this.key);
    }
}
