package org.bobpark.core.model.common;

import lombok.Getter;
import lombok.ToString;

import org.springframework.util.Assert;

@ToString
@Getter
public class Id<C, V> {

    private final V value;
    private final Class<C> clazz;

    private Id(Class<C> clazz, V value) {

        Assert.isTrue(clazz != null, "clazz must be provided.");
        Assert.isTrue(value != null, "value must be provided.");

        this.value = value;
        this.clazz = clazz;
    }

    public static <C, V> Id<C, V> of(Class<C> clazz, V value) {
        return new Id<>(clazz, value);
    }
}
