import org.example.*;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.util.List;

public class ShapeTest {
    /**
     * 三角形用例1,预期结果：成功，实际结果：成功
     */
    @Test
    public void testTriangle() {
        List<Vertex> vertices = List.of(
                new Vertex(0, 0),
                new Vertex(1, 1),
                new Vertex(2, 0)
        );
        Triangle triangle = new Triangle(vertices);
        // 检查是否能通过三个顶点构成三角形
        assertTrue(triangle.canForm(vertices));
        // 检查三角形的面积是否计算正确
        double expectedArea = 1.0;
        assertEquals(expectedArea, triangle.calcArea(), 0.001);
    }


    /**
     * 三角形用例2，预期结果：失败（共线），实际结果：失败
     */
    @Test
    public void testTriangle1() {
        List<Vertex> vertices1 = List.of(
                new Vertex(0, 0),
                new Vertex(1, 0),
                new Vertex(2, 0)
        );
        Triangle triangle1 = new Triangle(vertices1);
        assertFalse(triangle1.canForm(vertices1));
    }

    /**
     * 三角形用例3，预期结果：失败（两顶点），实际结果：失败
     */
    @Test
    public void testTriangle2() {
        List<Vertex> vertices2 = List.of(
                new Vertex(0, 0),
                new Vertex(0, 1)
        );
        Triangle triangle2 = new Triangle(vertices2);
        assertFalse(triangle2.canForm(vertices2));
    }

    /**
     * 三角形用例4，预期结果：失败（四顶点），实际结果：失败
     */
    @Test
    public void testTriangle3() {
        List<Vertex> vertices3 = List.of(
                new Vertex(0, 0),
                new Vertex(2, 0),
                new Vertex(1, 1),
                new Vertex(2, 2)
        );
        Triangle triangle3 = new Triangle(vertices3);
        assertFalse(triangle3.canForm(vertices3));
    }

    /**
     * 三角形用例5，预期结果：失败（小数），实际结果：失败
     */
    @Test
    public void testTriangle4() {
        List<Vertex> vertices4 = List.of(
                new Vertex(0, 0),
                new Vertex(1, (int) 1.5),
                new Vertex((int) 3.5, 0)
        );
        Triangle triangle4 = new Triangle(vertices4);
        assertTrue(triangle4.canForm(vertices4));
        double expectedArea4 = 2.625; // (1.5 * 3.5) / 0.5 = 2.625
        assertEquals(expectedArea4, triangle4.calcArea(), 0.001);
    }

    /**
     * 四边形用例1，预期结果：成功，实际结果：成功
     * */
    @Test
    public void testRectangle() {
        List<Vertex> vertices = List.of(
                new Vertex(0, 0),
                new Vertex(4, 0),
                new Vertex(4, 3),
                new Vertex(0, 3)
        );
        Rectangle rectangle = new Rectangle(vertices);
        // 检查是否能通过四个顶点构成矩形
        assertTrue(rectangle.canForm(vertices));
        // 检查矩形的面积是否计算正确
        double expectedArea = 12.0; // 4 * 3 = 12.0
        assertEquals(expectedArea, rectangle.calcArea(), 0.001);
    }

    /**
     * 四边形用例2，预期结果：失败（对边不相等），实际结果：失败
     * */
    @Test
    public void testRectangle1() {
        List<Vertex> vertices1 = List.of(
            new Vertex(0, 0),
            new Vertex(3, 0),
            new Vertex(3, 4),
            new Vertex(0, 3)
        );
        Rectangle rectangle1 = new Rectangle(vertices1);
        assertFalse(rectangle1.canForm(vertices1));
    }

    /**
     * 四边形用例3，预期结果：失败（三个顶点），实际结果：失败
     * */
    @Test
    public void testRectangle2() {
        List<Vertex> vertices2 = List.of(
            new Vertex(0, 0),
            new Vertex(4, 0),
            new Vertex(4, 3)
        );
        Rectangle rectangle2 = new Rectangle(vertices2);
        assertFalse(rectangle2.canForm(vertices2));
    }

    /**
     * 四边形用例4，预期结果：失败（五个顶点），实际结果：失败
     * */
    @Test
    public void testRectangle3() {
        List<Vertex> vertices3 = List.of(
            new Vertex(0, 0),
            new Vertex(4, 0),
            new Vertex(4, 3),
            new Vertex(0, 3),
            new Vertex(5, 5)
        );
        Rectangle rectangle3 = new Rectangle(vertices3);
        assertFalse(rectangle3.canForm(vertices3));
    }

    /**
     * 四边形用例5，预期结果：失败（对边相等但对角线不相等），实际结果：失败
     * */
    @Test
    public void testRectangle4() {
        List<Vertex> vertices4 = List.of(
                new Vertex(0, 0),
                new Vertex(4, 1),
                new Vertex(4, 5),
                new Vertex(0, 4)
        );
        Rectangle rectangle4 = new Rectangle(vertices4);
        assertFalse(rectangle4.canForm(vertices4));
    }

    /**
     * 四边形用例6，预期结果：成功（小数），实际结果：失败
     * */
    @Test
    public void testRectangle5() {
        List<Vertex> vertices5 = List.of(
                new Vertex(0, 0),
                new Vertex(4, 0),
                new Vertex(4, (int)4.5),
                new Vertex(0, (int)4.5)
        );
        Rectangle rectangle5 = new Rectangle(vertices5);
        assertTrue(rectangle5.canForm(vertices5));
        double expectedArea5 = 18.0; // 4 * 4.5 = 18.0
        assertEquals(expectedArea5, rectangle5.calcArea(), 0.001);
    }


    /**
     * 圆形用例1，预期结果：成功，实际结果：成功
     * */
    @Test
    public void testCircle() {
        Vertex center = new Vertex(100, 100);
        Circle circle = new Circle(center, 50);
        // 检查是否能通过一个顶点+不为0的半径构成圆形
        assertTrue(circle.formCircle(List.of(center)));
        // 检查圆形的面积是否计算正确
        double expectedArea = Math.PI * 50 * 50; // πr²
        assertEquals(expectedArea, circle.areaCircle(), 0.001);
    }

    /**
     * 圆形用例2，预期结果：失败（半径为0），实际结果：失败
     * */
    @Test
    public void testCircle1() {
        Vertex center1 = new Vertex(100, 100);
        Circle circle1 = new Circle(center1, 0);
        assertFalse(circle1.formCircle(List.of(center1)));
    }

    /**
     * 圆形用例3，预期结果：成功（半径为小数），实际结果：成功
     * */
        @Test
        public void testCircle2() {
        Vertex center2 = new Vertex(100, 100);
        Circle circle2 = new Circle(center2, 5.5);
        assertTrue(circle2.formCircle(List.of(center2)));
        double expectedArea2 = Math.PI * 5.5 * 5.5; // πr²
        assertEquals(expectedArea2, circle2.areaCircle(), 0.001);
    }

    /**
     * 圆形适配器用例1，预期结果：通过，实际结果：通过
     * */
    @Test
    public void testAdapterCircle() {
        Vertex center = new Vertex(100, 100);
        Circle circle = new Circle(center, 50);
        AdapterCircle adapterCircle = new AdapterCircle(circle);
        // 使用适配器检查是否能通过一个顶点构成圆形
        assertTrue(adapterCircle.canForm(List.of(center)));
        // 使用适配器检查圆形的面积是否计算正确
        double expectedArea = Math.PI * 50 * 50; // πr²
        assertEquals(expectedArea, adapterCircle.calcArea(), 0.001);
    }

    /**
     * 圆形适配器用例2，预期结果：失败（半径为0），实际结果：失败
     * */
    @Test
    public void testAdapterCircle1() {
        Vertex center1 = new Vertex(100, 100);
        Circle circle1 = new Circle(center1, 0);
        AdapterCircle adapterCircle1 = new AdapterCircle(circle1);
        assertFalse(adapterCircle1.canForm(List.of(center1)));
    }

    /**
     * 圆形适配器用例3，预期结果：成功（半径为小数），实际结果：成功
     * */
    @Test
    public void testApaterCircle2() {
        Vertex center2 = new Vertex(100, 100);
        Circle circle2 = new Circle(center2, 5.5);
        AdapterCircle adapterCircle2=new AdapterCircle(circle2);
        assertTrue(adapterCircle2.canForm(List.of(center2)));
        double expectedArea2 = Math.PI * 5.5 * 5.5; // πr²
        assertEquals(expectedArea2, adapterCircle2.calcArea(), 0.001);
    }
}
