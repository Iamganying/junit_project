package org.example;

// 顶点类
public class Vertex {
    int x, y;

    /**
     * @author ganying
     * @version 2024.11.14
     * @param x 原点（顶点）的x坐标
     * @param y 原点（顶点）的y坐标
     */
    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 计算两顶点之间的距离的面积
     * @author ganying
     * @version 2024.11.14
     * @return 两顶点之间的距离
     */
    public double calcDistance(Vertex other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

