
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class NhanVien {
	private String ten;
	private String ma;
	private Ngaythangnam ngayVao;
	private String viTri;
	private String loai;
	private double ngayCong;

	public NhanVien() {
		super();
	}

	public NhanVien(String ma, String ten, Ngaythangnam ngayVao, String viTri, String loai, double ngayCong) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.ngayVao = ngayVao;
		this.viTri = viTri;
		this.loai = loai;
		this.ngayCong = ngayCong;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public Ngaythangnam getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(Ngaythangnam ngayVao) {
		this.ngayVao = ngayVao;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public double getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(double ngayCong) {
		this.ngayCong = ngayCong;
	}

	public abstract void xemDonHang(int luachon);

	public void ghiDonVaoFile(ArrayList<CT_DonHang> dsDonHang) {
		String fileName = "Donhang.txt";
		File file = new File(fileName);

		try (FileWriter fileWriter = new FileWriter(file, false)) {
			for (CT_DonHang donhang : dsDonHang) {
				StringBuilder sb = new StringBuilder();
				sb.append(donhang.getMaKH()).append("#");
				sb.append(donhang.getMaDonHang()).append("#");
				sb.append(donhang.getEmail()).append("#");
				sb.append(donhang.getDiaChi()).append("#");
				sb.append(donhang.getNgayDH()).append("#");
				sb.append(donhang.getTongTien()).append("#");
				sb.append(donhang.getPtThanhToan()).append("#");
				sb.append(donhang.getTrangThai());
				sb.append(System.lineSeparator());

				fileWriter.write(sb.toString());
			}
			fileWriter.flush();
		} catch (IOException e) {
			System.out.println("Khong hop le" + e.getMessage());
		}
	}

	public abstract void xacNhanDonHang();

	public void tinhLuong() {
		if (this.getLoai().equalsIgnoreCase("pt")) {

			System.out.println("Tiền lương ngày cho PartTime: " + (40.500 * this.getNgayCong()));
		} else {
			System.out.println("Tien lương tháng cho Fulltime: " + (500.500 * this.getNgayCong()));
		}
	}

}