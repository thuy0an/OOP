
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
import java.util.Scanner;
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
                if(!this.loai.equalsIgnoreCase("PDF")&&!this.loai.equalsIgnoreCase("EPUB")||this.loai.isBlank()){
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
    public void nhapThongTinSachMem(){
        nhapVaCheckLoaiSach();
        super.nhapThongTinSachChoNhanVien();
        nhapVaCheckDungLuong();
       
    }
    
//   public void nhapVaCheckDungLuong(){
//        String s1 = "kb";
//        String s2 = "mb";
//        String s3 = "gb";
//        boolean validSize = false;
//        
//        System.out.println("Nhap kich co dung luong: ");
//        input1 = nhapttsachmem.nextLine().trim();
//        
//        do{
//            if(input1.equalsIgnoreCase(s1)){
//                do{
//                    try{
//                        System.out.println("Nhap dung luong: ");
//                        String dungluong = nhapttsachmem.nextLine().trim();
//                        this.dungLuong=Double.parseDouble(dungluong);
//                        if(this.dungLuong<0){
//                            System.out.println("Dung luong phai lon hon hoac bang 0, moi ban nhap lai.....");
//                        }
//                        else{
//                            validSize = true;
//                        }
//                    }catch(NumberFormatException e){
//                        System.out.println("Dung luong khong hop le, moi ban nhap lai.....");
//                    } 
//                }while(!validSize);
//            }
//            else if(input1.equalsIgnoreCase(s2)){
//                do{
//                    try{
//                        System.out.println("Nhap dung luong: ");
//                        String dungluong = nhapttsachmem.nextLine().trim();
//                        this.dungLuong=Double.parseDouble(dungluong);
//                        if(this.dungLuong<0){
//                            System.out.println("Dung luong phai lon hon hoac bang 0, moi ban nhap lai.....");
//                        }
//                        else{
//                            validSize = true;
//                        }
//                    }catch(NumberFormatException e){
//                        System.out.println("Dung luong khong hop le, moi ban nhap lai.....");
//                    } 
//                }while(!validSize);
//            }
//            else if(input1.equalsIgnoreCase(s3)){
//                do{
//                    try{
//                        System.out.println("Nhap dung luong: ");
//                        String dungluong = nhapttsachmem.nextLine().trim();
//                        this.dungLuong=Double.parseDouble(dungluong);
//                        if(this.dungLuong<0){
//                            System.out.println("Dung luong phai lon hon hoac bang 0, moi ban nhap lai.....");
//                        }
//                        else{
//                            validSize = true;
//                        }
//                    }catch(NumberFormatException e){
//                        System.out.println("Dung luong khong hop le, moi ban nhap lai.....");
//                    } 
//                }while(!validSize);
//            }
//        }while(!"kb".equalsIgnoreCase(input1)&&!"mb".equalsIgnoreCase(input1)&&!"gb".equalsIgnoreCase(input1));
//        
//    } phien ban chua hoan hao
        
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
        sachmem.nhapThongTinSachMem();
        
        System.out.println(sachmem.toString());
    }
}

/*
nhapVaCheckDungLuong cach 2:
public void nhapVaCheckDungLuong(){
        boolean validSizeType = false;
        do{
            System.out.println("Nhap kich co dung luong (kb/mb/gb): ");
            input1 = nhapttsachmem.nextLine().trim();
            
            if(!input1.equals(s1)&&!input1.equals(s2)&&!input1.equals(s3)){
                System.out.println("Kich co khong hop le, moi ban nhap lai.....");
            }
            else{
                String choice = input1.toLowerCase();
                switch(choice){
                    case "kb":
                        this.kichCoDungLuong="kb";
                        validSizeType=true;
                    case "mb":
                        this.kichCoDungLuong="mb";
                        validSizeType=true;
                    case "gb":
                        this.kichCoDungLuong="gb";
                        validSizeType=true;
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
*/
