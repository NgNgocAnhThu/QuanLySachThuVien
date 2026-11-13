
import java.util.ArrayList;
import java.util.Scanner;

class Sach {

    public String maSach;
    public String tieuDe;
    public String tacGia;
    public int namXuatBan;
    public int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public void HienThiThongTin() {
        System.out.println("------ THONG TIN SACH -----");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac Gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);

    }
}

public class BTT7_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();

        //Nhap so luong sach
        System.out.println("Nhap so luong sach");
        int n = Integer.parseInt(sc.nextLine());

        // Nhap thong tin tung cuon sach
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin sach thu " + (i + 1));

            System.out.print("Ma sach: ");
            String maSach = sc.nextLine();

            System.out.print("Tieu de: ");
            String tieuDe = sc.nextLine();

            System.out.print("Tac gia: ");
            String tacGia = sc.nextLine();

            System.out.print("Nam xuat ban: ");
            int namXuatBan = Integer.parseInt(sc.nextLine());

            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());

            // Tao doi tuong sach
            Sach s = new Sach(maSach, tieuDe, tacGia, namXuatBan, soLuong);

            // Them vao danh sach
            danhSach.add(s);
        }
        for (Sach s : danhSach) {
            s.HienThiThongTin();
        }
    }
}
