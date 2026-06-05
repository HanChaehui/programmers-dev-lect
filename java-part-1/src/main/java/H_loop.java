public class H_loop {
    // 구구단 2단부터 9단까지
    public static void practice1(){
        for(int i = 2; i <= 9; i++){
            System.out.printf("=== 구구단 %d단 ===\n", i);
            for(int j = 1; j <= 9; j++){
                System.out.printf("%d x %d = %d\n", i, j, i*j);
            }
        }
    }
    // continue: 1 ~ 100까지 짝수만 출력
    public static void practice2(){
        System.out.println("");
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 1){
                continue;
            }
            System.out.printf("%d ", i);
            if(i%10 == 0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
    // break: 1 ~ 100까지 올라가는데, 30에 도달했을 때 멈춤(탈출)
    public static void practice3(){
        for(int i = 1; i <= 100; i++){
            System.out.printf("%d ", i);
            if(i == 30){
                break;
            }
        }
    }
    public static void main(String[] args){
        practice1();
        practice2();
        practice3();
    }
}
