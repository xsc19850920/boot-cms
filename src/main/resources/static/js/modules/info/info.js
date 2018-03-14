$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/info/list',
        datatype: "json",
        colModel: [			
            { label: '编号', name: 'infoId', index: 'info_id', width: 50, key: true },
            { label : '封面图片', name : 'cloudUrl', width : 100, formatter : function(value, options, row) {
				 return '<img class="img-thumbnail" style="width: 60px;height: 60px;" src="' + value + '" >';
			}},
			{ label: '标题', name: 'title', index: 'title', width: 80 }, 			
			{ label: '分类', name: 'category.title', width: 80 }, 			
			{ label: '发布时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '相关', name: 'favoriteQty', width: 100, formatter: function(value, options, row){
				return '<p>收藏:'+value+'</p><p>阅读:'+row.viewQty+'</p><p>评论:'+row.commentQty+'</p><p>转载:'+row.shareQty+'</p>';
			} },
			{ label: '操作', name: 'allowDeleteFlag',  width: 80,formatter:function(value,options,row){
				
				  var rowData = "";
		          var editBtn = "<a onclick='vm.getInfo(\""+ row.infoId +"\")'>编辑</a>  ";
		          var delBtn = "<a onclick='vm.del(\""+ row.infoId +"\")'>删除</a>  ";
		          if(hasPermission('info:update')){
		        	  rowData += editBtn;
		          }
		          if(hasPermission('info:info') ){
		        	  rowData += delBtn;
		          }
		          return rowData;
			}},
			
//			{ label: '更新时间', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
//			{ label: '操作IP(保留0)', name: 'operIp', index: 'oper_ip', width: 80 }, 			
//			{ label: '操作用户ID', name: 'operUserId', index: 'oper_user_id', width: 80 }, 			
//			{ label: '删除标识', name: 'delFlag', index: 'del_flag', width: 80 }, 			
//			{ label: '作者', name: 'author', index: 'author', width: 80 }, 			
//			{ label: '简介', name: 'intro', index: 'intro', width: 80 }, 			
//			{ label: '图片路径', name: 'cloudUrl', index: 'cloud_url', width: 80 }, 			
//			{ label: '置顶标识', name: 'flagTop', index: 'flag_top', width: 80 }, 			
//			{ label: '查看次数', name: 'viewQty', index: 'view_qty', width: 80 }, 			
//			{ label: '收藏次数', name: 'favoriteQty', index: 'favorite_qty', width: 80 }, 			
//			{ label: '评论次数', name: 'commentQty', index: 'comment_qty', width: 80 }, 			
//			{ label: '分享次数', name: 'shareQty', index: 'share_qty', width: 80 }, 			
//			{ label: '状态类型 : 0未处_无效 1已处_有效', name: 'stateType', index: 'state_type', width: 80 }			
        ],
		viewrecords: true,
        height: 'auto',
        rowNum: 10,
		rowList : [10,30,50],
		caption:"文章列表",
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
        }
    });
    
    initCategoryList();
    
    new AjaxUpload('#uploadImg', {
        action: baseURL + '/sys/attachment/upload?X-Token=' + token,
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            layer.load(2);
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            layer.closeAll('loading');
            if(r.code == 0){
            	vm.info.cloudUrl = r.src;
            	$('#uploadImg').attr("src",vm.info.cloudUrl);
            }else{
                alert(r.msg);
            }
        }
    });
    
    $('.summernote').summernote({
    	lang : 'zh-CN',
    	callbacks: { // 覆写掉自带的上传文件函数
	        onImageUpload: function(files, editor, $editable) {
	        	var formData = new FormData();
	            formData.append("file", files[0]);
	            $.ajax({
	                data: formData,  
	                type: "POST",  
	                url: baseURL+ "/sys/attachment/upload",
	                cache: false,  
	                contentType: false,  
	                processData: false,  
	                success: function(image) {  
	                    $('.summernote').summernote('editor.insertImage',image.src);  
	                },  
	                error: function() {  
	                	 alert("插入失败");
	                }  
	            })
	        }
    	}
    });
});

var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		title: null,
		info: {},
		q:{
            keyword: null
		},
		categoryList:[],
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.info = {};
			$('.summernote').summernote('code','');
		},
		update: function (event) {
			var infoId = getSelectedRow();
			if(infoId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(infoId)
		},
		saveOrUpdate: function (event) {
			vm.info.detail = escape($('.summernote').summernote('code'));
			var url = vm.info.infoId == null ? "/info/save" : "/info/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.info)/*.replace(/\"/g,"\\\"").replace(/\'/g,"\\'")*/,
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
			//var infoIds = getSelectedRows();
			//if(infoIds == null){
				//return ;
			//}
			var idsArr = [];
			idsArr.push(id);
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "/info/delete",
                    contentType: "application/json",
				    //data: JSON.stringify(infoIds),
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
		getInfo: function(infoId){
			vm.showList = false;
			$.get(baseURL + "/info/info/"+infoId, function(r){
                vm.info = r.info;
                $('.summernote').summernote('code',unescape(r.info.detail));
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


function initCategoryList(){
	var url = baseURL + '/category/list';
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
	      vm.categoryList = r.page.list;
		}
	});
}
