package com.example.mybatisoraclesetting.modelVo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("PcDataVo")
public class PcDataVo {
 int bno;
 String cpu;
 String mem;
 String ssd;
 String pcname;
 String hdd;
 private Date toDate;
 String chbox[];
}
