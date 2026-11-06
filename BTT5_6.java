
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
        ArrayList<String> maSachList = new ArrayList<>();
        ArrayList<String> danhSachSach = new ArrayList<>();

        // Bài 1.6: Tạo mảng int[] soLuong gồm 5 cuốn sách
        int[] soLuong = new int[5];
        System.out.println("\n--- NHẬP SỐ LƯỢNG 5 CUỐN SÁCH ---");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nhập số lượng sách thứ " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
        }

        int tong = 0;
        int max = soLuong[0];
        System.out.println("\n--- DANH SÁCH SỐ LƯỢNG ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Sách thứ " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        System.out.println("Tổng số lượng: " + tong);
        System.out.println("Số lượng lớn nhất: " + max);
        // Bài 4.6: Xây dựng menu quản lý sách hoàn chỉnh
        int chon;
        do {
            System.out.println("\n--- QUẢN LÝ SÁCH ---");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.print("Mời bạn chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    System.out.print("Nhập số lượng sách cần thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhập sách thứ " + (i + 1));
                        Sach s = new Sach();
                        s.nhap(sc);
                        dsSach.add(s);
                        // Thêm mã sách vào ArrayList
                        maSachList.add(s.maSach);
                        // Thêm thông tin sách vào ArrayList
                        String thongTin = s.maSach + " - "
                                + s.tenSach + " - "
                                + s.soLuong + " - "
                                + s.donGia;
                        danhSachSach.add(thongTin);
                    }
                    System.out.println("Thêm sách thành công!");
                    break;

                // Hiển thị sách
                case 2:
                    if (dsSach.isEmpty()) {
                        System.out.println("Danh sách sách đang trống!");
                    } else {
                        System.out.println("\n--- DANH SÁCH SÁCH ---");
                        // Hiển thị thông tin sách
                        for (String s : danhSachSach) {
                            System.out.println(s);
                        }
                        // Hiển thị danh sách mã sách
                        System.out.println("\n--- DANH SÁCH MÃ SÁCH ---");
                        for (String ma : maSachList) {
                            System.out.println(ma);
                        }
                    }
                    break;

                // Tìm sách
                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = sc.nextLine();
                    boolean timThay = false;
                    // Tìm mã sách trong ArrayList
                    if (maSachList.contains(maTim)) {
                        // Tìm thông tin sách
                        for (Sach s : dsSach) {
                            if (s.maSach.equalsIgnoreCase(maTim)) {
                                System.out.println("Tìm thấy sách:");
                                s.xuat();
                                timThay = true;
                                break;
                            }
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy sách!");
                    }
                    break;

                // Xóa sách
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = sc.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < dsSach.size(); i++) {
                        if (dsSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                            // Xóa mã sách
                            maSachList.remove(i);
                            // Xóa thông tin sách
                            danhSachSach.remove(i);
                            // Xóa sách trong danh sách chính
                            dsSach.remove(i);
                            daXoa = true;
                            System.out.println("Xóa sách thành công!");
                            break;
                        }
                    }
                    if (!daXoa) {
                        System.out.println("Không tìm thấy sách cần xóa!");
                    }
                    break;

                // Sửa sách
                case 5:
                    System.out.print("Nhập mã sách cần sửa: ");
                    String maSua = sc.nextLine();
                    boolean daSua = false;
                    for (int i = 0; i < dsSach.size(); i++) {
                        if (dsSach.get(i).maSach.equalsIgnoreCase(maSua)) {
                            System.out.println("Nhập thông tin mới:");
                            Sach s = new Sach();
                            s.nhap(sc);
                            // Cập nhật thông tin sách
                            dsSach.set(i, s);
                            // Cập nhật mã sách
                            maSachList.set(i, s.maSach);

                            // Cập nhật thông tin sách
                            String thongTin = s.maSach + " - "
                                    + s.tenSach + " - "
                                    + s.soLuong + " - "
                                    + s.donGia;
                            danhSachSach.set(i, thongTin);
                            daSua = true;
                            System.out.println("Sửa sách thành công!");
                            break;
                        }
                    }
                    if (!daSua) {
                        System.out.println("Không tìm thấy sách cần sửa!");
                    }
                    break;

                // Bài 4.6: Tính tổng số lượng sách
                case 6:
                    int tongSoLuong = 0;

                    for (Sach s : dsSach) {
                        tongSoLuong += s.soLuong;
                    }

                    System.out.println("Tổng số lượng sách: " + tongSoLuong);
                    break;

                // Bài 4.6: Tính tổng giá trị sách
                case 7:
                    double tongGiaTri = 0;

                    for (Sach s : dsSach) {
                        tongGiaTri += s.soLuong * s.donGia;
                    }

                    System.out.println("Tổng giá trị sách: " + tongGiaTri);
                    break;

                // Bài 4.6: Thoát chương trình
                case 8:
                    System.out.println("Đã thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 8);
    }
}
