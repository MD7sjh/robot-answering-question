package app;

import model.Response;
import service.QkyRobotServiceImpl;
import service.RobotService;

import java.util.Scanner;

public class Main {

    private static final RobotService robotService = new QkyRobotServiceImpl();

    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("老板，麻烦您给我取个响亮的名字，按回车键确定！");
        String name = scanner.nextLine();
        System.out.println("hi，我是您的小助手"+ name + "，直接对我下达命令");
        while (true){
            String input = scanner.nextLine();
            if ("886".equalsIgnoreCase(input)){
                System.out.println("欢迎下次使用！");
                break;
            }else {
                Response response = robotService.qa(input);
                if (response != null && response.getCode() == 0){
                    System.out.println(name + "：" + response.getContent());
                }else {
                    System.out.println(name + "：暂时没明白您的意思，重新告诉我一下吧");
                }
            }
        }
        scanner.close();
    }
}
