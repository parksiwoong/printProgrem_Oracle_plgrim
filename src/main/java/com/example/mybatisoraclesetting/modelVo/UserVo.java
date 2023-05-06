package com.example.mybatisoraclesetting.modelVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserVo")
public class UserVo {
    private String name;
    private String age;
}
