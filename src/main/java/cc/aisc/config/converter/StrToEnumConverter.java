package cc.aisc.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * Created by sjf on 16-8-30.
 */
@Component
public class StrToEnumConverter implements ConverterFactory<String, Enum> {

    @Override
    @SuppressWarnings("unchecked")
    public <E extends Enum> Converter<String, E> getConverter(Class<E> targetType) {
        return new StringToTypeEnumConverter(targetType);
    }

    private final class StringToTypeEnumConverter<E extends Enum> implements Converter<String, E>{
        private final Class<E> enumType;

        StringToTypeEnumConverter(Class<E> enumType) {
            this.enumType = enumType;
        }
        @Override
        @SuppressWarnings("unchecked")
        public E convert(String source) {
            if (source.length() == 0) {
                return null;
            }
            return (E) Enum.valueOf(this.enumType, source.trim());
        }
    }
}
