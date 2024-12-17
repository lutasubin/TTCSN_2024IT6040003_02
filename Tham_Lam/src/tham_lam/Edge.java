/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tham_lam;

/**
 *
 * @author huutu
 */
public class Edge {
    String vertex1;
    String vertex2;

    public Edge(String vertex1, String vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    // Kiểm tra xem cạnh có chứa đỉnh nào hay không
    public boolean contains(String vertex) {
        return vertex1.equals(vertex) || vertex2.equals(vertex);
    }

    // Lấy đỉnh còn lại khi biết đỉnh đầu vào
    public String getOther(String vertex) {
        if (vertex.equals(vertex1)) {
            return vertex2;
        } else if (vertex.equals(vertex2)) {
            return vertex1;
        }
        return null;
    }
}

