package view;

import model.TelephoneDirectory;
import services.DirectoryService;
import utils.CSVUtils;
import utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoryView {
    static String path = "data/contacts.csv";
    private static DirectoryService directoryService = new DirectoryService();
    static Scanner scanner = new Scanner(System.in);

    public static void option() {
        Menu.mainMenu();
        int choice;
        while (true) {
            while (true) {
                Scanner input = new Scanner(System.in);
                try {
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("\tChức năng phải là 1 số!");
                    Menu.mainMenu();
                }
            }
            switch (choice) {
                case 1:
                    show();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    updatePhoneDirectory();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    CSVUtils.read(path);
                    break;
                case 7:
                    CSVUtils.write(path, directoryService.getItem());
                    break;
                case 8:
                    Menu.exit();
                    System.exit(0);
                default:
                    System.out.println("\tKhông có chức năng này. Mời bạn nhập đúng chức năng!");
                    Menu.mainMenu();
                    break;
            }
        }
    }

    public static void remove() {
        String fullname = "";
        System.out.print("Nhập họ và tên muốn xóa : ");
        fullname = scanner.nextLine();
            if (!isFullNameHaveInList(fullname)) {
                System.out.println("Không có họ tên nào '" + fullname + "' !");
                remove();
            } else {
                int count = 0;
                ArrayList<TelephoneDirectory> list = new ArrayList<>();
                for (TelephoneDirectory directory : list) {
                    if (directory.getFullname().equals(fullname)) {
                        count++;
                        list.add(directory);
                    }
                }}
//        show();
//        List directorieList = directoryService.getItem();
//        System.out.printf("Nhập tên \n=> \t");
//        String name = scanner.nextLine();
//        TelephoneDirectory directorie = new TelephoneDirectory();
//        if (directorieList.contains(name)) {
//            boolean check = true;
//            String chon = scanner.nextLine();
//            try {
//                switch (chon) {
//                    case "y":
//                        directoryService.remove();
//                        System.out.println("Xóa thành công!!!");
//                        do {
//                            System.out.println("=====================================");
//                            System.out.println("|       Nhấn '1' để quay lại        |");
//                            System.out.println("|       Nhấn '2' để thoát           |");
//                            System.out.println("=====================================");
//                            System.out.printf("=> \t");
//                            byte choice = Byte.parseByte(scanner.nextLine());
//                            switch (choice) {
//                                case 1:
//                                    DirectoryView.option();
//                                    break;
//                                case 2:
//                                    Menu.exit();
//                                    break;
//                                default:
//                                    System.out.println("\t Nhập lại!!! ");
//                                    check = false;
//                            }
//                        } while (!check);
//                        break;
//                    case "b":
//                        DirectoryView.option();
//                        break;
//                    default:
//                        System.out.println("Mời Nhập Lại!!! ");
//                }
//            } catch (Exception e) {
//                System.out.println("Chưa hợp lệ!!! Mời Nhập Lại");
//            }
//        }
//    }

}

    public static boolean isFullNameHaveInList(String fullname) {
        List<TelephoneDirectory> directoryList = directoryService.getItem();
        for (TelephoneDirectory list : directoryList) {
            if (list.getFullname().equals(fullname)) return true;
        }
        return false;
    }

    public static void show() {
        List<TelephoneDirectory> directoryList = directoryService.getItem();
        boolean check = false;
        System.out.println("-----------------------------------------DANH SÁCH ĐIỆN THOẠI-------------------------------------------");
        System.out.printf("%-10s %-15s %-25s %-10s %-20s %-10s %-15s", "SĐT", "NHÓM", "HỌ VÀ TÊN", "GIỚI TÍNH", "ĐỊA CHỈ", "NGÀY SINH", "EMAIL");
        System.out.println(" ");
        for (TelephoneDirectory directory : directoryList) {
            check = true;
            System.out.printf("%-10s %-15s %-25s %-10s %-20s %-10s %-15s\n", directory.getPhone(), directory.getTeam(), directory.getFullname(),
                    directory.getGender(), directory.getAddress(), directory.getBirthDate(), directory.getEmail());
        }
        System.out.println("------------------------------------------------------------------------------------------------------\n");
        if (!check) {
            System.out.println("Không có danh bạ nào trong bộ nhớ");
        }
        option();
    }

    public static void searchByName() {
        List<TelephoneDirectory> directoryList = directoryService.getItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập tên sản phẩm cần tìm kiếm : ");
        String search = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
        search = search.toLowerCase();
        System.out.println("-----------------------------------------DANH SÁCH ĐIỆN THOẠI-------------------------------------------");
        System.out.printf("%-10s %-15s %-25s %-10s %-20s %-10s %-15s", "SĐT", "NHÓM", "HỌ VÀ TÊN", "GIỚI TÍNH", "ĐỊA CHỈ", "NGÀY SINH", "EMAIL");
        System.out.println(" ");
        for (TelephoneDirectory directory : directoryList) {
            if (directory.getFullname().toLowerCase().contains(search)) {
                count++;
                System.out.printf("%-10s %-15s %-25s %-10s %-20s %-10s %-15s\n", directory.getPhone(), directory.getTeam(), directory.getFullname(),
                        directory.getGender(), directory.getAddress(), directory.getBirthDate(), directory.getEmail());
            }
        }

        showReturnSearch(count);
        System.out.println();
        option();
    }

    public static void showReturnSearch(int count) {
        System.out.println("Có '" + count + "' sản phẩm được tìm thấy !");
        char press = ' ';
        boolean isChoice;
        System.out.println();
        do {
            System.out.print("Nhấn 'R' để về menu tìm kiếm !");
            try {
                press = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                press = ' ';
            }
            switch (press) {
                case 'r':
                case 'R': {
                    DirectoryView.option();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }

    public static void add() {
        List<TelephoneDirectory> directoryList = directoryService.getItem();

        System.out.println("Mời bạn nhập thông tin");
        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại:");
            phoneNumber = scanner.nextLine();
            if (Validation.isPhoneValid(phoneNumber)) {
                break;
            } else
                System.out.println("\tKhông tồn tại số điện thoại này, hãy nhập lại:");
        }
        System.out.print("Nhập nhóm danh bạ:");
        String group = scanner.nextLine();
        System.out.print("Nhập họ và tên:");
        String fullName = scanner.nextLine();
        System.out.print("Nhập giới tính:");
        String sex = scanner.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = scanner.nextLine();
        System.out.print("Nhập ngày sinh:");
        String birthDate = scanner.nextLine();
        String email;
        while (true) {
            System.out.print("Nhập email:");
            email = scanner.nextLine();
            if (Validation.isEmailValid(email)) {
                break;
            } else
                System.out.println("\tKhông tồn tại địa chỉ email này, hãy nhập lại:");
        }
        TelephoneDirectory phoneDirectory = new TelephoneDirectory(phoneNumber, group, fullName, sex, address, birthDate, email);
       // directoryList.add(phoneDirectory);
        directoryService.add(phoneDirectory);
        System.out.println("Đã thêm thành công danh bạ vào bộ nhớ!");
        option();
    }

    public static void updatePhoneDirectory() {
        List<TelephoneDirectory> directoryList = directoryService.getItem();
        while (true) {
            System.out.print("Nhập số điện thoại của danh bạ cần sửa:");
            String phoneNumberNeedUpdate = scanner.nextLine();
            if (phoneNumberNeedUpdate.equals("")) {
                option();
                return;
            }
            boolean checkExistPhoneNumber = false;
            for (TelephoneDirectory p : directoryList) {
                if (p.getPhone().equals(phoneNumberNeedUpdate)) {
                    checkExistPhoneNumber = true;
                    System.out.print("Cập nhật nhóm danh bạ:");
                    String team = scanner.nextLine();
                    p.setTeam(team);
                    System.out.print("Cập nhật họ và tên:");
                    String fullName = scanner.nextLine();
                    p.setFullname(fullName);
                    System.out.print("Cập nhật giới tính:");
                    String gender = scanner.nextLine();
                    p.setGender(gender);
                    System.out.print("Cập nhật địa chỉ:");
                    String address = scanner.nextLine();
                    p.setAddress(address);
                    System.out.print("Cập nhật ngày sinh:");
                    String birthDate = scanner.nextLine();
                    p.setBirthDate(birthDate);
                    String emailUpdate;
                    while (true) {
                        System.out.print("Cập nhật email:");
                        emailUpdate = scanner.nextLine();
                        if (Validation.isEmailValid(emailUpdate)) {
                            break;
                        } else
                            System.out.println("\tKhông tồn tại địa chỉ email này, hãy nhập lại:");
                    }
                    p.setEmail(emailUpdate);
                    directoryService.update();
                    System.out.println("Đã cập nhật thành công vào bộ nhớ");
                    break;
                }
            }
            if (checkExistPhoneNumber) {
                option();
                return;
            } else {
                System.out.println("Không tìm được danh bạ với số điện thoại trên");
            }
        }
    }
}
