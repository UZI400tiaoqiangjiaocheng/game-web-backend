package com.itmy.mapper;

import com.itmy.pojo.dto.GameQueryParam;
import com.itmy.pojo.entity.Game;
import com.itmy.pojo.vo.GameVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameMapper {
    //插入游戏
    void insert(Game game);

    //分页查询游戏
    List<GameVo> list(GameQueryParam gameQueryParam);

    //通过id查询游戏详情
    @Select("select id ,user_id , game_name, game_year, game_type, game_size, game_price, game_description, game_cover, game_download_link, game_extract_code from game where id = #{gameId}")
    GameVo selectGameById(Integer gameId);
}
