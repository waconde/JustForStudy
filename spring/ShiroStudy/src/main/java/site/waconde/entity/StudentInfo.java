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
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(keepGlobalPrefix = false, schema = "study")
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = - 716095365518006203L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private String pwd;
    private Integer age;
    private String classroom;
    private Integer grade;
    private Integer deleted;
}
