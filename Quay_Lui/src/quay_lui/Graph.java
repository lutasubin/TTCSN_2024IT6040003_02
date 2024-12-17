/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quay_lui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author huutu
 */
public class Graph {
    Set<String> tapdinh;
    Map<String, Set<String>> dsdinhke;

    public Graph() {
        this.tapdinh = new HashSet<>();
        this.dsdinhke = new HashMap<>();
    }

    public Set<String> getTapdinh() {
        return tapdinh;
    }

    public void setTapdinh(Set<String> tapdinh) {
        this.tapdinh = tapdinh;
    }

    public Map<String, Set<String>> getDsdinhke() {
        return dsdinhke;
    }

    public void setDsdinhke(Map<String, Set<String>> dsdinhke) {
        this.dsdinhke = dsdinhke;
    }

    // Thêm đỉnh vào đồ thị
    public void themDinh(String tenDinh) {
        try {
            if (tenDinh == null || tenDinh.isEmpty()) {
                throw new IllegalArgumentException("Đỉnh không được để trống.");
            }
            if (!tapdinh.contains(tenDinh)) {
                tapdinh.add(tenDinh);
                dsdinhke.put(tenDinh, new HashSet<>());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Có lỗi khi thêm đỉnh: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    // Thêm cạnh giữa hai đỉnh
    public void themCanh(String dinh1, String dinh2) {
        try {
            if (dinh1 == null || dinh2 == null) {
                throw new IllegalArgumentException("Đỉnh không được để trống.");
            }
            if (!tapdinh.contains(dinh1) || !tapdinh.contains(dinh2)) {
                throw new IllegalArgumentException("Không tìm thấy: " + dinh1 + ", " + dinh2);
            }
            dsdinhke.get(dinh1).add(dinh2);
            dsdinhke.get(dinh2).add(dinh1);
        } catch (IllegalArgumentException e) {
            System.err.println("Có lỗi khi thêm cạnh: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

