package cc.aisc.business.rest.controller.sys.impl;

import cc.aisc.business.model.sys.Menu;
import cc.aisc.business.rest.controller.sys.IResourceController;
import cc.aisc.commons.base.CommonController;
import cc.aisc.commons.helper.TreeHelper;
import cc.aisc.commons.response.Response;
import cc.aisc.business.model.sys.Resource;
import cc.aisc.commons.response.ResponseData;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sjf on 16-7-4.
 */
@RestController
public class ResourceController extends CommonController<Resource> implements IResourceController {

    @Override
    @RequestMapping(value = PATH_SYS_RESOURCE + "/{id}", method = RequestMethod.GET)
    public Response getById(@PathVariable("id") String id) throws Exception {
        return super.getById(id);
    }

    @RequestMapping(value = PATH_SYS_RESOURCE + PATH_QUERY, method = RequestMethod.GET)
    public Response find(@RequestParam("qt") String qt,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return query(qt, page, size);
    }

    /*@RequestMapping(value = PATH_SYS_RESOURCE, method = RequestMethod.GET)
    public Response listValid(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValid(page, size);
    }*/

    @SuppressWarnings("unchecked")
    @RequestMapping(value = PATH_SYS_RESOURCE, method = {RequestMethod.GET})
    public Response getTree(@RequestParam HashMap<String, Object> o) throws Exception{
        o.putIfAbsent("level", 2);
        Response resp = getDetailed(o, 1, -1);
        ArrayList<Resource> params = (ArrayList<Resource>)(((ResponseData)resp.getBody().getData()).getData());
        LinkedList<Resource> lists = new LinkedList<>(params);
        List<Resource> tree = TreeHelper.getTree(lists);
        resp.getBody().setData(new ResponseData((long)tree.size(), tree));
        return resp;
    }

    @RequestMapping(value = PATH_SYS_RESOURCE + "/more", method = RequestMethod.POST)
    public Response listDetailed(@RequestBody HashMap<String, Object> o,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getDetailed(o, page, size);
    }

    @RequestMapping(value = PATH_SYS_RESOURCE, method = RequestMethod.POST)
    public Response listValued(@RequestBody HashMap<String, Object> o,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValued(o, page, size);
    }

    @Override
    @RequestMapping(value = PATH_SYS_RESOURCE + "/add", method = RequestMethod.POST)
    public Response add(@Valid @RequestBody(required = true) Resource record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_RESOURCE, method = RequestMethod.PUT)
    public Response update(@Valid @RequestBody(required = true) Resource record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_RESOURCE + "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") String id) throws Exception {
        return super.delete(id);
    }
}
