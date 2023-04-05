package com.example.song_info.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {
    private Integer id;
    @NotBlank(message = "{songName.notBlank}")
    @Size(max = 800, message = "{songName.size}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{songName.pattern}")
    private String songName;
    @NotBlank(message = "{singer.notBlank}")
    @Size(max = 300, message = "{singer.size}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{singer.pattern}")
    private String singer;
    @NotBlank(message = "{category.notBlank}")
    @Size(max = 1000, message = "{category.size}")
    @Pattern(regexp = "^[^@;.=+\\-]+$", message = "{category.pattern}")
    private String category;

    public SongDTO() {
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
