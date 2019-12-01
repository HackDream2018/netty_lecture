package test.designpattern.action.interpret;

import java.util.HashMap;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 抽象表达式
 * @date: 2019/12/1
 */
public abstract class Expression {

    /**
     * 解析表达式: a + b - c
     * HashMap<String, Integer>: key为表达式参数, value为参数内容;  {a = 1, b = 2};
     * 一个表达式会对应多个解析器, 经过多个解析器的处理后得到结果
     */
    public abstract int interpret(HashMap<String, Integer> map);

}
