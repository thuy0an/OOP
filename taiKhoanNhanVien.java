import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class taiKhoanNhanVien {
	private String password;
	private String username;

	public taiKhoanNhanVien() {

	}

	public taiKhoanNhanVien(String password, String username) {
		this.password = password;
		this.username = username;

	}

	public taiKhoanNhanVien(taiKhoanNhanVien tk) {
		this.password = tk.getPassword();
		this.username = tk.getUsername();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public NhanVien dangNhapTaiKhoanNhanVien(String username) {
		File file = new File("D:\\Lap trinh java\\BookStore\\nhanvien.txt");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] nhanvien = line.split("#");
				String maNhanVien = nhanvien[0];// 0
				String tenNhanVien = nhanvien[1];
				String ngayVaoLam = nhanvien[2];
				String viTri = nhanvien[3];
				String loai = nhanvien[4];
				String soCong = nhanvien[5];
				Ngaythangnam ngayvao = new Ngaythangnam(ngayVaoLam);
				if (maNhanVien.equals(username)) {
					if (viTri.equalsIgnoreCase("quanly")) {
						NhanVienQuanLy nvql = new NhanVienQuanLy(maNhanVien, tenNhanVien, ngayvao, viTri, loai,
								Double.parseDouble(soCong));
						return nvql;
					} else {
						NhanVienGiaoHang nvgh = new NhanVienGiaoHang(maNhanVien, tenNhanVien, ngayvao, viTri, loai,Double.parseDouble(soCong));
						return nvgh;
					}
					
				}
			}

		} catch (

		FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
		return null;
	}


	public NhanVien xacMinhTaiKhoanNhanVien(String username, String password) {

		File file = new File("D:\\Lap trinh java\\BookStore\\taikhoannhanvien.txt");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] nhanvien = line.split("#");
				String maNhanVien = nhanvien[0];// 0
				String matKhau = nhanvien[1];
				if (maNhanVien.equals(username) && matKhau.equals(password)) {
					NhanVien nv= dangNhapTaiKhoanNhanVien(username);
					return nv;
				}
			}

		} catch (

		FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
		return null;
	}
	
}
