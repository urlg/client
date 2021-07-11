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

   /**更新spdb.common表数据**/
   public  int updateCommonByCommonCode(Common common);

   /**通过common_code删除spdb.comm表中一条数据**/
   public int deleteCommonByCommonCode(Common common);

   /**使用MySQL的存储过程查询spdb.common表信息**/
  public ArrayList<Common> CommonInfoByCommonCode(Common common);
}
