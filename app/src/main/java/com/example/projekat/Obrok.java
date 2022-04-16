package com.example.projekat;

public class Obrok {

    private int id;
    private String name;
    private String description;
    private  int image_resource_id;

    public Obrok(String name, String description, int image_resource_id) {
        this.name = name;
        this.description = description;
        this.image_resource_id = image_resource_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
