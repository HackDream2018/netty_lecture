package test.designpattern.action.command;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 空命令用于初始化所有按钮
 * @date: 2019/10/13
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {

    }
}
