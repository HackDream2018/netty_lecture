package test.designpattern.action.observe.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/24
 */
public class Client {

    public static void main(String[] args) {
        // 创建第三方网站
        Wechat wechat = new Wechat();
        // 创建气象站
        WeatherStation station = new WeatherStation(wechat);

        // 气象站推送天气给第三方网站
        station.setData(30F, 150F,40F);
        System.out.println("========天气变化后=========");
        station.setData(40F, 160F,50F);
    }

}
