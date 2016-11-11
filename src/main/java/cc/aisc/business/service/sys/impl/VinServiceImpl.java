package cc.aisc.business.service.sys.impl;

import cc.aisc.business.mapper.sys.WmiCvtMapper;
import cc.aisc.business.mapper.sys.WmiMapper;
import cc.aisc.business.model.sys.Vin;
import cc.aisc.business.model.sys.Wmi;
import cc.aisc.business.model.sys.WmiCvt;
import cc.aisc.business.service.sys.VinService;
import cc.aisc.commons.base.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sjf on 16-11-7.
 */
@Service
@Transactional
public class VinServiceImpl extends CommonService<Vin> implements VinService {
}
