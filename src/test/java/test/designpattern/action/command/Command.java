package test.designpattern.action.command;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/13
 */
public interface Command {

    void execute();
    /**
     * 回退命令
     */
    void undo();

}
