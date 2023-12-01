
package BookStore;

public class CT_GioHang {
    private String maKhachhang;
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private int soLuong;
    private Double thanhTien;

    public CT_GioHang(String maKhachhang, String maSach, String tenSach, String loaiSach, int soLuong, Double thanhTien) {
        this.maKhachhang = maKhachhang;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
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
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public Double getThanhTien() {
        return thanhTien;
    }
    
    public void setThanhTien(Double thanhTien) {
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
       sb.append("Ten sach: ").append(this.getTenSach()).append("\n");
       sb.append("Ma sach: ").append(this.getMaSach()).append("\n");
       sb.append("Loai sach: ").append(this.getLoaiSach()).append("\n");
       sb.append("So luong: ").append(this.getSoLuong()).append("\n");
       sb.append("Thanh tien: ").append(this.getThanhTien()).append("\n");
       return sb.toString();
   }
}