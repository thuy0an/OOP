import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class khoPhieuGiamGia {
	private ArrayList<PhieuGiamGia> dsPhieuGiamGia=new ArrayList<>();
	public khoPhieuGiamGia() {
		
	}
	public ArrayList<PhieuGiamGia> docPhieuGiamGiaTuFile() {
		File file = new File("phieugiamgia.txt");
		ArrayList<PhieuGiamGia> dsPhieuGiamGia = new ArrayList<>();
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] phieugiamgiaFile=line.split("#");
				String maGiamGia=phieugiamgiaFile[0];
				String loaiGiamGia=phieugiamgiaFile[1];
				int giam=Integer.parseInt(phieugiamgiaFile[2]);
				int donToiThieu=Integer.parseInt(phieugiamgiaFile[3]);
				int soLuongTon=Integer.parseInt(phieugiamgiaFile[4]);
				PhieuGiamGia phieugiamgia=new PhieuGiamGia( maGiamGia,  loaiGiamGia,  giam,  donToiThieu, soLuongTon);
				dsPhieuGiamGia.add(phieugiamgia);
			}
			
		} catch (

		FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
		return dsPhieuGiamGia;
	}
	public void  giamSoLuongTonPhieuGiam(String maGiamGia) {
		ArrayList<PhieuGiamGia> dsPhieuGiamGia=docPhieuGiamGiaTuFile();
		for(PhieuGiamGia phieugiamgia:dsPhieuGiamGia) {
			if(phieugiamgia.getMaGiamGia().equals(maGiamGia));
			phieugiamgia.setSoLuongTon(phieugiamgia.getSoLuongTon()-1);
		}
		ghiPhieuGiamGiaVaoFile(dsPhieuGiamGia);
		
		
	}
	public void ghiPhieuGiamGiaVaoFile(ArrayList<PhieuGiamGia> dsphieugiamgia) {
		String fileName = "phieugiamgia.txt";
		File file = new File(fileName);
		
		try (FileWriter fileWriter = new FileWriter(file, true)) {
			for(PhieuGiamGia phieugiamgia:dsphieugiamgia) {
				StringBuilder sb=new StringBuilder();
				sb.append(phieugiamgia.getMaGiamGia()).append("#");
				sb.append(phieugiamgia.getLoaiGiamGia()).append("#");
				sb.append(phieugiamgia.getGiam()).append("#");
				sb.append(phieugiamgia.getDonToiThieu()).append("#");
				sb.append(phieugiamgia.getSoLuongTon());
				fileWriter.write(sb.toString());
			}
			System.out.println("Viet sach vao file thanh cong.....");
		} catch (IOException e) {
			System.out.println("Khong hop le" + e.getMessage());
		}

	}
	public boolean checkDonToiThieu(CT_DonHang donhang,PhieuGiamGia phieugiamgia) {
		if(phieugiamgia.getSoLuongTon()<1 )return false;
		if(phieugiamgia.getLoaiGiamGia().equalsIgnoreCase("codinh")) {
			int soLuongSP=donhang.getDsSanPham().split(";").length;
			return soLuongSP>=phieugiamgia.getDonToiThieu();
		}else {
			return donhang.getTongTien()>=phieugiamgia.getDonToiThieu();
		}
	}
	public PhieuGiamGia chonPhieuGiamGia(String maPhieu) {
		ArrayList<PhieuGiamGia> dsPhieuGiamGias=docPhieuGiamGiaTuFile();
		for(PhieuGiamGia phieugiamgia:dsPhieuGiamGia) {
			if(phieugiamgia.getMaGiamGia().equals(maPhieu)) return phieugiamgia;
		}
		return null;
	}
	public void hienThiPhieuGiamGiaDuDieuKien(CT_DonHang donhang) {
		ArrayList<PhieuGiamGia> dsPhieuGiamGia=docPhieuGiamGiaTuFile();
		System.out.println("\n+-----------------------------------------------+");
		System.out.println("|                    PHIEU GIAM GIA             |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Ma giam gia || Loai giam gia || Don Toi Thieu |");
		System.out.println("|-----------------------------------------------|");
		for(PhieuGiamGia phieugiamgia:dsPhieuGiamGia) {
			if(checkDonToiThieu(donhang, phieugiamgia)) {
				System.out.println(phieugiamgia.toString());
			}
		}
		System.out.println("|-----------------------------------------------|");
	}
//	public boolean checkDonToiThieu(CT_DonHang donhang) {
//		if(this.getSoLuongTon()<1) return false;
//		if(loaiGiamGia.equalsIgnoreCase("codinh")) {
//			int soLuongSP=donhang.getDsSanPham().split(";").length;
//			
//			return soLuongSP>=(int)this.getDonToiThieu();
//		}else {
//			return donhang.getTongTien()>=this.getDonToiThieu();
//		}
//	}
}
