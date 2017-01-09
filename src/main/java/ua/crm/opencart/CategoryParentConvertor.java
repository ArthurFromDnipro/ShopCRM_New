package ua.crm.opencart;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Oleg on 04.10.2016.
 */
@Converter(autoApply = false)
public class CategoryParentConvertor implements AttributeConverter<Integer, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Integer i) {
        if (i == null) {
            return Integer.valueOf(0);
        } else {
            return i;
        }
    }

    @Override
    public Integer convertToEntityAttribute(Integer i) {
        if (i.intValue() == 0) {
            return null;
        } else {
            return i;
        }
    }
}