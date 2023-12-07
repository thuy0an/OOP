
public class Ngaythangnam {
	int ngay;
	int thang;
	int nam;
	public Ngaythangnam(String ngaythangnam) {
		String[] dulieu=ngaythangnam.split("/");
		this.ngay=Integer.parseInt(dulieu[0]);
		this.thang=Integer.parseInt(dulieu[1]);
		this.nam=Integer.parseInt(dulieu[2]);
	}
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
}
