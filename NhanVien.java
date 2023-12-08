import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class NhanVien {
	private String ten;
	private int ma;
	private Ngaythangnam ngayVao;
	private int viTri;
	private int loai;

	public NhanVien() {
		super();
	}

	public NhanVien(String ten, int ma, Ngaythangnam ngayVao, int viTri, int loai) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.ngayVao = ngayVao;
		this.viTri = viTri;
		this.loai = loai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public Ngaythangnam getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(Ngaythangnam ngayVao) {
		this.ngayVao = ngayVao;
	}

	public int getViTri() {
		return viTri;
	}

	public void setViTri(int viTri) {
		this.viTri = viTri;
	}

	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public void xemDonHang() {
	}

	public void xemDonHang(int luachon)  {
	}

	public ArrayList<CT_DonHang> docDonHangTuFile() {
		File file = new File("D:\\Lap trinh java\\BookStore\\donhang.txt");
		ArrayList<CT_DonHang> dsDonHang = new ArrayList<>();
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] donHangFile = line.split("#");
				String maKhachHang = donHangFile[0];// 0
				String maDonHang = donHangFile[1];// 1
				String email = donHangFile[2];// 2
				String diaChi = donHangFile[3];// 3
				String ngayDH = donHangFile[4];// 4
				String dsSanPham = donHangFile[5];
				Double tongTien = Double.parseDouble(donHangFile[6]);// 6
				String ptThanhToan = donHangFile[7];// 7
				int trangThai = Integer.parseInt(donHangFile[8]);//
				CT_DonHang donhang = new CT_DonHang(maKhachHang, maDonHang, email, diaChi, ngayDH, dsSanPham, tongTien,
						ptThanhToan, trangThai);
				dsDonHang.add(donhang);
			}

		} catch (

		FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
		return dsDonHang;
	}

	public void ghiDonVaoFile(ArrayList<CT_DonHang> dsDonHang) {
		String fileName = "Donhang.txt";
		File file = new File(fileName);

		try (FileWriter fileWriter = new FileWriter(file, true)) {
			for (CT_DonHang donhang : dsDonHang) {
				StringBuilder sb = new StringBuilder();
				sb.append(donhang.getMaKH()).append("#");
				sb.append(donhang.getMaDonHang()).append("#");
				sb.append(donhang.getEmail()).append("#");
				sb.append(donhang.getDiaChi()).append("#");
				sb.append(donhang.getNgayDH()).append("#");
				sb.append(donhang.getDsSanPham()).append("#");
				sb.append(donhang.getTongTien()).append("#");
				sb.append(donhang.getPtThanhToan()).append("#");
				sb.append(donhang.getTrangThai());
				sb.append("#").append(System.lineSeparator());

				fileWriter.write(sb.toString());
			}
			fileWriter.flush();
			System.out.println("Viet sach vao file thanh cong.....");
		} catch (IOException e) {
			System.out.println("Khong hop le" + e.getMessage());
		}
	}

	
	public void xacNhanDonHang() {
	}

	public String toString() {
		return "\nMa nhan vien: "+this.ma+"\nTen nhan vien: "+this.ten+"Ngay vao lam: "+this.ngayVao;

	}

	public void tinhLuong() {
	}

}
