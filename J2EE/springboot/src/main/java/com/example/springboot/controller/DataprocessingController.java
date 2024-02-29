package com.example.springboot.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.springboot.service.IDataprocessingService;
import com.example.springboot.entity.Dataprocessing;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GRChen
 * @since 2023-06-08
 */
@RestController
@RequestMapping("/dataprocessing")
public class DataprocessingController {

            //上传磁盘路径
//            @Value("${files.upload.path}")
//            private  String filesUploadPath;

            @Autowired
            private IDataprocessingService dataprocessingService;

            // 新增或者更新
            @PostMapping
            public boolean save(@RequestBody Dataprocessing dataprocessing) {
                return dataprocessingService.saveOrUpdate(dataprocessing);
            }

            @DeleteMapping("/{rid}")
            public Boolean delete(@PathVariable Integer rid) {return dataprocessingService.removeById(rid);}


            @PostMapping("/del/batch")
            public boolean deleteBatch(@RequestBody List<Integer> ids) {
                return dataprocessingService.removeByIds(ids);
            }

            @GetMapping
            public List<Dataprocessing> findAll() {
                return dataprocessingService.list();
            }

            @GetMapping("/{rid}")
            public Dataprocessing findOne(@PathVariable Integer rid) {
                return dataprocessingService.getById(rid);
            }
            //分页查询
            //分页查询
            @GetMapping("/page")
            public Page<Dataprocessing> findPage(@RequestParam Integer pageNum,
                                                 @RequestParam Integer pageSize ,
                                                 @RequestParam(defaultValue = "") String classnum) {
                UpdateWrapper updateWrapper =new UpdateWrapper();
                updateWrapper.set("electricalconsume","(comnum*50)+(lignum*20)+(fannum*20)+(airnum*100)");
                Page<Dataprocessing> page =new Page<>(pageNum,pageSize);
                QueryWrapper<Dataprocessing> queryWrapper = new QueryWrapper<>();
                if(!"".equals(classnum)){
                    queryWrapper.like("classnum",classnum);
                }
                return dataprocessingService.page(new Page<>(pageNum,pageSize),queryWrapper);
            }



            /*导出*/
            @GetMapping("/export")
            public void export(HttpServletResponse response)throws Exception{
                //从数据库查出所有的数据
                List<Dataprocessing> list=dataprocessingService.list();
                //通过工具类创建writer写出磁盘路径
                ExcelWriter writer = ExcelUtil.getWriter(true);
                //自定义别名
                writer.addHeaderAlias("rid","教室ID");
                writer.addHeaderAlias("address","教室地址");
                writer.addHeaderAlias("electricalconsume","电能消耗量");
                writer.addHeaderAlias("correcttime","创建时间");
                writer.addHeaderAlias("datadif","日期差值");
                writer.addHeaderAlias("classnum","教室号");
                writer.addHeaderAlias("comnum","电脑设备数量");
                writer.addHeaderAlias("lignum","LED设备数量");
                writer.addHeaderAlias("fannum","风扇设备数量");
                writer.addHeaderAlias("airnum","空调设备数量");
                //一次性写出list内的对象到Excel,使用默认样式,强制输出标题
                writer.write(list,true);
                // 设置浏览器响应的格式
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
                String fileName = URLEncoder.encode("数据信息", "UTF-8");
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
                ServletOutputStream out = response.getOutputStream();
                writer.flush(out, true);
                out.close();
                writer.close();
            }

            /*导入*/
            @PostMapping("/import")
            public Boolean imp(MultipartFile file) throws Exception {
                InputStream inputStream = file.getInputStream();
                ExcelReader reader = ExcelUtil.getReader(inputStream);
                // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
//        List<User> list = reader.readAll(User.class);

                // 方式2：忽略表头的中文，直接读取表的内容
                List<List<Object>> list = reader.read(1);
                List<Dataprocessing> dataprocessings = CollUtil.newArrayList();
                for (List<Object> row : list) {
                    Dataprocessing dataprocessing = new Dataprocessing();
                    dataprocessing.setRid(Integer.valueOf(row.get(0).toString()));
                    dataprocessing.setClassnum(row.get(1).toString());
                    dataprocessing.setAddress(row.get(2).toString());
                    dataprocessing.setElectricalconsume((Integer) row.get(3));
                    dataprocessing.setDatadif(row.get(4).toString());
                    dataprocessing.setComnum((Integer) row.get(5));
                    dataprocessing.setLignum((Integer) row.get(6));
                    dataprocessing.setFannum((Integer) row.get(7));
                    dataprocessing.setAirnum((Integer) row.get(8));
                    dataprocessings.add(dataprocessing);
                }

                dataprocessingService.saveBatch(dataprocessings);
                return true;
            }


}
