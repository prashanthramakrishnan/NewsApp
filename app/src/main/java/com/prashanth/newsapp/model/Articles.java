package com.prashanth.newsapp.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Articles {

    @Getter
    @Setter
    @SerializedName("source")
    private Source source;

    @Getter
    @Setter
    @SerializedName("author")
    private String author;

    @Getter
    @Setter
    @SerializedName("title")
    private String title;

    @Getter
    @Setter
    @SerializedName("description")
    private String description;

    @Getter
    @Setter
    @SerializedName("url")
    private String url;

    @Getter
    @Setter
    @SerializedName("urlToImage")
    private String urlToImage;

    @Getter
    @Setter
    @SerializedName("publishedAt")
    private String publishedAt;

    @Getter
    @Setter
    @SerializedName("content")
    private String content;

    @NotNull
    @Override
    public String toString() {
        return "Articles{" +
                "source=" + source +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
