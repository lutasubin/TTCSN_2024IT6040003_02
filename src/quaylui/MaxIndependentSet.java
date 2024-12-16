/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quaylui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author huutu
 */
public class MaxIndependentSet {
    // Hàm chính
    public static void main(String[] args) {
        // Đầu vào bài toán
        try {
            // Đầu vào bài toán
            Set<String> tapdinh = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I"));
            Set<CanhNoiDinh> canh = new HashSet<>();
            // Thêm các cạnh vào đồ thị
            canh.add(new CanhNoiDinh("A", "B"));
            canh.add(new CanhNoiDinh("A", "C"));
            canh.add(new CanhNoiDinh("A", "D"));
            canh.add(new CanhNoiDinh("B", "E"));
            canh.add(new CanhNoiDinh("C", "F"));
            canh.add(new CanhNoiDinh("C", "G"));
            canh.add(new CanhNoiDinh("D", "H"));
            canh.add(new CanhNoiDinh("E", "I"));
            canh.add(new CanhNoiDinh("F", "I"));
            canh.add(new CanhNoiDinh("G", "I"));


            // Tìm tập độc lập cực đại
            Set<String> maxSet = DataUtil.findMaxIndependentSet(tapdinh, canh);

            // In kết quả
            System.out.println("Tập độc lập cực đại: " + maxSet);
        } catch (Exception e) {
            // Xử lý ngoại lệ chung
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
}