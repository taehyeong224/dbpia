package koreatech.cse.repository;


import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.repository.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert("INSERT INTO wsc.users (NAME, EMAIL, PASSWORD, AGE) VALUES (#{name}, #{email}, #{password}, #{age})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(User user);

    @Update("UPDATE wsc.users SET `KEY` = #{key} WHERE ID = #{id}")
    void updateKey(@Param("key") String key, @Param("id") int id);

    @Update("UPDATE wsc.users SET NAME = #{name}, EMAIL = #{email}, PASSWORD = #{password}, AGE = #{age} WHERE ID = #{id}")
    void update(User user);

    @Select("SELECT * FROM wsc.users WHERE `key` = #{key}")
    User getKey(@Param("key") String key);

    @Select("SELECT * FROM wsc.users WHERE ID = #{id}")
    User findOne(@Param("id") int id);

    @Select("SELECT * FROM wsc.users WHERE EMAIL = #{email}")
    User findByEmail(@Param("email") String email);

    @Delete("DELETE FROM wsc.users WHERE ID = #{id}")
    void delete(@Param("id") int id);

    @SelectProvider(type = UserSqlProvider.class, method = "findAllByProvider")
    List<User> findByProvider(Searchable searchable);

    @Select("<script>"
            + "SELECT * FROM wsc.users"
            + "<if test='name != null'> WHERE NAME = #{name}</if>"
            + "<if test='name != null and email != null'> OR EMAIL = #{email}</if>"
            + "<if test='orderParam != null'>ORDER BY ${orderParam} DESC</if>"
            + "</script>")
    List<User> findByScript(Searchable searchable);

    @Select("SELECT count(*) FROM wsc.authorities")
    int count();

}