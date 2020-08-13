package com.hy.ssm.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hy.ssm.pojo.Student;
import com.hy.ssm.service.IClassesService;
import com.hy.ssm.service.IMenuService;
import com.hy.ssm.service.IStudentService;
import com.hy.ssm.utils.LayUIData;
import com.hy.ssm.utils.MsgUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: wangsq
 * @Date: 2020/7/21 16:42
 * @Description:
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    Logger logger=Logger.getLogger(StudentController.class);

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassesService classesService;


    @Autowired
    private IMenuService iMenuService;
    /**
     * 查询所有
     * @param
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    @RequiresRoles(value = {"query"},logical = Logical.AND)
    public LayUIData list(Integer page,Integer limit,Student student){
        if(page==null){
            page=1;
        }
        if(limit==null){
            limit=2;
        }
        EntityWrapper entityWrapper=new EntityWrapper();
        if(!StringUtils.isEmpty(student)){
            if(!StringUtils.isEmpty(student.getStuName())){
                entityWrapper.eq("stu_name",student.getStuName());
            }
            if(!StringUtils.isEmpty(student.getClassno())){
                entityWrapper.eq("classno",student.getClassno());
            }
        }

        Page page1=studentService.selectPage(new Page<Student>(page,limit),entityWrapper);
        LayUIData layUIData=new LayUIData();
        layUIData.setCode(0);
        layUIData.setMsg("查询成功");
        layUIData.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        layUIData.setData(page1.getRecords());
        return layUIData;
    }


    @RequestMapping("/listcla")
    @ResponseBody
    public List list(){
        return classesService.selectList(null);
    }

    @RequestMapping("/getById")
    public String getById(String id, Model model){
        model.addAttribute("stu",studentService.selectById(id));
        return "/edit.html";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public MsgUtils add(String ids){
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("成功");
        studentService.deleteBatchIds(Arrays.asList(ids.split(",")));
        logger.info("数据删除成功！");
        return msgUtils;
    }


    @RequestMapping("/add")
    public String add(Student student){
        try {
            String str=null;
            str.split("");
            studentService.insert(student);
        } catch (NullPointerException e){
            e.printStackTrace();
            logger.error(e);
        }
        finally {

        }
        return "/list.html";
    }

    @RequestMapping("/fileupload")
    @ResponseBody
    public MsgUtils fileupload(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest req){
        MsgUtils msgUtils=new MsgUtils();

        try {
            // 图片上传
            // 设置图片名称，不能重复，可以使用uuid
            String picName = UUID.randomUUID().toString();
            // 获取文件名
            String oriName = pictureFile.getOriginalFilename();
            // 获取图片后缀
            String extName = oriName.substring(oriName.lastIndexOf("."));
            String path=req.getServletContext().getRealPath("/upload");
            // 开始上传
            pictureFile.transferTo(new File( path+"/"+picName + extName));
            msgUtils.setCode("0");
            msgUtils.setMsg("操作成功！");
            msgUtils.setData(picName +extName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            msgUtils.setCode("2");
            msgUtils.setMsg("系统繁忙！");
            e.printStackTrace();
        }
        return msgUtils;
    }


    @RequestMapping("/queryMenu")
    @ResponseBody
    public List queryMenu(){
        return iMenuService.queryBase();
    }


}
