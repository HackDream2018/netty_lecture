package test.designpattern.action.command;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/13
 */
public class Client {
    
    public static void main(String[] args) {
        // 遥控器
        RemoteControllerInvoke remoteController = new RemoteControllerInvoke();
        // ===========================电视===============================
        // 创建电视执行对象
        TVReceiver tvReceiver = new TVReceiver();
        // 电视执行对象与具体命令进行绑定
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        // 为遥控器上的智能家居绑定命令(no: 0-电视; 1-空调)
        int tvNo = 0;
        remoteController.setComand(tvNo, tvOnCommand, tvOffCommand);
        System.out.println("---------按下打开电视的按钮---------");
        remoteController.onButton(tvNo);// 电视机打开了
        System.out.println("---------按下关闭电视的按钮---------");
        remoteController.offButton(tvNo);// 电视机关闭了
        System.out.println("---------按下撤销的按钮---------");
        remoteController.undoButton(tvNo);// 电视机打开了
        // ===========================空调===============================
        int airConditioningNo = 1;
        AirConditioningReceiver airConditioningReceiver = new AirConditioningReceiver();
        AirConditioningOnCommand airConditioningOnCommand = new AirConditioningOnCommand(airConditioningReceiver);
        AirConditioningOffCommand airConditioningOffCommand = new AirConditioningOffCommand(airConditioningReceiver);
        remoteController.setComand(airConditioningNo, airConditioningOnCommand, airConditioningOffCommand);
        System.out.println("---------按下打开空调的按钮---------");
        remoteController.onButton(airConditioningNo);
        System.out.println("---------按下关闭空调的按钮---------");
        remoteController.offButton(airConditioningNo);
        System.out.println("---------按下撤销的按钮---------");
        remoteController.undoButton(airConditioningNo);
    }
    
}
