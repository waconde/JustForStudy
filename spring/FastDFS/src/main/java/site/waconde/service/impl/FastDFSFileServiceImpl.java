package site.waconde.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import site.waconde.clientConfig.FastDFSClient;
import site.waconde.entity.FastDFSFile;
import site.waconde.service.FastDFSFileService;

/**
 * 实现文件上传功能
 * 
 * @author side.wang
 *
 */
@Service
public class FastDFSFileServiceImpl implements FastDFSFileService {
    private static Logger logger = LoggerFactory.getLogger(FastDFSFileServiceImpl.class);

    @Override
    public String saveFile(MultipartFile multipartFile) {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
            if (inputStream != null) {
                int len1 = inputStream.available();
                file_buff = new byte[len1];
                inputStream.read(file_buff);
            }
            inputStream.close();
            FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
            fileAbsolutePath = FastDFSClient.upload(file); // upload to fastdfs
        } catch (IOException e1) {
            logger.error("receive file Exception!", e1);
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        /*
         * String path = FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
         * 因FastDFSClient.getTrackerUrl()未实现
         */
        String path = fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        return path;
    }
}
