
import java.util.ArrayList;
import java.util.Scanner;
public class BTT5_6 {
    // Khai báo lớp Sách
    static class Sach {
        String maSach;
        String tenSach;
        int soLuong;
        double donGia;
        // Nhập thông tin sách
        void nhap(Scanner sc) {
            System.out.print("Nhập mã sách: ");
            maSach = sc.nextLine();
            System.out.print("Nhập tên sách: ");
            tenSach = sc.nextLine();
            System.out.print("Nhập số lượng: ");
            soLuong = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập đơn giá: ");
            donGia = Double.parseDouble(sc.nextLine());
        }

        // Xuất thông tin sách
        void xuat() {
            System.out.println("Mã sách: " + maSach);
            System.out.println("Tên sách: " + tenSach);
            System.out.println("Số lượng: " + soLuong);
            System.out.println("Đơn giá: " + donGia);
            System.out.println("----------------------");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> dsSach = new ArrayList<>();
        int chon;
        // Bài 3: Menu lặp đến khi chọn thoát
        do {
            System.out.println("\n--- QUẢN LÝ SÁCH ---");
            System.out.println("1. Nhập danh sách sách");
            System.out.println("2. Tính tổng số lượng và tổng giá trị sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Tìm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                // Bài 1: Nhập n sách bằng vòng lặp
                case 1:
                    System.out.print("Nhập số lượng sách cần nhập: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhập sách thứ " + (i + 1));
                        Sach s = new Sach();
                        s.nhap(sc);
                        dsSach.add(s);
                    }
                    System.out.println("Nhập sách thành công!");
                    break;
                // Bài 2: Tính tổng số lượng và tổng giá trị
                case 2:
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;
                    for (Sach s : dsSach) {
                        tongSoLuong += s.soLuong;
                        tongGiaTri += s.soLuong * s.donGia;
                    }
                    System.out.println("Tổng số lượng sách: " + tongSoLuong);
                    System.out.println("Tổng giá trị sách: " + tongGiaTri);
                    break;
                // Hiển thị danh sách sách
                case 3:
                    if (dsSach.isEmpty()) {
                        System.out.println("Danh sách sách đang trống!");
                    } else {
                        for (Sach s : dsSach) {
                            s.xuat();
                        }
                    }
                    break;

                // Bài 4: Tìm sách theo mã
                case 4:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String ma = sc.nextLine();
                    boolean timThay = false;
                    for (Sach s : dsSach) {
                        if (s.maSach.equalsIgnoreCase(ma)) {
                            System.out.println("Tìm thấy sách:");
                            s.xuat();
                            timThay = true;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy sách!");
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}
