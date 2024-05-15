/*
プログラミング演習Ⅱの課題2-1から抜粋
コマンドライン引数には摂氏・華氏の順に入っている
メソッドを使って摂氏を華氏に変換、そして華氏を元に
四つの異なるメッセージを出すプログラム
*/
import java.util.Scanner;

public class port2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //コマンドライン引数から値をscanに代入

        double c = scan.nextDouble();
        //double関数のcに摂氏の値を代入
        double f = calcFahrenheit(c);
        //calcFahrenheit(摂氏の意)のメソッドの答えをfに格納
        
        System.out.printf("%.1f\n", f);
        //先に華氏の出力(小数点1以下四捨五入)をしておく
        printMessage(c, f);
        //fの値をもとにメッセージを出す
        scan.close();
        //エラー防止
    }
    
    public static double calcFahrenheit(double c){
        double calcFahrenheit = (c * 9 / 5) + 32;
        //摂氏を華氏に変換
        return calcFahrenheit;
        //16行目の式へ値を返す
    }
    
    public static void printMessage(double c, double f){
        if(f<50.0){
            System.out.println("cold");
            //摂氏50F未満でcoldを出力
        }else if (f <= 70.0){
            System.out.println("cool");
            //摂氏50～70F未満でcoolを出力
        }else if(f <= 90.0){
            System.out.println("warm");
            //摂氏70~90F未満でwarmを出力
        }else{
            System.out.println("hot");
            //摂氏90F以上でhotを出力
        }
    }
}
