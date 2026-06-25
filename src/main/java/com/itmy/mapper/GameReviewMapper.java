package com.itmy.mapper;

import com.itmy.pojo.entity.GameReview;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameReviewMapper {
    @Insert("insert into gamereview (user_id, game_id, user_name, review_type, review, create_time, update_time) values (#{userId}, #{gameId}, #{userName}, #{reviewType}, #{review}, #{createTime}, #{updateTime})")
    void insert(GameReview gameReview);

    @Select("select * from gamereview where game_id = #{gameId}")
    List<GameReview> selectByGameId(Integer gameId);

    @Update("update gamereview set review_type = #{reviewType}, review = #{review}, update_time = #{updateTime} where id = #{id}")
    void update(GameReview gameReview);

    @Delete("delete from gamereview where id = #{id}")
    void deleteById(Integer id);
}
