package site.waconde.service;

import org.springframework.web.multipart.MultipartFile;

public interface FastDFSFileService {
    String saveFile(MultipartFile file);
}
