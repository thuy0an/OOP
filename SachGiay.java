    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.bookstore_management;

import java.util.Scanner;

    /**
     *
     * @author ACER
     */
    public class SachGiay extends Sach{
        private String kichThuoc;
        private String loaiBia;
        private int hienCo;
        private String maSachGiay;

        public SachGiay() {
        }

        public SachGiay(String kichThuoc, String loaiBia, int hienCo) {
            this.kichThuoc = kichThuoc;
            this.loaiBia = loaiBia;
            this.hienCo = hienCo;
        }

        public String getKichThuoc() {
            return kichThuoc;
        }

        public void setKichThuoc(String kichThuoc) {
            this.kichThuoc = kichThuoc;
        }

        public String getLoaiBia() {
            return loaiBia;
        }

        public void setLoaiBia(String loaiBia) {
            this.loaiBia = loaiBia;
        }

        public int getHienCo() {
            return hienCo;
        }

        public void setHienCo(int hienCo) {
            this.hienCo = hienCo;
        }

        public void nhapVaCheckHienCo(){
            Scanner nhapttSachGiay = new Scanner(System.in);
            boolean validHienCo = false;
            do{
                try{
                    System.out.println("Nhap so luong: ");
                    String input = nhapttSachGiay.nextLine().trim();
                    this.hienCo = Integer.parseInt(input);
                    
                    if(this.hienCo<=0){
                        System.out.println("So luong phai lon 0, moi ban nhap lai.....");
                        this.hienCo = Integer.parseInt(input); 
                    }
                    else{
                        validHienCo = true;
                    }
                }catch(NumberFormatException e){
                    System.out.println("So luong khong hop le, moi ban nhap lai.....");
                }
            }while(!validHienCo);
        }
       public void checkKichThuoc(){
            String kichThuoc = this.kichThuoc;
            boolean validSize = false;
            do{
                if(!kichThuoc.equalsIgnoreCase("A4")&&!kichThuoc.equalsIgnoreCase("A5")){
                    System.out.println("Kich thuoc sach khong hop le, moi ban nhap lai.....");
                    this.kichThuoc=nhapttsach.nextLine();
                    kichThuoc=this.kichThuoc;
                }
                else{
                    validSize = true;
                }
            }while(!validSize);
        }
        public void checkLoaiBia(){
            String loaiBia = this.loaiBia;
            boolean validBia = false;
            do{
                if(!loaiBia.toLowerCase().equalsIgnoreCase("Bia cung")&&!loaiBia.toLowerCase().equalsIgnoreCase("Bia mem")){
                    System.out.println("Loai bia khong hop le, moi ban nhap lai.....");
                    this.loaiBia=nhapttsach.nextLine();
                    loaiBia=this.loaiBia;
                }
            }while(!validBia);
        }
        public void nhapThongTinSachGiay(){
            // Call inherited methods to input common book information
            super.nhapThongTinSachChoNhanVien(); // Utilize the input method from the Sach class
            Scanner nhapttSachGiay = new Scanner(System.in);
            
            // Input specific information for paper books
            System.out.println("Nhap kich thuoc sach: ");
            this.kichThuoc = nhapttSachGiay.nextLine();
            checkKichThuoc();
            
            System.out.println("Nhap loai bia: ");
            this.loaiBia = nhapttSachGiay.nextLine();
            checkLoaiBia();
//            System.out.println("Nhap so luong: ");
//            this.hienCo = Integer.parseInt(nhapttSachGiay.nextLine());
            nhapVaCheckHienCo();
        }
        @Override
        public String toString(){
            String superString = super.toString();
            StringBuilder sb = new StringBuilder(superString);
            sb.append("Kich thuoc: ").append(this.kichThuoc).append("\n");
            sb.append("Loai bia: ").append(this.loaiBia).append("\n");
            sb.append("Hien co: ").append(this.hienCo).append("\n");
            
            return sb.toString();
        }
        public static void main(String[] args){
            SachGiay sachgiay = new SachGiay();
            sachgiay.nhapThongTinSachGiay();
            System.out.println("Thong tin sach giay: " + sachgiay.toString());
        }

    }
