/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tham_lam;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author huutu
 */
public class Graph {
    // Tập đỉnh V
    Set<String> vertices;
    // Tập cạnh E
    Set<Edge> edges;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }

    // Thêm đỉnh vào đồ thị
    public void themDinh(String vertex) {
        vertices.add(vertex);
    }

    // Thêm cạnh vào đồ thị
    public void themCanh(String vertex1, String vertex2) {
        // Kiểm tra nếu cả hai đỉnh đều tồn tại trong đồ thị
        if (vertices.contains(vertex1) && vertices.contains(vertex2)) {
            edges.add(new Edge(vertex1, vertex2));
        } else {
            System.out.println("Một trong các đỉnh không tồn tại trong đồ thị!");
        }
    }

    // Tìm tập độc lập cực đại bằng thuật toán tham lam
    public Set<String> maximumIndependentSet() throws Exception {
        Set<String> independentSet = new HashSet<>();
        Set<String> removedVertices = new HashSet<>();

        try {
            // Duyệt qua tất cả các đỉnh
            for (String vertex : vertices) {
                // Kiểm tra nếu đỉnh không bị loại và không có cạnh nối với các đỉnh đã chọn
                if (!removedVertices.contains(vertex)) {
                    independentSet.add(vertex);
                    // Loại bỏ tất cả các đỉnh kề với đỉnh vừa chọn
                    for (Edge edge : edges) {
                        if (edge.contains(vertex)) {
                            removedVertices.add(edge.getOther(vertex));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Lỗi khi xử lý đồ thị: " + e.getMessage());
        }

        return independentSet;
    }
}

