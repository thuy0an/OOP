package BookStore;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhanVienQuanLy extends NhanVien {
	public NhanVienQuanLy() {
		super();
	}
	public NhanVienQuanLy(String ma, String ten, Ngaythangnam ngayVao, String viTri, String loai,double ngayCong) {
		super(ma, ten, ngayVao, viTri, loai,ngayCong) ;
			
	}
        private String trangThai(int so)
        {
            if ( so==1)
                return "Đang xử lý";
            else if ( so==2)
                return "Đã xử lý";
            else if ( so==3)
                return "Đang giao hàng";
            else if ( so==4)
                return "Đã nhận hàng";
            return "";
        }
        
        public void quanLySach() {
		TuSach tuSach = new TuSach();
		Scanner input = new Scanner(System.in);
		int luachon=0;
		do {
                        System.out.println("\t+-------------------------------------------------------------------------+");
			System.out.println("\t|                                     QUẢN LÝ SÁCH                        |");
			System.out.println("\t|-------------------------------------------------------------------------|");
			System.out.printf("\t| %-35s| %-35s|\n","1.Hiển thị sách đang kinh doanh","2.Tìm sách theo thông tin");
			System.out.printf("\t| %-35s| %-35s|\n","3.Chỉnh sửa thông tin sách","4.Thêm sách mới");
			System.out.printf("\t| %-72s|\n","0.Thoát quản lý sách");
			System.out.println("\t+-------------------------------------------------------------------------+");
                    try {
                        System.out.print("Nhập lựa chọn: ");
			luachon = Integer.parseInt(input.nextLine());
			switch (luachon) 
                        {
			case 0:
				break;
			case 1:
				tuSach.hienThiSachDangKinhDoanh();
				input.nextLine();
				break;
			case 2:
				tuSach.timSach();
				input.nextLine();
				break;
			case 3:
				tuSach.chinhSuaThongTinSach();
				input.nextLine();
				break;
			case 4:
				tuSach.themSach();
				input.nextLine();
				break;
			}
                        if (luachon <0 || luachon >4)
                            System.out.println("Vui lòng nhập đúng các chức năng");

                    }catch(NumberFormatException ei)
                    {
                        System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                        luachon=1;
                    }	
		} while (luachon != 0);
	}

	public void quanLyDonHang() {
		int luachon=0;
		Scanner input = new Scanner(System.in);
		do {
                        System.out.println("\t+-------------------------------------------------------------------------+");
			System.out.println("\t|                           QUẢN LÝ ĐƠN HÀNG                              |");
			System.out.println("\t|-------------------------------------------------------------------------|");
                        
			System.out.printf("\t| %-35s| %-35s|\n","1.Xem tất cả đơn hàng","2.Xem đơn hàng chưa xác nhận");
			System.out.printf("\t| %-35s| %-35s|\n","3.Xen đơn hàng đã xác nhận","4.Xác nhận đơn hàng");
			System.out.printf("\t| %-72s|\n","0.Thoát quản lý đơn hàng");
			System.out.println("\t+-------------------------------------------------------------------------+");
                        try 
                        {                       
                            System.out.print("Nhap lua chon: ");
                            luachon = Integer.parseInt(input.nextLine());
                            switch (luachon) {
                                case 0:
                                        break;
                                case 1:
                                        xemDonHang(1);
                                        input.nextLine();
                                        break;
                                case 2:
                                        xemDonHang(2);
                                        input.nextLine();
                                        break;
                                case 3:
                                        xemDonHang(3);
                                        input.nextLine();
                                        break;
                                case 4:
                                        xacNhanDonHang();
                                        input.nextLine();
                                        break;
                                }
                            if (luachon <0 || luachon >4)
                            System.out.println("Vui lòng nhập đúng các chức năng");
                        }
                        catch(NumberFormatException ei){
                        System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                        luachon=1;
                    }	

		} while (luachon != 0);
	}

	@Override
	public void xemDonHang(int luachon) {
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		switch (luachon) {
		case 1:
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) 
                        {
                            System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
						donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
						donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(), trangThai(donhang.getTrangThai()),
						donhang.getDsSanPham());
                            try {
				Thread.sleep(150);
                            } 
                            catch (InterruptedException e) {
				}
			}
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

			break;
		case 2:
                        // đơn chưa xác nhận
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() ==1)
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							trangThai(donhang.getTrangThai()), donhang.getDsSanPham());
                            try {
				Thread.sleep(150);
                            } 
                            catch (InterruptedException e) {
				}
			}
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			break;

		case 3:
                    // đơn đã xác nhận
			System.out.print("\n\n");
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang) {
				if (donhang.getTrangThai() ==2)
					System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(),
							trangThai(donhang.getTrangThai()), donhang.getDsSanPham());
                            try {
				Thread.sleep(150);
                            } 
                            catch (InterruptedException e) {
				}
			}
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			break;
		}

	}

	@Override
	public void xacNhanDonHang() {

		String luachon;
		String maDon = "";
                int chon=-1, flag=0; // flag kiểm tra mã đơn có tồn tại hay ko
		Scanner input = new Scanner(System.in);
		do {
			ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
			xemDonHang(2);
			System.out.println("\n\t+------------------------------------------------------+");
			System.out.println("\t|                     XÁC NHẬN ĐƠN HÀNG                |");
			System.out.println("\t|------------------------------------------------------|");
			System.out.println("\t| Nhập mã đơn để xác nhận đơn hàng                     |");
			System.out.println("\t| Nhập 0 để thoát chức năng xác nhận đơn hàng          |");
			System.out.println("\t+------------------------------------------------------+");
			System.out.print("Nhập mã đơn: ");
			luachon = input.nextLine();
			if (!luachon.equalsIgnoreCase("0")) {
				do {
					System.out.println("\n\t+------------------------------------------------------+");
					System.out.println("\t|                     XÁC NHẬN                         |");
					System.out.println("\t|------------------------------------------------------|");
					System.out.println("\t|1. Xác nhận đơn hàng của khách                        |");
					System.out.println("\t|0. Trở lại phần xác nhận đơn                          |");
					System.out.println("\t+------------------------------------------------------+");
                                        try {
                                            System.out.print("Nhập lựa chọn: ");
                                            chon = Integer.parseInt(input.nextLine());
                                            if (chon <0 || chon >1)
                                            System.out.println("Vui lòng nhập đúng các chức năng");
                                        }
                                        
                                        catch(NumberFormatException ei){
                                            System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                                            chon=0;
                                        }

				} while (chon != 0 && chon != 1);
                                
				if (chon ==1) {
					maDon = luachon;
					for (CT_DonHang donhang : dsDonHang) 
                                        {
                                            if (donhang.getMaDonHang().equals(maDon)) 
                                            {
						if (donhang.getTrangThai() == 1) 
                                                {
                                                    flag=1;
                                                    donhang.setTrangThai(2);
                                                    ghiDonVaoFile(dsDonHang);
                                                    System.out.println("*Xác nhận đơn hàng thành công! *");
                                                } else
                                                System.out.println("! Đơn hàng đã được xác nhận, không thể thay đổi trang thái !");
							// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
                                            }
					}
				}
                                if (flag !=1)
                                    System.out.println("Mã đơn hàng này không tồn tại");
			}
                        luachon="0";
		} while (luachon.equalsIgnoreCase("0")==false);

	}

	public void thongKeTheoLoai() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheLoai = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		for (CT_DonHang donhang : dsDonHang) {
			String[] dulieuSach = donhang.getDsSanPham().split(";");
			for (String dsSanPham : dulieuSach) {
				dsSach.add(dsSanPham);
			}
		}
		for (String dulieuSach : dsSach) {
			TuSach tusach = new TuSach();
			String[] thongtin = dulieuSach.split(" x ");
			int soLuong = Integer.parseInt(thongtin[2].trim());
			String maSach = thongtin[1].trim();
			if (tusach.timSachTheoID(maSach) != null) {
				Sach sach = new Sach(tusach.timSachTheoID(maSach));
				tongDoanhThu += soLuong * sach.getGia();
				if (thongKeTheLoai.containsKey(sach.getLoaiSach())) {
					double[] dulieu = thongKeTheLoai.get(sach.getLoaiSach());
					dulieu[0] += soLuong;
					dulieu[1] += soLuong * sach.getGia();
					thongKeTheLoai.put(sach.getLoaiSach(), dulieu);
				} else {
					double[] dulieu = new double[2];
					dulieu[0] = soLuong;
					dulieu[1] = soLuong * sach.getGia();
					thongKeTheLoai.put(sach.getLoaiSach(), dulieu);
				}
			}
		}
		System.out.println("\n\t+------------------------------------------------+");
		System.out.println("\t|               THỐNG KÊ LOẠI SÁCH                |");
                System.out.printf("\t| %-14s || %-15s || %-10s|\n","Loại Sách","Số lượng bán ra","Doanh thu");
                System.out.println("\t+------------------------------------------------+");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String loaiSach = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("\t| %-14s || %-15s || %-10s|\n",loaiSach,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("\t+------------------------------------------------+");
		System.out.printf("\t|Tổng doanh thu: %-32s|\n", Double.toString(tongDoanhThu));
		System.out.println("\t+------------------------------------------------+");
	}

	public void thongKeTheoTheLoai() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheLoai = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		for (CT_DonHang donhang : dsDonHang) {
			String[] dulieuSach = donhang.getDsSanPham().split(";");
			for (String dsSanPham : dulieuSach) {
				dsSach.add(dsSanPham);
			}
		}

		for (String dulieuSach : dsSach) {
			TuSach tusach = new TuSach();
			String[] thongtin = dulieuSach.split(" x ");
			int soLuong = Integer.parseInt(thongtin[2].trim());
			String maSach = thongtin[1].trim();
			if (tusach.timSachTheoID(maSach) != null) {
				Sach sach = new Sach(tusach.timSachTheoID(maSach));
				tongDoanhThu += soLuong * sach.getGia();
				if (thongKeTheLoai.containsKey(sach.getTheLoai())) {
					double[] dulieu = thongKeTheLoai.get(sach.getTheLoai());
					dulieu[0] += soLuong;
					dulieu[1] += soLuong * sach.getGia();
					thongKeTheLoai.put(sach.getTheLoai(), dulieu);
				} else {
					double[] dulieu = new double[2];
					dulieu[0] = soLuong;
					dulieu[1] = soLuong * sach.getGia();
					thongKeTheLoai.put(sach.getTheLoai(), dulieu);
				}
			}
		}
                System.out.println("\n\t+------------------------------------------------+");
		System.out.println("\t|                THỐNG KÊ THỂ LOẠI               |");
                System.out.printf("\t| %-14s || %-15s || %-10s|\n","Thể loại","Số lượng bán ra","Doanh thu");
                System.out.println("\t+------------------------------------------------+");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String theLoai = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("\t| %-14s || %-15s || %-10s|\n",theLoai,Double.toString(dulieu[0]),Double.toString(dulieu[1]));

			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("\t*------------------------------------------------*");
		System.out.printf("\t| Tổng doanh thu: %-31s|\n", Double.toString(tongDoanhThu));
		System.out.println("\t+------------------------------------------------+");
	}

	public void thongKeTatCaSach() {
		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheLoai = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		for (CT_DonHang donhang : dsDonHang) {
			String[] dulieuSach = donhang.getDsSanPham().split(";");
			for (String dsSanPham : dulieuSach) {
				dsSach.add(dsSanPham);
			}
		}

		for (String dulieuSach : dsSach) {
			TuSach tusach = new TuSach();
			String[] thongtin = dulieuSach.split(" x ");
			int soLuong = Integer.parseInt(thongtin[2].trim());
			String maSach = thongtin[1].trim();
			if (tusach.timSachTheoID(maSach) != null) {
				Sach sach = new Sach(tusach.timSachTheoID(maSach));
				tongDoanhThu += soLuong * sach.getGia();
				if (thongKeTheLoai.containsKey(sach.getMaSach())) {
					double[] dulieu = thongKeTheLoai.get(sach.getMaSach());
					dulieu[0] += soLuong;
					dulieu[1] += soLuong * sach.getGia();
					thongKeTheLoai.put(sach.getMaSach(), dulieu);
				} else {
					double[] dulieu = new double[2];
					dulieu[0] = soLuong;
					dulieu[1] = soLuong * sach.getGia();
					thongKeTheLoai.put(sach.getMaSach(), dulieu);
				}
			}
		}
		System.out.println("\n\t+-------------------------------------------+");
		System.out.println("\t|            THỐNG KÊ TẤT CẢ SÁCH           |");
                System.out.printf("\t| %-9s || %-15s || %-10s|\n","Mã Sách","Số lượng bán ra","Doanh thu");
                System.out.println("\t|-------------------------------------------|");
		for (Map.Entry<String, double[]> set : thongKeTheLoai.entrySet()) {
			String maSach = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("\t| %-9s || %-15s || %-10s|\n",maSach,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("\t*-------------------------------------------*");
		System.out.printf("\t| Tổng doanh thu: %-26s|\n", Double.toString(tongDoanhThu));
		System.out.println("\t+-------------------------------------------+");
	}

	public void thongKeTheoKhoangTG() {

		Scanner input = new Scanner(System.in);
		double tongDoanhThu = 0;
		ArrayList<CT_DonHang> dsDonHang = docDonHangTuFile();
		Map<String, double[]> thongKeTheoTG = new HashMap<>();
		ArrayList<String> dsSach = new ArrayList<>();
		boolean[] matches = new boolean[3];
		matches[0] = matches[1] = true;
		matches[2] = false;
		String ngaybatdau;
		String ngayketthuc;
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		do {
			if (matches[0] == false || matches[1] == false)
				System.out.println("Vui lòng nhập đúng định dạng dd/mm/yyyy!");
			System.out.println("nhập khoảng thời gian bắt đầu thống kê (nhập e để bỏ qua thời gian bắt đầu): ");
			ngaybatdau = input.nextLine();
			System.out.println("nhập khoảng thời gian kết thúc thống kê (nhap e để bỏ qua thời gian kết thúc): ");
			ngayketthuc = input.nextLine();
			if (ngaybatdau.equalsIgnoreCase("e") && ngayketthuc.equalsIgnoreCase("e")) {
				matches[2] = true;
			} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == false) {
				matches[0] = pattern.matcher(ngaybatdau).matches();
				matches[1] = pattern.matcher(ngayketthuc).matches();
			} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == true) {
				matches[0] = pattern.matcher(ngaybatdau).matches();
			} else if (ngaybatdau.equalsIgnoreCase("e") == true && ngayketthuc.equalsIgnoreCase("e") == false) {
				matches[1] = pattern.matcher(ngayketthuc).matches();
			}

		} while (matches[0] == false || matches[1] == false);
		if (matches[2]) {
			thongKeTatCaSach();
		} else if (ngaybatdau.equalsIgnoreCase("e") == true && ngayketthuc.equalsIgnoreCase("e") == false) {
			for (CT_DonHang donhang : dsDonHang) {
				Ngaythangnam tgDH = new Ngaythangnam(donhang.getNgayDH());

				Ngaythangnam tgSoSanh = new Ngaythangnam(ngayketthuc);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				if (tgSoSanh.getNam() > tgDH.getNam()) {
					if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
						double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
						dulieu[0] += 1;
						dulieu[1] += donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					} else {
						double[] dulieu = new double[2];
						dulieu[0] = 1;
						dulieu[1] = donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					}
				} else if (tgSoSanh.getNam() == tgDH.getNam()) {
					if (tgSoSanh.getThang() > tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanh.getThang() == tgDH.getThang()) {
						if (tgSoSanh.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				}
			}
			System.out.println("\n\t+--------------------------------------------+");
			System.out.println("\t|            THỐNG KÊ THEO TG                |");
			System.out.println("\t|  Ngày DH  || Số lượng bán ra || Doanh Thu  |");
			System.out.println("\t|--------------------------------------------|");
		
			for (Map.Entry<String, double[]> set : thongKeTheoTG.entrySet()) {
				String ngayDH = set.getKey();
				double[] dulieu = set.getValue();
				System.out.printf("\t| %-10s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
		
			System.out.println("\t*--------------------------------------------*");
			System.out.printf("\t| Tổng doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
			System.out.println("\t+--------------------------------------------+");
		} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == true) {
			for (CT_DonHang donhang : dsDonHang) {
				Ngaythangnam tgDH = new Ngaythangnam(donhang.getNgayDH());
				Ngaythangnam tgSoSanh = new Ngaythangnam(ngaybatdau);
				if (tgSoSanh.getNam() < tgDH.getNam()) {
					if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
						double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
						dulieu[0] += 1;
						dulieu[1] += donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					} else {
						double[] dulieu = new double[2];
						dulieu[0] = 1;
						dulieu[1] = donhang.getTongTien();
						tongDoanhThu += dulieu[1];
						thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
					}
				} else if (tgSoSanh.getNam() == tgDH.getNam()) {
					if (tgSoSanh.getThang() < tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanh.getThang() == tgDH.getThang()) {
						if (tgSoSanh.getNgay() <= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				}
			}
                        System.out.println("\n\t+--------------------------------------------+");
			System.out.println("\t|            THỐNG KÊ THEO TG                |");
			System.out.println("\t|  Ngày DH  || Số lượng bán ra || Doanh Thu  |");
			System.out.println("\t|--------------------------------------------|");

			for (Map.Entry<String, double[]> set : thongKeTheoTG.entrySet()) {
				String ngayDH = set.getKey();
				double[] dulieu = set.getValue();
				System.out.printf("\t| %-10s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
		
			System.out.println("\t*--------------------------------------------*");
			System.out.printf("\t| Tổng doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
			System.out.println("\t+--------------------------------------------+");
		} else if (ngaybatdau.equalsIgnoreCase("e") == false && ngayketthuc.equalsIgnoreCase("e") == false) {
			for (CT_DonHang donhang : dsDonHang) {
				Ngaythangnam tgDH = new Ngaythangnam(donhang.getNgayDH());
				Ngaythangnam tgSoSanhDau = new Ngaythangnam(ngaybatdau);
				Ngaythangnam tgSoSanhCuoi = new Ngaythangnam(ngayketthuc);

				if (tgSoSanhDau.getNam() < tgDH.getNam() && tgSoSanhCuoi.getNam() > tgDH.getNam()) {

				} else if (tgSoSanhDau.getNam() == tgDH.getNam() && tgSoSanhCuoi.getNam() > tgDH.getNam()) {
					if (tgSoSanhDau.getThang() < tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanhDau.getThang() == tgDH.getThang()) {
						if (tgSoSanhDau.getNgay() <= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				} else if (tgSoSanhDau.getNam() < tgDH.getNam() && tgSoSanhCuoi.getNam() == tgDH.getNam()) {
					if (tgSoSanhCuoi.getThang() > tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanhCuoi.getThang() == tgDH.getThang()) {
						if (tgSoSanhCuoi.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				} else if (tgSoSanhDau.getNam() == tgDH.getNam() && tgSoSanhCuoi.getNam() == tgDH.getNam()) {
					if (tgSoSanhDau.getThang() < tgDH.getThang() && tgSoSanhCuoi.getThang() > tgDH.getThang()) {
						if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
							double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
							dulieu[0] += 1;
							dulieu[1] += donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						} else {
							double[] dulieu = new double[2];
							dulieu[0] = 1;
							dulieu[1] = donhang.getTongTien();
							tongDoanhThu += dulieu[1];
							thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
						}
					} else if (tgSoSanhDau.getThang() == tgDH.getThang() && tgSoSanhCuoi.getThang() > tgDH.getThang()) {
						if (tgSoSanhDau.getNgay() <= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					} else if (tgSoSanhDau.getThang() < tgDH.getThang() && tgSoSanhCuoi.getThang() == tgDH.getThang()) {
						if (tgSoSanhCuoi.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					} else if (tgSoSanhDau.getThang() == tgDH.getThang()
							&& tgSoSanhCuoi.getThang() == tgDH.getThang()) {
						if (tgSoSanhDau.getNgay() <= tgDH.getNgay() && tgSoSanhCuoi.getNgay() >= tgDH.getNgay()) {
							if (thongKeTheoTG.containsKey(donhang.getNgayDH())) {
								double[] dulieu = thongKeTheoTG.get(donhang.getNgayDH());
								dulieu[0] += 1;
								dulieu[1] += donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							} else {
								double[] dulieu = new double[2];
								dulieu[0] = 1;
								dulieu[1] = donhang.getTongTien();
								tongDoanhThu += dulieu[1];
								thongKeTheoTG.put(donhang.getNgayDH(), dulieu);
							}
						}
					}
				}

			}
			System.out.println("\n\t+--------------------------------------------+");
			System.out.println("\t|            THỐNG KÊ THEO TG                |");
			System.out.println("\t|  Ngày DH  || Số lượng bán ra || Doanh Thu  |");
			System.out.println("\t|--------------------------------------------|");
                        

			for (Map.Entry<String, double[]> set : thongKeTheoTG.entrySet()) {
				String ngayDH = set.getKey();
				double[] dulieu = set.getValue();
				System.out.printf("\t| %-10s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
				}
			}
		
			System.out.println("\t*--------------------------------------------*");
			System.out.printf("\t| Tổng doanh thu: %-27s|\n", Double.toString(tongDoanhThu));
			System.out.println("\t+--------------------------------------------+");
		}
	
	
	}

	public void luaChonThongKe() {
		int luachon;
		Scanner input = new Scanner(System.in);
		do {
                        System.out.println("\n\t+---------------------------------------------------+");
			System.out.println("\t|                     THỐNG KÊ                      |");
			System.out.println("\t|---------------------------------------------------|");
			System.out.printf("\t| %-50s|\n","1.Thống kê doanh thu theo thể loại sách");
			System.out.printf("\t| %-50s|\n","2.Thống kê doanh thu theo loại sách");
			System.out.printf("\t| %-50s|\n","3.Thống kê doanh thu tất cả sách");
			System.out.printf("\t| %-50s|\n","4.Thống kê doanh thu theo khoảng thời gian");
			System.out.printf("\t| %-50s|\n","0.Thoát");
			System.out.println("\t+---------------------------------------------------+");
                        try {
                            System.out.print("Nhập lựa chọn: ");
                            luachon = Integer.parseInt(input.nextLine());
                            switch (luachon) {
                            case 1:
				thongKeTheoTheLoai();
				input.nextLine();
				break;
                            case 2:
				thongKeTheoLoai();
				input.nextLine();
				break;
                            case 3:
				thongKeTatCaSach();
				input.nextLine();
				break;
                            case 4:
				thongKeTheoKhoangTG();
				input.nextLine();
				break;
                            }
                            if (luachon <0 || luachon >4)
                            System.out.println("--Vui lòng nhập đúng các chức năng--");
                        }
                        catch(NumberFormatException ei)
                        {
                            System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                            luachon=1;
                        }	
			
		}while (luachon != 0);

	}

	public void quanLy() {
		Scanner input = new Scanner(System.in);
		int luachon;
		do {
                        System.out.println("\n\t+---------------------------------------------------+");
			System.out.println("\t|                     MENU THAO TÁC                 |");
			System.out.println("\t|---------------------------------------------------|");
			System.out.printf("\t| %-50s|\n","1.Xem thông tin nhân viên");
			System.out.printf("\t| %-50s|\n","2.Quản lý sách");
			System.out.printf("\t| %-50s|\n","3.Quản lý đơn hàng");
			System.out.printf("\t| %-50s|\n","4.Thống kê các loại");
                        System.out.printf("\t| %-50s|\n","5.Thêm voucher giảm giá");
			System.out.printf("\t| %-50s|\n","0.Thoát");
			System.out.println("\t+---------------------------------------------------+");
                        try{
                            System.out.print("Nhập lựa chọn: ");
                            luachon = Integer.parseInt(input.nextLine());

                            switch (luachon) {
                            case 1:
                                    System.out.println(this.toString());
                                    tinhLuong();
                                    break;
                            case 2:
                                    quanLySach();
                                    break;
                            case 3:
                                    quanLyDonHang();
                                    break;
                            case 4:
                                    luaChonThongKe();
                                    break;
                            case 5:
                                    PhieuGiamGia phieu= new PhieuGiamGia();
                                    phieu.themVoucher();
                                    break;
                            }
                            if (luachon <0 || luachon >5)
                            System.out.println("--Vui lòng nhập đúng các chức năng--");
                        }
                    catch(NumberFormatException ei)
                    {
                        System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
                        luachon=1;
                    }

		} while (luachon != 0);
    }

        @Override
        public String toString() {
            String loai="";
            if ( this.getLoai().equalsIgnoreCase("pt"))
                loai="Làm PartTime";
            else loai="Làm FullTime";
            
            return "\nMã Nhân Viên: "+this.getMa()+
                   "\nTên Nhân Viên: "+this.getTen()+
                   "\nNgày vào làm: "+this.getNgayVao().toString()+"\n"+loai+
                   "\nChức vụ: "+this.getViTri();

	}
}