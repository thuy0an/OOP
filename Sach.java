/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookstore_management;

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

    Scanner nhapttsach = new Scanner(System.in);
    public Sach() {
        
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
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
    public void nhapThongTinSachChoNhanVien() {

        nhapVaCheckTenSach();
        
        nhapVaCheckMaSach();

        nhapVaCheckTenTG();
        
        nhapVaCheckSoTrang();
        
        nhapVaCheckTheLoai();
        
        nhapVaCheckTenNXB();

        nhapVaCheckGia();
        
        System.out.println("Nhap mo ta sach: ");
        this.moTa = nhapttsach.nextLine();
        String mota = this.getMoTa();
        
//        System.out.println("Nhap so luong: ");
//        this.soLuong = Integer.parseInt(nhapttsach.nextLine());
        //nhapVaCheckSoLuong();
        
    }

    //Hàm kiểm tra tính hợp lệ khi nhập tên sách
    public void nhapVaCheckTenSach(){
        boolean validTen = false;
        do{
            try{
                System.out.println("Nhap ten sach: ");
                String input = nhapttsach.nextLine().trim();
                this.setTenSach(input);
                String tensach = this.getTenSach();
                if(!tensach.matches("^[a-zA-Z0-9\\s]+$")||tensach.isBlank()){
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
    
    //Hàm kiểm tra tính hợp lệ khi nhập mã sách
    public void nhapVaCheckMaSach(){
        boolean validMa = false;
        do{
            try{
                System.out.println("Nhap ma sach: ");
                String input = nhapttsach.nextLine().trim();
                this.setMaSach(input);
                String masacH = this.getMaSach();
                if(!masacH.matches("^[a-zA-Z0-9\\s]+$")||masacH.isBlank()){
                    System.out.println("Ma sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                }
                else{
                    validMa = true;
                }
                // Check if it's SachGiay or SachMem
                if(this instanceof SachGiay){
                    this.setMaSach(masacH + "P"); //P: Paper
                }else if(this instanceof SachMem){
                    SachMem sachmem = (SachMem) this;
                    if(sachmem.getLoai().equalsIgnoreCase("PDF")){
                        this.setMaSach(masacH + "SP"); //SP: Soft PDF
                    }else if(sachmem.getLoai().equalsIgnoreCase("EPUB")){
                        this.setMaSach(masacH + "SE"); //SE: Soft EPUB
                    }
                }
            }catch(Exception e){
                System.out.println("Ma sach khong hop le, moi ban nhap lai.....");
            }
        }while(!validMa);
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập tên tác giả
    public void nhapVaCheckTenTG(){
        boolean validTG = false;
        do{
            try{
                System.out.println("Nhap ten tac gia: ");
                String input = nhapttsach.nextLine().trim();
                this.setTacGia(input);
                String tg=this.getTacGia();
                if(!tg.matches("^[a-zA-Z\\s]+$")||tg.isBlank()){
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
    public void nhapVaCheckSoTrang() {
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
    
    //Hàm kiểm tra tính hợp lệ khi nhập tên NXB
    public void nhapVaCheckTenNXB(){
        boolean validNXB = false;
        do{
            try{
                System.out.println("Nhap ten NXB: ");
                String input = nhapttsach.nextLine().trim();
                this.setNXB(input);
                String nxb=this.getNXB();
                
                if(!nxb.matches("^[a-zA-Z\\s]+$")||nxb.isBlank()){
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
    
    public void nhapVaCheckTheLoai(){
        boolean validCate = false;
        do{
           try{
               System.out.println("Nhap the loai: ");
               String input = nhapttsach.nextLine().trim();
               this.setTheLoai(input);
               String genre = this.getTheLoai();
               if(!genre.matches("^[a-zA-Z0-9\\s]+$")||genre.isBlank()){
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
    
    public void nhapVaCheckGia(){
        boolean validGia = false;
        do{
            try{
                System.out.println("Nhap gia: ");
                String input = nhapttsach.nextLine().trim();
                this.setGia(Double.parseDouble(input));
                Double price = this.getGia();
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
    
    public void nhapVaCheckSoLuong(){
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
