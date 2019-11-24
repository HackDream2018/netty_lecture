package test.designpattern.action.observe;

import java.util.ArrayList;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/24
 */
public class Client {
    
    public static void main(String[] args) {
        // 创建具体观察者
        Wechat wechat = new Wechat();
        CSDN csdn = new CSDN();

        // 观察者气象站
        WeatherStation station = new WeatherStation(new ArrayList<>());
        station.registerObserver(wechat);
        station.registerObserver(csdn);
        station.setData(30F, 150F,40F);
        System.out.println("========天气变化后群推=========");
        station.setData(40F, 160F,50F);
        System.out.println("========移除微信后群推=========");
        station.removeObserver(wechat);
        station.setData(40F, 160F,50F);

       /* 微信端 今天温度: 30.0
        微信端 今天气压: 150.0
        微信端 今天湿度: 40.0
        CSDN 今天温度: 30.0
        CSDN 今天气压: 150.0
        CSDN 今天湿度: 40.0
                ========天气变化后群推=========
        微信端 今天温度: 40.0
        微信端 今天气压: 160.0
        微信端 今天湿度: 50.0
        CSDN 今天温度: 40.0
        CSDN 今天气压: 160.0
        CSDN 今天湿度: 50.0
                ========移除微信后群推=========
        CSDN 今天温度: 40.0
        CSDN 今天气压: 160.0
        CSDN 今天湿度: 50.0*/
    }
    
}
