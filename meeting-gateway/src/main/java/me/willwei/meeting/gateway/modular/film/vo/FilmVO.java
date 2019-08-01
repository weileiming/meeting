package me.willwei.meeting.gateway.modular.film.vo;

import lombok.Data;

import java.util.List;

/**
 * FilmVO
 *
 * @author leiming
 * @date 2019-08-01
 */
@Data
public class FilmVO {

    private int filmNum;
    private List<FilmInfo> filmInfo;

}
