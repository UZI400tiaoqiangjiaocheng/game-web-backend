package com.itmy.mapper;

import com.itmy.pojo.vo.GameVo;
import com.itmy.pojo.vo.GameWareHostVo;
import com.itmy.service.GameWareHostService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface GameWareHostMapper {
    //根据游戏名称查询游戏
    List<GameWareHostVo> queryGame(String gameName);

    //删除游戏
    @Delete("delete from gamewarehouse where id = #{id}")
    void deleteGame(Integer id);

    //根据用户id查询用户游戏资产
    @Select("select g.game_price from gamewarehouse as gh join game as g on gh.game_id = g.id where gh.user_id = #{id}")
    List<Double> queryAssets(Integer id);
}
