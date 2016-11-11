package cc.aisc.business.rest.controller.auth;

import cc.aisc.commons.base.CommonController;
import cc.aisc.commons.response.Response;
import cc.aisc.business.model.auth.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by sjf on 16-7-4.
 */
@RestController
public class UserController extends CommonController<User> implements IUserController {

    @Override
    @RequestMapping(value = PATH_AUTH_USER + "/{id}", method = RequestMethod.GET)
    public Response getById(@PathVariable("id") String id) throws Exception {
        return super.getById(id);
    }


    @RequestMapping(value = PATH_AUTH_USER + PATH_QUERY, method = RequestMethod.GET)
    public Response find(@RequestParam("qt") String qt,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return query(qt, page, size);
    }

    @RequestMapping(value = PATH_AUTH_USER, method = RequestMethod.GET)
    public Response listValid(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValid(page, size);
    }

    @RequestMapping(value = PATH_AUTH_USER + "/more", method = RequestMethod.POST)
    public Response listDetailed(@RequestBody HashMap<String, Object> o,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getDetailed(o, page, size);
    }

    @RequestMapping(value = PATH_AUTH_USER, method = RequestMethod.POST)
    public Response listValued(@RequestBody HashMap<String, Object> o,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "-1") int size) throws Exception {
        return getValued(o, page, size);
    }

    @Override
    @RequestMapping(value = PATH_AUTH_USER + "/add", method = RequestMethod.POST)
    public Response add(@Valid @RequestBody(required = true) User record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_AUTH_USER, method = RequestMethod.PUT)
    public Response update(@Valid @RequestBody(required = true) User record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_AUTH_USER + "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") String id) throws Exception {
        return super.delete(id);
    }

}
