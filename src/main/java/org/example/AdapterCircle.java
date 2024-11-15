package org.example;

import java.awt.*;
import java.util.List;

// 圆形适配器类，将圆形转换为Polygon
public class AdapterCircle implements Polygon{
    private Circle circle;

    /**
     * @author ganying
     * @version 2024.11.14
     * @param circle Circle的实例对象
     */
    public AdapterCircle(Circle circle) {
        this.circle = circle;
    }

    /**
     * 计算圆的面积
     * @author ganying
     * @version 2024.11.14
     * @return 圆的面积
     */

    @Override
    public double calcArea() {
        return circle.areaCircle();
    }

    /**
     * 判断圆（顶）点数是否为1
     * @author ganying
     * @version 2024.11.14
     * @param vertices 顶点的位置，共一组数据，一组数据包含两个参数
     * @return false或者true
     */
    public boolean canForm(List<Vertex> vertices) {
        return circle.formCircle(vertices);
    }

    /**
     * @author ganying
     * @version 2024.11.14
     * @param g 绘图对象
     */
    @Override
    public void draw(Graphics g) {
        circle.drawCircle(g);
    }
}
