/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tham_lam;

import java.util.Set;

/**
 *
 * @author huutu
 */
public class Tham_Lam {
    public static void main(String[] args) {
       try {
            // Khởi tạo đồ thị
            Graph graph = new Graph();

            // Thêm các đỉnh vào đồ thị
            graph.themDinh("A");
            graph.themDinh("B");
            graph.themDinh("C");
            graph.themDinh("D");
            graph.themDinh("E");
            graph.themDinh("F");
            graph.themDinh("G");
            graph.themDinh("H");
            graph.themDinh("I");
            // Thêm các cạnh vào đồ thị
            graph.themCanh("A", "B");
            graph.themCanh("A", "C");
            graph.themCanh("A", "D");
            graph.themCanh("B", "E");
            graph.themCanh("C", "F");
            graph.themCanh("C", "G");
            graph.themCanh("D", "H");
            graph.themCanh("E", "I");
            graph.themCanh("F", "I");
            graph.themCanh("G", "I");

            // Tìm tập độc lập cực đại
            Set<String> independentSet = graph.maximumIndependentSet();
            // In kết quả
            System.out.println("Tập độc lập cực đại: " + independentSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

