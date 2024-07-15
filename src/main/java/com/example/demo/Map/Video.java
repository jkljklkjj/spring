package com.example.demo.Map;

public class Video {
    private String videoUrl; // 视频地址
    private String coverUrl; // 视频封面链接
    private String title; // 视频标题

    // 构造函数
    public Video(String videoUrl, String coverUrl, String title) {
        this.videoUrl = videoUrl;
        this.coverUrl = coverUrl;
        this.title = title;
    }

    // Getter 和 Setter
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}