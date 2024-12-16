/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quaylui;

/**
 *
 * @author huutu
 */
public class CanhNoiDinh {
    public String u;  // u và v là 2 đỉnh được nói với nhau bởi một cạnh
    public String v;

    public CanhNoiDinh(String u, String v) {
        if (u == null || v == null) {
                throw new IllegalArgumentException("Các đỉnh của cạnh không thể là null.");
            }
        this.u = u;
        this.v = v;
    }

    @Override
        public int hashCode() {
            return u.hashCode() + v.hashCode();
        }

    @Override
         public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof CanhNoiDinh)) return false;
            CanhNoiDinh edge = (CanhNoiDinh) obj;
            return (u.equals(edge.u) && v.equals(edge.v)) || (u.equals(edge.v) && v.equals(edge.u));
        }
    
}
