$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/classes/room/video/list',
        datatype: "json",
        colModel: [			
            { label: '编号', name: 'classRoomVideoId', index: 'class_room_video_id', width: 50, key: true },
            /*<embed id="embid" wmode="direct" flashvars="vid=b00167x9o7q&amp;tpid=0&amp;showend=1&amp;showcfg=1&amp;searchbar=1&amp;pic=http://shp.qpic.cn/qqvideo_ori/0/b00167x9o7q_496_280/0&amp;skin=http://imgcache.qq.com/minivideo_v1/vd/res/skins/TencentPlayerMiniSkin.swf&amp;shownext=1&amp;list=2&amp;autoplay=0" quality="high" name="tenvideo_flash_player_1432016342747" bgcolor="#000000" width="280px" height="240px" align="middle" allowscriptaccess="always" allowfullscreen="true" type="application/x-shockwave-flash" pluginspage="http://get.adobe.com/cn/flashplayer/" src="http://player.youku.com/player.php/sid/XNzY3OTE5Njk2/v.swf">*/
            { label: '视频', name: 'fileSrc', index: 'file_src', width: 80 }, 			
            { label: '标题', name: 'title', index: 'title', width: 80 }, 			
			{ label: '发布时间', name: 'createTime', index: 'create_time', width: 80 }, 	
			{ label: '操作', name: 'opt',  width: 80},
			
//			{ label: '更新时间', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
//			{ label: '操作ip', name: 'operIp', index: 'oper_ip', width: 80 }, 			
//			{ label: '操作用户id', name: 'operUserId', index: 'oper_user_id', width: 80 }, 			
//			{ label: '删除标识', name: 'delFlag', index: 'del_flag', width: 80 }, 			
//			{ label: '会话课堂id', name: 'classRoomId', index: 'class_room_id', width: 80 }, 			
//			{ label: '音视频秒数', name: 'duration', index: 'duration', width: 80 }, 			
//			{ label: '音视频秒数文本 : 01:10:20', name: 'durationText', index: 'duration_text', width: 80 }, 			
//			{ label: '显示顺序', name: 'displayOrder', index: 'display_order', width: 80 }, 			
//			{ label: '查看次数', name: 'viewQty', index: 'view_qty', width: 80 }, 			
//			{ label: '状态类型 : 0未处_无效 1已处_有效', name: 'stateType', index: 'state_type', width: 80 }			
        ],
		viewrecords: true,
        //height: 385,
        rowNum: 10,
		rowList : [10,30,50],
		caption:"视频列表",
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        //multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        	var ids = $("#jqGrid").jqGrid('getDataIDs');
	        for (var i = 0; i < ids.length; i++) {
	          var id = ids[i];
	          var rowData = "";
	          var editBtn = "<a onclick='vm.getInfo(\""+ id +"\")'>编辑</a>  ";
	          var delBtn = "<a onclick='vm.del(\""+ id +"\")'>删除</a>  ";
	          if(hasPermission('classes:room:update')){
	        	  rowData += editBtn;
	          }
	          if(hasPermission('classes:room:info')){
	        	  rowData += delBtn;
	          }
	          $("#jqGrid").jqGrid('setRowData', ids[i], { opt: rowData});
	        }
	        
	        initClassRoomList();
        }
    });
    
    
    
    new AjaxUpload('#uploadVideo', {
        action: baseURL + '/sys/attachment/upload?X-Token=' + token,
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            layer.load(2);
          /*  if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }*/
        },
        onComplete : function(file, r){
            layer.closeAll('loading');
            if(r.code == 0){
            	vm.classRoomVideo.fileSrc = r.src;
            	$('#uploadVideo').attr("src",vm.classRoomVideo.fileSrc);
            }else{
                alert(r.msg);
            }
        }
    });
});

var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		title: null,
		classRoomVideo: {},
		classRoomList:[],
		q:{
            keyword: null
		},
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.classRoomVideo = {};
		},
		update: function (event) {
			var classRoomVideoId = getSelectedRow();
			if(classRoomVideoId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(classRoomVideoId)
		},
		saveOrUpdate: function (event) {
			var url = vm.classRoomVideo.classRoomVideoId == null ? "/classes/room/video/save" : "/classes/room/video/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.classRoomVideo),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (id) {
//			/var classRoomVideoIds = getSelectedRows();
			//if(classRoomVideoIds == null){
				//return ;
			//}
			var idsArr = [];
			idsArr.push(id);
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "/classes/room/video/delete",
                    contentType: "application/json",
				    //data: JSON.stringify(classRoomVideoIds),
				    data: JSON.stringify(idsArr),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(classRoomVideoId){
			vm.showList = false;
			$.get(baseURL + "/classes/room/video/info/"+classRoomVideoId, function(r){
                vm.classRoomVideo = r.classRoomVideo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				 postData:{'keyword': vm.q.keyword},
                page:page
            }).trigger("reloadGrid");
		}
	}
});


function initClassRoomList(){
	var url = baseURL + '/classes/room/list';
	var data = {			
			_search: false,
			limit: 10,
			page: 1,
			sidx: "",
			order: "asc"
	};
	$.ajax({
		type: "POST",
	    url: url,
        contentType: "application/json",
	    data: JSON.stringify(data),
	    success: function(r){
	      vm.classRoomList = r.page.list;
		}
	});
}