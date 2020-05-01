public class Selection {

    public static void selection(int[] a) {
        int len = a.length;
        int i_min, min, tmp;
        for (int i = 0; i < len; i++) {
            i_min = i;
            min = a[i];
            for (int j = i+1 ; j < len ; j++) {
                if(min > a[j]){
                  min = a[j];
                  i_min = j;
                }
            }
            tmp = a[i];
            a[i] = a[i_min];
            a[i_min] = tmp;
        }
    }

}
