import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Exekuzio garaian adierazteko anotazioa ez borratzeko
@Retention(RetentionPolicy.RUNTIME)
// Anotazioa atributuak klaseko atributuekin lotzeko
@Target(ElementType.FIELD)
public @interface HeaderMapping {
    String value();
}
