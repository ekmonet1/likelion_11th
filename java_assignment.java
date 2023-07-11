import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class java_assignment {
    public static void main() {
        System.out.println("======================");
        System.out.println("은행 계좌 만들기");
        System.out.println("======================");

        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        ArrayList accounts_info = new ArrayList();

        while(!flag){

            HashMap accounts = new HashMap();

            System.out.println("=====Bank Menu=====");
            System.out.println("1. 계좌개설");
            System.out.println("2. 입금하기");
            System.out.println("3. 출금하기");
            System.out.println("4. 전체조회");
            System.out.println("5. 프로그램 종료");
            System.out.println("===================");
            System.out.println("입력 : ");

            String first_input = sc.nextLine();

            while(true) {
                if (first_input.equals("1")) {
                    System.out.println("=====계좌개설=====");
                    System.out.println("계좌 번호를 입력하세요");
                    String account_input = sc.nextLine();
                    String name_input = sc.nextLine();
                    Integer deposit_input = sc.nextInt();

                    accounts.put("account_input",account_input);
                    accounts.put("name_input",name_input);
                    accounts.put("deposit_input",deposit_input);

                    accounts_info.add(accounts);

                    System.out.println("##계좌개설을 완료하였습니다##");
                    System.exit(0);
                } else if (first_input.equals("2")) {
                    System.out.println("=====입금하기=====");
                    while(true) {
                        System.out.println("입금하실 계좌번호를 입력해주세요");
                        String verifying_account_input = sc.nextLine();
                        if (verifying_account_input.equals(accounts.get("accounts_input"))) {
                            System.out.println("계좌이름 : " + accounts.get("name_input"));
                            System.out.println("계좌잔고 : " + accounts.get("deposit_input"));
                            break;
                        } else {
                            System.out.println("계좌번호를 다시 입력해주세요");
                        }
                    }
                    System.out.println("입금하실 금액을 입력해주세요 :");
                    String amount_input = sc.nextLine();
                    int amount = Integer.parseInt(amount_input);
                    int deposit1 = accounts.get("deposit_input");

                    deposit1 += amount;

                    accounts.put("deposit_input",deposit1);

                    System.out.println("##계좌 잔고 :" + accounts.get("deposit"));
                    System.out.println("##입금이 완료되었습니다##");
                    System.out.println("======================");
                } else if (first_input.equals("3")) {
                    System.out.println("=====출금하기=====");
                    while(true) {
                        System.out.println("출금하실 계좌번호를 입력해주세요");
                        String verifying_account_output = sc.nextLine();
                        if (verifying_account_output.equals(accounts.get("accounts_input"))) {
                            System.out.println("계좌이름 : " + accounts.get("name_input"));
                            System.out.println("계좌잔고 : " + accounts.get("deposit_input"));
                            break;
                        } else {
                            System.out.println("계좌번호를 다시 입력해주세요");
                        }
                    }
                    System.out.println("출금하실 금액을 입력해주세요 : ");
                    String try_withdraw = sc.nextLine();
                    int withdraw = Integer.parseInt(try_withdraw);

                    while(true){
                        int deposit = accounts.get("deposit_input");
                        if (Integer.compare(withdraw,deposit) == 1){
                            System.out.println("잔액이 부족합니다. 다시 시도해주세요");
                        }
                        else{
                            deposit-=withdraw;
                            accounts.put("deposit_input",deposit);
                            break;
                        }
                    }
                } else if (first_input.equals("4")) {
                    System.out.println("=====전체조회=====");
                    System.out.println("계좌번호 : "+accounts.get("accounts_input")+" / 이름 : "+accounts.get("name_input")+" / 잔액 : "+accounts.get("deposit_input"));
                } else if (first_input.equals("5")) {
                    System.out.println("##프로그램을 종료합니다##");
                    System.exit(0);
                }
            }
        }
    }
}
