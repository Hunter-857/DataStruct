package ag;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;



class DBHelper {
    public final static Connection getAccessConn() throws SQLException {
        //String path=Constant.CLASS_PATH.replace("WEB-INF"+Constant.PATH_SEPARATOR+"classes/","");
        String path = "./";
        String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"shop.mdb";

        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }catch(ClassNotFoundException cfe){
            throw new SQLException("no jdbc driver");
        }
        Connection conn= DriverManager.getConnection(strurl) ;
        return conn;
    }

    public final static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException se) {
            System.out.println("关闭数据库连接失败");
        }
    }
}
//商品类
class  ShangPin implements Serializable  {
    int id;
    String name;
    String unit;//计量单位
    int count;//数量
    double price;//单价
    String rukuTime;//入库日期
    public ShangPin(int id, String name, String unit, int amount, double price, String rukuTime) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.count = amount;
        this.price = price;
        this.rukuTime = rukuTime;
    }
}

//水果类
class Fruit extends ShangPin implements Serializable{
    String brand;//品牌
    int grade;//等级

    public Fruit(int id, String name, String unit, int amount, double price, String rukuTime, String brand, int grade) {
        super(id, name, unit, amount, price, rukuTime);
        this.brand = brand;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "水果{" +
                "编号=" + id +
                ", 名称='" + name + '\'' +
                ", 计量单位='" + unit + '\'' +
                ", 数量=" + count +
                ", 价格=" + price +
                ", 入库时间='" + rukuTime + '\'' +
                ", 品牌='" + brand + '\'' +
                ", 等级='" + grade + '\'' +
                '}';
    }
}
//食品类
class Food extends ShangPin implements Serializable{
    String producer;//厂家
    String produceTime;//生产日期
    int baozhiDay;//保质期

    public Food(int id, String name, String unit, int amount, double price, String rukuTime, String factory, String producrTime, int baozhiDay) {
        super(id, name, unit, amount, price, rukuTime);
        this.producer = factory;
        this.produceTime = producrTime;
        this.baozhiDay = baozhiDay;
    }

    @Override
    public String toString() {
        return "食品{" +
                "编号=" + id +
                ", 名称='" + name + '\'' +
                ", 计量单位='" + unit + '\'' +
                ", 数量=" + count +
                ", 价格=" + price +
                ", 入库时间='" + rukuTime + '\'' +
                ", 厂家='" + producer + '\'' +
                ", 生产日期='" + produceTime + '\'' +
                ", 保质期='" + baozhiDay + '\'' +
                '}';
    }
}
//电器类
class DianQi extends ShangPin implements Serializable{
    String factory;//厂家
    String produceTime;//生产日期
    String type;//型号

    public DianQi(int id, String name, String unit, int amount, double price, String rukuTime, String factory, String produceTime, String type) {
        super(id, name, unit, amount, price, rukuTime);
        this.factory = factory;
        this.produceTime = produceTime;
        this.type = type;
    }

    @Override
    public String toString() {
        return "电器{" +
                "编号=" + id +
                ", 名称='" + name + '\'' +
                ", 计量单位='" + unit + '\'' +
                ", 数量=" + count +
                ", 价格=" + price +
                ", 入库时间='" + rukuTime + '\'' +
                ", 厂家='" + factory + '\'' +
                ", 生产日期='" + produceTime + '\'' +
                ", 型号='" + type + '\'' +
                '}';
    }
}
//入库/出库类
class Sell implements Serializable{
    int proId;//商品id
    String proName;//商品名称
    int amount;//数量
    int type;//1代表入库 2代表出库

    public Sell(int proId, String proName, int amount, int type) {
        this.proId = proId;
        this.proName = proName;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        if(type==1){
            return "入库{" +
                    "商品id='" + proId + '\'' +
                    ", 商品名称='" + proName + '\'' +
                    ", 入库数量='" + amount + '\'' +
                    '}';
        }else {
            return "出库{" +
                    "商品id='" + proId + '\'' +
                    ", 商品名称='" + proName + '\'' +
                    ", 出库数量='" + amount + '\'' +
                    '}';
        }
    }
}

public class Example {
    private static Scanner keyboard=new Scanner(System.in);
    //hashMap集合保存商品的信息
    HashMap<String,List<ShangPin>>shangpins;
    //ArrayList集合保存出库/入库的信息
    ArrayList<Sell>sells;
    //定义其它容器
    Example() throws IOException, ClassNotFoundException {
        //读入数据
        //ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream("src/zxw/data/sells.txt"));
        //ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream("src/zxw/data/shangpin.txt"));

        ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream("/Users/hunter/Desktop/JAVApro/ag/assert/sells.txt"));
        ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream("/Users/hunter/Desktop/JAVApro/ag/assert/shangpin.txt"));
        sells=(ArrayList<Sell>) inputStream1.readObject();
        shangpins=(HashMap<String, List<ShangPin>>) inputStream2.readObject();

    }
    //=====================================================
    //功能处理函数
    void panKu(){
        System.out.println("==============盘库处理！！==============");
        System.out.println("当前所有的水果信息如下：");
        for (ShangPin f : shangpins.get("水果")) {
            System.out.println(f);
        }
        System.out.println("当前所有的食品信息如下：");
        for (ShangPin food : shangpins.get("食品")) {
            System.out.println(food);
        }
        System.out.println("当前所有的电器信息如下：");
        for (ShangPin dainqi : shangpins.get("电器")) {
            System.out.println(dainqi);
        }
        System.out.println("当前入库/出库信息如下：");
        for (Sell sell : sells) {
            System.out.println(sell);
        }
    }
    void shouKuan(){
        System.out.println("==============出售处理！！==============");
        //判断当前是否有在售的商品
        boolean hasShangpin=false;
        for (List<ShangPin> value : shangpins.values()) {
            if(value.size()!=0)hasShangpin=true;
        }
        if(!hasShangpin){
            System.out.println("当前没有商品在售！");
            return;
        }
        System.out.println("当前所有在售商品信息如下：");
        for (ShangPin f : shangpins.get("水果")) {
            System.out.println(f);
        }
        for (ShangPin food : shangpins.get("食品")) {
            System.out.println(food);
        }
        for (ShangPin dainqi : shangpins.get("电器")) {
            System.out.println(dainqi);
        }
        System.out.println("请输入要购买的商品编号：");
        int id= keyboard.nextInt();
        //遍历集合，查找该商品
        boolean e=false;
        for (String s : shangpins.keySet()) {
            for (ShangPin shangPin : shangpins.get(s)) {
                if(shangPin.id==id){
                    System.out.println("请输入要购买的数量：");
                    int amount= keyboard.nextInt();
                    //判断库存是否充足
                    if(shangPin.count <amount){
                        System.out.println("库存不足！");
                        return;
                    }
                    e=true;
                    //扣减库存
                    shangPin.count -=amount;
                    System.out.println("商品购买成功");
                    sells.add(new Sell(id,shangPin.name,amount,2));
                    return;
                }
            }
        }
        if(!e) System.out.println("没有找到对应的商品！");
    }
    void ruKu(){
        System.out.println("==============入库处理！！=============");
        System.out.println("你想进货哪一种商品？（1水果 2食品 3电器）");
        int choose=keyboard.nextInt();
        if(choose==1){
            List<ShangPin> fruits = shangpins.get("水果");
            System.out.println("请输入id：");
            int id=keyboard.nextInt();
            //判断id是否存在
            boolean exist=false;
            for (ShangPin fruit : fruits) {
                if (fruit.id == id) {
                    System.out.println("请输入要进货的数量：");
                    int count = keyboard.nextInt();
                    //修改数量
                    fruit.count += count;
                    System.out.println("进货成功！");
                    sells.add(new Sell(id,fruit.name,count,1));
                    exist = true;
                }
            }
            if(exist)return;
            System.out.println("请输入名称：");
            String name= keyboard.next();
            System.out.println("请输入计量单位：");
            String unit= keyboard.next();
            System.out.println("请输入数量：");
            int amount= keyboard.nextInt();
            System.out.println("请输入单价：");
            double price= keyboard.nextDouble();
            System.out.println("请输入品牌：");
            String brand= keyboard.next();
            System.out.println("请输入等级：");
            int grade= keyboard.nextInt();
            fruits.add(new Fruit(id,name,unit,amount,price,new SimpleDateFormat("yyyy-MM-hh HH:mm:ss").format(new Date()),brand,grade));
            sells.add(new Sell(id,name,amount,1));
            System.out.println("进货成功！");
        }else if(choose==2){
            List<ShangPin> foods = shangpins.get("食品");
            System.out.println("请输入id：");
            int id=keyboard.nextInt();
            //判断id是否存在
            boolean exist=false;
            for (ShangPin food : foods) {
                if (food.id == id) {
                    System.out.println("请输入要进货的数量：");
                    int amount = keyboard.nextInt();
                    //修改数量
                    food.count +=amount;
                    sells.add(new Sell(id,food.name,amount,1));
                    System.out.println("进货成功！");
                    exist = true;
                }
            }
            if(exist)return;
            System.out.println("请输入名称：");
            String name= keyboard.next();
            System.out.println("请输入计量单位：");
            String unit= keyboard.next();
            System.out.println("请输入数量：");
            int amount= keyboard.nextInt();
            System.out.println("请输入单价：");
            double price= keyboard.nextDouble();
            System.out.println("请输入厂家:");
            String factory= keyboard.next();
            System.out.println("请输入生产日期:");
            String shengchan= keyboard.next();
            System.out.println("请输入保质期:");
            int baozhi= keyboard.nextInt();
            sells.add(new Sell(id,name,amount,1));
            foods.add(new Food(id,name,unit,amount,price,new SimpleDateFormat("yyyy-MM-hh HH:mm:ss").format(new Date()),factory,shengchan,baozhi));
            System.out.println("进货成功！");
        }else if(choose==3){
            List<ShangPin> dianqis = shangpins.get("电器");
            System.out.println("请输入id：");
            int id=keyboard.nextInt();
            //判断id是否存在
            boolean e=false;
            for (ShangPin dianqi : dianqis) {
                if (dianqi.id == id) {
                    System.out.println("请输入要进货的数量：");
                    int amount = keyboard.nextInt();
                    //修改数量
                    dianqi.count += amount;
                    System.out.println("进货成功！");
                    sells.add(new Sell(id, dianqi.name,amount,1));
                    e = true;
                }
            }
            if(e)return;
            System.out.println("请输入名称：");
            String name= keyboard.next();
            System.out.println("请输入计量单位：");
            String unit= keyboard.next();
            System.out.println("请输入数量：");
            int amount= keyboard.nextInt();
            System.out.println("请输入单价：");
            double price= keyboard.nextDouble();
            System.out.println("请输入厂家:");
            String factory= keyboard.next();
            System.out.println("请输入生产日期:");
            String shengchan= keyboard.next();
            System.out.println("请输入型号：");
            String type= keyboard.next();
            dianqis.add(new DianQi(id,name,unit,amount,price,new SimpleDateFormat("yyyy-MM-hh HH:mm:ss").format(new Date()),factory,shengchan,type));
            sells.add(new Sell(id,name,amount,1));
            System.out.println("进货成功！");
        }else {
            System.out.println("请输入1,2,3");
        }
    }

    //
    void mainMenu(){ //显示菜单
        System.out.println("  1-入库");
        System.out.println("  2-盘库");
        System.out.println("  3-收款");
        System.out.println("  0-退出");
        System.out.println("===========");
        System.out.print(" 请选择：");
    }

    public void main(String[] args) throws IOException, ClassNotFoundException {
        Example chaoShi= new  Example();
        boolean isLoop=true;
        while(isLoop){
            chaoShi.mainMenu();//显示菜单
            try{
                int cmd=keyboard.nextInt();//选择
                //System.out.println();

                switch(cmd){
                    case 1:chaoShi.ruKu();break;
                    case 2:chaoShi.panKu();break;
                    case 3:chaoShi.shouKuan();break;
                    case 0:isLoop=false;chaoShi.save();break;
                    default:System.out.println("Exception: 命令输入错误！");
                        keyboard.nextLine();
                }
            } catch (InputMismatchException  e){
                System.out.println("Exception: 请输入数字 ！！");
                keyboard.nextLine();
            } catch (Exception  e){
                System.out.println("Exception: 系统运行出现错误！");
                System.out.println(e.getMessage());
            }
        }

    }
    //将集合中的数据保存到文件
    public  void save() throws IOException {
       //ObjectOutputStream o1 = new ObjectOutputStream(new FileOutputStream("src/zxw/data/sells.txt"));
       //ObjectOutputStream o2 = new ObjectOutputStream(new FileOutputStream("src/zxw/data/shangpin.txt"));
        ObjectOutputStream o1 = new ObjectOutputStream(new FileOutputStream("/Users/hunter/Desktop/JAVApro/ag/assert/sells.txt"));
        ObjectOutputStream o2 = new ObjectOutputStream(new FileOutputStream("/Users/hunter/Desktop/JAVApro/ag/assert/shangpin.txt"));
        o1.writeObject(sells);
        o2.writeObject(shangpins);
        o1.close();
        o2.close();
    }

}

