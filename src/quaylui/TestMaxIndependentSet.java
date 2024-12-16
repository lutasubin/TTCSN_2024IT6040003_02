package quaylui;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestMaxIndependentSet {
    public static void main(String[] args) {
        // Kịch bản 1: Kiểm tra với tập hợp rỗng
        try {
            Set<String> tapdinhRong = new HashSet<>();
            Set<CanhNoiDinh> canhRong = new HashSet<>();
            DataUtil.findMaxIndependentSet(tapdinhRong, canhRong);
        } catch (IllegalArgumentException e) {
            System.out.println("Kịch bản 1: " + e.getMessage()); // Mong đợi thông báo lỗi
        }

        // Kịch bản 2: Kiểm tra với tập hợp hợp lệ
        try {
            Set<String> tapdinh = new HashSet<>(Arrays.asList("A", "B", "C"));
            Set<CanhNoiDinh> canh = new HashSet<>();
            canh.add(new CanhNoiDinh("A", "B"));
            canh.add(new CanhNoiDinh("B", "C"));
            Set<String> maxSet = DataUtil.findMaxIndependentSet(tapdinh, canh);
            System.out.println("Kịch bản 2: Tập độc lập cực đại: " + maxSet); // Kiểm tra kết quả
        } catch (Exception e) {
            System.out.println("Kịch bản 2: Đã xảy ra lỗi: " + e.getMessage());
        }

        // Kịch bản 3: Kiểm tra với các đỉnh null
        try {
            Set<String> tapdinh = null;
            Set<CanhNoiDinh> canh = new HashSet<>();
            DataUtil.findMaxIndependentSet(tapdinh, canh);
        } catch (IllegalArgumentException e) {
            System.out.println("Kịch bản 3: " + e.getMessage()); // Mong đợi thông báo lỗi
        }

        // Kịch bản 4: Kiểm tra với các đỉnh không liên kết
        try {
            Set<String> tapdinh = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
            Set<CanhNoiDinh> canh = new HashSet<>();
            // Không có cạnh nào giữa các đỉnh
            Set<String> maxSet = DataUtil.findMaxIndependentSet(tapdinh, canh);
            System.out.println("Kịch bản 4: Tập độc lập cực đại: " + maxSet); // Mong đợi tất cả các đỉnh
        } catch (Exception e) {
            System.out.println("Kịch bản 4: Đã xảy ra lỗi: " + e.getMessage());
        }

        // Kịch bản 5: Kiểm tra với đồ thị có chu trình
        try {
            Set<String> tapdinh = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
            Set<CanhNoiDinh> canh = new HashSet<>();
            canh.add(new CanhNoiDinh("A", "B"));
            canh.add(new CanhNoiDinh("B", "C"));
            canh.add(new CanhNoiDinh("C", "D"));
            canh.add(new CanhNoiDinh("D", "A")); // Tạo chu trình
            Set<String> maxSet = DataUtil.findMaxIndependentSet(tapdinh, canh);
            System.out.println("Kịch bản 5: Tập độc lập cực đại: " + maxSet); // Kiểm tra kết quả
        } catch (Exception e) {
            System.out.println("Kịch bản 5: Đã xảy ra lỗi: " + e.getMessage());
        }

        // Kịch bản 6: Kiểm tra với nhiều cạnh
        try {
            Set<String> tapdinh = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E"));
            Set<CanhNoiDinh> canh = new HashSet<>();
            canh.add(new CanhNoiDinh("A", "B"));
            canh.add(new CanhNoiDinh("A", "C"));
            canh.add(new CanhNoiDinh("B", "C"));
            canh.add(new CanhNoiDinh("C", "D"));
            canh.add(new CanhNoiDinh("D", "E"));
            Set<String> maxSet = DataUtil.findMaxIndependentSet(tapdinh, canh);
            System.out.println("Kịch bản 6: Tập độc lập cực đại: " + maxSet); // Kiểm tra kết quả
        } catch (Exception e) {
            System.out.println("Kịch bản 6: Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}