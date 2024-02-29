package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2023-06-09
 */
@Getter
@Setter
  @TableName("t_project")
@ApiModel(value = "Project对象", description = "")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("任务id")
        @TableId("pid")
        private Integer pid;

      @ApiModelProperty("任务")
      private String project;

      @ApiModelProperty("任务地址")
      private String paddress;

      @ApiModelProperty("任务描述")
      private String description;

      @ApiModelProperty("任务发布时间")
      private LocalDateTime ptime;


}
