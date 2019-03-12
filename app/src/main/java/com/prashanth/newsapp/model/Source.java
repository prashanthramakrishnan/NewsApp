package com.prashanth.newsapp.model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Source {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @NotNull
    @Override
    public String toString() {
        return "Source{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
