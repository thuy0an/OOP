/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package BookStore;

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
    	this.gia=sach.getgia();
    	this.moTa=sach.getMoTa();
    	this.loaiSach=sach.getLoaiSach();
    	this.soLuong=sach.getSoLuong();
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
    
    public String tenSach(){
        return this.tenSach;
    }
    public String getLoaiSach() {    
        return loaiSach;
    }
    public void setLoaiSach(String loaiSach) {    
        this.loaiSach = loaiSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public void nhapThongTinSachChoNhanVien() {
        Scanner nhapttsach = new Scanner(System.in);
        nhapVaCheckTenSach();
        
        nhapVaCheckMaSach();

        nhapVaCheckTenTG();
        
        nhapVaCheckSoTrang();
        
        nhapVaCheckTheLoai();
        
        nhapVaCheckTenNXB();

        nhapVaCheckGia();
        
        System.out.println("Nhap mo ta sach: ");
        this.setMoTa(nhapttsach.nextLine());
        
    }
    
    //Hàm kiểm tra tính hợp lệ khi nhập tên sách
    public void nhapVaCheckTenSach(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validTen = false;
        do{
            try{
                System.out.println("Nhap ten sach: ");
                String input = nhapttsach.nextLine().trim();
                this.setTenSach(input);
                if(!this.getTenSach().matches("^[a-zA-Z0-9\\s]+$")||this.getTenSach().trim().isEmpty()){
                    System.out.println("Ten sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                    this.setTenSach(nhapttsach.nextLine().trim());
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
        Scanner nhapttsach = new Scanner(System.in);
        String tensach = this.getTenSach();
        boolean validTenSach = false;
        
        do{
            if(!tensach.matches("^[a-zA-Z0-9\\s]+$")||tensach.trim().isEmpty()){
                System.out.println("Ten sach khong hop le, moi ban nhap la.....");
                this.setTenSach(nhapttsach.nextLine());
                tensach = this.getTenSach();
            }
            else{
                validTenSach = true;
            }
        }while(!validTenSach);
    }
    //Hàm kiểm tra tính hợp lệ khi nhập mã sách
    public void nhapVaCheckMaSach(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validMa = false;
        do{
            try{
                System.out.println("Nhap ma sach: ");
                String input = nhapttsach.nextLine().trim();
                this.setMaSach(input);
                
                if(!this.getMaSach().matches("^[a-zA-Z0-9\\s]+$")||this.getMaSach().trim().isEmpty()){
                    System.out.println("Ma sach chi duoc chua chu, so va khoang trang. Moi ban nhap lai.....");
                    this.setMaSach(nhapttsach.nextLine().trim());
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
        Scanner nhapttsach = new Scanner(System.in);
        String masach = this.getMaSach();
        boolean validMa =false;
        
        do{
            if(!masach.matches("^[a-zA-Z0-9\\s]+$")||masach.trim().isEmpty()){
                System.out.println("Ma sach khong hop le. moi ban nhap lai.....");
                this.setMaSach(nhapttsach.nextLine());
                masach = this.getMaSach();
            }
            else{
                validMa = true;
            }
        }while(!validMa);
    }
    public void nhapVaCheckTenTG(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validTG = false;
        do{
            try{
                System.out.println("Nhap ten tac gia: ");
                String input = nhapttsach.nextLine().trim();
                this.setTacGia(nhapttsach.nextLine().trim());
                
                if(!this.getTacGia().matches("^[a-zA-Z\\s]+$")||this.getTacGia().trim().isEmpty()){
                    System.out.println("Ten tac gia khong hop le, moi ban nhap lai.....");
                    this.setTacGia(nhapttsach.nextLine().trim());
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
        Scanner nhapttsach = new Scanner(System.in);
        String author = this.getTacGia();
        boolean validTG = false;
        do{
            if (!author.matches("^[a-zA-Z\\s]+$")|| author.trim().isEmpty()) {
                System.out.println("Ten khong hop le, moi ban nhap lai: ");
                this.setTacGia(nhapttsach.nextLine());
                author=this.getTacGia();
            } else {
                validTG = true;
            }
        } while (!validTG);
    }
    //Hàm kiểm tra tính hợp lệ khi nhập số trang
    public void nhapVaCheckSoTrang() {
        Scanner nhapttsach = new Scanner(System.in);
        boolean validPageNum = false;
        do {
            try {
                System.out.println("Nhap so trang: ");
                String input = nhapttsach.nextLine().trim();
                this.setSoTrang(Integer.parseInt(input));
            
                if (this.getSoTrang() <= 0) {
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
        Scanner nhapttsach = new Scanner(System.in);
        boolean validNXB = false;
        do{
            try{
                System.out.println("Nhap ten NXB: ");
                String input = nhapttsach.nextLine().trim();
                this.setNXB(input);
                
                if(!this.getNXB().matches("^[a-zA-Z\\s]+$")||this.getNXB().trim().isEmpty()){
                    System.out.println("Ten NXB khong hop le, moi ban nhap lai.....");
                    this.setNXB(nhapttsach.nextLine().trim());
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
        Scanner nhapttsach = new Scanner(System.in);
        String nxb = this.getNXB();
        boolean validNXB = false;
        do{
            nxb = this.getNXB().trim();
            
            if (!nxb.matches("^[a-zA-Z\\s]+$") || nxb.trim().isEmpty()) {
                System.out.println("Ten khong hop le, moi ban nhap lai: ");
                this.setNXB(nhapttsach.nextLine());
                nxb=this.getNXB();
            } else {
                validNXB = true;
            }
        } while (!validNXB);
    }
    public void nhapVaCheckTheLoai(){
        Scanner nhapttsach = new Scanner(System.in);
        boolean validCate = false;
        do{
           try{
               System.out.println("Nhap the loai: ");
               String input = nhapttsach.nextLine().trim();
               this.setTheLoai(input);
               if(!this.getTheLoai().matches("^[a-zA-Z0-9\\s]+$")||this.getTheLoai().trim().isEmpty()){
                   System.out.println("The loai khong hop le, moi ban nhap lai.....");
                   this.setTheLoai(nhapttsach.nextLine().trim());
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
        Scanner nhapttsach = new Scanner(System.in);
        boolean validGia = false;
        do{
            try{
                System.out.println("Nhap gia: ");
                String input = nhapttsach.nextLine().trim();
                this.setDonGia(Double.parseDouble(input));
                
                if(this.getgia()<=0){
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
        Scanner nhapttsach = new Scanner(System.in);
        boolean validSoLuong = false;
        do{
            try{
                System.out.println("Nhap so luong: ");
                String input = nhapttsach.nextLine().trim();
                this.setSoLuong(Integer.parseInt(input));
                
                if(this.getSoLuong()<=0){
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
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Ten sach: ").append(this.getTenSach()).append("\n");
        sb.append("Ma sach: ").append(this.getMaSach()).append("\n");
        sb.append("Ten tac gia: ").append(this.getTacGia()).append("\n");
        sb.append("So trang: ").append(this.getSoTrang()).append(" trang\n");
        sb.append("Nha xuat ban: ").append(this.getNXB()).append("\n");
        sb.append("The loai: ").append(this.getTheLoai()).append("\n");
        sb.append("Gia: ").append(this.getgia()).append("\n");
        sb.append("Mo ta sach: ").append(this.getMoTa()).append("\n");
        sb.append("So luong: ").append(this.getSoLuong()).append("\n");  
        return sb.toString();
    }


}