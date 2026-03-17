import java.util.Scanner;

/**
 * ClassName: Util
 * Description:
 *          Util类中定义了各种从键盘录入信息的方法
 * @author chuanchuan
 * @version 1.0
 * @create 2026/3/17 9:42
 */
public class Util {
    public static Scanner sc = new Scanner(System.in);
    /**
     * 从键盘录入“拼电商客户管理系统”的主界面选择
     * */
    public static char readMenuSelection() {
        // 主菜单选择列表: 1, 2, 3, 4, 5
        String[] selections = {"1", "2", "3", "4", "5"};
        while(true) {
            String str = sc.nextLine().trim();
            for (int i = 0; i < selections.length; i++) {
                if (selections[i].equals(str)) {
                    return selections[i].charAt(0);
                }
            }
            System.out.print("输入有误，请重新输入(1-5): ");
        }
    }
    /**
     * 当用户选择5退出“拼电商客户管理系统”时，需要键盘录入是否确认退出的选项
     * */
    public static char readConfirmSelection() {
        String[] selections = {"Y", "N", "YES", "NO"};
        while (true) {
            String str = sc.nextLine().trim();
            for (int i = 0; i < selections.length; i++) {
                if (selections[i].equalsIgnoreCase(str)) {
                    return selections[i].charAt(0);
                }
            }
            System.out.print("输入有误，请重新输入(Y/N): ");
        }
    }
    /**
     * 用于读取客户姓名
     * */
    public static String readCustomerName() {
        String name = sc.nextLine().trim();
        while (true) {
            if (name.length() >= 2 && name.length() <= 10) return name;
            System.out.print("姓名长度为2-10，请重新输入: ");
            name = sc.nextLine().trim();
        }
    }
    /**
     * 用于读取客户年龄
     * */
    public static int readCustomerAge() {
        String ageStr = sc.nextLine().trim();
        while (true) {
            if (!ageStr.isEmpty() && ageStr.matches("\\d+")) {
                int age = Integer.parseInt(ageStr);
                if (age >= 0 && age <= 120) {
                    return age;
                } else {
                    System.out.print("年龄范围不合法，请重新输入: ");
                    ageStr = sc.nextLine().trim();
                    continue;
                }
            }
            System.out.print("年龄格式不合法，请输入数字: ");
            ageStr = sc.nextLine().trim();
        }
    }

    /**
     * 用于读取客户性别
     * */
    public static char readCustomerGender() {
        String gender = sc.nextLine().trim();
        while (true) {
            if ("男".equals(gender) || "女".equals(gender)) return gender.charAt(0);
            System.out.print("性别输入有误，请重新输入(男/女): ");
            gender = sc.nextLine().trim();
        }
    }

    /**
     * 用于读取客户号码
     * */
    public static String readCustomerPhone() {
        String phone = sc.nextLine().trim();
        while (true) {
            if (phone.matches("^1\\d{10}$")) return phone;
            System.out.print("手机号格式不正确，请输入以1开头，共11位的手机号码: ");
            phone = sc.nextLine().trim();
        }
    }

    /**
     * 用于读取客户邮箱
     * */
    public static String readCustomerEmail() {
        String Email = sc.nextLine().trim();
        return Email;
    }

    /**
     * 用于读取客户的编号
     * */
    public static int readCustomerIndex(int numberOfCustomers) {
        String indexStr = sc.nextLine().trim();
        while (true) {
            if (indexStr.matches("\\d+")) {
                int index = Integer.parseInt(indexStr);
                if (index >= 0 && index <= numberOfCustomers) {
                    return index;
                } else {
                    System.out.print("客户编号不合法，请重新输入: ");
                    indexStr = sc.nextLine().trim();
                }
            }
        }
    }
}
