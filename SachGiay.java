    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
package BookStore;


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
                    this.setHienCo(Integer.parseInt(input));
                    
                    if(this.getHienCo()<=0){
                        System.out.println("So luong phai lon 0, moi ban nhap lai.....");
                        this.setHienCo(Integer.parseInt(input));
                    }
                    else{
                        validHienCo = true;
                    }
                }catch(NumberFormatException e){
                    System.out.println("So luong khong hop le, moi ban nhap lai.....");
                }
            }while(!validHienCo);
        }
        
        public void nhapThongTinSachGiay(){
            super.nhapThongTinSachChoNhanVien();
            Scanner nhapttSachGiay = new Scanner(System.in);

            System.out.println("Nhap kich thuoc sach: ");
            this.setKichThuoc(nhapttSachGiay.nextLine());
            
            System.out.println("Nhap loai bia: ");
            this.setLoaiBia(nhapttSachGiay.nextLine());
            
            nhapVaCheckHienCo();
        }
        
        @Override
        public String toString(){
            String superString = super.toString();
            StringBuilder sb = new StringBuilder(superString);
            sb.append("Kich thuoc: ").append(this.getKichThuoc()).append("\n");
            sb.append("Loai bia: ").append(this.getLoaiBia()).append("\n");
            sb.append("Hien co: ").append(this.getHienCo()).append("\n");
            
            return sb.toString();
        }

    }
