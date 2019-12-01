package test.designpattern.action.interpret;

import java.util.HashMap;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 符号解析器: 运算符...
 * @date: 2019/12/1
 */
public class SymbolExpression extends Expression{

    /**
     * 每个运算符只与符号两侧的变量有关;
     * 但无论是以变量表达式还是其他表达式, 均为Expression的子类(依赖倒转);
     */
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 由子类去实现
     */
    @Override
    public int interpret(HashMap<String, Integer> map) {
        throw new UnsupportedOperationException();
    }

}
