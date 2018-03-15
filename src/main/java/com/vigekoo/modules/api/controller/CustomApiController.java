package com.vigekoo.modules.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigekoo.common.Constant;
import com.vigekoo.common.exception.AppException;
import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.api.annotation.Login;
import com.vigekoo.modules.api.utils.JwtUtils;
import com.vigekoo.modules.sys.entity.SysUser;
import com.vigekoo.modules.sys.service.SysUserService;
import com.vigekoo.modules.user.entity.UserOrder;
import com.vigekoo.modules.user.service.UserOrderService;

/**
 * @author sxia
 * @Description: TODO()
 * @date 2017-9-27 14:49
 */
@RestController
@RequestMapping("/api")
public class CustomApiController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private SysUserService sysUserService;
    
    
    @Autowired
    private UserOrderService rserOrderService;
    
//    @Autowired
//    private SysUserTokenService sysUserTokenService;
    
    

    @GetMapping("/login")
    public Result login(String username, String password){
        //用户信息
        SysUser user = sysUserService.queryByUserName(username);

        //账号不存在
        if(user == null) {
            return Result.error("账号不存在");
        }

        //密码错误
        if(!user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return Result.error("密码不正确");
        }
        
        //账号锁定
  		if(Constant.UserStatus.DISABLE.getValue() == user.getStatus()){
  			return Result.error("账号已被锁定,请联系管理员");
  		}

  		//生成token，并保存到数据库
//  		Map<String, Object> result=sysUserTokenService.createToken(user.getId());
//  		Result r =Result.ok().put(result);
//        return r;
        
        
      //生成token
        String token = jwtUtils.generateToken(user.getId());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", user.getId());
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        Result r=Result.ok().put(map);
        return r;
    }

    @Login
    @GetMapping("/test")
    public Result test(){
        return Result.ok();
    }
    
   /**
    * 	快递单号 */
    @Login
    @PostMapping("/order/trackingNo/update")
    public Result test(@RequestParam("userOrderId") Long userOrderId,
    					@RequestParam("trackingNo") String trackingNo ,
    					HttpServletRequest request){
    	UserOrder userOrder = rserOrderService.queryObject( userOrderId);
    	if(userOrder == null){
    		throw new AppException("订单id错误.");
    	}
    	if(StringUtils.isNotEmpty(trackingNo)){
    		long currentTime = new Date().getTime();
    		userOrder.setModifyTime(currentTime);
    		userOrder.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
    		userOrder.setTrackingNo(trackingNo);
    		
    		return Result.ok();
    	}
    	return Result.error("快递单号不能为空");
    }
    
    /**
   	 *   订单状态（1兑换中 2已发货 3已收货）*/
    @Login
    @PostMapping("/order/stateType/update")
    public Result test(@RequestParam("userOrderId") Long userOrderId,  
    					@RequestParam("stateType") Integer stateType,
    					HttpServletRequest request){
    	UserOrder userOrder = rserOrderService.queryObject( userOrderId);
    	if(userOrder == null){
    		throw new AppException("订单id错误.");
    	}
    	int[] stateTypeArr = {1,2,3};
    	if(ArrayUtils.contains(stateTypeArr, stateType) ){
    		long currentTime = new Date().getTime();
    		userOrder.setModifyTime(currentTime);
    		userOrder.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
    		userOrder.setStateType(stateType);
    		return Result.ok();
    	}
    	return Result.error("订单状态错误.");
    }

}
