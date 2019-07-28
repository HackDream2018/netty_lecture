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
        graphic.drawShap(new Circle());
        graphic.drawShap(new Square());
    }

    class Graphic {

        public void drawShap(Shape shape) {
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
