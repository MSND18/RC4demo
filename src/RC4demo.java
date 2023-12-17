import java.util.Arrays;

public class RC4demo {
    public static void main(String[] args) {
        RC4 demo1 = new RC4();
        demo1.setT(Integer.parseInt("5C", 16),Integer.parseInt("37", 16));
        System.out.println("加密前: " + Arrays.toString(demo1.S));
        int[] encrypted = demo1.encrypt();
        System.out.println("加密后: " + Arrays.toString(encrypted));
    }
}

class RC4{
    public static final int TABLESIZE = 16;

    int[] S;
    int[] T = new int[TABLESIZE];
    public RC4(){
        S = new int[TABLESIZE];
        for(int i = 0; i < S.length; i++){
            S[i] = i;
        }
    }
    public void setT(int K1, int K0){
        for(int i = 0; i < T.length; i = i + 2){
            T[i] = K1;
        }
        for(int i = 1; i < T.length; i = i + 2){
            T[i] = K0;
        }
    }
    public void setT(int K2, int K1, int K0){
        for(int i = 0; i < T.length; i = i + 2){
            T[i] = K2;
        }
        for(int i = 1; i < T.length; i = i + 2){
            T[i] = K1;
        }
        for(int i = 2; i < T.length; i = i + 2){
            T[i] = K0;
        }
    }
    public int[] encrypt(){
        int j = 0;
        for(int i = 0; i < 16; i++){
            j = (j + S[i] + T[i]) % 16;
            swap(S, i, j);
        }
        return S;
    }
    private void swap(int[] S, int i, int j){
        int tmp = S[i];
        S[i] = S[j];
        S[j] = tmp;
    }



}