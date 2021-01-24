import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class ArrayProcessorTest {

    @ParameterizedTest
    @MethodSource("differentIntArrays")
    void shouldReturnArrayAfterLastFour(int [] expected, int [] incoming){
        Assertions.assertArrayEquals(expected,ArrayProcessor.cutLastFour(incoming));
    }

    private static Stream<Arguments> differentIntArrays(){
        return Stream.of(
                Arguments.arguments(new int[]{3,2}, new int[]{5,4,3,2}),
                Arguments.arguments(new int[]{5,5}, new int[]{2,4,3,3,4,5,5}),
                Arguments.arguments(new int[]{}, new int[]{5,4,3,2,4})
        );
    }

    @Test
    void shouldThrowRuntimeExceptionIfNoFour(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            int[] expected = ArrayProcessor.cutLastFour(new int[]{0, 1, 2});
        });
    }


    @ParameterizedTest
    @MethodSource("oneAndFourIntArrays")
    void shouldReturnTrueIfArrayHasOneOrFour(int [] incoming){
        Assertions.assertTrue(ArrayProcessor.findOneOrFour(incoming));
    }

    private static Stream<Arguments> oneAndFourIntArrays(){
        return Stream.of(
                Arguments.arguments(new int[]{5,5,1,2}),
                Arguments.arguments(new int[]{5,4,3,2,4}),
                Arguments.arguments(new int[]{5,4,3,2,4,1})
        );
    }
    @ParameterizedTest
    @MethodSource("noOneAndFourIntArrays")
    void shouldReturnFalseIfArrayHasOneOrFour(int [] incoming){
        Assertions.assertFalse(ArrayProcessor.findOneOrFour(incoming));
    }
    private static Stream<Arguments> noOneAndFourIntArrays(){
        return Stream.of(
                Arguments.arguments(new int[]{5,5,3,2}),
                Arguments.arguments(new int[]{})
        );
    }

}
