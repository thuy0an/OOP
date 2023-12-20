
package BookStore;

public class CT_GioHang {
    private String maKhachhang;
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private double giaSach;
    private int soLuong;
    private double thanhTien;

    public CT_GioHang(String maKhachhang, String maSach, String tenSach, String loaiSach,double giaSach, int soLuong, double thanhTien) {
        this.maKhachhang = maKhachhang;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.giaSach=giaSach;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
    
    public CT_GioHang(String maSach, String tenSach, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
    }
        
    public CT_GioHang() {
    }


    public String getMaKhachhang() {
        return maKhachhang;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }
    
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public double getThanhTien() {
        return thanhTien;
    }
    
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setMaKhachhang(String maKhachhang) {
        this.maKhachhang = maKhachhang;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("\n");
       sb.append("Ten sach: ").append(this.getTenSach()).append("\t");
       sb.append("Ma sach: ").append(this.getMaSach()).append("\n");
       sb.append("Loai sach: ").append(this.getLoaiSach()).append("\t");
       sb.append("Gia sach: ").append(this.getGiaSach()).append("\t");
       sb.append("So luong: ").append(this.getSoLuong()).append("\t");
       sb.append("Thanh tien: ").append(this.getThanhTien()).append("\n");
       return sb.toString();
   }
}