public class B_variable_method {
    public static void main(String[] args) {

        int result = add(10, 20);
        printResult(result);
        result = minus(20, 10);
        printResult(result);
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int minus(int a, int b){
        return a - b;
    }

    public static void printResult(int result){
        System.out.println("result: "+ result);
    }
}

// 기본형 - 값을 저장
// 변수 : byte short float(뒤에 f 붙이기) double int long(뒤에 L 붙이기) char(정수 넣으면 아스키코드 알파벳 변환 출력) boolean
// 상수 : 변수 type 앞에 final 키워드 ex) final float PI = 3.14f;
// 참조형 - 주소 저장
// 문자열 :