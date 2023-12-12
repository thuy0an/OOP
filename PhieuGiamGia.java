
public class PhieuGiamGia {
	private String maGiamGia;
	private String loaiGiamGia;//codinh phantram
	private int Giam;
	private int donToiThieu;
	private int soLuongTon;
//	private Ngaythangnam ngayHetHan;
	public PhieuGiamGia() {
		
	}



	public PhieuGiamGia(String maGiamGia, String loaiGiamGia, int giam, int donToiThieu, int soLuongTon) {
	super();
	this.maGiamGia = maGiamGia;
	this.loaiGiamGia = loaiGiamGia;
	Giam = giam;
	this.donToiThieu = donToiThieu;
	this.soLuongTon = soLuongTon;
}


	public String getMaGiamGia() {
		return maGiamGia;
	}



	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}



	public String getLoaiGiamGia() {
		return loaiGiamGia;
	}



	public void setLoaiGiamGia(String loaiGiamGia) {
		this.loaiGiamGia = loaiGiamGia;
	}



	public int getGiam() {
		return Giam;
	}



	public void setGiam(int giam) {
		Giam = giam;
	}



	public int getDonToiThieu() {
		return donToiThieu;
	}



	public void setDonToiThieu(int donToiThieu) {
		this.donToiThieu = donToiThieu;
	}



	public int getSoLuongTon() {
		return soLuongTon;
	}



	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}



	@Override
	public String toString() {
		boolean loaiCoDinh=this.getLoaiGiamGia().equalsIgnoreCase("codinh")==true;
		String loaiGiamGia=loaiCoDinh?"Giam gia co dinh":"Giam gia chiet khau";
		String donToiThieu=loaiCoDinh?this.getDonToiThieu()+" san pham":this.getDonToiThieu()+" dong";
		return this.getMaGiamGia()+"      "+loaiGiamGia+"       "+donToiThieu;
	}
}
