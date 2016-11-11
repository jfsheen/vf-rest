package cc.aisc.business.service.sys.impl;

import cc.aisc.business.model.sys.VinHao;
import cc.aisc.business.service.sys.VinHaoService;
import cc.aisc.commons.base.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-11-9.
 */

@Service
@Transactional
public class VinHaoServiceImpl extends CommonService<VinHao> implements VinHaoService {
}
