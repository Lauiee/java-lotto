package lotto.util;

import java.util.function.Supplier;

public class InputRetry {

    public static <T> T retry(Supplier<T> inputMethod){
        try{
            return inputMethod.get();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());;
            return retry(inputMethod);
        }
    }
}
