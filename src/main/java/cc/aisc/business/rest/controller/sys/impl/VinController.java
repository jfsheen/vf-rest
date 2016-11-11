package cc.aisc.business.rest.controller.sys.impl;

import cc.aisc.business.model.sys.Vin;
import cc.aisc.business.model.sys.Wmi;
import cc.aisc.business.model.sys.WmiCvt;
import cc.aisc.business.mongo.vin.VinLogDoc;
import cc.aisc.business.mongo.vin.VinLogRepo;
import cc.aisc.business.rest.controller.sys.IVinController;
import cc.aisc.business.service.sys.VinService;
import cc.aisc.business.service.sys.WmiCvtService;
import cc.aisc.business.service.sys.WmiService;
import cc.aisc.commons.base.CommonController;
import cc.aisc.commons.response.Response;
import cc.aisc.commons.response.ResponseBulider;
import cc.aisc.commons.utils.VINUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by sjf on 16-11-7.
 */
@RestController
public class VinController extends CommonController<Vin> implements IVinController {

    private final VinService vinService;
    private final WmiService wmiService;
    private final WmiCvtService wmiCvtService;
    private final VinLogRepo vinLogRepo;

    @Autowired
    public VinController(VinService vinService, WmiService wmiService, WmiCvtService wmiCvtService, VinLogRepo vinLogRepo) {
        this.vinService = vinService;
        this.wmiService = wmiService;
        this.wmiCvtService = wmiCvtService;
        this.vinLogRepo = vinLogRepo;
    }


    @RequestMapping(value = PATH_SYS_VIN + "/{id}", method = RequestMethod.GET)
    public Response getById(@PathVariable("id") String id) throws Exception {
        return super.getById(id);
    }

    @RequestMapping(value = PATH_SYS_VIN + PATH_QUERY, method = RequestMethod.GET)
    public Response find(@RequestParam("qt") String qt,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return query(qt, page, size);
    }

    @RequestMapping(value = PATH_SYS_VIN, method = RequestMethod.GET)
    public Response listValid(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValid(page, size);
    }

    @RequestMapping(value = PATH_SYS_VIN + "/more", method = RequestMethod.POST)
    public Response listDetailed(@RequestBody HashMap<String, Object> o,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getDetailed(o, page, size);
    }

    @RequestMapping(value = PATH_SYS_VIN, method = RequestMethod.POST)
    public Response listValued(@RequestBody HashMap<String, Object> o,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValued(o, page, size);
    }


    @RequestMapping(value = PATH_SYS_VIN + "/add1", method = RequestMethod.GET)
    public Response add1() throws Exception {
        Vin vin = new Vin();
        vin.setVin("LSGGH59D");
        vin.setDescription("上海通用凯迪拉克");
        vinService.insert(vin);
        return new ResponseBulider().setBody(1, true, false, "上海通用尅迪拉克", vin).get();
    }

    @Override
    @RequestMapping(value = PATH_SYS_VIN + "/add", method = RequestMethod.POST)
    public Response add(@Valid @RequestBody(required = true) Vin record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_VIN, method = RequestMethod.PUT)
    public Response update(@Valid @RequestBody(required = true) Vin record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_VIN + "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") String id) throws Exception {
        return super.delete(id);
    }
}
