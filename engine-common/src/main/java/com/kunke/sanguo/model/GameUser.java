package com.kunke.sanguo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 游戏用户表
 * </p>
 *
 * @author mr.l
 * @since 2023-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_game_user")
@ApiModel(value="GameUser对象", description="游戏用户表")
public class GameUser implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "唯一标识")
    private String uid;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "真实姓名")
    private String trueName;

    @ApiModelProperty(value = "身份证号")
    private Integer idNumber;

    @ApiModelProperty(value = "注册时间")
    private Date registerTime;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "渠道id")
    private Integer channelId;

    @ApiModelProperty(value = "登录地址")
    private String loginLocation;

    @ApiModelProperty(value = "登录ip")
    private String loginIp;

    @ApiModelProperty(value = "所属帮会 0未加入帮会")
    private Integer groupId;


}
