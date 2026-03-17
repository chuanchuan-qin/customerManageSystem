/**
 * ClassName: CustomerList
 * Description:
 *          CustomerList类为Customer类的管理模块，内部使用数组管理一组Customer对象，封装了增删改查方法。
 * @author chuanchuan
 * @create 2026/3/16 10:12
 * @version 1.0
 */
public class CustomerList {
    // 用户存放客户
    private Customer[] customerArray;

    // 记录客户数量
    private int numberOfCustomers;
    /**
     * 构造器，用于初始化customers数组
     * @param maxNumberOfCustomers 指定customers数组的最大空间
     * */
    public CustomerList(int maxNumberOfCustomers) {
        customerArray = new Customer[maxNumberOfCustomers];
    }
    /**
     * 增加客户，用于将客户增加到customers数组中
     * @param customer 需要增加的客户
     * @return 添加成功返回true，添加失败返回false
     * */
    public boolean addCustomer(Customer customer) {
        if (numberOfCustomers >= customerArray.length) {
            return false;
        }
        customerArray[numberOfCustomers++] = customer;
        return true;
    }
    /**
     * 删除客户，从customers数组中删除指定索引的客户
     * @param index 需要删除的客户在customer数组中的索引
     * @return 删除成功返回true，删除失败返回false
     * */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= numberOfCustomers) {
            return false;
        }
        for (int i = index; i < numberOfCustomers - 1; i++) {
            customerArray[i] = customerArray[i + 1];
        }
        customerArray[numberOfCustomers - 1] = null;
        numberOfCustomers--;
        return true;
    }
    /**
     * 更新客户信息，用户将customer替换customers数组中索引为index的客户
     * @param index 需要更新信息的客户的数组下标
     * @param customer 需要更新为的客户信息
     * @return 更新成功返回true，更新失败返回false
     * */
    public boolean updateCustomer(int index, Customer customer) {
        if (index < 0 || index >= numberOfCustomers) {
            return false;
        }
        customerArray[index] = customer;
        return true;
    }
    /**
     * 用于获得数组中指定索引的客户对象
     * @return 返回customers数组中指定索引的客户对象，索引无效返回null
     * */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= numberOfCustomers) {
            return null;
        }
        return customerArray[index];
    }
    /**
     * 用于获得数组中记录的所有客户对象
     * @return 返回customers数组中记录的所有客户对象，返回数组长度与客户数量一样
     * */
    public Customer[] getAllCustomers() {
        Customer[] customers = new Customer[numberOfCustomers];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = this.customerArray[i];
        }
        return customers;
    }
    /**
     * 用于获得数组中客户对象的数量
     * @return 返回数组中客户对象的数量
     * */
    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

}
