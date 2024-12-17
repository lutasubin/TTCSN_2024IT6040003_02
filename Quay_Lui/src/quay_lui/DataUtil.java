/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quay_lui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author huutu
 */
public class DataUtil {
    private static void backtrack(Graph graph, List<String> tapdinh, int index, Set<String> tapdoclap,
                                  Set<Set<String>> dstapdoclapmax, int[] kichThuocMax) {
        if (index == tapdinh.size()) {
            if (tapdoclap.size() > kichThuocMax[0]) {
                dstapdoclapmax.clear();
                dstapdoclapmax.add(new HashSet<>(tapdoclap));
                kichThuocMax[0] = tapdoclap.size();
            } else if (tapdoclap.size() == kichThuocMax[0]) {
                dstapdoclapmax.add(new HashSet<>(tapdoclap));
            }
            return;
        }
        String dinh = tapdinh.get(index);
        // Kiểm tra nếu có thể thêm đỉnh hiện tại vào tập độc lập
        boolean kiemtra = true;
        for (String dinhke : graph.dsdinhke.get(dinh)) {
            if (tapdoclap.contains(dinhke)) {
                kiemtra = false;
                break;
            }
        }
        // Nếu thêm được, thử thêm đỉnh vào tập độc lập
        if (kiemtra) {
            tapdoclap.add(dinh);
            backtrack(graph, tapdinh, index + 1, tapdoclap, dstapdoclapmax, kichThuocMax);
            tapdoclap.remove(dinh);
        }
        // Thử bỏ qua đỉnh hiện tại
        backtrack(graph, tapdinh, index + 1, tapdoclap, dstapdoclapmax, kichThuocMax);
    }
    public static Set<Set<String>> maximum_Independent_Sets(Graph graph) {
        Set<Set<String>> dstapdoclapmax = new HashSet<>();
        Set<String> tapdoclap = new HashSet<>();
        int[] kichThuocMax = {0};
        try {
            backtrack(graph, new ArrayList<>(graph.tapdinh), 0, tapdoclap, dstapdoclapmax, kichThuocMax);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return dstapdoclapmax;
    }
}
