public class Main {


    public static void main(String[] args) {
        int[] arr = {5,2,4,6,1,3,2,6};
        System.out.println("Начальная последовательность чисел " + toStringPrint(arr));
        arr = sort(arr);
        System.out.println("Итоговая последовательность чисел " + toStringPrint(arr));
    }

    public static int[] sort(int[] arr) {
        if (arr.length != 1){
            int middle = arr.length / 2;

            int[] beforeMiddle = new int[middle];
            System.arraycopy(arr, 0, beforeMiddle, 0, middle);

            int[] afterMiddle = new int[arr.length - middle];
            System.arraycopy(arr, middle, afterMiddle, 0, arr.length - middle);

            beforeMiddle = sort(beforeMiddle);
            afterMiddle = sort(afterMiddle);

            arr = merge(beforeMiddle, afterMiddle);
            return arr;
        }
        else return arr;
    }

    public static int[] merge(int[] beforeMiddle, int[] afterMiddle) {
        int[] result = new int[beforeMiddle.length + afterMiddle.length];
        int val1 = 0, val2 = 0;

        for(int i = 0; i < result.length; i++){
            if(val1 == beforeMiddle.length){
                result[i] = afterMiddle[val2];
                val2++;
            }
            else if(val2 == afterMiddle.length){
                result[i] = beforeMiddle[val1];
                val1++;
            }
            else if(beforeMiddle[val1] > afterMiddle[val2]){
                result[i] = afterMiddle[val2];
                val2++;
            }
            else {
                result[i] = beforeMiddle[val1];
                val1++;
            }
        }
        return result;
    }

    private static String toStringPrint(int[] vals){
        String s = "";
        for(int i : vals){
            s += (i + " ");
        }
        return s;
    }
}
