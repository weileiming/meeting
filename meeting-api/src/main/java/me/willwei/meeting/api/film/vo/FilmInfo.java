package me.willwei.meeting.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * FilmInfo
 *
 * @author leiming
 * @date 2019-08-01
 */
@Data
public class FilmInfo implements Serializable {

    private String filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;

}
