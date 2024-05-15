import java.util.Scanner;
//プログラミング演習Ⅱ　第六回の課題
//intの処理限界を超えた桁数を持つ数字同士の引き算を行うプログラム

public class port1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //コマンドライン引数から数字をscanに格納する

        final int DIGIT = 100;
        //[最大100桁]と問題文にあったため、100個の列を持つDIGITを生成

        int[] a = new int[DIGIT];
        int[] b = new int[DIGIT];
        int[] diff = new int[DIGIT+1];
        //DIGITと同じ列数をもつa,bを生成　答えを格納するdiffも生成

        String num = scan.next();
        //String形式としてscan内にある整数を代入
        int na = num.length();
        //numが何桁かをlengthで抽出
        for(int i = 0; i < na; i++){
            a[na-1-i] = (int)(num.charAt(i) - '0');
        }
        /*
        numの桁数分だけnumの数字を一文字ずつintに変換しaに代入していく
        以下の作業をbにおいても行う
        */

        num = scan.next();
        int nb = num.length();
        for(int i = 0; i < nb; i++){
            b[nb-1-i] = (int)(num.charAt(i) - '0');
        }
        
        int n = (na > nb ? na : nb);
        //naの方が多い場合はnaの値を、nbが多い場合はnbの値をnに代入
        int r = 0;
        
        for(int i = 0; i < n; i++){
            r = a[i] - b[i] - r;
            //rにa-bの答えを代入する
            diff[i] = r < 0 ? (r + 10):r;
            /*
            rが0未満だった場合はrに10を足した数値を、
            0を越えている場合はrのそのままの数値をdiffに代入
            */
            r = (r < 0) ? 1:0;
            //rの数値が0以下だった場合、次のループに持ち込むために1を足す
        }
        
        if(r == 1){
            diff[n] = 1;
            //ループ終了時点でrに1が残っていた場合、一番最後の桁に1を代入
            n++;
            //桁数を記すnの数字に1を足す
        }
        
        for(int i = n-1; i >= 0; i--){
            if(r > 0 || diff[i] > 0 || i==0){
                //rが0を越えているか、diffの値が0以上か、iが0である時に処理を続行
                r++;
                System.out.print(diff[i]);
                //答えを出力
            }
        }
        scan.close();
        //エラー落ちを避けるためにscanをcloseしておく
    }
}
