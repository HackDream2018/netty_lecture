package test.designpattern.action.observe;

import java.util.ArrayList;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/24
 */
public class WeatherStation implements Subject{

    /**
     * 温度
     */
    private Float temperature;

    /**
     * 气压
     */
    private Float pressure;

    /**
     * 湿度
     */
    private Float humidity;

    /**
     * 被观察者容器
     */
    private ArrayList<Observer> observers = new ArrayList<>();

    public WeatherStation(ArrayList<Observer> observer) {
        this.observers.addAll(observer);
    }

    /**
     * 将最新天气数据推送给第三方网站
     */
    public void setData(Float temperature, Float pressure, Float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    private void dataChange() {
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(getTemperature(), getPressure(), getHumidity());
        }
    }

    private Float getTemperature() {
        return temperature;
    }

    private Float getPressure() {
        return pressure;
    }

    private Float getHumidity() {
        return humidity;
    }
}
