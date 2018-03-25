package com.mqtest.com.redistest.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.mqtest.com.redistest.config.Daysconf;

@Service("service")
public class Dayservice {
	@Autowired
	private Daysconf days;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;
	//第一次时调用
	public void init(){
		Map<String, String> map = days.getMaps();
		Set<String> set = map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String date=it.next();
			setStr(date,map.get(date));
		}
	}
	
	 /**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public String getStr(String key){
    	if(valOpsStr.get(key)==null)
    		init();
        return valOpsStr.get(key);
    }

    /**
     * 设置Str缓存
     * @param key
     * @param val
     */
    private void setStr(String key, String val){
        valOpsStr.set(key,val);
    }
}
