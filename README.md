 **项目说明：** 

首先这是renren-fast的个人定制版，要多谢renren-fast的项目开源，多谢项目开发者的努力。

renren-fast是一个轻量级的Java快速开发平台，具体查看：http://git.oschina.net/babaio/renren-fast

 **定制版具有如下特点：** 

友好的代码结构及注释，便于阅读及二次开发

实现前后端分离，通过token进行数据交互，前端再也不用关注后端技术

灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求

页面交互使用Vue2.x，极大的提高了开发效率

完善的代码生成机制，可在线生成entity、xml、dao、service、html、js代码，减少70%以上的开发任务

引入API模板，根据token作为登录令牌，极大的方便了APP接口开发

引入Hibernate Validator校验框架，轻松实现后端校验

引入路由机制，刷新页面会停留在当前页

修改了附件管理功能，增加内容管理功能，分类，专题，标签等等细节

	
更新用户订单信息
	登陆   --> http://101.132.171.95/bb/admin/api/login?username=om&password=admin
		结果:
			失败 
				情况1:{
					"msg": "账号不存在",
					"code": 500
				}
				情况2:{
					"msg": "账号已被锁定,请联系管理员",
					"code": 500
				}
			成功{
				"msg": "操作成功",
				"code": 0,
				"expire": 60,
				"userId": "2",
				"token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNTIxMzQ4MDE1LCJleHAiOjE1MjEzNDgwNzV9.yNjDut4mpx_933x4vwnoIc66YPyiigNVfQzIBbuiotIuEwXv89BKUFpfbbd2Ve8H9tvy7LARs9KhcIncEstLew"
			   }
	操作  -->http://101.132.171.95/bb/admin/api/order/update
	header : token:login 获得的字符串
			 Content-Type :application/json
	body : 	{
				"userOrderId":974930032147300352
				, "stateType":2
				,"trackingNo" :"1123"
			}
		 结果 
			成功 : {
					"msg": "操作成功",
					"code": 0
					}	
			失败 : {
				"msg": "订单信息错误.",
				"code": 500
			}
文章H5路径 ---> http://101.132.171.95/bb/admin/info/view?infoId=975037830059261952