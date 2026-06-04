import java.util.Scanner;

public class D_scanner_print {
    public static void main(String[] args){

        System.out.println("당신의 이름은?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.printf("제 이름은 %s입니다.\n", userName);

        System.out.println("당신의 나이는?");
        int userAge = sc.nextInt();
        System.out.printf("제 나이는 %d입니다.\n", userAge);
    }
}

// 참조형 변수는 new 키워드 사용하여 생성 (String은 제외)
// Scanner도 참조형