package me.willwei.meeting.gateway.modular.film.vo;

import lombok.Data;

/**
 * FilmInfo
 *
 * @author leiming
 * @date 2019-08-01
 */
@Data
public class FilmInfo {

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
