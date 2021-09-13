package site.waconde.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(schema = "study", keepGlobalPrefix = false)
public class PermissionInfo implements Serializable {
    private static final long serialVersionUID = - 2640311866203024958L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
}
