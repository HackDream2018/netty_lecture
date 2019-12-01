package test.designpattern.action.interpret;

import java.util.HashMap;
import java.util.Stack;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 计算器控制中心
 * @date: 2019/12/1
 */
public class Calculator {
    /**
     * 定义表达式
     */
    private Expression expression;
    /**
     * @param expStr: a+b-c
     */
    public Calculator(String expStr) {
        // 利用栈的数据结构, 安排好运算先后顺序
        Stack<Expression> stack = new Stack<>();
        // ['a', '+', 'b', '-', 'c']
        char[] expArrays = expStr.toCharArray();
        Expression left = null;
        Expression right = null;
        // 映射表达式的属性值
        for (int i = 0; i < expArrays.length; i++) {
            switch(expArrays[i]) {
                case '+': // 加表达式解析器对象 left和right
                    // 从栈顶部删除且返回对象
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(expArrays[++i]));
                    stack.push(new SymbolAddExpression(left, right));
                    break;
                case '-':// 减表达式解析器对象 left和right
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(expArrays[++i]));
                    stack.push(new SymbolSubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(expArrays[i])));
            }
        }
        // 最终的表达式解析器是最后一个符号的 左右变量表达式对象
        this.expression = stack.pop();
    }
    /**
     * 将表达式交给解析器去解析
     */
    public int run(HashMap<String, Integer> map) {
        return this.expression.interpret(map);
    }
}
