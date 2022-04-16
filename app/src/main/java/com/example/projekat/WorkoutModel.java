package com.example.projekat;

public class WorkoutModel {

    private int id;
    private String name;
    private String video;

    public WorkoutModel(int id, String name, String video) {
        this.id = id;
        this.name = name;
        this.video = video;
    }

    public WorkoutModel(String name, String video) {
        this.name = name;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
