package org.example;

import java.awt.*;
import java.util.List;

public class Circle {
    private Vertex center;
    private double radius;
     /**
      * @author ganying
      * @version 2024.11.14
      * @param center 原点的位置，共一组数据，一组数据包含两个参数
      * @param radius 圆的半径
      */
    public Circle(Vertex center, double radius) {
        this.center = center;
        this.radius = radius;
    }

     /**
      * 计算圆的面积
      * @author ganying
      * @version 2024.11.14
      * @return 圆的面积
      */
    public double areaCircle() {
        return Math.PI * radius * radius;
    }

     /**
      * 判断圆点数是否为1，且半径不为0或负数
      * @author ganying
      * @version 2024.11.14
      * @param vertices 圆的原点位置
      * @return false或者true
      */
    public boolean formCircle(List<Vertex> vertices) {
        //半径不为0
        return !(radius==0);
    }

    /**
     * @author ganying
     * @version 2024.11.14
     * @param g 绘图对象
     */
    public void drawCircle(Graphics g) {
        g.drawOval(center.x - (int) radius, center.y - (int) radius, (int) (2 * radius), (int) (2 * radius));
    }
}
