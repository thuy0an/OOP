

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NhanVienQuanLy extends NhanVien {
	public NhanVienQuanLy() {
		super();
	}

	public NhanVienQuanLy(String ma, String ten, Ngaythangnam ngayVao, String viTri, String loai, double ngayCong) {
		super(ma, ten, ngayVao, viTri, loai, ngayCong);

	}

	private String trangThai(int so) {
		if (so == 1)
			return "Đang xử lý";
		else if (so == 2)
			return "Đã xử lý";
		else if (so == 3)
			return "Đang giao hàng";
		else if (so == 4)
			return "Đã nhận hàng";
		return "";
	}

	public void quanLySach() {
		TuSach tuSach = new TuSach();
		Scanner input = new Scanner(System.in);
		int luachon = 0;
		do {
			System.out.println("\t+-------------------------------------------------------------------------+");
			System.out.println("\t|                                     QUẢN LÝ SÁCH                        |");
			System.out.println("\t|-------------------------------------------------------------------------|");
			System.out.printf("\t| %-35s| %-35s|\n", "1.Hiển thị sách đang kinh doanh", "2.Tìm sách theo thông tin");
			System.out.printf("\t| %-35s| %-35s|\n", "3.Chỉnh sửa thông tin sách", "4.Thêm sách mới");
			System.out.printf("\t| %-72s|\n", "0.Thoát quản lý sách");
			System.out.println("\t+-------------------------------------------------------------------------+");
			try {
				System.out.print("Nhập lựa chọn: ");
				luachon = Integer.parseInt(input.nextLine());
				switch (luachon) {
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
				if (luachon < 0 || luachon > 4)
					System.out.println("Vui lòng nhập đúng các chức năng");

			} catch (NumberFormatException ei) {
				System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
				luachon = 1;
			}
		} while (luachon != 0);
	}

	public void quanLyDonHang() {
		int luachon = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("\t+-------------------------------------------------------------------------+");
			System.out.println("\t|                           QUẢN LÝ ĐƠN HÀNG                              |");
			System.out.println("\t|-------------------------------------------------------------------------|");

			System.out.printf("\t| %-35s| %-35s|\n", "1.Xem tất cả đơn hàng", "2.Xem đơn hàng chưa xác nhận");
			System.out.printf("\t| %-35s| %-35s|\n", "3.Xen đơn hàng đã xác nhận", "4.Xác nhận đơn hàng");
			System.out.printf("\t| %-72s|\n", "0.Thoát quản lý đơn hàng");
			System.out.println("\t+-------------------------------------------------------------------------+");
			try {
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
				if (luachon < 0 || luachon > 4)
					System.out.println("Vui lòng nhập đúng các chức năng");
			} catch (NumberFormatException ei) {
				System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
				luachon = 1;
			}

		} while (luachon != 0);
	}

	@Override
	public void xemDonHang(int luachon) {
		DonHang temp=new DonHang();
		ArrayList<CT_DonHang> dsDonHang = temp.docDonHangTuFile();
		ArrayList<CT_DonHang> dsSanPham=temp.docCTDonHangTuFile("CT_DonHang.txt");
		TuSach tusach=new TuSach();
		switch (luachon) {
		case 1:
			System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|                                                                                               TẤT CẢ ĐƠN HÀNG                                                                                                                                                                              |");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s\n","Mã đơn","Mã khách hàng","Địa chỉ","Email","Ngày đặt hàng","PT thanh toán","Tổng tiền","Trạng thái","Danh sách sản phẩm");
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
			for (CT_DonHang donhang : dsDonHang){
				String sp="";
				for(CT_DonHang sanpham: dsSanPham) {
					Sach sach=tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
					sp+= sach.getMaSach()+" x "+sach.getTenSach()+";";
				}
                            System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
						donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
						donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(), trangThai(donhang.getTrangThai()),
						sp);
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
				String sp="";
				if (donhang.getTrangThai() ==1) {
					for(CT_DonHang sanpham: dsSanPham) {
						Sach sach=tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
						sp+= sach.getMaSach()+" x "+sach.getTenSach()+";";
					}
	                            System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(), trangThai(donhang.getTrangThai()),
							sp);
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
				String sp="";
				if (donhang.getTrangThai() ==2) {
					for(CT_DonHang sanpham: dsSanPham) {
						Sach sach=tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
						sp+= sach.getMaSach()+" x "+sach.getTenSach()+";";
					}
	                            System.out.printf("| %-15s || %-15s || %-20s || %-15s || %-15s || %-15s || %-15s || %-10s || %s|\n",
							donhang.getMaDonHang(), donhang.getMaKH(), donhang.getDiaChi(), donhang.getEmail(),
							donhang.getNgayDH(), donhang.getPtThanhToan(), donhang.getTongTien(), trangThai(donhang.getTrangThai()),
							sp);
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
		int chon = -1, flag = 0; // flag kiểm tra mã đơn có tồn tại hay ko
		Scanner input = new Scanner(System.in);
		do {
			DonHang temp = new DonHang();
			ArrayList<CT_DonHang> dsDonHang = temp.docDonHangTuFile();
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
						if (chon < 0 || chon > 1)
							System.out.println("Vui lòng nhập đúng các chức năng");
					}

					catch (NumberFormatException ei) {
						System.out.println("\n--Vui lòng chọn đúng các thao tác đã hiển thị!!!--\n");
						chon = 0;
					}

				} while (chon != 0 && chon != 1);

				if (chon == 1) {
					maDon = luachon;
					for (CT_DonHang donhang : dsDonHang) {
						if (donhang.getMaDonHang().equals(maDon)) {
							if (donhang.getTrangThai() == 1) {
								flag = 1;
								donhang.setTrangThai(2);
								ghiDonVaoFile(dsDonHang);
								System.out.println("*Xác nhận đơn hàng thành công! *");
							} else
								System.out.println("! Đơn hàng đã được xác nhận, không thể thay đổi trang thái !");
							// 1: đang xử lý; 2: đã xác nhận , 3: đang giao; 4: đã nhận hàng
						}
					}
				}
				if (flag != 1)
					System.out.println("Mã đơn hàng này không tồn tại");
			}
			luachon = "0";
		} while (luachon.equalsIgnoreCase("0") == false);

	}
	public void thongKeTatCaSach() {
		double tongDoanhThu=0;
		Map<String,Integer> dsSach=new HashMap<>(); 
		DonHang tempo=new DonHang();
		ArrayList<CT_DonHang> dsDonHang=tempo.docDonHangTuFile();
		ArrayList<CT_DonHang> dsSanPham=tempo.docCTDonHangTuFile("CT_DonHang.txt");
		int ngaybatdau=0;
		int ngayketthuc=99999;
		TuSach tusach=new TuSach();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Nhập thời gian bắt đầu (dd/mm/yyyy) hoặc e để bỏ qua: ");
	  String start=input.nextLine();
	  System.out.println("Nhập thời gian kết thúc (dd/mm/yyyy) hoặc e để bỏ qua: ");
	  String end=input.nextLine();
	  boolean[] matches=new boolean[2];
	  matches[0]=matches[1]=true;
	  int status=0;
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

		Pattern pattern = Pattern.compile(regex);
		do {
		  if (start.equalsIgnoreCase("e") == false && end.equalsIgnoreCase("e") == false) {
				matches[0] = pattern.matcher(start).matches();
				matches[1] = pattern.matcher(end).matches();
			} else if (start.equalsIgnoreCase("e") == false && end.equalsIgnoreCase("e") == true) {
				matches[0] = pattern.matcher(start).matches();
				status=1;//status 1 => end bo qua 1 co du lieu
			} else if (start.equalsIgnoreCase("e") == true && end.equalsIgnoreCase("e") == false) {
				matches[1] = pattern.matcher(end).matches();
				status=2;//status 2=> start bo qua 2 co du lieu
			}
		}while(matches[0]==false||matches[1]==false);
		if(status==1) {
			Ngaythangnam temp=new Ngaythangnam(start);
			ngaybatdau=temp.getNam()+temp.getThang()+temp.getNgay();
			
		}else if(status==2) {
			Ngaythangnam temp=new Ngaythangnam(end);
			ngayketthuc=temp.getNam()+temp.getThang()+temp.getNgay();
		}
		for(CT_DonHang donhang: dsDonHang) {
			Ngaythangnam ntn=new Ngaythangnam(donhang.getNgayDH());
			int ngayDH=ntn.getNam()+ntn.getThang()+ntn.getNgay();
			if(ngayDH<ngaybatdau||ngayDH>ngayketthuc) continue;
			for(CT_DonHang sanpham:dsSanPham) {
				int soLuong=sanpham.getDsSanPham().getSoLuong();
				Sach sach=tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
	
					tongDoanhThu += soLuong*sach.getGia();
					if(dsSach.containsKey(sach.getMaSach())) {
						
						Integer soLuongMua=dsSach.get(sach.getMaSach());
						soLuongMua++;
						dsSach.put(sach.getMaSach(), soLuongMua);
					}else {
						Integer soLuongMua=new Integer(1);
						dsSach.put(sach.getMaSach(),soLuongMua);
					}
				
				}
			}
		
		 Map<String, Integer> dsSachDaSapXep = dsSach.entrySet()  .stream()
	                .sorted(Map.Entry.comparingByValue())
	                .collect(Collectors.toMap(
	                        Map.Entry::getKey,
	                        Map.Entry::getValue,
	                        (e1, e2) -> e1,
	                        LinkedHashMap::new
	                ));
		 System.out.println("\t+----------------------------------------------+");
			System.out.println("\t     THỐNG KÊ TẤT CẢ SÁCH                 ");
			System.out.println("\t| Mã sách || Số lượng ||  Doanh Thu");
		for(Map.Entry<String,Integer> sach:dsSachDaSapXep.entrySet()) {
			
			System.out.printf("\n\t %-6s || %-10s || %-8s",sach.getKey(),sach.getValue(),sach.getValue()*tusach.timSachTheoID(sach.getKey()).getGia());
		 }
		System.out.println("\n+----------------------------------------------+");
		System.out.println("\tTong doanh thu: "+tongDoanhThu);
}

	public void thongKeTheoKhoangTG() {
		double tongDoanhThu=0;
		Map<String,double[]>thongKeTheoTGDH=new HashMap<>();//ma the loai 0-5 best seller lenght-1=revenue
		DonHang tempo=new DonHang();
		ArrayList<CT_DonHang> dsDonHang=tempo.docDonHangTuFile();
		ArrayList<CT_DonHang> dsSanPham=tempo.docCTDonHangTuFile("CT_DonHang.txt");
		int ngaybatdau=0;
		int ngayketthuc=99999;
		TuSach tusach=new TuSach();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Nhập thời gian bắt đầu (dd/mm/yyyy) hoặc e để bỏ qua: ");
	  String start=input.nextLine();
	  System.out.println("Nhập thời gian kết thúc (dd/mm/yyyy) hoặc e để bỏ qua: ");
	  String end=input.nextLine();
	  boolean[] matches=new boolean[2];
	  matches[0]=matches[1]=true;
	  int status=0;
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

		Pattern pattern = Pattern.compile(regex);
		do {
		  if (start.equalsIgnoreCase("e") == false && end.equalsIgnoreCase("e") == false) {
				matches[0] = pattern.matcher(start).matches();
				matches[1] = pattern.matcher(end).matches();
			} else if (start.equalsIgnoreCase("e") == false && end.equalsIgnoreCase("e") == true) {
				matches[0] = pattern.matcher(start).matches();
				status=1;//status 1 => end bo qua 1 co du lieu
			} else if (start.equalsIgnoreCase("e") == true && end.equalsIgnoreCase("e") == false) {
				matches[1] = pattern.matcher(end).matches();
				status=2;//status 2=> start bo qua 2 co du lieu
			}
		}while(matches[0]==false||matches[1]==false);
		if(status==1) {
			Ngaythangnam temp=new Ngaythangnam(start);
			ngaybatdau=temp.getNam()+temp.getThang()+temp.getNgay();
			
		}else if(status==2) {
			Ngaythangnam temp=new Ngaythangnam(end);
			ngayketthuc=temp.getNam()+temp.getThang()+temp.getNgay();
		}
		for(CT_DonHang donhang: dsDonHang) {
			Ngaythangnam ntn=new Ngaythangnam(donhang.getNgayDH());
			int ngayDH=ntn.getNam()+ntn.getThang()+ntn.getNgay();
			if(ngayDH<ngaybatdau||ngayDH>ngayketthuc) continue;
			for(CT_DonHang sanpham:dsSanPham) {
				int soLuong=sanpham.getDsSanPham().getSoLuong();
				Sach sach=tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
				if(thongKeTheoTGDH.containsKey(donhang.getNgayDH())) {
					double[] dulieu=thongKeTheoTGDH.get(donhang.getNgayDH());
					dulieu[0]+=soLuong;
					dulieu[1]+=soLuong*sach.getGia();
					thongKeTheoTGDH.put(donhang.getNgayDH(), dulieu);
					tongDoanhThu += dulieu[1];
			
				}else {
					double[] dulieu=new double[2];
					dulieu[0]+=soLuong;
					dulieu[1]+=soLuong*sach.getGia();
					thongKeTheoTGDH.put(donhang.getNgayDH(), dulieu);
					tongDoanhThu += dulieu[1];
					
				}
			}
		}
	

		 
		System.out.println("\n\t+-------------------------------------------------------+");
		System.out.println("\t|            THỐNG KÊ THEO THỂ LOẠI SÁCH                | ");
		System.out.println("\t| Ngày DH || Số lượng bán ra   || Doanh Thu ");
		for (Map.Entry<String, double[]> set :thongKeTheoTGDH.entrySet()) {
			String ngayDH = set.getKey();
			double[] dulieu = set.getValue();
			System.out.printf("\t| %-9s || %-15s || %-10s|\n",ngayDH,Double.toString(dulieu[0]),Double.toString(dulieu[1]));
			System.out.println("\t+---------------------------------------------------+");
//			try {
//				Thread.sleep(150);
//			} catch (InterruptedException e) {
//			}
		}
		System.out.println("Tong doanh thu: "+tongDoanhThu);
	}
	public void thongKeTheoTheLoaiSach() {
		double tongDoanhThu=0;
		Map<String,double[]> thongKeTheoTheLoaiSach=new HashMap<>();//ma the loai 0-5 best seller lenght-1=revenue
		Map<String,Integer> dsSach=new HashMap<>(); 
		DonHang tempo=new DonHang();
		ArrayList<CT_DonHang> dsDonHang=tempo.docDonHangTuFile();
		ArrayList<CT_DonHang> dsSanPham=tempo.docCTDonHangTuFile("CT_DonHang.txt");
		int ngaybatdau=0;
		int ngayketthuc=99999;
		TuSach tusach=new TuSach();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Nhập thời gian bắt đầu (dd/mm/yyyy) hoặc e để bỏ qua: ");
	  String start=input.nextLine();
	  System.out.println("Nhập thời gian kết thúc (dd/mm/yyyy) hoặc e để bỏ qua: ");
	  String end=input.nextLine();
	  boolean[] matches=new boolean[2];
	  matches[0]=matches[1]=true;
	  int status=0;
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

		Pattern pattern = Pattern.compile(regex);
		do {
		  if (start.equalsIgnoreCase("e") == false && end.equalsIgnoreCase("e") == false) {
				matches[0] = pattern.matcher(start).matches();
				matches[1] = pattern.matcher(end).matches();
			} else if (start.equalsIgnoreCase("e") == false && end.equalsIgnoreCase("e") == true) {
				matches[0] = pattern.matcher(start).matches();
				status=1;//status 1 => end bo qua 1 co du lieu
			} else if (start.equalsIgnoreCase("e") == true && end.equalsIgnoreCase("e") == false) {
				matches[1] = pattern.matcher(end).matches();
				status=2;//status 2=> start bo qua 2 co du lieu
			}
		}while(matches[0]==false||matches[1]==false);
		if(status==1) {
			Ngaythangnam temp=new Ngaythangnam(start);
			ngaybatdau=temp.getNam()+temp.getThang()+temp.getNgay();
			
		}else if(status==2) {
			Ngaythangnam temp=new Ngaythangnam(end);
			ngayketthuc=temp.getNam()+temp.getThang()+temp.getNgay();
		}
		for(CT_DonHang donhang: dsDonHang) {
			Ngaythangnam ntn=new Ngaythangnam(donhang.getNgayDH());
			int ngayDH=ntn.getNam()+ntn.getThang()+ntn.getNgay();
			if(ngayDH<ngaybatdau||ngayDH>ngayketthuc) continue;
			for(CT_DonHang sanpham:dsSanPham) {
				int soLuong=sanpham.getDsSanPham().getSoLuong();
				Sach sach=tusach.timSachTheoID(sanpham.getDsSanPham().getMaSach());
				if(thongKeTheoTheLoaiSach.containsKey(sach.getTheLoai())) {
					double[] dulieu=thongKeTheoTheLoaiSach.get(sach.getTheLoai());
					dulieu[0]+=soLuong;
					System.out.println(sach.getTenSach()+" "+soLuong+"\n");
					dulieu[1]+=soLuong*sach.getGia();
					thongKeTheoTheLoaiSach.put(sach.getTheLoai(), dulieu);
					tongDoanhThu += dulieu[1];
					if(dsSach.containsKey(sach.getMaSach())) {
						
						Integer soLuongMua=dsSach.get(sach.getMaSach());
						soLuongMua++;
						dsSach.put(sach.getMaSach(), soLuongMua);
					}else {
						Integer soLuongMua=new Integer(1);
						dsSach.put(sach.getMaSach(),soLuongMua);
					}
				}else {
					double[] dulieu=new double[2];
					dulieu[0]+=soLuong;
					dulieu[1]+=soLuong*sach.getGia();
					thongKeTheoTheLoaiSach.put(sach.getTheLoai(), dulieu);
					tongDoanhThu += dulieu[1];
					if(dsSach.containsKey(sach.getMaSach())) {
						Integer soLuongMua=dsSach.get(sach.getMaSach());
						soLuongMua++;
						dsSach.put(sach.getMaSach(), soLuongMua);
					}else {
						Integer soLuongMua=new Integer(1);
						dsSach.put(sach.getMaSach(),soLuongMua);
					}
				}
			}
		}
		Map<String, Integer> dsSachDaSapXep = dsSach.entrySet()
		        .stream()
		        .sorted(Map.Entry.<String, Integer>comparingByValue())
		        .collect(Collectors.toMap(
		                Map.Entry::getKey,
		                Map.Entry::getValue,
		                (e1, e2) -> e1,
		                LinkedHashMap::new
		        ));

		 
		System.out.println("\n\t+-------------------------------------------------------+");
		System.out.println("\t|            THỐNG KÊ THEO THỂ LOẠI SÁCH                | ");
		System.out.println("\t| Thể Loại || Số lượng bán ra || Top sale của thể loại || Doanh Thu ");
                System.out.println("\t+---------------------------------------------------+");
		for (Map.Entry<String, double[]> set : thongKeTheoTheLoaiSach.entrySet()) {
			String theLoai = set.getKey();
			double[] dulieu = set.getValue();
			int tongBanRa=0;
			String topsale="";
			int count=0;
			for(Map.Entry<String,Integer> sach:dsSachDaSapXep.entrySet()) {
				if(count==5) break;
				if(tusach.timSachTheoID(sach.getKey()).getTheLoai().equalsIgnoreCase(theLoai)) { topsale+= sach.getKey() +" x "+sach.getValue()+" | ";
					count++;
					tongBanRa+=sach.getValue();
				}
				
			}
			System.out.printf("\t| %-9s || %-15s || %-40s || %-10s|\n",theLoai,Integer.toString(tongBanRa),topsale,Double.toString(dulieu[1]));
			System.out.println("\t+---------------------------------------------------+");
//			try {
//				Thread.sleep(150);
//			} catch (InterruptedException e) {
//			}
		}
		System.out.println("Tong doanh thu: "+tongDoanhThu);
	}
	public void luaChonThongKe() {
		int luachon;
		Scanner input = new Scanner(System.in);
		do {
                        System.out.println("\n\t+---------------------------------------------------+");
			System.out.println("\t|                     THỐNG KÊ                      |");
			System.out.println("\t|---------------------------------------------------|");
			System.out.printf("\t| %-50s|\n","1.Thống kê doanh thu theo thể loại sách");
			System.out.printf("\t| %-50s|\n","2.Thống kê doanh thu tất cả sách");
			System.out.printf("\t| %-50s|\n","3.Thống kê doanh thu theo khoảng thời gian");
			System.out.printf("\t| %-50s|\n","0.Thoát");
			System.out.println("\t+---------------------------------------------------+");
                        try {
                            System.out.print("Nhập lựa chọn: ");
                            luachon = Integer.parseInt(input.nextLine());
                            switch (luachon) {
                            case 1:
				thongKeTheoTheLoaiSach();
				input.nextLine();
				break;

                            case 2:
				thongKeTatCaSach();
				input.nextLine();
				break;
                            case 3:
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