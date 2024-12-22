package lab8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация @DataProcessor будет доступна в процессе выполнения программы
@Retention(RetentionPolicy.RUNTIME) // Указывает, что аннотация будет доступна во время выполнения
@Target(ElementType.METHOD) // Указывает, что аннотация применяется к методам
public @interface DataProcessor {
    // Описание аннотации (опционально)
    String description() default "Data processing method";
}
