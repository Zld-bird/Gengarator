package com.example.demo.controller.emergency;

import com.example.demo.entity.emergency.EmergencyPlan;
import com.example.demo.service.emergency.EmergencyPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.*;

import static java.net.URLEncoder.encode;

/**
 * 应急预案管理
 * @author zld
 * date: 2020/9/29
 * version: 02.06
 */
@Validated
@RestController
@Slf4j
@RequestMapping("api/emergency/plan")
public class EmergencyPlanController {

    private final EmergencyPlanService emergencyPlanService;

    public EmergencyPlanController(EmergencyPlanService emergencyPlanService) {
        this.emergencyPlanService = emergencyPlanService;
    }

    /**
     * 分页查询
     * @param planName
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/query")
    public ResponseEntity queryAllByPage(@RequestParam(value = "planName") String planName,
                                         @RequestParam(value = "page") Integer page,
                                         @RequestParam(value = "size") Integer size){
        Pageable pageable = page != null && size != null ? PageRequest.of(page, size) : Pageable.unpaged();
        return new ResponseEntity<>(emergencyPlanService.queryAllPage(planName,pageable), HttpStatus.OK);
    }

    /**
     * 查询唯一
     * @param id
     */
    @GetMapping(value = "/queryOne")
    public ResponseEntity queryOne(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(emergencyPlanService.queryOne(id),HttpStatus.OK);
    }

    /**
     * 新增或者修改
     * @param emergencyPlan
     */
    @PostMapping(value = "/insertOrUpdate")
    public void saveOrUpdate(@RequestBody EmergencyPlan emergencyPlan){
        if(null == emergencyPlan.getId()) {
            emergencyPlanService.save(emergencyPlan);
        }else {
            emergencyPlanService.update(emergencyPlan);
        }
    }

    /**
     * 删除
     * @param id
     */
    @GetMapping(value = "/delete")
    public void delete(@RequestParam @NotNull Long id){
        emergencyPlanService.delete(id);
    }

    @Value("${upload.files.base.path}")
    private String rootPath;

    @GetMapping("/download")
    public void download(HttpServletResponse response, String path, String filename) {
        log.info("应急预案管理下载文件开始");
        //清空一下response对象，否则出现缓存什么的
        response.reset();
        //指明这是一个下载的response
        response.setContentType("application/x-download");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        ServletOutputStream os = null;//输出流
        BufferedInputStream buffer = null;//输入流
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + encode(filename, "UTF-8"));
            os = response.getOutputStream();
            buffer = new BufferedInputStream(new FileInputStream(rootPath+path));
            byte[] content = new byte[1024];
            int length;
            while ((length = buffer.read(content, 0, content.length)) != -1) {
                os.write(content, 0, length);
            }
            os.flush();
            log.info("应急预案管理下载文件结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    log.error("文件下载异常:-->" + e.getMessage());
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("文件下载异常:-->" + e.getMessage());
                }
            }
        }
    }
    /*@GetMapping("/download")
    public HttpServletResponse download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            //fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }*/

   /* public void downloadLocal(HttpServletResponse response) throws FileNotFoundException {
        // 下载本地文件
        String fileName = "Operator.doc".toString(); // 文件的默认保存名
        // 读到流中
        InputStream inStream = new FileInputStream("c:/Operator.doc");// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadNet(HttpServletResponse response) throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("windine.blogdriver.com/logo.gif");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("c:/abc.gif");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
