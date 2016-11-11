package cc.aisc.business.rest.controller.sys.impl;

import cc.aisc.business.rest.controller.sys.IMenuController;
import cc.aisc.commons.base.CommonController;
import cc.aisc.commons.helper.TreeHelper;
import cc.aisc.commons.response.*;
import cc.aisc.business.model.sys.Menu;
import cc.aisc.business.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class MenuController extends CommonController<Menu> implements IMenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @Override
    @RequestMapping(value = PATH_SYS_MENU + "/{id}", method = RequestMethod.GET)
    public Response getById(@PathVariable("id") String id) throws Exception {
        return super.getById(id);
    }


    @RequestMapping(value = PATH_SYS_MENU + PATH_QUERY, method = RequestMethod.GET)
    public Response find(@RequestParam("qt") String qt,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return query(qt, page, size);
    }

    /*@RequestMapping(value = PATH_SYS_MENU, method = RequestMethod.GET)
    public Response listValid(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValid(page, size);
    }*/

    @SuppressWarnings("unchecked")
    @RequestMapping(value = PATH_SYS_MENU, method = {RequestMethod.GET})
    public Response getTree(@RequestParam HashMap<String, Object> o) throws Exception{
        o.putIfAbsent("level", 2);
        Response resp = getDetailed(o, 1, -1);
        ArrayList<Menu> params = (ArrayList<Menu>)(((ResponseData)resp.getBody().getData()).getData());
        LinkedList<Menu> lists = new LinkedList<>(params);
        List<Menu> tree = TreeHelper.getTree(lists);
        resp.getBody().setData(new ResponseData((long)tree.size(), tree));
        return resp;
    }

    @RequestMapping(value = PATH_SYS_MENU + "/more", method = RequestMethod.POST)
    public Response listDetailed(@RequestBody HashMap<String, Object> o,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getDetailed(o, page, size);
    }

    @RequestMapping(value = PATH_SYS_MENU, method = RequestMethod.POST)
    public Response listValued(@RequestBody HashMap<String, Object> o,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValued(o, page, size);
    }

    @Override
    @RequestMapping(value = PATH_SYS_MENU + "/add", method = RequestMethod.POST)
    public Response add(@Valid @RequestBody(required = true) Menu record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_MENU, method = RequestMethod.PUT)
    public Response update(@Valid @RequestBody(required = true) Menu record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_SYS_MENU + "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") String id) throws Exception {
        return super.delete(id);
    }
}
