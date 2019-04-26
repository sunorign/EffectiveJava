package 创建和销毁对象;

public class 自动关闭资源文件 {
    public static void main(String[] args){
        try(Connection connection = new Connection()){
            connection.sendData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Connection implements AutoCloseable{
    public void sendData(){
        System.out.println("发送数据");
    }

    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}
