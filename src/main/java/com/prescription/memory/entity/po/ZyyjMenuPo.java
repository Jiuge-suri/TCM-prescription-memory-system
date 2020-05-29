package com.prescription.memory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yinjie
 * @since 2020-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("zyyj_menu")
@ApiModel(value="ZyyjMenuPo对象", description="")
public class ZyyjMenuPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "导航名称")
    private String text;

    @ApiModelProperty(value = "导航状态")
    private String state;

    @ApiModelProperty(value = "导航图标")
    @TableField("iconCls")
    private String iconCls;

    @ApiModelProperty(value = "导航链接")
    private String url;

    @ApiModelProperty(value = "节点")
    private Integer nid;


}
