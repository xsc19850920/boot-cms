package com.vigekoo.modules.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;
import com.vigekoo.modules.user.entity.User;
import com.vigekoo.modules.user.entity.UserAddress;
import com.vigekoo.modules.user.entity.UserBaby;
import com.vigekoo.modules.user.entity.UserDetail;
import com.vigekoo.modules.user.entity.UserOrder;
import com.vigekoo.modules.user.entity.UserStatistics;
import com.vigekoo.modules.user.service.UserAddressService;
import com.vigekoo.modules.user.service.UserBabyService;
import com.vigekoo.modules.user.service.UserDetailService;
import com.vigekoo.modules.user.service.UserOrderService;
import com.vigekoo.modules.user.service.UserService;
import com.vigekoo.modules.user.service.UserStatisticsService;

/**
 * @author sxia
 * @Description: TODO(用户)
 * @date 2018-03-10 14:16:18
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserStatisticsService userStatisticsService;
	
	@Autowired
	private UserAddressService userAddressService;
	
	@Autowired
	private UserOrderService userOrderService;
	
	@Autowired
	private UserBabyService userBabyService;
	
	@Autowired
	private UserDetailService userDetailService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<User> userList = userService.queryList(query);
		int total = userService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	@RequestMapping("/totalUser")
	public Result list(){

		int totalUser = userService.queryTotalUser();
		int totalUserToday = userService.queryTotalUserToday();
		
		return Result.ok().put("totalUser", totalUser).put("totalUserToday",totalUserToday);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("user:info")
	public Result info(@PathVariable("userId") Long userId){
		User user = userService.queryObject(userId);
		
		//init user statistics
		List<UserStatistics> userStatisticsList = userStatisticsService.queryListByUserId(String.valueOf(userId));
		
		//init user details
		UserDetail userDetail = userDetailService.queryObject(userId);
		
		//init user baby
		UserBaby userBaby = userBabyService.queryObject(userId);
		
		Map<String,Integer> userStatisticsMap = new HashMap<String, Integer>(); 
		for (UserStatistics userStatistics : userStatisticsList) {
			switch (userStatistics.getStatisticsKey()) {
			case 2:
				userStatisticsMap.put("points", userStatistics.getStatisticsValue());
				break;
			case 3:
				userStatisticsMap.put("article", userStatistics.getStatisticsValue());
				break;
			case 4:
				userStatisticsMap.put("music", userStatistics.getStatisticsValue());
				break;
			case 5:
				userStatisticsMap.put("exchange", userStatistics.getStatisticsValue());
				break;
			case 6:
				userStatisticsMap.put("forword", userStatistics.getStatisticsValue());
				break;
			}

		}
		//init user address 
		
		//查询列表数据
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		Query query = new Query(params);
		List<UserAddress> userAddressList = userAddressService.queryList(query);
		int totalAddress = userAddressService.queryTotal(query);
		PageUtils userAddressPageUtil = new PageUtils(userAddressList, totalAddress, query.getLimit(), query.getPage());
		
		
		List<UserOrder> userOrderList = userOrderService.queryList(query);
		int totalOrder = userOrderService.queryTotal(query);
		PageUtils userOrderPageUtil = new PageUtils(userOrderList, totalOrder, query.getLimit(), query.getPage());
		
		return Result.ok()
				.put("user", user)
				.put("userBaby",userBaby)
				.put("userDetail",userDetail)
				.put("userStatisticsMap",userStatisticsMap)
				.put("userAddressPageUtil",userAddressPageUtil)
				.put("userOrderPageUtil",userOrderPageUtil);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:save")
	public Result save(@RequestBody User user){
		userService.save(user);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:update")
	public Result update(@RequestBody User user){
		userService.update(user);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:delete")
	public Result delete(@RequestBody Long[] userIds){
		userService.deleteBatch(userIds);
		
		return Result.ok();
	}
	
}
