package cc.aisc.commons.task;

import cc.aisc.business.model.sys.VinHao;
import cc.aisc.business.model.sys.Wmi;
import cc.aisc.business.mongo.DocModelRepo;
import cc.aisc.business.mongo.vin.VinLogDoc;
import cc.aisc.business.mongo.vin.VinLogRepo;
import cc.aisc.business.service.sys.VinHaoService;
import cc.aisc.business.service.sys.WmiService;
import cc.aisc.commons.utils.VINUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by sjf on 16-10-10.
 */
@Component
public class ScheduledTask {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

    private final DocModelRepo docModelRepo;
    private final VinLogRepo vinLogRepo;
    private final VinHaoService vinHaoService;
    private final WmiService wmiService;

    private int count = 1;

    @Autowired
    public ScheduledTask(DocModelRepo docModelRepo, VinLogRepo vinLogRepo, VinHaoService vinHaoService, WmiService wmiService) {
        this.docModelRepo = docModelRepo;
        this.vinLogRepo = vinLogRepo;
        this.vinHaoService = vinHaoService;
        this.wmiService = wmiService;
    }

    public void work() throws Exception {

    }

    public void work1() throws Exception {
        query(ready());
    }

    private void query(String vin) throws Exception {
        String appKey = "945736ab83b441b29a275a8351fec0fd";

        StringBuilder sb = new StringBuilder();
        sb.append("http://apis.haoservice.com/efficient/vinservice?vin=")
                .append(vin)
                .append("&key=")
                .append(appKey);

        try {
            long t1 = System.currentTimeMillis();
            HttpResponse<String> response = Unirest.get(sb.toString()).asString();
            Gson gson = new Gson();
            Type type = new TypeToken<Response>() {}.getType();
            Response resp = gson.fromJson(response.getBody(), type);
            if (resp.getError_code() == 0) {
                vinHaoService.insert(resp.getResult());
                LOGGER.info("查询到数据, 品牌为: {}, 费时: {} ms", resp.getResult().getPp(), System.currentTimeMillis() - t1);
            }else {
                LOGGER.warn("未查询到数据, 结果为: {}, 费时: {} ms", resp.getReason(), System.currentTimeMillis() - t1);
            }
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private String ready() throws Exception {
        BufferedReader br = null;

        long cl =(long)17276050;
        String log = null;
        try {
            br = new BufferedReader(new FileReader("/home/sjf/dev/vin/var/current.lock"));
            if ((log = br.readLine()) != null) {
                cl += Long.valueOf(log);
            }else {
                log = "0";
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        String v1_3 = "LBE";
        String v9 = "X";     //校验位，0-9X 随意
        String v10 = "G";   //年份 G=2016, H=2017   “ I O Q U Z 0 ”不用
        String v11_17 = "X000001";

        String v4_10 = Long.toString(cl, 36) + v9 + v10;

        String vin = v1_3 + v4_10 + v11_17;

        LOGGER.info("vin = {}", vin);


        BufferedWriter bw = null;
        BufferedWriter fw = null;
        try{
            bw = new BufferedWriter(new FileWriter("/home/sjf/dev/vin/var/current.lock", false));
            assert log != null;
            bw.write((Long.valueOf(log) + 1) + "");
            fw = new BufferedWriter(new FileWriter("/home/sjf/dev/vin/var/" + Long.toString(cl, 36).substring(1,2) + ".invalid", true));
            fw.write(v1_3 + v4_10);
            fw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bw != null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fw != null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return vin;
    }

    private class Response {
        private int error_code;
        private String reason;
        private VinHao result;

        int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public VinHao getResult() {
            return result;
        }

        public void setResult(VinHao result) {
            this.result = result;
        }
    }
}
