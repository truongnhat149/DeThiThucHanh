package view;

import java.util.Scanner;

public class Menu {

    public Menu() {
        DirectoryView.option();
    }

    public static void mainMenu() {
        System.out.println("===================================================================");
        System.out.println("======              CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ            =======");
        System.out.println("===================================================================");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát\n");
        System.out.println("Chọn chức năng: \t");
    }
    public static void exit(){
        System.out.println("\t\t.....Bạn vừa thoát chương trình!!!");
    }
}

