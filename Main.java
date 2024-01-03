import java.util.Arrays;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    String palabra = "JJOTTA";
    String[] args1 = new String[palabra.length()];
    args1 = stringPermutations(palabra);
    palabra = Arrays.toString(args1);
    System.out.println(palabra);
  }

  public static String[] stringPermutations(String s) {
    char[] c = s.toCharArray();
    
//CREAR UNA PLANTILLA DE 26 POSICIONES PARA INDICAR LA CANTIDAD DE       
//LETRAS DEL ALFABETO (INGLES) QUE TIENE LA PALABRA RECIBIDA
// 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
// A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    int[] ct = new int[26];

  //INFORMAR LA CANTIDAD DE CADA UNA DE LAS LETRAS QUE HAY EN LA PALABRA
    for(int i=0; i < c.length; i++) {
      ct[c[i]-'A']++;
    }

    ArrayList<char[]> al = solve(new char[c.length],0,ct);
    String[] st = new String[al.size()];
    for(int i=0; i<al.size();i++) {
      st[i] = new String(al.get(i));
    }
    
    return st;
  }

  public static ArrayList<char[]> solve(char[] curr, int ind, int[] ct){
    ArrayList<char[]> out = new ArrayList<char[]>();

    if(ind == curr.length){
      out.add(curr.clone());
      return out;
    }

    for(int i=0; i<ct.length; i++) {
      if(ct[i] > 0) {
        curr [ind] = (char)(i+'A');
        ct[i]--;
        ArrayList<char[]> al = solve(curr, ind+1,ct);
        out.addAll(al);
        ct[i]++;
      }
    }

    return out;
  }
}