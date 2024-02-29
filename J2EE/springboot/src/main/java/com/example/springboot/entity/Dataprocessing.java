package com.example.springboot.entity;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author GRChen
 * @since 2023-06-08
 */
@Getter
@Setter
  @TableName("t_dataprocessing")
@ApiModel(value = "Dataprocessing对象", description = "")
public class Dataprocessing implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("教室ID")
      @TableId("rid")
      private Integer rid;

      @ApiModelProperty("地址")
      private String address;

      @ApiModelProperty("电能消耗量")
      private Integer electricalconsume;

      @ApiModelProperty("更新时间")
      private Date correcttime;

      @ApiModelProperty("日期差值")
      private String datadif;

      @ApiModelProperty("教室号")
      private String classnum;

      @ApiModelProperty("电脑设备数量")
      private Integer comnum;

      @ApiModelProperty("LED设备数量")
      private Integer lignum;

      @ApiModelProperty("电脑设备数量")
      private Integer fannum;

      @ApiModelProperty("空调设备数量")
      private Integer airnum;
}
