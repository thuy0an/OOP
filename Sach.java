/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.io.File;
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
    private String loaiSach;
    private int soLuong;
    public Sach() {
        
    }

    public Sach(String tenSach,String maSach,String tacGia,int soTrang,String theLoai,String NXB,double gia,String moTa,String loaiSach,int soLuong) {
    	this.tenSach=tenSach;
    	this.maSach=maSach;
    	this.tacGia=tacGia;
    	this.soTrang=soTrang;
    	this.theLoai=theLoai;
    	this.NXB=NXB;
    	this.gia=gia;
    	this.moTa=moTa;
    	this.loaiSach=loaiSach;
    	this.soLuong=soLuong;

    }
    
    public Sach(Sach sach) {
    	this.tenSach=sach.getTenSach();
    	this.maSach=sach.getMaSach();
    	this.tacGia=sach.getTacGia();
    	this.soTrang=sach.getSoTrang();
    	this.theLoai=sach.getTheLoai();
    	this.NXB=sach.getNXB();
    	this.gia=sach.getGia();
    	this.moTa=sach.getMoTa();
    	this.loaiSach=sach.getLoaiSach();
    	this.soLuong=sach.getSoLuong();
    }

    public String getTenSach() {
        return this.tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return this.maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTacGia() {
        return this.tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoTrang() {
        return this.soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getNXB() {
        return this.NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGia() {
        return this.gia;
    }

    public void setGia(double Gia) {
        this.gia = Gia;
    }

    public String getTheLoai() {
        return this.theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    public String getLoaiSach() {    
        return this.loaiSach;
    }
    public void setLoaiSach(String loaiSach) {    
        this.loaiSach = loaiSach;
    }
    
    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setAll(String maSach, String tenSach, String tacgia, int sotrang, String theloai, String nxb, double gia, String mota)
    {
        this.maSach=maSach;
        this.tenSach=tenSach;
        this.tacGia=tacgia;
        this.soTrang=sotrang;
        this.theLoai=theloai;
        this.NXB=nxb;
        this.gia=gia;
        this.moTa=mota;
    }

    
    public void nhapThongTinSachChoNhanVien() {

        nhapVaCheckTenSach();

        nhapVaCheckMaSach();

        nhapVaCheckTenTG();
        
        nhapVaCheckSoTrang();
        
        nhapVaCheckTheLoai();
        
        nhapVaCheckTenNXB();

        nhapVaCheckGia();
        
        nhapVaCheckMoTa();
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập tên sách
    private void nhapVaCheckTenSach(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validTen = false;
        do{
            try{
                System.out.println("Nhap ten sach: ");
                String input = nhapttsach.nextLine().trim();
                this.setTenSach(input);
                String tensach = this.getTenSach();
                if(!tensach.matches("^[a-zA-Z0-9\\s]+$")||tensach.trim().isEmpty()){
                    System.out.println("Ten sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                }
                else{
                    validTen = true;
                }
            }catch(Exception e){
                System.out.println("Ten sach khong hop le, moi ban nhap lai.....");
            }
        }while(!validTen);
    }
    
    public String laySo(String id){
        String phanMaSo = id.replaceAll("[^0-9]", ""); //thay the bat cu ki tu nao khong phai la so
        return phanMaSo;
    }
    
    
    
    //Hàm kiểm tra tính hợp lệ khi nhập mã sách
    private void nhapVaCheckMaSach(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validMa = false;
        
        File file = new File("book.txt");
        do{
            try{
                System.out.println("Nhap ma sach: ");
                String input = nhapttsach.nextLine().trim();
                this.setMaSach(input);
                String masacH = this.getMaSach();
                while(!masacH.matches("^[a-zA-Z0-9\\s]+$")||masacH.trim().isEmpty()){
                    System.out.println("Ma sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                    input = nhapttsach.nextLine().trim();
                }
                
                try(Scanner scanner = new Scanner(file)){
                    while(scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        String [] docduoc = line.split("#");
                        String masacH2 = docduoc[1];
                        String phanSo = laySo(masacH2);
                        if(phanSo.equalsIgnoreCase(masacH)&&masacH2.contains("P")){
                            System.out.println("Đã có sách Giấy");
                            validMa=true; //nếu không có sẽ bị yêu càu nhập lại mã
                            
                        }
                        else if(phanSo.equalsIgnoreCase(masacH)&&masacH2.contains("SF")){
                            System.out.println("Đã có sách PDF");
                            validMa=true;
                            
                        }
                        if(phanSo.equalsIgnoreCase(masacH)&&masacH2.contains("SE")){
                            System.out.println("Đã có sách EPUB");
                            validMa=true;
                            
                        }
                        else validMa=true;
                    }
                }catch(Exception e){
                    System.out.println("ERROR!!!");
                }
                
                if(this instanceof SachGiay){
                    SachGiay sachgiay = (SachGiay) this;
                    this.setMaSach(masacH + "P"); //P: Paper
                }else if(this instanceof SachMem){
                    SachMem sachmem = (SachMem) this;
                    if(sachmem.getLoai().equalsIgnoreCase("PDF")){
                        this.setMaSach(masacH +"SF"); //SF: Soft PDF
                    }else if(sachmem.getLoai().equalsIgnoreCase("EPUB")){
                        this.setMaSach(masacH +"SE"); //SE: Soft EPUB
                    }
                }   
                    
            }catch(Exception e){
                System.out.println("Ma sach khong hop le, moi ban nhap lai.....");
            }
        }while(!validMa);
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập tên tác giả
    private void nhapVaCheckTenTG(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validTG = false;
        do{
            try{
                System.out.println("Nhap ten tac gia: ");
                String input = nhapttsach.nextLine().trim();
                this.setTacGia(input);
                String tg=this.getTacGia();
                if(!tg.matches("^[a-zA-Z\\s]+$")||tg.trim().isEmpty()){
                    System.out.println("Ten tac gia khong hop le, moi ban nhap lai.....");
                }
                else{
                    validTG = true;
                }
            }catch(Exception e){
                System.out.println("Ten tac gia khong hop le, moi ban nhap lai.....");
            }
        }while(!validTG);
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập số trang
    private void nhapVaCheckSoTrang() {
        Scanner nhapttsach = new Scanner(System.in);
        boolean validPageNum = false;
        do {
            try {
                System.out.println("Nhap so trang: ");
                String input = nhapttsach.nextLine().trim();
                this.setSoTrang(Integer.parseInt(input)); 
                int sotrang = this.getSoTrang();
                if (sotrang <= 0) {
                    System.out.println("So trang phai lon hon 0, moi ban nhap lai.....");
                } else {
                    validPageNum = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("So trang khong hop le, moi ban nhap lai.....");
            }
        } while (!validPageNum);
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập ten NXB
    private void nhapVaCheckTenNXB(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validNXB = false;
        do{
            try{
                System.out.println("Nhap ten NXB: ");
                String input = nhapttsach.nextLine().trim();
                this.setNXB(input);
                String nxb=this.getNXB();
                
                if(!nxb.matches("^[a-zA-Z\\s]+$")||nxb.trim().isEmpty()){
                    System.out.println("Ten NXB khong hop le, moi ban nhap lai.....");
                }
                else{
                    validNXB = true;
                }
            }catch(Exception e){
                System.out.println("Ten NXB khong hop le, moi ban nhap lai.....");
            }
        }while(!validNXB);
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập the loai
    private void nhapVaCheckTheLoai(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validCate = false;
        do{
           try{
               System.out.println("Nhap the loai: ");
               String input = nhapttsach.nextLine().trim();
               this.setTheLoai(input);
               String genre = this.getTheLoai();
               if(!genre.matches("^[a-zA-Z0-9\\s]+$")||genre.trim().isEmpty()){
                   System.out.println("The loai khong hop le, moi ban nhap lai.....");
               }
               else{
                   validCate = true;
               }
           }catch(Exception e){
               System.out.println("The loai khong hop le, moi ban nhap lai.....");
           }
            
        }while(!validCate);
    }
    
    private void nhapVaCheckGia(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validGia = false;
        do{
            try{
                System.out.println("Nhap gia: ");
                String input = nhapttsach.nextLine().trim();
                this.setGia(Double.parseDouble(input));
                double price = this.getGia();
                if(price<=0){
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
    private void nhapVaCheckSoLuong(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validSoLuong = false;
        do{
            try{
                System.out.println("Nhap so luong: ");
                String input = nhapttsach.nextLine().trim();
                this.setSoLuong(Integer.parseInt(input));
                int sl = this.getSoLuong();
                if(sl<=0){
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
    
    private void nhapVaCheckMoTa(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validMoTa = false;
        do{
            try{
                System.out.println("Nhap mo ta: ");
                String input = nhapttsach.nextLine().trim();
                this.setMoTa(input);
                String mota=this.getMoTa();
                
                if(!mota.matches("^[a-zA-Z0-9\\s]+$")||mota.trim().isEmpty()){
                    System.out.println("Mo ta chi duoc chua chu va so, moi ban nhap lai.....");
                }
                else{
                    validMoTa = true;
                }
            }catch(Exception e){
                System.out.println("Ten NXB khong hop le, moi ban nhap lai.....");
            }
        }while(!validMoTa);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Thay đổi nội dung của chuỗi mà k tạo ra một chuỗi mới each time
        sb.append("\n");
        sb.append("Ten sach: ").append(this.getTenSach()).append("\n");
        sb.append("Ma sach: ").append(this.getMaSach()).append("\n");
        sb.append("Ten tac gia: ").append(this.getTacGia()).append("\n");
        sb.append("So trang: ").append(this.getSoTrang()).append(" trang\n");
        sb.append("Nha xuat ban: ").append(this.getNXB()).append("\n");
        sb.append("The loai: ").append(this.getTheLoai()).append("\n");
        sb.append("Gia: ").append(this.getGia()).append("\n");
        sb.append("Mo ta sach: ").append(this.getMoTa()).append("\n");
        sb.append("So luong: ").append(this.getSoLuong()).append("\n");
        //Thêm thông tin khác tại đây nếu cần
        
        return sb.toString();
    }
}