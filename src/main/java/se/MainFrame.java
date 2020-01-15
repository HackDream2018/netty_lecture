package se;

import javax.swing.*;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/1/9
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(500, 450);//设置窗口大小
        setTitle("我是窗口");//设置标题
        ImageIcon imageIcon = new ImageIcon("image/icon.png");
        setIconImage(imageIcon.getImage());//设置图片
        this.setLayout(null);//设置里面控件的布局方式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置点击关闭对出程序
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);//显示窗口
    }
}