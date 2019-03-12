package com.prashanth.newsapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class TopHeadlinesResponse {

    @Getter
    @Setter
    @SerializedName("status")
    private String status;

    @Getter
    @Setter
    @SerializedName("totalResults")
    private int totalResults;

    @Getter
    @Setter
    @SerializedName("articles")
    private ArrayList<Articles> articles;

    @NotNull
    @Override
    public String toString() {
        return "TopHeadlinesResponse{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", headlineStructures=" + articles +
                '}';
    }
}
