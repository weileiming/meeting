package me.willwei.meeting.film.modular.film.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.util.DateUtil;
import me.willwei.meeting.api.film.FilmServiceApi;
import me.willwei.meeting.api.film.vo.BannerVO;
import me.willwei.meeting.api.film.vo.FilmInfo;
import me.willwei.meeting.api.film.vo.FilmVO;
import me.willwei.meeting.film.common.persistence.dao.BannerTMapper;
import me.willwei.meeting.film.common.persistence.dao.FilmTMapper;
import me.willwei.meeting.film.common.persistence.model.BannerT;
import me.willwei.meeting.film.common.persistence.model.FilmT;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * DefaultFilmServiceImpl
 *
 * @author leiming
 * @date 2019-08-01
 */
@Component
@Service(version = "${film.service.version}")
public class DefaultFilmServiceImpl implements FilmServiceApi {

    private BannerTMapper bannerTMapper;
    private FilmTMapper filmTMapper;

    @Autowired
    public void setBannerTMapper(BannerTMapper bannerTMapper) {
        this.bannerTMapper = bannerTMapper;
    }

    @Autowired
    public void setFilmTMapper(FilmTMapper filmTMapper) {
        this.filmTMapper = filmTMapper;
    }

    @Override
    public List<BannerVO> getBanners() {
        ArrayList<BannerVO> result = new ArrayList<>();
        List<BannerT> banners = bannerTMapper.selectList(null);
        for (BannerT bannerT : banners) {
            BannerVO bannerVO = new BannerVO();
            bannerVO.setBannerId(bannerT.getUuid()+"");
            bannerVO.setBannerAddress(bannerT.getBannerAddress());
            bannerVO.setBannerUrl(bannerT.getBannerUrl());
            result.add(bannerVO);
        }
        return result;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos;

        // 正在热映影片的限制条件
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "1");
        // 判断是否是首页需要的内容
        if (isLimit) {
            // 如果是，则限制条数、显示内容为热映影片
            Page<FilmT> page = new Page<>(1, nums);
            List<FilmT> films = filmTMapper.selectPage(page, entityWrapper);
            // 组织filmInfos
            filmInfos = getFilmInfos(films);
            filmVO.setFilmNum(films.size());
            filmVO.setFilmInfo(filmInfos);
        } else {
            // 如果不是，则是列表页，同样需要限制内容为热映影片
        }
        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos;

        // 即将上映影片的限制条件
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "2");
        // 判断是否是首页需要的内容
        if (isLimit) {
            // 如果是，则限制条数、显示内容为热映影片
            Page<FilmT> page = new Page<>(1, nums);
            List<FilmT> films = filmTMapper.selectPage(page, entityWrapper);
            // 组织filmInfos
            filmInfos = getFilmInfos(films);
            filmVO.setFilmNum(films.size());
            filmVO.setFilmInfo(filmInfos);
        } else {
            // 如果不是，则是列表页，同样需要限制内容为热映影片
        }
        return filmVO;
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        // 条件->正在上映的，票房前10名
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "1");

        Page<FilmT> page = new Page<>(1, 10, "film_box_office");
        List<FilmT> films = filmTMapper.selectPage(page, entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(films);

        return filmInfos;
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        // 条件->即将上映的，预售前10名
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "2");

        Page<FilmT> page = new Page<>(1, 10, "film_preSaleNum");
        List<FilmT> films = filmTMapper.selectPage(page, entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(films);

        return filmInfos;
    }

    @Override
    public List<FilmInfo> getTop() {
        // 条件->正在上映的，评分前10名
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "1");

        Page<FilmT> page = new Page<>(1, 10, "film_score");
        List<FilmT> films = filmTMapper.selectPage(page, entityWrapper);

        List<FilmInfo> filmInfos = getFilmInfos(films);

        return filmInfos;
    }

    private List<FilmInfo> getFilmInfos(List<FilmT> films) {
        List<FilmInfo> filmInfos = new ArrayList<>();
        for (FilmT filmT : films) {
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setFilmId(filmT.getUuid()+"");
            filmInfo.setFilmName(filmT.getFilmName());
            filmInfo.setScore(filmT.getFilmScore());
            filmInfo.setImgAddress(filmT.getImgAddress());
            filmInfo.setFilmType(filmT.getFilmType());
            filmInfo.setFilmScore(filmT.getFilmScore());
            filmInfo.setExpectNum(filmT.getFilmPresalenum());
            filmInfo.setBoxNum(filmT.getFilmBoxOffice());
            filmInfo.setShowTime(DateUtil.getDay(filmT.getFilmTime()));
            filmInfos.add(filmInfo);
        }
        return filmInfos;
    }

}
