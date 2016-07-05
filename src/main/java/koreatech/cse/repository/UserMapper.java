package koreatech.cse.repository;

import java.util.List;
import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.repository.provider.UserSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Insert(value={"INSERT INTO USERS (NAME, EMAIL, PASSWORD, AGE) VALUES (#{name}, #{email}, #{password}, #{age})"})
    @SelectKey(statement={"SELECT LAST_INSERT_ID()"}, keyProperty="id", before=false, resultType=int.class)
    public void insert(User var1);

    @Update(value={"UPDATE USERS SET `KEY` = #{key} WHERE ID = #{id}"})
    public void updateKey(@Param(value="key") String var1, @Param(value="id") int var2);

    @Update(value={"UPDATE USERS SET NAME = #{name}, EMAIL = #{email}, PASSWORD = #{password}, AGE = #{age} WHERE ID = #{id}"})
    public void update(User var1);

    @Select(value={"SELECT * FROM USERS WHERE `key` = #{key}"})
    public User getKey(@Param(value="key") String var1);

    @Select(value={"SELECT * FROM USERS WHERE ID = #{id}"})
    public User findOne(@Param(value="id") int var1);

    @Select(value={"SELECT * FROM USERS WHERE EMAIL = #{email}"})
    public User findByEmail(@Param(value="email") String var1);

    @Delete(value={"DELETE FROM USERS WHERE ID = #{id}"})
    public void delete(@Param(value="id") int var1);

    @SelectProvider(type=UserSqlProvider.class, method="findAllByProvider")
    public List<User> findByProvider(Searchable var1);

    @Select(value={"<script>SELECT * FROM USERS<if test='name != null'> WHERE NAME = #{name}</if><if test='name != null and email != null'> OR EMAIL = #{email}</if><if test='orderParam != null'>ORDER BY ${orderParam} DESC</if></script>"})
    public List<User> findByScript(Searchable var1);

    @Select(value={"SELECT count(*) FROM AUTHORITIES"})
    public int count();
}