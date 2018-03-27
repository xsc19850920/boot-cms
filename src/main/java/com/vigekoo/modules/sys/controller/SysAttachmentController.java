package com.vigekoo.modules.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aliyun.oss.OSSClient;
import com.vigekoo.common.Constant;
import com.vigekoo.common.annotation.SysLog;
import com.vigekoo.common.exception.AppException;
import com.vigekoo.common.utils.AliyunOSSClientUtil;
import com.vigekoo.common.utils.AttachmentUtils;
import com.vigekoo.common.utils.FileUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.entity.SysAttachment;
import com.vigekoo.modules.sys.service.SysAttachmentService;

/**
 * @author sxia
 * @Description: TODO(附件)
 * @date 2017-7-10 17:07
 */
@RestController
@RequestMapping("/sys/attachment")
public class SysAttachmentController extends AbstractController {

	@Autowired
	private SysAttachmentService sysAttachmentService;

	/**
	 * 所有附件列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:attachment:list")
	public Result list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysAttachment> configList = sysAttachmentService.queryList(query);
		int total = sysAttachmentService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(configList, total, query.getLimit(), query.getPage());
		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 附件信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:attachment:info")
	public Result info(@PathVariable("id") Long id) {
		SysAttachment attachment = sysAttachmentService.queryObject(id);
		return Result.ok().put("attachment", attachment);
	}

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
//	@RequiresPermissions("sys:attachment:upload")
	public Result upload(HttpServletRequest request) {

		String webpath = StringUtils.EMPTY;
		try {
			List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
			if (files.isEmpty()) {
				throw new AppException("上传文件不能为空");
			}

			for (MultipartFile file : files) {
				String suffix = FileUtils.getSuffix(file.getOriginalFilename());

				String newFileName = AttachmentUtils.newFileName(suffix);
				File newFile = new File(newFileName);
				file.transferTo(newFile);
				newFile.deleteOnExit();
				logger.debug(String.format("富文本上传文件物理路径 ： %s", newFile.getAbsolutePath()));
				// 初始化OSSClient
//				OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
//				AliyunOSSClientUtil.uploadObject2OSS(ossClient, newFile, Constant.BACKET_NAME, Constant.FOLDER);
//				webpath = AliyunOSSClientUtil.getUrl(Constant.FOLDER + newFile.getName());
				webpath = "http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D";
				logger.debug(String.format("富文本上传文件路径 ： %s", webpath));

				SysAttachment sysAttachment = new SysAttachment();
				sysAttachment.setId(IdGenUtil.get().nextId());
				sysAttachment.setUserId(getUserId());
				sysAttachment.setTitle(file.getOriginalFilename());
				sysAttachment.setPath(webpath);
				sysAttachment.setSuffix(suffix);
				sysAttachment.setMimeType(file.getContentType());
				sysAttachment.setCreateTime(new Date());
				sysAttachmentService.save(sysAttachment);
			}

			return Result.ok().put("src", webpath);
		} catch (IOException e) {
			throw new AppException("系统异常");
		}
	}

	/**
	 * 下载文件
	 * @throws Throwable 
	 */
	@RequestMapping("/download/{id}")
	@RequiresPermissions("sys:attachment:download")
	public void download(@PathVariable("id") Long id, HttpServletResponse response) {
		SysAttachment attachment = sysAttachmentService.queryObject(id);
		if (attachment == null) {
			throw new AppException("文件不存在");
		}

		String path = /*FileUtils.getTempPath() +*/ attachment.getPath();
		FileUtils.download(path, attachment.getTitle(), response);
	}

	/**
	 * 删除配置
	 */
	@SysLog("删除配置")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:attachment:delete")
	public Result delete(@RequestBody Long[] ids/*@RequestParam(value = "key") String key*/) {
		sysAttachmentService.deleteBatch(ids);
		return Result.ok();
//		if (!key.isEmpty()) {
//			// 初始化OSSClient
//			OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
//			AliyunOSSClientUtil.deleteFile(ossClient, Constant.BACKET_NAME, Constant.FOLDER, key);
//			return Result.ok();
//		} else {
//			return Result.error();
//		}
	}

}
