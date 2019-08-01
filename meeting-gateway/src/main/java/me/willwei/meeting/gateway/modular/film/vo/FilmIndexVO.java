package me.willwei.meeting.gateway.modular.film.vo;

import lombok.Data;

import java.util.List;

/**
 * FilmIndexVO
 *
 * @author leiming
 * @date 2019-08-01
 */
@Data
public class FilmIndexVO {

    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;

}
