/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaiKhoanNhanVien {
	private String password;
	private String username;

	public TaiKhoanNhanVien() {

	}

	public TaiKhoanNhanVien(String password, String username) {
		this.password = password;
		this.username = username;

	}

	public TaiKhoanNhanVien(TaiKhoanNhanVien tk) {
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
		File file = new File("nhanvien.txt");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] nhanvien = line.split("#");
				String maNhanVien = nhanvien[0];
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


	public NhanVien xacMinhTaiKhoanNhanVien() 
        {
            int tieptuc=1,flag=0;
            do
            {
                Scanner input= new Scanner(System.in);
                System.out.println("----------Dăng nhập vào tài khoản----------");
                String tenDangNhap, matKhau;
                System.out.print("1.Tên đăng nhập: ");
                tenDangNhap=input.nextLine();
                System.out.print("2.Mật khẩu: ");
                matKhau=input.nextLine();
                File file = new File("taikhoannhanvien.txt");
		try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
			String[] nhanvien = line.split("#");
			String maNhanVien = nhanvien[0];
			String mkNhanVien = nhanvien[1];
			if (maNhanVien.equals(tenDangNhap) && mkNhanVien.equals(matKhau)) 
                        {
                            flag=1;
                            NhanVien nv= dangNhapTaiKhoanNhanVien(tenDangNhap);
                            return nv;
                        }
                    }
                    if (flag !=1)
                    {
                        do{
                            System.out.println("Tài khoản nhâp sai!");
                            System.out.println("Bạn có muốn nhập lại ?");
                            System.out.println("0.Không\t 1.Có");    
                            tieptuc=Integer.parseInt(input.nextLine());
                            if (tieptuc != 1 && tieptuc != 0)
                                System.out.println("Vui lòng chọn đúng thao tác !!");
                        }while (tieptuc != 1 && tieptuc != 0);
                    }
		}
                catch (FileNotFoundException e) {
			System.out.println("Khong tim duoc file: " + e.getMessage());
		} 
                catch (Exception e) {
			System.out.println("Da co loi xay ra: " + e.getMessage());
		}
		
            }while ( tieptuc==1);
            return null;
	}
	
}
