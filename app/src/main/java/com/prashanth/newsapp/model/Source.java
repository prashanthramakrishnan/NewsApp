package com.prashanth.newsapp.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Source {

    @Getter
    @Setter
    @SerializedName("id")
    private String id;

    @Getter
    @Setter
    @SerializedName("name")
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
