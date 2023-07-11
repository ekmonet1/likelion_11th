import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserRegister {
    public static void main(String[] args) {
        System.out.println("========================");
        System.out.println("회원 등록");
        System.out.println("========================");


        boolean register = false;
        Scanner sc = new Scanner(System.in);

        while(!register){
            System.out.println("회원가입을 하시겠습니까? \nY: 진행    N:취소");
            System.out.println("  ==  ");
            String register_input = sc.nextLine();

            if(register_input.equalsIgnoreCase("y")) {  //대문자소문자 구별X
                register = true;
                System.out.println("==========================");
                System.out.println("회원가입이 진행됩니다.");
                System.out.println("==========================");
            } else if (register_input.equalsIgnoreCase("n")) {
                System.out.println("==========================");
                System.out.println("회원가입이 종료됩니다.");
                System.out.println("==========================");
                System.exit(0);
            } else {
                System.out.println("입력값을 확인해주세요.");
            }

            ArrayList users = new ArrayList();

            while (true) {
                HashMap user = new HashMap();

                System.out.println("ID: ");
                String username = sc.nextLine();

                String password = "";

                while (true) {
                    System.out.print("PW: ");
                    password = sc.nextLine();
                    System.out.print("PW 확인: ");
                    String password_confirm = sc.nextLine();

                    if (password.equals(password_confirm)) {
                        break;
                    } else {
                        System.out.println("=======================");
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        System.out.println("비밀번호를 다시 입력해주세요.");
                        System.out.println("=======================");
                    }
                }
                System.out.println("이름 : ");
                String realname = sc.nextLine();

                String birthdate;
                while (true) {
                    System.out.println("생년월일 6자를 입력해주세요 : ");
                    birthdate = sc.nextLine();
                    System.out.println(birthdate.length());

                    if (birthdate.length() == 6) {
                        break;
                    } else {
                        System.out.println("6자 입력이 아닙니다. 다시 시도해주세요");
                    }
                }
                System.out.println("이메일 : ");
                String email = sc.nextLine();

                user.put("username", username);
                user.put("password", password);
                user.put("realname", realname);
                user.put("birthdate", birthdate);
                users.add(user);

                System.out.println("==================");
                System.out.println(user.get("realname")+" 님, 가입을 환영합니다.");
                System.out.println("ID는 "+user.get("username")+"입니다.");
            }
        }
    }
}