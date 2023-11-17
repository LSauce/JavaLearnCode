package cn.kiroe.day01;

import java.util.Scanner;

public class Main {
    public static double test1(){
        long l = 20;
        return l;
    }
    public static void main(String[] args) {

        //1. 季节
        //theSeason()q

        //2. 工资




    }
    public static void personalIncomeTaxCalculator(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入工资薪金所得：");
        double salary = scanner.nextDouble();

        double tax = calculatePersonalIncomeTax(salary);
        double netSalary = salary - tax;

        System.out.println("应缴纳的个人所得税：" + tax);
        System.out.println("到手工资：" + netSalary);
    }

    public static double calculatePersonalIncomeTax(double salary) {
        double taxableIncome = salary - 2000;
        double tax;

        if (taxableIncome <= 500) {
            tax = taxableIncome * 0.05;
        } else if (taxableIncome <= 2000) {
            tax = taxableIncome * 0.1 - 25;
        } else if (taxableIncome <= 5000) {
            tax = taxableIncome * 0.15 - 125;
        } else if (taxableIncome <= 20000) {
            tax = taxableIncome * 0.2 - 375;
        } else if (taxableIncome <= 40000) {
            tax = taxableIncome * 0.25 - 1375;
        } else if (taxableIncome <= 60000) {
            tax = taxableIncome * 0.3 - 3375;
        } else if (taxableIncome <= 80000) {
            tax = taxableIncome * 0.35 - 6375;
        } else if (taxableIncome <= 100000) {
            tax = taxableIncome * 0.4 - 10375;
        } else {
            tax = taxableIncome * 0.45 - 15375;
        }

        return tax;
    }
    /*
    * 键盘录入某个人的工资收入，求他应该缴纳的个人所得税以及最后得到的工资。

        也就是说需要求两个值：

        缴纳的个税

        到手工资

        个人所得税的计算方法是：

        应纳税额 = 应纳税所得额 * 税率 - 速算扣除数 （速算扣除额已经扣除了重复计算的部分）

其中，应纳税所得额 = 工资薪金所得-2000（即工资超过2000的部分才需要缴税）

针对不同的收入人群，需要缴纳个税的税率是不同的，详参下列表格：

级数	应纳税所得额	税率（单位:%）	速算扣除数
1	不超过500元的	5	0
2	超过500元但是不超过2000的	10	25
3	超过2000元但是不超过5000元的	15	125
4	超过5000元但是不超过20000元的	20	375
5	超过20000元但是不超过40000元的	25	1375
6	超过40000元但是不超过60000元的	30	3375
7	超过60000元但是不超过80000元的	35	6375
8	超过80000元但是不超过100000元的	40	10375
9	超过100000元的	45	15375
注：

代码直接写在main()方法中即可，注意命名规范！

再次重复一遍，速算扣除数，已经扣除了重复计算的部分。你不需要考虑重复计算的部分，实际生活中的缴税计算也是这样的，只不过个税起征点调整到了5000


    * */


    public static void theSeason(){
          /*
    * 先键盘录入一个表示月份的整数，然后利用switch语句输出每个月份对应的季节：

        12、1、2：冬季

        3、4、5：春季

        6、7、8：夏季

        9、10、11：秋季

注：合理使用case穿越，注意命名规范
    *
    * */
        Scanner in = new Scanner(System.in);
        System.out.println("键盘录入月份,输出月份对应的季节");
        System.out.print("请输入月份:");
        int month = in.nextInt();
        System.out.println(month +"月是："+ toSeason(month) );
        in.close();
    }
    public static String toSeason(int month){
        String reason = "默认";
        switch (month){
            case 12:
            case 1:
            case 2:
                reason = "冬季";
                break;
            case 3:
            case 4:
            case 5:
                reason = "春季";
                break;
            case 6:
            case 7:
            case 8:
                reason = "夏季";
                break;
            case 9:
            case 10:
            case 21:
                reason = "秋季";
                break;
            default:
                reason = "数据错误";

        }

        return reason;
    }

}
