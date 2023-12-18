package com.mycompany.bookstore_management;


import com.mycompany.bookstore_management.Sach;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class SachMem extends Sach{
    private String loai;
    private String kichCoDungLuong;
    private double dungLuong;
    private String maSachMem;
    private String s1="kb";
    private String s2="mb";
    private String s3="gb";
    Scanner nhapttsachmem = new Scanner(System.in);
    String input1;
    public SachMem() {
    }

    public SachMem(String loai, double dungLuong) {
        this.loai = loai;
        this.dungLuong = dungLuong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getKichCoDungLuong() {
        return kichCoDungLuong;
    }

    public void setKichCoDungLuong(String kichCoDungLuong) {
        this.kichCoDungLuong = kichCoDungLuong;
    }

    public double getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(double dungLuong) {
        this.dungLuong = dungLuong;
    }

    
    public void nhapVaCheckLoaiSach(){
        boolean validType = false;
        do{
            try{
                System.out.println("Nhap loai sach (PDF/EPUB): ");
                String input = nhapttsachmem.nextLine().trim();
                this.loai = input;
                if(!this.loai.equalsIgnoreCase("PDF")&&!this.loai.equalsIgnoreCase("EPUB")||this.loai.isEmpty()){
                    System.out.println("Loai sach khong hop le, moi ban nhap lai.....");
                    this.loai= input;
                }
                else{
                    validType = true;
                }
            }catch(Exception e){
                System.out.println("Loai sach khong hoo le, moi ban nhap lai.....");
            }
        }while(!validType);
    }
    
    public void nhapVaCheckDungLuong(){
        boolean validSizeType = false;
        do{
            System.out.println("Nhap kich co dung luong (kb/mb/gb): ");
            input1 = nhapttsachmem.nextLine().trim();
            
            if(!input1.equals(s1)&&!input1.equals(s2)&&!input1.equals(s3)){
                System.out.println("Kich co khong hop le, moi ban nhap lai.....");
            }
            else{
                if(input1.toLowerCase().equalsIgnoreCase(s1)){
                    this.kichCoDungLuong=s1;
                    validSizeType = true;
                }
                else if(input1.toLowerCase().equalsIgnoreCase(s2)){
                    this.kichCoDungLuong=s2;
                    validSizeType = true;
                }
                else if(input1.toLowerCase().equalsIgnoreCase(s3)){
                    this.kichCoDungLuong=s2;
                    validSizeType = true;
                }
            }
        }while(!validSizeType);
        
        // Prompt for size input based on the validated size type
        try{
            System.out.println("Nhap dung luong: ");
            String dungluong = nhapttsachmem.nextLine().trim();
            this.dungLuong = Double.parseDouble(dungluong);
            if(this.dungLuong<0){
                System.out.println("Dung luong phai lon hon hoac bang 0, moi ban nhap lai.....");
                nhapVaCheckDungLuong();
            }
        }catch(NumberFormatException e){
            System.out.println("Dung luong khong hop le, moi ban nhap lai.....");
            nhapVaCheckDungLuong();
        }
    }
    public void nhapThongTinSachMem(Sach sach){
        super.setTenSach(sach.getTenSach());
        super.setMaSach((sach.getMaSach()));
        super.setTacGia(sach.getTacGia());
        super.setSoTrang(sach.getSoTrang());
        super.setTheLoai(sach.getTheLoai());
        super.setNXB(sach.getNXB());
        super.setGia(sach.getGia());
        super.setMoTa(sach.getMoTa());
        super.setLoaiSach(sach.getLoaiSach());
        nhapVaCheckLoaiSach();
        nhapVaCheckDungLuong();
    }

    @Override
    public String toString(){
        String superString = super.toString();
        StringBuilder sb = new StringBuilder(superString);
        sb.append("Loai sach: ").append(this.loai).append("\n");
        sb.append("Dung luong: ").append(this.dungLuong).append(input1).append("\n");
        return sb.toString();
    }
    
    public static void main(String[]args){
        SachMem sachmem = new SachMem();
        sachmem.nhapThongTinSachMem(sachmem);
        
        System.out.println(sachmem.toString());
    }
}
