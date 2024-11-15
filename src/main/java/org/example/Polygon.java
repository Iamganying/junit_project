package org.example;

import java.awt.*;
import java.util.List;

interface Polygon {
    /**
     * 计算面积方法
     * @return 图形面积
     */
    double calcArea();

    /**
     * 是否能构成对应图形方法
     * @param vertices 顶(圆)点的位置
     * @return true或者false，*/
    boolean canForm(List<Vertex> vertices);

    /**
     * 图形绘画和方法
     * @param g 绘画对象*/
    void draw(Graphics g);
}
