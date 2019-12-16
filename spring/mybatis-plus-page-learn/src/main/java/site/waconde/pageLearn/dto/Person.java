package site.waconde.pageLearn.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * description: Person <br>
 * date: 2019/12/13 11:35 <br>
 * author: side.wang <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
@TableName("person")
public class Person {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String name;
    private Integer age;
}
