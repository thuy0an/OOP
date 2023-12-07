

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class TuSach {
    private int soSach;
    private static int sachDaHienThi = 0;
    private ArrayList<Sach> books = new ArrayList<>();

    public TuSach() {
        this.soSach = 0;
    }

    public int getSoSach() {
        return soSach;
    }

    public void setSoSach(int soSach) {
        this.soSach = soSach;
    }

    public ArrayList<Sach> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Sach> books) {
        this.books = books;
    }
    
    public void themSach() {
        Scanner input = new Scanner(System.in);
        String tiepTuc=null;
        do{
            Sach sach = null;
            System.out.println("Ban muon them loai sach nao?");
            System.out.println("1: Sach giay | 2: Sach mem");
            
            String choice = input.nextLine();
            if(!choice.equalsIgnoreCase("1")&&!choice.equalsIgnoreCase("2")){
                System.out.println("Lua chon khong hop le, moi ban nhap lai.....");
                themSach();
            }
            switch (choice) {
            case "1":
                sach = new SachGiay();
                ((SachGiay) sach).nhapThongTinSachChoNhanVien();
                books.add(sach);
                soSach++;
                vietSachVaoFile(choice);
                break;
            case "2":
                sach = new SachMem();
                ((SachMem) sach).nhapThongTinSachMem();
                books.add(sach);
                soSach++;
                vietSachVaoFile(choice);
                break;
            default:
                System.out.println("Lua chon khong phu hop.....");
                break;
            }
            System.out.println("Ban co muon tiep tuc them sach? (Y/N)");
            tiepTuc=input.nextLine();
        }while(!tiepTuc.equalsIgnoreCase("N"));  
    }
    public void vietSachVaoFile(String choice) {
        String fileName = "Sach.txt";
        File file = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (Sach sach : books) {
                StringBuilder sb = new StringBuilder();
                sb.append(sach.getTenSach()).append("#");
                sb.append(sach.getMaSach()).append("#");
                sb.append(sach.getTacGia()).append("#");
                sb.append(sach.getSoTrang()).append("#");
                sb.append(sach.getTheLoai()).append("#");
                sb.append(sach.getNXB()).append("#");
                sb.append(sach.getgia()).append("#");
                sb.append(sach.getMoTa()).append("#");

                if (sach instanceof SachGiay) {
                    sb.append("Giay").append("#");
                    sb.append(((SachGiay) sach).getKichThuoc()).append("#");
                    sb.append(((SachGiay) sach).getLoaiBia()).append("#");
                    sb.append("////").append("#");
                    sb.append("////").append("#");
                    sb.append(((SachGiay) sach).getHienCo());
                } else if (sach instanceof SachMem) {
                    sb.append(((SachMem) sach).getLoai()).append("#");
                    sb.append("////").append("#");
                    sb.append("////").append("#");
                    sb.append(((SachMem) sach).getKichCoDungLuong()).append("#");
                    sb.append(((SachMem) sach).getDungLuong()).append("#");
                    sb.append("////");
                }
                sb.append(System.lineSeparator());
                fileWriter.write(sb.toString());   
            }
            books.clear();
            fileWriter.flush();
            System.out.println("Viet sach vao file thanh cong.....");
        } catch (IOException e) {
            System.out.println("Khong hop le" + e.getMessage());
        }
    }
    public void xoaSachTheoID(){
        Scanner input = new Scanner(System.in);
        String canXoa = input.nextLine();
        try{
            File inputFile = new File("book.txt");
            File tempFile = new File("TempBook.txt");
            
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(tempFile);
            
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                String[] bookDetails = currentLine.split("#");
                if(bookDetails.length>1 && bookDetails[1].equalsIgnoreCase(canXoa)){
                    continue; //Skip writing this line to the temporary file (delete it)
                }
                writer.write(currentLine + System.lineSeparator()); //Write into temporary file
            }
            writer.close();
            scanner.close();
            
            //Replace the original file with the updated one
            if(inputFile.delete()){
                if(!tempFile.renameTo(inputFile)){
                    throw new IOException("Khong the cap nhat ten file.....");
                }
                System.out.println("Xoa sach thanh cong <3");
            }else{
                throw new IOException("Khong the xoa file goc.....");
            }
        }catch(IOException e){
            System.out.println("Co loi khi thao tac voi file: " + e.getMessage());
        }
        
        
    }
    
    public void xoaSachTheoTen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten sach ban muon xoa: ");
        String tenSachCanXoa = input.nextLine();
        
        Iterator<Sach> iterator = books.iterator();
        while(iterator.hasNext()){
            Sach sach = iterator.next();
            if(sach.getTenSach().equalsIgnoreCase(tenSachCanXoa)){
                iterator.remove();
                soSach--;
                System.out.println("Xoa sach thanh cong <3");
                break;
            }
        }
    }
    public void timSachTheoTen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten sach ban muon tim: ");
        String tenSachCanTim = input.nextLine();
        while(!tenSachCanTim.matches("^[a-zA-Z0-9\\s]+$")||tenSachCanTim.isBlank()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            tenSachCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){   //từ đây đến else if là để input dữ liệu từ chuỗi thông tin về sách vào các mục tương ứng
                String line=scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                if(tenSach.toLowerCase().contains(tenSachCanTim)){  //phần này để xét điều kiện để chọn các sách phù hợp yêu cầu để hiển thị
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                   //break; //ngừng tìm khi sách đã được tìm thấy
                }
            }
            
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found) //(found) có nghĩa là cách viết khác của found==true, vậy !found tức là false
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoID(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma sach ban muon tim: ");
        String maSachCanTim = input.nextLine();
        while(!maSachCanTim.matches("^[a-zA-Z0-9\\s]+$")||maSachCanTim.isBlank()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            maSachCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                
                if(maSach.toLowerCase().contains(maSachCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public Sach timSachTheoID(String id){
        String maSachCanTim = id;
        Sach foundSach=null;
        while(!maSachCanTim.matches("^[a-zA-Z0-9\\s]+$")||maSachCanTim.isBlank()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            maSachCanTim=id;
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                
                if(maSach.toLowerCase().contains(maSachCanTim)){
                    foundSach=new Sach();
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        return foundSach;
    }
    public void timSachTheoTG(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten tac gia ma ban muon tim: ");
        String tgCanTim = input.nextLine();
        while(!tgCanTim.matches("^[a-zA-Z\\s]+$")||tgCanTim.isBlank()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            tgCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){               
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                
                if(tacGia.toLowerCase().contains(tgCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoNXB(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap NXB ma ban muon tim: ");
        String nxbCanTim = input.nextLine();
        while(!nxbCanTim.matches("^[a-zA-Z\\s]+$")||nxbCanTim.isBlank()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            nxbCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                
                if(nXB.toLowerCase().contains(nxbCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSachTheoKhoangGia(){
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap gia thap nhat: ");
        Double min = Double.parseDouble(input.nextLine());
        System.out.println("Nhap gia cao nhat: ");
        Double max = Double.parseDouble(input.nextLine());
        System.out.println("\nCac sach tu " + min + " - " + max +": \n" );
        try(Scanner scanner = new Scanner(file)){              
            System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){    
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                if(Gia>=min&&Gia<=max){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        if(!found)
            System.out.println("\nKhong co sach trong khoang nay...");
    }
    public void timSachTheoTheLoai(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap the loai ban muon tim kiem: ");
        String theLoaiCanTim = input.nextLine();
        while(!theLoaiCanTim.matches("^[a-zA-Z\\s]+$")||theLoaiCanTim.isBlank()){
            System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
            theLoaiCanTim=input.nextLine();
        }
        boolean found = false;
        String fileName = "book.txt";
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            System.out.println("\n\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    THONG TIN SACH                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){ 
               String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
                
                if(theloai.toLowerCase().contains(theLoaiCanTim)){
                    System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                    System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println("Khong doc duoc file.....\n" + e.getMessage());
        }
        if(!found)
            System.out.println("Khong tim thay sach.....");
    }
    public void timSach(){
        String code;
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("\t+---------- Query Options ----------+");
        System.out.println("\t|     1. Tim sach theo Ten          |");
        System.out.println("\t|     2. Tim sach theo Ma Sach      |");
        System.out.println("\t|     3. Tim sach theo Tac Gia      |");
        System.out.println("\t|     4. Tim sach theo NXB          |");
        System.out.println("\t|     5. Tim sach theo Gia          |");
        System.out.println("\t|     6. Tim sach theo The Loai     |");
        System.out.println("\t+-----------------------------------+");
        System.out.print("\n Moi ban nhap:  ");
        code = input.nextLine();
        while(!code.equals("1")&&!code.equals("2")&&!code.equals("3")&&!code.equals("4")&&!code.equals("5")&&!code.equals("6")){
            System.out.println("Lua chon khong hop le, vui long nhap lai.....");
            code=input.nextLine();
        }
        switch(code){
            case "1":
                System.out.println("\n\n\t\t\tTIM SACH THEO TEN");
                timSachTheoTen();
                break;
            case "2":
                System.out.println("\n\n\t\t\tTIM SACH THEO MA SACH");
                timSachTheoID();
                break;
            case "3":
                System.out.println("\n\n\t\t\tTIM SACH THEO TAC GIA");
                timSachTheoTG();
                break;
            case "4":
                System.out.println("\n\n\t\t\tTIM SACH THEO NXB");
                timSachTheoNXB();
                break;
            case "5":
                System.out.println("\n\n\t\t\tTIM SACH THEO KHOANG GIA");
                timSachTheoKhoangGia();
                break;
            case "6":
                System.out.println("\n\n\t\t\tTIM SACH THEO THE LOAI");
                timSachTheoTheLoai();
                break;
        }
        System.out.println("Ban co muon tiep tuc tim kiem? (Y/N)");
        String opt=input.nextLine();
        while(!opt.toLowerCase().equalsIgnoreCase("N")&&!opt.toLowerCase().equalsIgnoreCase("Y")&&!opt.toLowerCase().equalsIgnoreCase("No")&&!opt.toLowerCase().equalsIgnoreCase("Yes")){
                        System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
                        opt = input.nextLine();
                    }
        if(opt.toLowerCase().equalsIgnoreCase("Y")||opt.toLowerCase().equalsIgnoreCase("Yes"))
            timSach();
    }

    public static void hienThiSachDangKinhDoanh() { 
        File file= new File("book.txt");
        try (Scanner scanner = new Scanner(file)) 
        {
            System.out.println("\n\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                    BOOK  DATABASE                                                                                                                                                                                 |");
            System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
//            System.out.println("|"+"                      Ten Sach                     |" +"  Ma Sach "+"|" + "          Tac Gia              |"+"So Trang  "+"|"+ "     The Loai   |"+ "       NXB      "+"|"+ "    Gia    |"+"                            Mo Ta                  |"+ " Loai Sach|"+ " Size|"+ " Loai Bia |"+ "FSize|"+ "Dung Luong|"+ " So Luong |");
            System.out.printf("| %-50s| %-10s| %-30s| %-9s| %-15s| %-15s| %-10s| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", "Ten Sach", "Ma Sach", "Tac Gia", "So Trang", "The Loai", "NXB", "Gia", "Mo Ta", "Loai Sach","Size","Loai Bia","FSize","Dung Luong","So Luong", "|");
            System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");
            while(scanner.hasNextLine()){   //.availabe: tra ve 1 luong byte co the doc, neu <=0 tuc la doc khong thanh cong
                sachDaHienThi++;
                String line = scanner.nextLine();
                String[] sachDuocDoc = line.split("#");
                String tenSach = sachDuocDoc[0];
                String maSach = sachDuocDoc[1];
                String tacGia = sachDuocDoc[2];
                int soTrang = Integer.parseInt(sachDuocDoc[3]);
                String theloai = sachDuocDoc[4];
                String nXB = sachDuocDoc[5];
                double Gia = Double.parseDouble(sachDuocDoc[6]);
                String moTa = sachDuocDoc[7];
                String loaiSach = sachDuocDoc[8];
                String kichThuoc="";
                String loaiBia="";
                String kichCoDungLuong="";
                String dungLuong="";
                String soLuong="";
                if ( loaiSach.equals("Giay")){
                    kichThuoc = sachDuocDoc[9];
                    loaiBia = sachDuocDoc[10];
                    kichCoDungLuong="////";
                    dungLuong="////";
                    soLuong=sachDuocDoc[13];
                }
                else if(loaiSach.toLowerCase().equalsIgnoreCase("PDf")||loaiSach.toLowerCase().equalsIgnoreCase("EPUB")){
                    kichThuoc="////";
                    loaiBia="////";
                    kichCoDungLuong = sachDuocDoc[11];
                    dungLuong =sachDuocDoc[12];
                    soLuong="////";
                }
//                int soLuong = Integer.parseInt(sachDuocDoc[11]);
//                if (loaiSach.equals("Giay")) 
//                    System.out.printf("| %-50s| %-9s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-50s| %-5s| %-5s| %-5s|%n",tenSach, maSach, tacGia, soTrang, theloai, nXB, donGia, moTa, loaiSach, kichThuoc, loaiBia, soLuong, "|");
//                else{
//                    System.out.printf("| %-50s| %-9s| %-30s| %-9d| %-15s| %-15s| %-10.2f| %-50s| %-5s| %-5s| %-5s| %n",tenSach, maSach, tacGia, soTrang, theloai, nXB, donGia, moTa, loaiSach, kichCoDungLuong, dungLuong, soLuong, "|");
//                }
//                System.out.println("+---------------------------------------------------+----------+-------------------------------+----------+----------------+----------------+-----------+---------------------------------------------------+----------+-----+----------+-----+----------+----------+");
                System.out.printf("| %-50s| %-10s| %-30s| %-9d| %-15s| %-15s| %-10.3f| %-45s| %-9s| %-4s| %-9s| %-6s| %-10s| %-10s| %n", tenSach, maSach, tacGia, soTrang, theloai, nXB, Gia, moTa, loaiSach, kichThuoc, loaiBia, kichCoDungLuong, dungLuong,soLuong,"|");
                System.out.println("+---------------------------------------------------+-----------+-------------------------------+----------+----------------+----------------+-----------+----------------------------------------------+----------+-----+----------+-------+-----------+-----------+");


                if(sachDaHienThi%10==0){
                    System.out.println("Ban co muon tiep tuc hien thi? (Y/N)");
                    Scanner input = new Scanner(System.in);
                    String opt = input.nextLine();
                    
                    while(!opt.toLowerCase().equalsIgnoreCase("N")&&!opt.toLowerCase().equalsIgnoreCase("Y")&&!opt.toLowerCase().equalsIgnoreCase("No")&&!opt.toLowerCase().equalsIgnoreCase("Yes")){
                        System.out.println("Lua chon khong phu hop, vui long nhap lai.....");
                        opt = input.nextLine();
                    }
                    if(opt.toLowerCase().equalsIgnoreCase("N")){
                        sachDaHienThi=0;
                        break;
                    }
                    System.out.println("+---------------------------------------------------+----------+-------------------------------+----------+----------------+----------------+-----------+---------------------------------------------------+----------+-----+----------+-----+----------+----------+");

                }
            }
        }catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
    
    public void chinhSuaThongTinSach(){
        
    }
    
    
    public static void main(String [] args){
        TuSach tuSach = new TuSach();
        Scanner input = new Scanner(System.in);
        
//        //Them sach cach 1
//        System.out.println("Nhap so luong sach ban muon them: ");
//        int soLuongSach = Integer.parseInt(input.nextLine());
//        for(int i =0;i<soLuongSach;i++){
//            Sach sach = new Sach(); //sach ở đây là instance variable, được tạo khi một đối tượng được tạo bằng việc sử dụng từ khóa new và sẽ bị phá hủy khi đối tượng bị phá hủy. 
//            sach.nhapThongTinSach();
//            tuSach.themSach(sach);
//        }
        //Them sach cach 2
//        tuSach.themSach();
        //Viet sach vao file
        //tuSach.vietSachVaoFile("book.txt");
        //Hien thi nhung sach dang kinh doanh
        tuSach.hienThiSachDangKinhDoanh();

        //Xoa sach theo ID
        //tuSach.xoaSachTheoID();
//        //Xoa sach theo ten
//        tuSach.xoaSachTheoTen();
//        tuSach.hienThiSachDangCo();
//        //Danh gia sach
//        tuSach.danhGia();
//        String danhGiaTuKhachHang = tuSach.danhGiaTuKhachHang();
//        System.out.println(danhGiaTuKhachHang);
//        //Menu Tim Sach
        tuSach.timSach();
        
       
    }
}
