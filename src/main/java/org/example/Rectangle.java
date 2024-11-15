package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Rectangle implements Polygon {
    private List<Vertex> vertices;

    /**
     * @author ganying
     * @version 2024.11.14
     * @param vertices 顶点的位置，共四组数据，一组数据包含两个参数
     */
    public Rectangle(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * 计算机矩形的面积
     * @author ganying
     * @version 2024.11.14
     * @return 矩形的面积
     */
    @Override
    public double calcArea() {
        double length = vertices.get(0).calcDistance(vertices.get(1));
        double width = vertices.get(1).calcDistance(vertices.get(2));
        return length * width;
    }

    /**
     * 判断顶点数是否为4，对边是否相同且对角线是否相同
     * @author ganying
     * @version 2024.11.15
     * @param vertices 顶点的位置，共四组数据，一组数据包含两个参数
     * @return false或者true
     */
    @Override
    public boolean canForm(List<Vertex> vertices) {
        if (vertices.size() != 4)  // 矩形需要四个顶点
            return false;
        // 四条边
        double p1 = vertices.get(0).calcDistance(vertices.get(1));
        double p2 = vertices.get(1).calcDistance(vertices.get(2));
        double p3 = vertices.get(2).calcDistance(vertices.get(3));
        double p4 = vertices.get(3).calcDistance(vertices.get(0));
        // 两条对角线
        double p5 = vertices.get(0).calcDistance(vertices.get(2));
        double p6 = vertices.get(1).calcDistance(vertices.get(3));
        double[] arr={p1, p2, p3, p4, p5, p6};
        Arrays.sort(arr);
        return arr[0] == arr[1] && arr[2] == arr[3] && arr[4] == arr[5]; // 矩形对边相同且对角线相同
    }

    /**
     * @author ganying
     * @version 2024.11.14
     * @param g 绘图对象
     */
    @Override
    public void draw(Graphics g) {
        int x = vertices.get(0).x;
        int y = vertices.get(0).y;
        int width = (int) vertices.get(0).calcDistance(vertices.get(1));
        int height = (int) vertices.get(1).calcDistance(vertices.get(2));
        g.drawRect(x, y, width, height);
    }
}
