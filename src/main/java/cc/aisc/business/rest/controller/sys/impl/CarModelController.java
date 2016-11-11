package cc.aisc.business.rest.controller.sys.impl;

import cc.aisc.business.model.sys.CarModel;
import cc.aisc.business.rest.controller.sys.ICarModelController;
import cc.aisc.business.service.sys.CarModelService;
import cc.aisc.commons.base.CommonController;
import cc.aisc.commons.exception.ResultAbsentException;
import cc.aisc.commons.exception.ServiceException;
import cc.aisc.commons.helper.TreeHelper;
import cc.aisc.commons.response.*;
import cc.aisc.commons.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sjf on 16-10-21.
 */

@RestController
public class CarModelController extends CommonController<CarModel> implements ICarModelController {


    private final CarModelService carModelService;

    @Autowired
    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @Override
    @RequestMapping(value = PATH_SYS_CAR_MODEL + "/{id}", method = RequestMethod.GET)
    public Response getById(@PathVariable("id") String id) throws Exception {
        return super.getById(id);
    }

    @RequestMapping(value = PATH_SYS_CAR_MODEL + PATH_QUERY, method = RequestMethod.GET)
    public Response find(@RequestParam("qt") String qt,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return query(qt, page, size);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = PATH_SYS_CAR_MODEL, method = {RequestMethod.GET})
    public Response getTree(@RequestParam HashMap<String, Object> o) throws Exception{
        o.putIfAbsent("level", 2);
        Response resp = getDetailed(o, 1, -1);
        ArrayList<CarModel> params = (ArrayList<CarModel>)(((ResponseData)resp.getBody().getData()).getData());
        LinkedList<CarModel> lists = new LinkedList<>(params);
        List<CarModel> tree = TreeHelper.getTree(lists);
        resp.getBody().setData(new ResponseData((long)tree.size(), tree));
        return resp;
    }

    @RequestMapping(value = PATH_SYS_CAR_MODEL + "/{id}/{prop}", method = RequestMethod.GET)
    public Response find1(@PathVariable("id") String id, @PathVariable("prop") String prop) throws Exception {
        try {
            int weight = carModelService.findCarModelProp(id, prop);
            return new Response(new ResponseBody(100001, true, false, "查询成功", new ResponseData(1L, weight)), HttpStatus.OK);
        }catch (ServiceException | ResultAbsentException e){
            throw e;
        }catch (Exception ee){
            throw new ServiceException(ee.getMessage(), ee);
        }
    }

    @RequestMapping(value = PATH_SYS_CAR_MODEL + "/more", method = RequestMethod.POST)
    public Response listDetailed(@RequestBody HashMap<String, Object> o,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getDetailed(o, page, size);
    }

    @RequestMapping(value = PATH_SYS_CAR_MODEL, method = RequestMethod.POST)
    public Response listValued(@RequestBody HashMap<String, Object> o,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValued(o, page, size);
    }

    @Override
    @RequestMapping(value = PATH_SYS_CAR_MODEL + "/add", method = RequestMethod.POST)
    public Response add(@Valid @RequestBody(required = true) CarModel record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_CAR_MODEL, method = RequestMethod.PUT)
    public Response update(@Valid @RequestBody(required = true) CarModel record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_CAR_MODEL + "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") String id) throws Exception {
        return super.delete(id);
    }
}
