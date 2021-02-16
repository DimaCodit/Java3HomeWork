import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AppTest {

    @ParameterizedTest
    @MethodSource("dataForGetItemsAfter4")
    void getItemsAfter4(int[] a, int[] b) {
        Assertions.assertArrayEquals(a, App.getItemsAfter4(b));
    }

    @Test
    void getItemsAfter4ex() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    App.getItemsAfter4(new int[]{1});
                }
        );
    }

    public static List<Arguments> dataForGetItemsAfter4() {
        List<Arguments> paramsList = new ArrayList();
        paramsList.add(Arguments.arguments(new int[]{55,33,22}, new int[]{1,3,5,4,55,33,22}));
        paramsList.add(Arguments.arguments(new int[]{6,33,22}, new int[]{1,3,5,4,4,6,33,22}));
        paramsList.add(Arguments.arguments(new int[]{1}, new int[]{1,3,5,4,1}));
        paramsList.add(Arguments.arguments(new int[]{1}, new int[]{1,3,5,4,4,4,1}));
        paramsList.add(Arguments.arguments(new int[]{}, new int[]{4}));


        return paramsList;
    }


    @ParameterizedTest
    @MethodSource("dataForOnlyOnesAndFours")
    void onlyOnesAndFours(int[] array) {
        Assertions.assertTrue(App.onlyOnesAndFours(array));
    }

    public static List<Arguments> dataForOnlyOnesAndFours() {
        List<Arguments> paramsList = new ArrayList();
        paramsList.add(Arguments.arguments(new int[]{1,3,5,4,55,33,22}));
        paramsList.add(Arguments.arguments(new int[]{1,1,4,4,1,4,4}));
        paramsList.add(Arguments.arguments(new int[]{1,3,5,4,55,33,22}));
        paramsList.add(Arguments.arguments(new int[]{1,1,4,4,1,4,4}));
        return paramsList;
    }
}