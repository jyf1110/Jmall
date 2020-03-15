package com.taiji.jmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
 import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmallManageWebApplicationTests {

    @Test
    public void  contextLoads() throws IOException, MyException {
        String tracker = JmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径
        ClientGlobal.init(tracker);
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=trackerClient.getTrackerServer();
        StorageClient storageClient=new StorageClient(trackerServer,null);
        String[] uploadInfos=storageClient.upload_file("f:/a.jpg","jpg",null);
        String url = "http://49.232.167.203";
        for (String uploadInfo : uploadInfos) {
            url += "/"+uploadInfo;

            //url = url + uploadInfo;
        }

        System.out.println(url);


    }

}
