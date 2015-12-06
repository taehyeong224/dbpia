package koreatech.cse.repository;


import koreatech.cse.domain.Authority;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityMapper {
    @Insert("INSERT INTO wsc.authorities (userId, ROLE) VALUES (#{userId}, #{role})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(Authority authority);

    @Update("UPDATE wsc.authorities SET userId = #{userId}, ROLE = #{role} WHERE ID = #{id}")
    void update(Authority authority);

    @Select("SELECT * FROM wsc.authorities WHERE userId = #{userId}")
    List<Authority> findByUserId(@Param("userId") int userId);

    @Delete("DELETE FROM wsc.authorities WHERE ID = #{id}")
    void delete(Authority authority);

    @Select("SELECT count(*) FROM wsc.authorities")
    int count();

}