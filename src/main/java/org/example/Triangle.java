package org.example;

import java.awt.*;
import java.util.List;

// 三角形类，符合Polygon接口
public class Triangle implements Polygon {
    private List<Vertex> vertices;

    /**
     * @author ganying
     * @version 2024.11.14
     * @param vertices 顶点的位置，共三组数据，一组数据包含两个参数
     */
    public Triangle(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * 计算机三角形的面积
     * @author ganying
     * @version 2024.11.14
     * @return 三角形的面积
     */
    @Override
    public double calcArea() {
        double a = vertices.get(0).calcDistance(vertices.get(1));
        double b = vertices.get(1).calcDistance(vertices.get(2));
        double c = vertices.get(2).calcDistance(vertices.get(0));
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // 海伦公式计算面积
    }

    /**
     * 判断顶点数是否为3，且三点不共线
     * @author ganying
     * @version 2024.11.15
     * @param vertices 顶点的位置，共三组数据，一组数据包含两个参数
     * @return false或者true
     */
    @Override
    public boolean canForm(List<Vertex> vertices) {
        if(vertices.size() != 3)// 三角形需要三个顶点
            return false;
        // 计算三点是否共线
        Vertex p1 = vertices.get(0);
        Vertex p2 = vertices.get(1);
        Vertex p3 = vertices.get(2);
        // crossProduct为0代表共线，其他值为不共线
        int crossProduct = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
        return crossProduct != 0;
    }

    /**
     * @author ganying
     * @version 2024.11.14
     * @param g 绘图对象
     */
    @Override
    public void draw(Graphics g) {
        int[] xPoints = {vertices.get(0).x, vertices.get(1).x, vertices.get(2).x};
        int[] yPoints = {vertices.get(0).y, vertices.get(1).y, vertices.get(2).y};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
