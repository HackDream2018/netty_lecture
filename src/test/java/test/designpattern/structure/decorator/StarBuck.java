package test.designpattern.structure.decorator;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/8
 */
public class StarBuck {
    
    public static void main(String[] args) {
        // 一杯无因咖啡
        AbsDrink decafCoffeeDrink = new DecafCoffee();
        System.out.println("费用 = " + decafCoffeeDrink.calculateCost());
         System.out.println("描述 =" + decafCoffeeDrink.getDescription());
        // 一杯无因咖啡 + 牛奶
        decafCoffeeDrink = new Milk(decafCoffeeDrink);
        System.out.println("加入一份牛奶后 费用 = " + decafCoffeeDrink.calculateCost());
        System.out.println("加入一份牛奶后 描述 =" + decafCoffeeDrink.getDescription());
        // 一杯无因咖啡 + 牛奶 + 白糖
        decafCoffeeDrink = new Sugar(decafCoffeeDrink);
        System.out.println("加入一份牛奶+白糖后 费用 = " + decafCoffeeDrink.calculateCost());
        System.out.println("加入一份牛奶+白糖后 描述 =" + decafCoffeeDrink.getDescription());
    }
    
}
