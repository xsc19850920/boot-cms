package com.vigekoo.modules.info.service;

import com.vigekoo.modules.info.entity.InfoAudio;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(信息_音频)
 * @date 2018-03-11 14:18:11
 */
public interface InfoAudioService {
	
	InfoAudio queryObject(Long infoAudioId);
	
	List<InfoAudio> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InfoAudio infoAudio);
	
	void update(InfoAudio infoAudio);
	
	void delete(Long infoAudioId);
	
	void deleteBatch(Long[] infoAudioIds);

}
