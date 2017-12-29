package defsteps;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;
import util.CreateFileUtil;
import util.DateUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.config.HeaderConfig.headerConfig;
import static io.restassured.specification.ProxySpecification.*;

public class BaseStep {

    private static final RequestSpecification requestSpecification;

    static {//set default properties
        requestSpecification =given();
        PrintStream fileOutPutStream = null;
        try {
            String logDir = "logs";
            CreateFileUtil.createDir(logDir);
            String filePath = Paths.get(logDir, DateUtil.getCurrentTime("yyyy_MM_dd_HHmmss") + ".log").toString();
            fileOutPutStream = new PrintStream(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RestAssured.config = RestAssured.config().logConfig(new LogConfig(fileOutPutStream, true));
    }


    public static void setProxy(String host, int port,String userName, String passWord,String scheme){
        ProxySpecification proxySpecification;
        if(scheme.equalsIgnoreCase("https")){
            proxySpecification = host(host).withPort(port).withAuth(userName, passWord).withScheme("https");
        }else{
            proxySpecification = host(host).withPort(port).withAuth(userName, passWord).withScheme("http");
        }
        requestSpecification.proxy(proxySpecification);
    }

    //for set the head value
    public void setHead(String headName, String headValue){
        requestSpecification.headers(headName,headValue);
    }

    //for reset the head value
    public void reSetHead(String headName, String headValue){
        requestSpecification.config(RestAssuredConfig.config().headerConfig(headerConfig().overwriteHeadersWithName(headName))).
                header(headName, headValue);
    }





//    public static Response sendRequest(String protocol, String host, String url, String method, String paras, String heads){
//        Response response;
//        RequestSpecification requestSpecification;
//        if("https".equalsIgnoreCase(protocol)){
//            requestSpecification = given().relaxedHTTPSValidation().log().all();
//        }else{
//            requestSpecification = given().log().all();
//        }
//
//    }


    public static void main(String[] args){
        Response ss = given().log().all().header("x", "1").header("x", "2").relaxedHTTPSValidation().when().get("https://www.baidu.com/");
//        Response ss = sendRequest("https", "https://www.baidu.com", "get", "", "");
        List<Header> responseHead = ss.headers().asList();
        System.out.println(responseHead);
//        ss.getStatusCode()
//        System.out.println(ss.get);
    }

}
