package me.willwei.meeting.film.modular.film.service;

import me.willwei.meeting.api.film.FilmServiceApi;
import me.willwei.meeting.api.film.vo.BannerVO;
import me.willwei.meeting.api.film.vo.FilmInfo;
import me.willwei.meeting.api.film.vo.FilmVO;
import me.willwei.meeting.film.common.persistence.dao.BannerTMapper;
import me.willwei.meeting.film.common.persistence.model.BannerT;
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

    @Autowired
    public void setBannerTMapper(BannerTMapper bannerTMapper) {
        this.bannerTMapper = bannerTMapper;
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
        return null;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {
        return null;
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        return null;
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        return null;
    }

    @Override
    public List<FilmInfo> getTop() {
        return null;
    }

}
