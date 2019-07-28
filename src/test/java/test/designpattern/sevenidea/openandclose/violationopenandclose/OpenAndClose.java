package test.designpattern.sevenidea.openandclose.violationopenandclose;

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
            if(shape.shapeType == 1) {
                drawCircle();
            }else if(shape.shapeType == 2) {
                drawSquare();
            }
        }

        private void drawSquare() {
            System.out.println("画方形");
        }

        private void drawCircle() {
             System.out.println("画圆形");
        }

    }

    class Shape {
        int shapeType;
    }

    class Circle extends Shape {
        public Circle() {
            super.shapeType = 1;
        }
    }

    class Square extends Shape {
        public Square() {
            super.shapeType = 2;
        }
    }
}
