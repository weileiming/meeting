package me.willwei.meeting.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * BannerVO
 *
 * @author leiming
 * @date 2019-08-01
 */
@Data
public class BannerVO implements Serializable {

    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;

}
