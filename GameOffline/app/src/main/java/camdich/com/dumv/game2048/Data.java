package camdich.com.dumv.game2048;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.widget.TextView;

//import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Data {
    private boolean khoa=true,khoaback=true;

    private static Data data;
    private int soO = 14,soDiem=400,Point,brack=0;
    public void khoiTao(){
    khoa=true;
    soO=14;
    soDiem=0;
    this.Point=0;
    brack=0;
}
    public int getSoDiem(setDataa dataa) {
        if(Point>=2048){
            dataa.win();
        }

        return soDiem;
    }

    public int getPoint() {
        this.Point=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrSo[i][j] == 0) {
                    soO++;
                }
                if(this.Point<arrSo[i][j]){
                    this.Point=arrSo[i][j];
                }
            }
        }
        return Point;
    }

    private int[] mangMau;
    private int[][] arrSo = new int[4][4];
    private ArrayList<Integer> arr = new ArrayList<>();
    private Random r = new Random();
/////
    private int[][] mangLui= new int[4][4];
    private boolean khoaCHuyenDoi=true;
    private void setMangLui(){
        if (!khoaCHuyenDoi) {
            return;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                mangLui[i][j]=arrSo[i][j];
            }
        }
    }
    public void back(){
        if(soDiem>=200&&khoaback){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arrSo[i][j]=mangLui[i][j];
            }
        }
content();
        soDiem=soDiem-200;}else {
}
    }

    public void setKhoaback(boolean khoaback) {
        this.khoaback = khoaback;
    }

    ////
    static {
        data = new Data();
    }

    public static Data getInstance() {
        return data;
    }

    public void getMau(Context context) {
        khoiTao();
        TypedArray ta = context.getResources().obtainTypedArray(R.array.color);
        mangMau = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            mangMau[i] = ta.getColor(i, 0);
        }
        ta.recycle();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrSo[i][j] = 0;
            }
        }
    }

    public int setText(int so) {
        if (so != 0) {
            int a = (int) (Math.log(so) / Math.log(2));
            a = a - 1;
            return mangMau[a];
        } else {
            return Color.WHITE;
        }
    }

    public void content() {
        arr.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr.add(arrSo[i][j]);
            }
        }
    }

    private void taoSo() {
        if(!khoa){
            return;
        }
        soO=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrSo[i][j] == 0) {
                    soO++;
                }

            }
        }
        int so = 2;
        if (soO == 1) {
            so = 1;
        } else if (soO == 0) {
            so = 0;
        } else {
            so = 1 + r.nextInt(2);
        }
        while (so != 0) {
            int x = r.nextInt(4), y = r.nextInt(4);
            if (arrSo[x][y] == 0) {
                int k = r.nextInt(46) + 10;
                if (k % 10 == 0) {
                    arrSo[x][y] = 4;
                    this.soDiem=this.soDiem+4;
                } else {
                    this.soDiem=this.soDiem+2;
                    arrSo[x][y] = 2;
                }
                so--;
            }
        }
        khoa=false;
    }

    public void intt() {
        taoSo();
        arr.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr.add(arrSo[i][j]);
            }
        }
    }

    public void trai() {
        soO = 0;
        setMangLui();
        khoaCHuyenDoi=false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = arrSo[i][j];
                if (h == 0) {

                    continue;
                } else {
                    int st = j + 1;
                    for (int k = st; k < 4; k++) {
                        int g = arrSo[i][k];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            arrSo[i][j] = 2 * h;
                            arrSo[i][k] = 0;
                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

for(int i=0;i<4;i++){
    for(int j=0;j<4;j++){
        int h=arrSo[i][j];
        if(h!=0){
            continue;
        }else {
            for(int k=j+1;k<4;k++){
                if(arrSo[i][k]==0){
                    continue;
                }else {
                    arrSo[i][j]=arrSo[i][k];
                    arrSo[i][k]=0;
                    khoa=true;
                    break;
                }
            }
        }

    }
}

        taoSo();
        content();
    }
    public void phai() {
        soO = 0;
        setMangLui();
        khoaCHuyenDoi=false;
        for (int i = 3; i >=0; i--) {
            for (int j = 3; j >=0; j--) {
                int h = arrSo[i][j];
                if (h == 0) {

                    continue;
                } else {
                    int st = j - 1;
                    for (int k = st; k >=0; k--) {
                        int g = arrSo[i][k];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            arrSo[i][j] = 2 * h;
                            arrSo[i][k] = 0;
                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            for(int j=3;j>=0;j--){
                int h=arrSo[i][j];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j-1;k>=0;k--){
                        if(arrSo[i][k]==0){
                            continue;
                        }else {
                            arrSo[i][j]=arrSo[i][k];
                            arrSo[i][k]=0; khoa=true;
                            break;
                        }
                    }
                }

            }
        }


        taoSo();
        content();
    }
    public void len() {
        soO = 0;

        setMangLui();
        khoaCHuyenDoi=false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = arrSo[j][i];
                if (h == 0) {

                    continue;
                } else {
                    int st = j + 1;
                    for (int k = st; k < 4; k++) {
                        int g = arrSo[k][i];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            arrSo[j][i] = 2 * h;
                            arrSo[k][i] = 0;
                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int h=arrSo[j][i];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j+1;k<4;k++){
                        if(arrSo[k][i]==0){
                            continue;
                        }else {
                            arrSo[j][i]=arrSo[k][i];
                            arrSo[k][i]=0; khoa=true;
                            break;
                        }
                    }
                }

            }
        }


        taoSo();
        content();
    }
    public void xuong() {
        soO = 0;
        setMangLui();
        khoaCHuyenDoi=false;
        for (int i = 3; i >=0; i--) {
            for (int j = 3; j >=0; j--) {
                int h = arrSo[j][i];
                if (h == 0) {

                    continue;
                } else {
                    int st = j - 1;
                    for (int k = st; k >=0; k--) {
                        int g = arrSo[k][i];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            arrSo[j][i] = 2 * h;
                            arrSo[k][i] = 0;
                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            for(int j=3;j>=0;j--){
                int h=arrSo[j][i];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j-1;k>=0;k--){
                        if(arrSo[k][i]==0){
                            continue;
                        }else {
                            arrSo[j][i]=arrSo[k][i];
                            arrSo[k][i]=0; khoa=true;
                            break;
                        }
                    }
                }

            }
        }

        taoSo();
        content();
    }
    public ArrayList<Integer> getArr() {

        return arr;
    }


    ///
    private boolean khoaChon=true;

    public void doiChoi(int a,int b){
        if(soDiem<300){
            return;
        }

        int x1 = 0,y1=0,x2=0,y2=0;
        for(int i=0;i<4;i++) {
            int c = a - 4 * i;
            if (c >= 0 && c < 4) {
                x1 = i;
                y1 = c;
            }
        }
        for(int i=0;i<4;i++){
            int c=b-4*i;
            if(c>=0&&c<4){
                x2=i;
                y2=c;
            }}
        soDiem=soDiem-300;
        int a1=arrSo[x1][y1];
        arrSo[x1][y1]=arrSo[x2][y2];
        arrSo[x2][y2]=a1;
        content();
        khoaChon=true;
    }
    public void setKhoaChon(boolean khoaChon) {
        this.khoaChon = khoaChon;
    }

    public boolean isKhoaChon() {
        if (soDiem<300){
            return false;
        }
        return khoaChon;
    }
    ///////
    public void chuyen(){
        if (soDiem>=100){
            boolean f=false;
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    int a=arrSo[i][j];
                    if(a==2){
                        arrSo[i][j]=4;
                        soDiem=soDiem+2;
                        f=true;
                    }
                }
            }
            if(f){
                content();
                soDiem=soDiem-100;
            }
        }
    }
}
