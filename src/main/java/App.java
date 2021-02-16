import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] res = getItemsAfter4(new int[]{1,3,5,4,4, 4,55,33,22});
        for (int i:res) {
            System.out.println(i);
        }

        System.out.println(onlyOnesAndFours(new int[]{1,1,1,4,4, 4,1} ));

    }
    // Получаем элементы находящиеся после последней четверки
    public static int[] getItemsAfter4(int[] array){
        int lastIndex = array.length -1;
        for(int i = lastIndex; i>=0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i+1, lastIndex+1);
            }
        }

        throw new RuntimeException("no element 4 in array");
    }
    // проверяем на последовательность 1 и 4
    public static boolean onlyOnesAndFours(int[] array) {
        for (int i : array) {
            if (i != 1 && i !=4) {
                return false;
            }
        }
        return true;
    }

}
