package com.mapper;
import com.entity.Department;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper()
public interface DepartMentMapper {

    /****************************************************
     * 功能：根据id查询表department信息
     * @param id
     *      |备注：id为必须项
     * @return
     */

    @Select("SELECT * FROM department where id=#{id}")
    Department getDeptById(String id);

    /****************************************************
     * 功能：查询表department所有信息
     * @param
     *      |备注：
     * @return
     */
    @Results({
        @Result(property = "id",column="id")
    })
    @Select("SELECT * FROM department")
     List<Department> getDeptAll();

    /***************************************************
     * 功能：根据id更新数据
     * @return
     *     |出参 int
     *     |备注：出参表示更新的条数
     *     |{@link java.lang.Integer}
     */
    @Update("UPDATE  department SET department_name=#{department_name}  where id=#{id}")
    int updateDept(String department_name,int id);

    /****************************************************
     * 功能：向表department表插入一条数据
     * @param
     *       |入参：department_name
     *          |描述：职员姓名
     *          {@link java.lang.String}
     *
     *       |入参：department_age
     *          |描述：职员年龄
     *          {@link java.lang.Integer}
     *
     *       |入参：department_sex
     *          |描述：职员性别
     *          {@link java.lang.Character}
     *       |入参：department_address
     *          |描述：职员住址
     *          {@link java.lang.String}
     *
     *       |入参：department_id
     *          |描述：职员编号
     *          {@link java.lang.Integer}
     *
     *       |入参：department_occupation
     *          |描述：职员职业
     *          {@link java.lang.String}
     * @return
     *       |出参：
     *       |描述：当返回的数据为1时表明插入成功，否则插入失败
     *       |{@link java.lang.Integer}
     */
    @Options(useGeneratedKeys = true,keyColumn = "id")
    @Insert("Insert into department values(#{id},#{department_name},#{department_age},#{department_sex}, #{department_address}, #{department_occupation})")
    int insertDept(Department department);
}
