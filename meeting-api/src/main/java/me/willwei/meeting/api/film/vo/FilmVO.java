package me.willwei.meeting.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * FilmVO
 *
 * @author leiming
 * @date 2019-08-01
 */
@Data
public class FilmVO implements Serializable {

    private int filmNum;
    private List<FilmInfo> filmInfo;

}
