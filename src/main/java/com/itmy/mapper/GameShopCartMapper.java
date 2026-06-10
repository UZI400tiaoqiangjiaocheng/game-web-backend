package com.itmy.mapper;

import com.itmy.pojo.entity.GameShopCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameShopCartMapper {
    //将游戏添加到购物车中
    @Insert("insert into gameshopcart (buy_user_id,game_name,game_price,game_cover,game_id,create_time) values (#{buyUserId},#{gameName},#{gamePrice},#{gameCover},#{gameId},#{createTime})")
    void insert(GameShopCart gameShopCart);

    //根据用户id查询购物车中的游戏
    @Select("select * from gameshopcart where buy_user_id = #{currentUserId}")
    List<GameShopCart> selectByBuyUserId(Integer currentUserId);

    //根据id删除购物车中的游戏
    void deleteBatchIds(List<Integer> ids);
}
