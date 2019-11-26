package test.designpattern.sevenidea.openandclose;

import org.junit.Test;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/28
 */
public class OpenAndClose {

    @Test
    public void testMethod() {
        Graphic graphic = new Graphic();
        graphic.drawShape(new Circle());
        graphic.drawShape(new Square());
    }

    class Graphic {

        public void drawShape(Shape shape) {
            shape.drawGraphic();
        }

    }

    abstract class Shape {
        abstract void drawGraphic();
    }

    class Circle extends Shape {
        @Override
        void drawGraphic() {
            System.out.println("画圆形");
        }
    }

    class Square extends Shape {
        @Override
        void drawGraphic() {
            System.out.println("画方形");
        }
    }
}
