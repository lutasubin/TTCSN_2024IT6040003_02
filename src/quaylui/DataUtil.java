/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quaylui;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author huutu
 */
public class DataUtil {
     // Hàm trả về các đỉnh kề với một đỉnh
    private static Set<String> dinhke(String u, Set<CanhNoiDinh> canh) throws IllegalArgumentException {
        if (u == null) {
            throw new IllegalArgumentException("Đỉnh không thể là null.");
        }

        Set<String> neighbors = new HashSet<>();
        for (CanhNoiDinh edge : canh) {
            if (edge.u.equals(u)) {
                neighbors.add(edge.v);
            } else if (edge.v.equals(u)) {
                neighbors.add(edge.u);
            }
        }
        return neighbors;
    }
    
    // Hàm kiểm tra tính hợp lệ của một đỉnh
    private static boolean kiemtra(String u, Set<String> tapdinhdoclap, Set<CanhNoiDinh> canh) throws IllegalArgumentException {
        if (u == null) {
            throw new IllegalArgumentException("Đỉnh không thể là null.");
        }

        for (String v : tapdinhdoclap) {
            if (canh.contains(new CanhNoiDinh(u, v)) || canh.contains(new CanhNoiDinh(v, u))) {
                return false;
            }
        }
        return true;
    }

    // Hàm đệ quy quay lui
    private static void backtrack(Set<String> tapdinh, Set<CanhNoiDinh> tapcanh, Set<String> tapdinhdoclap, Set<String> maxSet) {
        // Cập nhật maxSet nếu tapdinhdoclap lớn hơn
        if (tapdinhdoclap.size() > maxSet.size()) {
            maxSet.clear();
            maxSet.addAll(tapdinhdoclap);
        }

        // Duyệt qua từng đỉnh còn lại trong tapdinh
        for (String u : new HashSet<>(tapdinh)) { // Tạo bản sao để tránh sửa đổi trực tiếp
            try {
                if (kiemtra(u, tapdinhdoclap, tapcanh)) { // Kiểm tra tính hợp lệ
                    tapdinhdoclap.add(u); // Thêm u vào tapdinhdoclap
                    
                    // Loại bỏ u và các đỉnh kề với u khỏi tapdinh
                    Set<String> tapdinhke = dinhke(u, tapcanh);
                    Set<String> newVertices = new HashSet<>(tapdinh); // newVertices là bản sao của tapdinh
                    newVertices.remove(u); 
                    newVertices.removeAll(tapdinhke); 

                    // Gọi đệ quy với tập mới
                    backtrack(newVertices, tapcanh, tapdinhdoclap, maxSet);

                    // Quay lui: Loại bỏ u khỏi currentSet
                    tapdinhdoclap.remove(u);
                }
            } catch (Exception e) {
                System.out.println("Lỗi khi xử lý đỉnh " + u + ": " + e.getMessage());
            }
        }
    }

    // Hàm tìm tập độc lập cực đại
    public static Set<String> findMaxIndependentSet(Set<String> tapdinh, Set<CanhNoiDinh> tapcanh) throws IllegalArgumentException {
        if (tapdinh == null || tapcanh == null) {
            throw new IllegalArgumentException("Tập đỉnh hoặc tập cạnh không thể là null.");
        }
        
        Set<String> maxSet = new HashSet<>();
        Set<String> tapdinhdoclap = new HashSet<>();
        backtrack(tapdinh, tapcanh, tapdinhdoclap, maxSet);
        return maxSet;
    }
}
