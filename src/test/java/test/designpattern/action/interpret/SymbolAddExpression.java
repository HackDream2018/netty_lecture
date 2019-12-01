package test.designpattern.action.interpret;

import java.util.HashMap;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 加法符号表达式解析器
 * @date: 2019/12/1
 */
public class SymbolAddExpression extends SymbolExpression {

    public SymbolAddExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * 重写父类的解析方法
     *  进行相加操作   HashMap<String, Integer>: key为表达式参数, value为参数内容;  {a = 1, b = 2}
     */
    @Override
    public int interpret(HashMap<String, Integer> map) {
        // super.left.interpret(map): 返回left 变量表达式对应的 a = 1
        // super.right.interpret(map): right 变量表达式对应的 b = 2
        return super.left.interpret(map) + super.right.interpret(map);
    }

}
