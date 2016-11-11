package cc.aisc.config.converter;

import cc.aisc.commons.type.TypeEnums;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjf on 16-8-29.
 *
 */
@Deprecated
public class ValuedEnumConverter implements ConditionalGenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<>();
        pairs.add(new ConvertiblePair(Integer.class, TypeEnums.class));
        pairs.add(new ConvertiblePair(String.class, TypeEnums.class));
        return pairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        int i = -1;
        if (sourceType.getType() == Integer.class) {
            i = (Integer)source;
        } else if (sourceType.getType() == String.class) {
            i = Integer.parseInt((String)source);
        }
        return TypeEnums.fromInt(i);
    }

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType != null && targetType != null;
    }
}
