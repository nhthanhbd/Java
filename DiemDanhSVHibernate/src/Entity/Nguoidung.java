package Entity;
// Generated Aug 17, 2017 7:16:05 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Nguoidung generated by hbm2java
 */
public class Nguoidung  implements java.io.Serializable {


     private String tenNguoiDung;
     private String matKhau;
     private String hoTen;
     private Integer maLoaiNguoiDung;
     private String tenLoaiNguoiDung;
     private Set<Sinhvienmonhoc> sinhvienmonhocs = new HashSet<Sinhvienmonhoc>(0);

    public Nguoidung() {
    }

	
    public Nguoidung(String tenNguoiDung, String hoTen, String tenLoaiNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
        this.hoTen = hoTen;
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
    }
    public Nguoidung(String tenNguoiDung, String matKhau, String hoTen, Integer maLoaiNguoiDung, String tenLoaiNguoiDung, Set<Sinhvienmonhoc> sinhvienmonhocs) {
       this.tenNguoiDung = tenNguoiDung;
       this.matKhau = matKhau;
       this.hoTen = hoTen;
       this.maLoaiNguoiDung = maLoaiNguoiDung;
       this.tenLoaiNguoiDung = tenLoaiNguoiDung;
       this.sinhvienmonhocs = sinhvienmonhocs;
    }
   
    public String getTenNguoiDung() {
        return this.tenNguoiDung;
    }
    
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    public String getMatKhau() {
        return this.matKhau;
    }
    
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public Integer getMaLoaiNguoiDung() {
        return this.maLoaiNguoiDung;
    }
    
    public void setMaLoaiNguoiDung(Integer maLoaiNguoiDung) {
        this.maLoaiNguoiDung = maLoaiNguoiDung;
    }
    public String getTenLoaiNguoiDung() {
        return this.tenLoaiNguoiDung;
    }
    
    public void setTenLoaiNguoiDung(String tenLoaiNguoiDung) {
        this.tenLoaiNguoiDung = tenLoaiNguoiDung;
    }
    public Set<Sinhvienmonhoc> getSinhvienmonhocs() {
        return this.sinhvienmonhocs;
    }
    
    public void setSinhvienmonhocs(Set<Sinhvienmonhoc> sinhvienmonhocs) {
        this.sinhvienmonhocs = sinhvienmonhocs;
    }




}

