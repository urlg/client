package com.demo.comm.mapper;

import com.demo.comm.entity.Common;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("commonManager")
@SuppressWarnings("all")
public interface CommonManager {

   /**查询spdb.common表中所有记录**/
   public ArrayList<Common> getAllCommonInfo();

   /**向Common表中增加一条数据**/
   public int insertCommon(
           String commonCode,
           String checkField,
           String isNecessary
   );
}
