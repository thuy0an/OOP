import java.util.Scanner;

public class APP {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Nhap tk:");
		Scanner sc=new Scanner(System.in);
		String username=sc.nextLine();
		System.out.println("Nhap mk");
		String pass=sc.nextLine();
		taiKhoanNhanVien tk=new taiKhoanNhanVien();
		NhanVien nhanvien=tk.xacMinhTaiKhoanNhanVien(username, pass);
		if(nhanvien!=null) {
			if(nhanvien instanceof NhanVienGiaoHang) {
				NhanVienGiaoHang nv=(NhanVienGiaoHang) nhanvien;
				nv.quanLyDonHang();
			}else if(nhanvien instanceof NhanVienQuanLy) {
				NhanVienQuanLy nv=(NhanVienQuanLy) nhanvien;
				nv.quanLy();
			}
		}else {
			System.out.println("Vui long kiem tra tai khoan va mat khau");
		}
		
	}
}
