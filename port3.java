/*
プログラミング演習Ⅱ　課題1-1より抜粋
提示された4つのデータファイルの中から、
コマンドライン入力に記載されたA,Bどちらかのボートが
どれだけの時間借りられたかを示すプログラム
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class port3 {
    public static void main (String[] args){
        try{
            //ファイルが見つからなかった場合エラーを返す関数
            Scanner file = new Scanner(new File(args[0]));
            //ファイル名はargs関数内に仕込まれている
            Scanner scan = new Scanner(System.in);
            //コマンドライン引数に記載された文字を引き出せる様にする
            
            char s = scan.next().charAt(0);
            //scanに記載された文字は1文字と確定しているためcharで格納
            int tm = 0;
            //借りた総時間を格納するtmを生成
            
            while(file.hasNext()){
                char b = file.next().charAt(0);
                //ボート名
                char io = file.next().charAt(0);
                //「借りた」をしめす"O"か、「返した」をしめす"I"が格納される
                int h = file.nextInt();
                //時
                int m = file.nextInt();
                //分
                if(b != s){
                    continue;
                    //ボート名が問題文で指定されたボートと違う場合処理をスキップ
                }
                switch(io){
                    case 'I':
                       tm += 60*h+m;
                       break;
                       //Iが必然と値が大きくなるため先に格納
                    case 'O':
                        tm -= 60*h+m;
                        break;
                        //IからOの値を引いて使用時間を割り出す
                }
            }
            if(tm>0){
            System.out.printf("%d:%02d\n",tm/60,tm%60);
            //正常に値が出た場合は出力
            }else{
                System.out.println("0:00");
                //無効な値が出た場合0を返す
            }
            scan.close();  
            file.close();
            //エラー対策
        } catch(FileNotFoundException e){
            System.out.println(e);
            //ファイルが見つからなかった場合eを出力
        }
      
    }
}
