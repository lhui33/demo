package com.kunke.sanguo.common;

public class RedisKeyDeclare {
    // 玩家信息缓存 PLAYER_INFO#{userId}
    public static final String PLAYER_INFO = "PLAYER_INFO#{userId}";
    //游戏配置
    public static final String GAME_CONFIG = "gameConfig";
    //游戏服务器列表
    public static final String GAME_SERVICE_LIST = "gameServiceList";
    //用户宗门信息
    public static final String USER_DOOR_INFO = "UserDoorInfo#{userId}#{roleId}";
    //用户弟子信息
    public static final String USER_DISCIPLE_INFO = "UserDiscipleInfo#{userId}#{roleId}";
    //用户背包信息
    private static final String USER_BACKPACK_INFO = "UserBackPackInfo#{userId}#{roleId}";
    //用户技能缓存
    public static final String USER_SKILL_INFO = "UserSkillInfo#{userId}#{roleId}";

    // 获取玩家信息缓存key
    public static String getPlayerInfoKey(int userId) {
        return PLAYER_INFO.replace("{userId}", String.valueOf(userId));
    }
    public static String getUserDoorInfoKey(long userId,int roleId) {
        return USER_DOOR_INFO.replace("{userId}", String.valueOf(userId)).replace("{roleId}", String.valueOf(roleId));
    }
    public static String getUserDiscipleInfoKey(long userId, int roleId) {
        return USER_DISCIPLE_INFO.replace("{userId}", String.valueOf(userId)).replace("{roleId}", String.valueOf(roleId));
    }
    public static String getUserBackPackInfo(Long userId, Integer roleId) {
        return USER_BACKPACK_INFO.replace("{userId}", String.valueOf(userId)).replace("{roleId}", String.valueOf(roleId));
    }

    public static String getUserSkillInfoKey(Long userId, Integer roleId) {
        return USER_SKILL_INFO.replace("{userId}", String.valueOf(userId)).replace("{roleId}", String.valueOf(roleId));
    }


}
