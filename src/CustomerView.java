/**
 * ClassName: CustomerView
 * Description:
 *
 * @author chuanchuan
 * @version 1.0
 * @create 2026/3/16 10:12
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    {
        customerList.addCustomer(new Customer("张三", 20, '男',
                "13023002300", "zhangsan@qq.com"));
        customerList.addCustomer(new Customer("李四", 21, '男',
                "13014001400", "Lisi@qq.com"));

    }

    /**
     * 进入“拼电商客户管理系统”主界面
     */
    public void enterMainMenu() {
        while (true) {
            System.out.println("---------------拼电商客户管理系统主界面---------------");
            System.out.println("                1. 添 加 客 户");
            System.out.println("                2. 删 除 客 户");
            System.out.println("                3. 修 改 客 户");
            System.out.println("                4. 客 户 列 表");
            System.out.println("                5. 退    出\n");
            System.out.print("请选择 (1 - 5):");

            char Selection = Util.readMenuSelection();

            switch (Selection) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    deleteCustomer();
                    break;
                case '3':
                    updateCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N): ");
                    char confirmExitSelection = Util.readConfirmSelection();
                    if (confirmExitSelection == 'Y') {
                        System.out.println("已退出，欢迎下次使用本系统！");
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    public void addNewCustomer() {
        System.out.println("----------添加新客户----------");
        System.out.print("请输入新客户的姓名: ");
        String name = Util.readCustomerName();
        System.out.print("请输入新客户的年龄: ");
        int age = Util.readCustomerAge();
        System.out.print("请输入新客户的性别(男/女): ");
        char gender = Util.readCustomerGender();
        System.out.print("请输入新客户的手机号码: ");
        String phone = Util.readCustomerPhone();
        System.out.print("请输入新客户的邮箱: ");
        String email = Util.readCustomerEmail();
        Customer customer = new Customer(name, age, gender, phone, email);
        boolean result = customerList.addCustomer(customer);
        if (!result) {
            System.out.println("添加新客户失败，客户数量已达上限！");
        } else {
            System.out.println("添加新客户成功！");
        }
    }

    public void updateCustomer() {
        System.out.println("----------更改客户信息----------");
        System.out.print("输入需要更改信息客户的编号：");
        int index = Util.readCustomerIndex(customerList.getNumberOfCustomers());
        Customer customer = customerList.getCustomer(index - 1);
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
        System.out.println((index) + "\t\t" + customer.getInfo());
        System.out.print("你确认要修改该客户的信息吗(Y/N): ");
        char confirmSelection = Util.readConfirmSelection();
        if (confirmSelection == 'N') {
            return;
        }
        System.out.print("请输入将姓名修改为: ");
        String name = Util.readCustomerName();
        customer.setName(name);
        System.out.print("请输入将年龄修改为: ");
        int age = Util.readCustomerAge();
        customer.setAge(age);
        System.out.print("请输入将性别修改为(男/女): ");
        char gender = Util.readCustomerGender();
        customer.setGender(gender);
        System.out.print("请输入将手机号码修改为: ");
        String phone = Util.readCustomerPhone();
        customer.setPhone(phone);
        System.out.print("请输入将邮箱修改为: ");
        String email = Util.readCustomerEmail();
        customer.setEmail(email);
        boolean result = customerList.updateCustomer(index - 1, customer);
        if (!result) {
            System.out.println("客户信息更改失败！");
        } else {
            System.out.println("客户信息更改成功！");
        }
    }

    public void deleteCustomer() {
        System.out.println("----------删除客户信息----------");
        System.out.print("输入需要删除客户的编号：");
        int index = Util.readCustomerIndex(customerList.getNumberOfCustomers());
        Customer customer = customerList.getCustomer(index - 1);
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
        System.out.println((index) + "\t\t" + customer.getInfo());
        System.out.print("你确认要删除该客户的信息吗(Y/N): ");
        char confirmSelection = Util.readConfirmSelection();
        if (confirmSelection == 'N') {
            return;
        }
        boolean result = customerList.deleteCustomer(index - 1);
        if (!result) {
            System.out.println("删除客户失败，输入标号有误！");
        } else {
            System.out.println("删除客户成功！");
        }
    }

    public void listAllCustomer() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] customers = customerList.getAllCustomers();
        if (customers.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            for (int i = 0; i < customers.length; i++) {
//            System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
                System.out.println((i + 1) + "\t\t" + customers[i].getInfo());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------");
    }
}
