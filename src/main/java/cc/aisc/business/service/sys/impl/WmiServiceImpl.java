package cc.aisc.business.service.sys.impl;

import cc.aisc.business.mapper.sys.WmiCvtMapper;
import cc.aisc.business.mapper.sys.WmiMapper;
import cc.aisc.business.model.sys.Wmi;
import cc.aisc.business.model.sys.WmiCvt;
import cc.aisc.business.service.sys.WmiService;
import cc.aisc.commons.base.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sjf on 16-11-9.
 */

@Service
@Transactional
public class WmiServiceImpl extends CommonService<Wmi> implements WmiService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VinServiceImpl.class);

    private final WmiMapper wmiMapper;
    private final WmiCvtMapper wmiCvtMapper;

    @Autowired
    public WmiServiceImpl(WmiMapper wmiMapper, WmiCvtMapper wmiCvtMapper) {
        this.wmiMapper = wmiMapper;
        this.wmiCvtMapper = wmiCvtMapper;
    }

    public void combine() {
        try {
            HashMap<String, Object> p = new HashMap<>();
            p.put("vehType","乘用车");
            @SuppressWarnings("unchecked")
            List<WmiCvt> wcs = (List<WmiCvt>)wmiCvtMapper.selectValuedBySelective(p);
            for (WmiCvt wc : wcs){
                HashMap<String, Object> p1 = new HashMap<>();
                p1.put("wmi", wc.getWmi());
                @SuppressWarnings("unchecked")
                List<Wmi> ws = (List<Wmi>)wmiMapper.selectValuedBySelective(p1);
                if (ws == null || ws.size() == 0){
                    Wmi w = new Wmi();
                    w.setWmi(wc.getWmi());
                    w.setCoNam(wc.getComName());
                    w.setDs((short)0);
                    w.setTs(new Date().getTime());
                    wmiMapper.insert(w);
                }
            }

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
