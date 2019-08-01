package me.willwei.meeting.api.film;

import me.willwei.meeting.api.film.vo.BannerVO;
import me.willwei.meeting.api.film.vo.FilmInfo;
import me.willwei.meeting.api.film.vo.FilmVO;

import java.util.List;

/**
 * FilmServiceApi
 *
 * @author leiming
 * @date 2019-08-01
 */
public interface FilmServiceApi {

    /**
     * 获取banners
     *
     * @return
     */
    List<BannerVO> getBanners();

    /**
     * 获取热映影片
     *
     * @param isLimit
     * @param nums
     * @return
     */
    FilmVO getHotFilms(boolean isLimit, int nums);

    /**
     * 获取即将上映影片【受欢迎程度排序】
     *
     * @param isLimit
     * @param nums
     * @return
     */
    FilmVO getSoonFilms(boolean isLimit, int nums);

    /**
     * 获取票房排行榜
     *
     * @return
     */
    List<FilmInfo> getBoxRanking();

    /**
     * 获取人气排行榜
     *
     * @return
     */
    List<FilmInfo> getExpectRanking();

    /**
     * 获取Top100
     *
     * @return
     */
    List<FilmInfo> getTop();

}
