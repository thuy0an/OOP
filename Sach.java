

import java.io.IOException;
import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Sach { 
    private String tenSach;
    private String maSach;
    private String tacGia;
    private int soTrang;
    private String theLoai;
    private String NXB;
    private double gia;
    private String moTa;
    //private String danhGia;
    //private int soSao;
    private String loaiSach;
    private int soLuong;
    private int soLuongMua;
    Scanner nhapttsach = new Scanner(System.in);
    public Sach() {
        
    }
    public Sach(Sach sach) {
    	this.tenSach=sach.getTenSach();
    	this.maSach=sach.getMaSach();
    	this.tacGia=sach.getTacGia();
    	this.soTrang=sach.getSoTrang();
    	this.theLoai=sach.getTheLoai();
    	this.NXB=sach.getNXB();
    	this.gia=sach.getgia();
    	this.moTa=sach.getMoTa();
    	this.loaiSach=sach.getLoaiSach();
    	this.soLuong=sach.getSoLuong();
    	this.soLuongMua=sach.getsoLuongMua();
    }
    public Sach(String tenSach, int soLuongMua){
        this.tenSach=tenSach;
        this.soLuong=soLuongMua;
    }
    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getgia() {
        return gia;
    }

    public void setDonGia(double donGia) {
        this.gia = donGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    public String getLoaiSach() {    
        return loaiSach;
    }
    public void setLoaiSach(String loaiSach) {    
        this.loaiSach = loaiSach;
    }

//    public String getDanhGia() {
//        return danhGia;
//    }
//
//    public void setDanhGia(String danhGia) {
//        this.danhGia = danhGia;
//    }
//
//    public int getSoSao() {
//        return soSao;
//    }
//
//    public void setSoSao(int soSao) {
//        this.soSao = soSao;
//    }
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    private int getsoLuongMua(){
        return soLuongMua;
    }
    private void setsoLuongMua(int soLuongMua){
        this.soLuongMua=soLuongMua;
    }
    public void nhapThongTinSachChoNhanVien() {
//        System.out.println("Nhap ten sach: ");
//        this.tenSach = nhapttsach.nextLine();
//        checkTenSach();
        nhapVaCheckTenSach();
        
//        System.out.println("Nhap ma sach: ");
//        this.maSach = nhapttsach.nextLine();
//        checkMaSach();
        nhapVaCheckMaSach();

//        System.out.println("Nhap ten tac gia: ");
//        this.tacGia = nhapttsach.nextLine();
//        checkTenTG(); //Đây là hàm non-static nhưng vì nó đang nằm trong cùng lớp Sach và truy cập các thành viên non-static của lớp như this.tacgia mà không cần đối tượng tham chiếu cụ thể. Khi gọi hàm nó tự hiểu 'this' tham chiêu đến đối tượng hiện tại của lớp Sach 
        nhapVaCheckTenTG();
        
//        System.out.println("Nhap so trang: ");
//        this.soTrang = Integer.parseInt(nhapttsach.nextLine());
        nhapVaCheckSoTrang();
        
        nhapVaCheckTheLoai();
        
//        System.out.println("Nhap NXB: ");
//        this.NXB = nhapttsach.nextLine();
//        checkTenNXB();
        nhapVaCheckTenNXB();

//        System.out.println("Nhap don gia: ");
//        this.donGia = Double.parseDouble(nhapttsach.nextLine());
        nhapVaCheckGia();
        
        System.out.println("Nhap mo ta sach: ");
        this.moTa = nhapttsach.nextLine();
        
//        System.out.println("Nhap so luong: ");
//        this.soLuong = Integer.parseInt(nhapttsach.nextLine());
        //nhapVaCheckSoLuong();
        
    }
    
//    public void danhGia(){
//        System.out.println("Moi ban danh gia: ");
//        this.danhGia = nhapttsach.nextLine();
//
//        System.out.println("Moi ban cho sao: ");
//        this.soSao = Integer.parseInt(nhapttsach.nextLine());
//        while (this.soSao < 0 || this.soSao > 5) {
//            System.out.println("Moi ban nhap lai so sao (0-5): ");
//            this.soSao = Integer.parseInt(nhapttsach.nextLine());
//        }
//    }
    //Hàm kiểm tra tính hợp lệ khi nhập tên sách
    public void nhapVaCheckTenSach(){
        boolean validTen = false;
        do{
            try{
                System.out.println("Nhap ten sach: ");
                String input = nhapttsach.nextLine().trim();
                this.tenSach = input;
                
                if(!this.tenSach.matches("^[a-zA-Z0-9\\s]+$")||this.tenSach.isBlank()){
                    System.out.println("Ten sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                    this.tenSach = input;
                }
                else{
                    validTen = true;
                }
            }catch(Exception e){
                System.out.println("Ten sach khong hop le, moi ban nhap lai.....");
            }
        }while(!validTen);
    }
    public void checkTenSach(){
        String tensach = this.tenSach;
        boolean validTenSach = false;
        
        do{
            if(!tensach.matches("^[a-zA-Z0-9\\s]+$")||tensach.isBlank()){
                System.out.println("Ten sach khong hop le, moi ban nhap la.....");
                this.tenSach = nhapttsach.nextLine();
                tensach = this.tenSach;
            }
            else{
                validTenSach = true;
            }
        }while(!validTenSach);
    }
    //Hàm kiểm tra tính hợp lệ khi nhập mã sách
    public void nhapVaCheckMaSach(){
        boolean validMa = false;
        do{
            try{
                System.out.println("Nhap ma sach: ");
                String input = nhapttsach.nextLine().trim();
                this.maSach = input;
                
                if(!this.maSach.matches("^[a-zA-Z0-9\\s]+$")||this.maSach.isBlank()){
                    System.out.println("Ma sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                    this.maSach = input;
                }
                else{
                    validMa = true;
                }
                // Check if it's SachGiay or SachMem
                if(this instanceof SachGiay){
                    this.maSach += "P"; //P: Paper
                }else if(this instanceof SachMem){
                    SachMem sachmem = (SachMem) this;
                    if(sachmem.getLoai().equalsIgnoreCase("PDF")){
                        this.maSach += "SP"; //SP: Soft PDF
                    }else if(sachmem.getLoai().equalsIgnoreCase("EPUB")){
                        this.maSach += "SE"; //SE: Soft EPUB
                    }
                }
            }catch(Exception e){
                System.out.println("Ma sach khong hop le, moi ban nhap lai.....");
            }
        }while(!validMa);
    }
    public void checkMaSach(){
        String masach = this.maSach;
        boolean validMa =false;
        
        do{
            if(!masach.matches("^[a-zA-Z0-9\\s]+$")||masach.isBlank()){
                System.out.println("Ma sach khong hop le. moi ban nhap lai.....");
                this.maSach = nhapttsach.nextLine();
                masach = this.maSach;
            }
            else{
                validMa = true;
            }
        }while(!validMa);
    }
    public void nhapVaCheckTenTG(){
        boolean validTG = false;
        do{
            try{
                System.out.println("Nhap ten tac gia: ");
                String input = nhapttsach.nextLine().trim();
                this.tacGia = input;
                
                if(!this.tacGia.matches("^[a-zA-Z\\s]+$")||this.tacGia.isBlank()){
                    System.out.println("Ten tac gia khong hop le, moi ban nhap lai.....");
                    this.tacGia = input;
                }
                else{
                    validTG = true;
                }
            }catch(Exception e){
                System.out.println("Ten tac gia khong hop le, moi ban nhap lai.....");
            }
        }while(!validTG);
    }
    //Hàm kiểm tra tính hợp lệ khi nhập tên tác giả
    public void checkTenTG(){
        String author = this.tacGia;
        boolean validTG = false;
        do{
            //author = this.tacGia.trim(); //Remove trailing whitespace, phương thức trim(): trả về một chuỗi mới mà không bao gồm các ký tự trắng ở cả hai đầu của chuỗi gốc.
            
            if (!author.matches("^[a-zA-Z\\s]+$") /*|| author.isEmpty()*/ || author.isBlank()) {
                System.out.println("Ten khong hop le, moi ban nhap lai: ");
                this.tacGia = nhapttsach.nextLine();
                author=this.tacGia;
            } else {
                validTG = true;
            }
        } while (!validTG);
    }
    //Hàm kiểm tra tính hợp lệ khi nhập số trang
    public void nhapVaCheckSoTrang() {
        boolean validPageNum = false;
        do {
            try {
                System.out.println("Nhap so trang: ");
                String input = nhapttsach.nextLine().trim();
                this.soTrang = Integer.parseInt(input);
            
                if (this.soTrang <= 0) {
                    System.out.println("So trang phai lon hon 0, moi ban nhap lai.....");
                } else {
                    validPageNum = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("So trang khong hop le, moi ban nhap lai.....");
            }
        } while (!validPageNum);
    }
    public void nhapVaCheckTenNXB(){
        boolean validNXB = false;
        do{
            try{
                System.out.println("Nhap ten NXB: ");
                String input = nhapttsach.nextLine().trim();
                this.NXB = input;
                
                if(!this.NXB.matches("^[a-zA-Z\\s]+$")||this.NXB.isBlank()){
                    System.out.println("Ten NXB khong hop le, moi ban nhap lai.....");
                    this.NXB = input;
                }
                else{
                    validNXB = true;
                }
            }catch(Exception e){
                System.out.println("Ten NXB khong hop le, moi ban nhap lai.....");
            }
        }while(!validNXB);
    }
    //Hàm kiểm tra tính hợp lệ khi nhập tên NXB
    public void checkTenNXB(){
        String nxb = this.NXB;
        boolean validNXB = false;
        do{
            nxb = this.NXB.trim();
            
            if (!nxb.matches("^[a-zA-Z\\s]+$") || nxb.isEmpty()) {
                System.out.println("Ten khong hop le, moi ban nhap lai: ");
                this.NXB = nhapttsach.nextLine();
                nxb=this.NXB;
            } else {
                validNXB = true;
            }
        } while (!validNXB);
    }
    public void nhapVaCheckTheLoai(){
        boolean validCate = false;
        do{
           try{
               System.out.println("Nhap the loai: ");
               String input = nhapttsach.nextLine().trim();
               this.theLoai = input;
               if(!this.theLoai.matches("^[a-zA-Z0-9\\s]+$")||this.theLoai.isBlank()){
                   System.out.println("The loai khong hop le, moi ban nhap lai.....");
                   this.theLoai = input;
               }
               else{
                   validCate = true;
               }
           }catch(Exception e){
               System.out.println("The loai khong hop le, moi ban nhap lai.....");
           }
            
        }while(!validCate);
    }
    
    public void nhapVaCheckGia(){
        boolean validGia = false;
        do{
            try{
                System.out.println("Nhap gia: ");
                String input = nhapttsach.nextLine().trim();
                this.gia = Double.parseDouble(input);
                
                if(this.gia<=0){
                    System.out.println("Gia phai lon hon 0,moi ban nhap lai.....");
                }
                else{
                    validGia = true;
                }
            } catch(NumberFormatException e){
                System.out.println("Gia khong hop le, moi ban nhap lai.....");
            }
        }while(!validGia);
    }
    public void nhapVaCheckSoLuong(){
        boolean validSoLuong = false;
        do{
            try{
                System.out.println("Nhap so luong: ");
                String input = nhapttsach.nextLine().trim();
                this.soLuong = Integer.parseInt(input);
                
                if(this.soLuong<=0){
                    System.out.println("So luong phai lon hon 0, moi ban nhap lai.....");
                }
                else{
                    validSoLuong = true;
                }
            }catch(NumberFormatException e){
                System.out.println("So luong khong hop le, moi ban nhap lail.....");
            }
        }while(!validSoLuong);
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Thay đổi nội dung của chuỗi mà k tạo ra một chuỗi mới each time
        sb.append("\n");
        sb.append("Ten sach: ").append(this.tenSach).append("\n");
        sb.append("Ma sach: ").append(this.maSach).append("\n");
        sb.append("Ten tac gia: ").append(this.tacGia).append("\n");
        sb.append("So trang: ").append(this.soTrang).append(" trang\n");
        sb.append("Nha xuat ban: ").append(this.NXB).append("\n");
        sb.append("The loai: ").append(this.theLoai).append("\n");
        sb.append("Gia: ").append(this.gia).append("\n");
        sb.append("Mo ta sach: ").append(this.moTa).append("\n");
        sb.append("So luong: ").append(this.soLuong).append("\n");
        //Thêm thông tin khác tại đây nếu cần
        
        return sb.toString();
    }
//    public String danhGiaTuKhachHang(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("Danh gia sach: ").append(this.danhGia).append("\n");
//        sb.append("So sao: ").append(this.soSao).append("/5").append("\n");
//        
//        return sb.toString();
//    }
    public String tenSach(){
        return this.tenSach;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        Sach sach = new Sach();
        sach.nhapThongTinSachChoNhanVien();
        System.out.println(sach.toString());
    }
}
