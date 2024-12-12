package org.yearup.models;

public class Elf {
    private int elfId;
    private String name;
    private String imageUrl;
    private int elfRank;
    private int roleId;

    public Elf() {}

    public Elf(int elfId, String name, String imageUrl, int elfRank, int roleId) {
        this.elfId = elfId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.elfRank = elfRank;
        this.roleId = roleId;
    }

    public int getElfId() {
        return elfId;
    }

    public void setElfId(int elfId) {
        this.elfId = elfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getElfRank() {
        return elfRank;
    }

    public void setElfRank(int elfRank) {
        this.elfRank = elfRank;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
