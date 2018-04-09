package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.entity.RiZhi;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/rizhi")
public class RiZhiController {

    //声明此请求类型为get请求 只接收get请求
    //@RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    @RequestMapping("/queryrizhi")
    public String queryRiZhiInfo(){
        //创建httpclient对象 HttpClients httpclient的封装工具类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建对应的http请求 get请求
        HttpGet httpGet = new HttpGet("http://localhost:8086/app/rizhi");
        //设置对应的请求参数
        String list=null;
        try {
            //执行http请求 execute执行
            CloseableHttpResponse response = httpclient.execute(httpGet);
            //获取响应结果
            HttpEntity entity = response.getEntity();
            //把响应结果转为字符串  EntityUtils entity工具类集合
            String responseStr = EntityUtils.toString(entity);

            list = responseStr;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @ResponseBody
    @RequestMapping("/addrizhi")
    public String addrizhi(RiZhi riZhi){

        //创建httpclient对象 HttpClients httpclient的封装工具类
        //创建对应的http请求
        HttpPost httpPost = new HttpPost("http://localhost:8086/app/rizhi");
        StringEntity reqEntity = new StringEntity(JSON.toJSONString(riZhi), "UTF-8");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setEntity(reqEntity);
        //设置对应的请求参数
        try {
            //执行http请求 execute执行
            CloseableHttpResponse response = httpclient.execute(httpPost);
            //获取响应结果
            HttpEntity entity = response.getEntity();
            //把响应结果转为字符串  EntityUtils entity工具类集合
            String responseStr = EntityUtils.toString(entity);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "true";
    }

    @ResponseBody
    @RequestMapping("/deleterizhi")
    public String deleterizhi(Integer rid){
        //创建httpclient对象 HttpClients httpclient的封装工具类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建对应的http请求
        HttpDelete httpDelete = new HttpDelete("http://localhost:8086/app/rizhi/"+rid);
        //设置对应的请求参数
        try {
            //执行http请求 execute执行
            CloseableHttpResponse response = httpclient.execute(httpDelete);
			/*//获取响应结果
			HttpEntity entity = response.getEntity();
			//把响应结果转为字符串  EntityUtils entity工具类集合
			String responseStr = EntityUtils.toString(entity);
			System.out.println(responseStr);*/
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "true";
    }

    @ResponseBody
    @RequestMapping("/updaterizhi")
    public String updaterizhi(Integer rid,String rname,String rtype,String rtime){

        RiZhi riZhi = new RiZhi();

        riZhi.setRid(rid);
        riZhi.setRname(rname);
        riZhi.setRtime(rtime);
        riZhi.setRtype(rtype);

        //创建httpclient对象 HttpClients httpclient的封装工具类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建对应的http请求
        HttpPut httpPut= new HttpPut("http://localhost:8086/app/rizhi/update");

        StringEntity reqEntity = new StringEntity(JSON.toJSONString(riZhi), "UTF-8");
        httpPut.setHeader("Content-Type","application/json");
        httpPut.setEntity(reqEntity);
        //设置对应的请求参数
        try {
            //执行http请求 execute执行
            CloseableHttpResponse response = httpclient.execute(httpPut);
			//获取响应结果
			HttpEntity entity = response.getEntity();
			//把响应结果转为字符串  EntityUtils entity工具类集合
			String responseStr = EntityUtils.toString(entity);
			System.out.println(responseStr);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "true";
    }
    //根据id 修改不好用
    /*@ResponseBody
    @RequestMapping("/updaterizhi")
    public String updaterizhi(Integer rid){
        //创建httpclient对象 HttpClients httpclient的封装工具类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建对应的http请求
        HttpPut httpPut= new HttpPut("http://localhost:8086/app/rizhi/"+rid);
        //设置对应的请求参数
        try {
            //执行http请求 execute执行
            CloseableHttpResponse response = httpclient.execute(httpPut);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "true";
    }
*/


}
